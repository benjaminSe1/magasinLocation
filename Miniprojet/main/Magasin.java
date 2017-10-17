package main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

import articles.Article;
import articles.ArticleComparator;
import exception.ArticleIndispoException;

/**
 * Created by E145725x on 19/09/17.
 */
public class Magasin {
    private String nom;
    private ArrayList<Article> articlesDispos;
    private ArrayList<Article> articlesNonDispos;
    private Archive archive;
    private ArrayList<Location> locations;
    private ArrayList<Client> clients;

    public static DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public static final String[] filtres = {"refCroiss", "refDecroiss", "prixCroiss", "prixDecroiss", "marqueCroiss", "marqueDecroiss", "modeleCroiss", "modeleDecroiss"};

    /**
     * Constructeur de la classe Magasin. On le construit à partir d'une liste d'articles disponible ou non. Ces articles seront dispatchés dans les listes articlesDispo et articlesNonDispo
     *
     * @param nom Nom du magasin
     * @param articles Liste des articles du magasin
     * @param archives Archive du magasin
     */
    public Magasin(String nom, ArrayList<Article> articles, Archive archives) {
        this.nom = nom;
        this.articlesDispos = new ArrayList<>();
        this.archive = archive;
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
            }else{
                this.articlesDispos.add(article);
            }
        }
    }

    /**
     *Teste la disponibilité de d'une HashMap d'articles, correspondant au contenu d'une location
     * @param articles HashMap d'articles dont ont veut tester la disponibilité
     * @return boolean : true si disponible, false sinon
     */
    public boolean checkDispoLocation(HashMap<Article, Integer> articles){
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
     *Méthode qui permet d'effectuer une location. Elle créé l'objet location.
     * @param articles articles HashMap correspondant au contenu d'une location
     * @param dateDebut date de début de la location
     * @param dateFin date de fin de la location
     * @param client client qui loue
     * @return boolean : true si la location c'est effectuée, false sinon
     * @throws ArticleIndispoException
     */
    public boolean loue(HashMap<Article, Integer> articles, String dateDebut, String dateFin, Client client) throws ArticleIndispoException {
        try {
            if (this.checkDispoLocation(articles)) {
                Date startDate = format.parse(dateDebut);
                Date endDate = format.parse(dateFin);
                String newDateDebutString = format.format(startDate);
                String newDateFinString = format.format(endDate);
                System.out.println(newDateDebutString);
                System.out.println(newDateFinString);
                double montant = 0.0;
                for (Article a : articles.keySet()) {
                    a.decrementeDispo(articles.get(a));
                    montant += a.getPrix_j() * articles.get(a);
                    this.majDispoArticle(a);
                }
                Location loc = new Location(startDate, endDate, articles, client, montant);
                this.locations.add(loc);
                client.ajouteLocation(loc);
                if (!this.clients.contains(client)) {
                    this.clients.add(client);
                }
                return true;
            } else {
                throw new ArticleIndispoException("Un des articles est indispo");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Méthode qui met à jour les liste d'articles. si l'article n'est pas dispo, il est mit dans la bonne liste.
     * @param article
     */
    public void majDispoArticle(Article article){
        if(article.getNbDispo() <= 0){
            this.articlesNonDispos.add(article);
            this.articlesDispos.remove(article);
        }
    }

    /**
     * Méthode qui retourne la liste de charactère représentant tous les articles disponibles du magasin
     * @param filtre filtre sur la recherche peut être compris parmis les valeurs de Magasin.filtres
     * @return String retourne la liste de charactère représentant tous les articles disponibles du magasin
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
     * @param client Client dont on souhaite connaitre les locations
     */
    public void afficheLocation(Client client) {
        client.afficheLocation();
    }

    /**
     * Méthode qui permet d'archiver une location
     * @param location La location que l'on veut archiver
     */
    public void archive(Location location) {
    }

    /**
     * Méthode permettant de vérifier si le filtre éxiste
     * @param filtre Le filtre à vérifier
     * @return boolean : True si le filtre éxiste, false sinon
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
}
