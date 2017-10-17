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

    public static final String[] filtres = {"refCroiss", "refDecroiss", "prixCroiss", "prixDecroiss", "marqueCroiss", "marqueDecroiss", "modeleCroiss", "modeleDecroiss"};

    public Magasin(String nom, ArrayList<Article> articleDispos, Archive archives) {
        this.nom = nom;
        this.articlesDispos = articleDispos;
        this.archive = archive;
        this.locations = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.articlesNonDispos = new ArrayList<>();
        Iterator<Article> it = articleDispos.iterator();
        while (it.hasNext()) {
            Article article = it.next();
            if (article.getNbDispo() <= 0) {
                this.articlesNonDispos.add(article);
                it.remove();
            }
        }
        System.out.println(articlesDispos);
    }

    //Check la disponibilité d'un article
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

    public boolean loue(HashMap<Article, Integer> articles, String dateDebut, String dateFin, Client client) throws ArticleIndispoException {
        try {
            if (this.checkDispoLocation(articles)) {
                DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
                Date dateD = format.parse(dateDebut);
                Date dateF = format.parse(dateFin);
                System.out.println("date : ");
                System.out.println(dateD);
                System.out.println("date : ");
                System.out.println(dateF);
                double montant = 0.0;
                for (Article a : articles.keySet()) {
                    a.decrementeDispo(articles.get(a));
                    montant += a.getPrix_j() * articles.get(a);
                    if (a.getNbDispo() == 0) {
                        this.articlesNonDispos.add(a);
                        this.articlesDispos.remove(a);
                    }
                }
                Location loc = new Location(dateD, dateF, articles, client, montant);
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

    public void afficheLocation(Client client) {
        client.afficheLocation();
    }

    public void archive(Location location, Client client, Double montant) {
    }

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
