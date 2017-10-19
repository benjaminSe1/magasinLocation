package main;

import articles.Article;
import articles.ArticleComparator;
import exception.ArticleIndispoException;
import exception.LocationImpossibleException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Classe permettant de modéliser un Magasin
 * Created by E145725x on 19/09/17.
 */
public class Magasin {

    private String nom;

    private ArrayList<Article> articlesDispos;

    private ArrayList<Article> articlesNonDispos;

    private Archive archive;

    private ArrayList<Location> locations;

    private ArrayList<Client> clients;

    public static final String[] filtres = {"refCroiss", "refDecroiss", "prixCroiss", "prixDecroiss", "marqueCroiss", "marqueDecroiss", "modeleCroiss", "modeleDecroiss"};

    /**
     * Constructor
     * Constructeur de la classe Magasin. On le construit à partir d'une liste d'articles disponible ou non. Ces articles seront dispatchés dans les listes articlesDispo et articlesNonDispo
     *
     * @param nom      - Le nom du magasin
     * @param articles - La liste des articles du magasin
     */
    public Magasin(String nom, ArrayList<Article> articles) {
        this.nom = nom;
        this.articlesDispos = new ArrayList<>();
        this.archive = new Archive();
        this.locations = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.articlesNonDispos = new ArrayList<>();
        //Dès le constructeur, nous mettons à jour la liste d'articles dispo et indispos
        //Pour cela, pour chaque articles, nous regardons leur disponibilités, si elle est inférieur ou égale à 0,
        //l'article est mit dans la liste articlesNonDispos
        Iterator<Article> it = articles.iterator();
        while (it.hasNext()) {
            Article article = it.next();
            if (article.getNbDispo() <= 0) {
                this.articlesNonDispos.add(article);
            } else {
                this.articlesDispos.add(article);
            }
        }
    }

    /**
     * Méthode permettant de tester la disponibilité d'une HashMap d'articles, correspondant au contenu d'une location
     *
     * @param articles - HashMap d'articles dont ont veut tester la disponibilité
     * @return - Boolean : true si disponible, False sinon
     */
    public boolean checkDispoLocation(HashMap<Article, Integer> articles) {
        boolean res = true;
        for (Article a : articles.keySet()) {
            //exception
            if (a.getNbDispo() < articles.get(a)) {
                res = false;
            }
        }
        return res;
    }

    /**
     * Méthode qui permet d'effectuer une location. Elle créée l'objet location.
     *
     * @param articles  - articles HashMap correspondant au contenu d'une location
     * @param dateDebut - date de début de la location
     * @param dateFin   - date de fin de la location
     * @param client    - client qui loue
     * @return la location créée
     * @throws ArticleIndispoException     Exception levée lorsqu'un article est demandé dans une location en quantité non disponible
     * @throws LocationImpossibleException Exception levée lorsqu'une location est impossible à effectuer
     * @throws ParseException              Exception levée lors d'une erreur de parsing de la date
     */
    public Location loue(HashMap<Article, Integer> articles, String dateDebut, String dateFin, Client client) throws ArticleIndispoException, LocationImpossibleException, ParseException {
        if (this.checkDispoLocation(articles)) {
            Date startDate = stringToDate(dateDebut);
            Date endDate = stringToDate(dateFin);

            for (Article a : articles.keySet()) {
                a.decrementeDispo(articles.get(a));
                this.majListeArticles(a);
            }
            Location loc = new Location(startDate, endDate, articles, client);
            this.locations.add(loc);
            client.ajouteLocation(loc);
            if (!this.clients.contains(client)) {
                this.clients.add(client);
            }
            return loc;

        } else {
            throw new ArticleIndispoException("Un des articles est indispo");
        }
    }

    /**
     * Méthode qui permet de gérer la restitution des articles de la location
     *
     * @param location la location qui est rendu au magasin
     */
    public void rend(Location location) {
        Client c = location.getClient();
        for (Article a : location.getArticles().keySet()) {
            a.incrementeDispo(location.getArticles().get(a));
            this.majListeArticles(a);
        }
        c.rend(location);
        this.archive.archiver(location);
    }

    /**
     * Méthode qui met à jour les listes d'articles. En fonction de sa disponibilité, l'article est mit dans la bonne liste.
     *
     * @param article L'article à mettre à jour.
     */
    public void majListeArticles(Article article) {
        if (article.getNbDispo() <= 0) {
            this.articlesNonDispos.add(article);
            this.articlesDispos.remove(article);
        } else if (article.getNbDispo() > 0) {
            if (this.articlesNonDispos.contains(article)) {
                this.articlesNonDispos.remove(article);
            }
            if (!this.articlesDispos.contains(article)) {
                this.articlesDispos.add(article);
            }
        }
    }

    /**
     * Méthode qui retourne la liste de charactère représentant tous les articles disponibles du magasin
     *
     * @param filtre - filtre sur la recherche peut être compris parmis les valeurs de Magasin.filtres
     * @return String - retourne la liste de charactère représentant tous les articles disponibles du magasin
     */
    public String afficheArticle(String filtre) {
        //exception
        if (!Magasin.checkFiltre(filtre)) {
            return "Mauvais filtre";
        }
        articlesDispos.sort(new ArticleComparator(filtre));
        String res = "";
        Iterator<Article> it = articlesDispos.iterator();
        while (it.hasNext()) {
            res += it.next().toString();
            res += '\n';
        }
        return res;
    }

    /**
     * Méthode qui affiche les locations pour un client donné
     *
     * @param client - Client dont on souhaite connaitre les locations
     */
    public void afficheLocation(Client client) {
        client.afficheLocation();
    }

    /**
     * Méthode qui permet d'archiver une location
     *
     * @param location - La location que l'on veut archiver
     */
    public void archive(Location location) {
    }

    /**
     * Méthode permettant de vérifier si le filtre existe
     *
     * @param filtre - Le filtre à vérifier
     * @return Boolean - : True si le filtre éxiste, false sinon
     */
    public static boolean checkFiltre(String filtre) {
        boolean res = false;
        for (String s : Magasin.filtres) {
            if (s == filtre) {
                return true;
            }
        }
        return res;
    }

    /**
     * Méthode permettant de prendre une date et de la transformer en string au format dd/MM/yyyy
     *
     * @param date - La date à retourner en String
     * @return newDateString - La date en String
     * @throws ParseException Exception levée lors d'une erreur de parsing de la date
     */
    public static String dateToString(Date date) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String newDateString = format.format(date);
        return newDateString;
    }

    /**
     * Méthode permettant de prendre une date et de la transformer en string au format dd/MM/yyyy
     *
     * @param stringDate - La string à parser en date
     * @return date - La date parsée
     * @throws ParseException Exception levée lors d'une erreur de parsing de la date
     */
    public static Date stringToDate(String stringDate) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = format.parse(stringDate);
        return date;
    }

    public double getMontantPeriode(String stringDebut, String stringFin) throws ParseException {
        double res = 0.0;
        Date dateDebut = stringToDate(stringDebut);
        Date dateFin = stringToDate(stringFin);
        int i = 0;
        int j = 0;
        for(Location loc : this.locations){
            if(loc.getDateDebut().after(dateDebut) && loc.getDateFin().before(dateFin)){
                res += loc.getMontant();
                j++;
            }
            i++;
        }
        return res;
    }
}
