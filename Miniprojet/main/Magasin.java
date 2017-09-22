package main;

import java.util.ArrayList;
import java.util.HashMap;

import articles.Article;
import articles.ArticleComparator;

/**
 * Created by E149769S on 19/09/17.
 */
public class Magasin {
    private String nom;
    private ArrayList<Article> articlesDispos;
    private ArrayList<Article> articlesNonDispos;
    private Archive archive;
    private ArrayList<Location> locations;
    private ArrayList<Client> clients;
    public static final String[] filtres = {"refCroiss", "refDecroiss","prixCroiss", "prixDecroiss","marqueCroiss", "marqueDecroiss", "modeleCroiss", "modeleDecroiss"};

    public Magasin(String nom, ArrayList<Article> articleDispos, Archive archives) {
        this.nom = nom;
        this.articlesDispos = articleDispos;
        this.archive = archive;
        this.locations = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.articlesNonDispos = new ArrayList<>();
        for(Article a : this.articlesDispos){
            if(a.getNbDispo() <= 0){
                this.articlesNonDispos.add(a);
                this.articlesNonDispos.remove(a);
            }
        }
    }

    //Check la disponnibilité d'un article
    public boolean checkDispoLocation(HashMap<Article, Integer> articles){
        boolean res = true;
        for(Article a : articles.keySet()){
            //exception
            if(a.getNbDispo() < articles.get(a)) res = false;
        }
        return res;
    }

    public boolean loue(HashMap<Article, Integer> articles, String dateDebut, String dateFin, Client client, double montant){
        if(this.checkDispoLocation(articles)) {
            for(Article a : articles.keySet()){
                a.decrementeDispo(articles.get(a));
                if(a.getNbDispo() == 0){
                    this.articlesNonDispos.add(a);
                    this.articlesDispos.remove(a);
                }
            }
            Location loc = new Location(dateDebut, dateFin, articles, client);
            this.locations.add(loc);
            if(!this.clients.contains(client))this.clients.add(client);
            return true;
        }else{
            //exception
            return false;
        }

    }

    public String afficheArticle(String filtre){
        //exception
        if(!Magasin.checkFiltre(filtre))return "Mauvais filtre";
        articlesDispos.sort(new ArticleComparator(filtre));
        String res = "";
       for(Article a : articlesDispos){
           res += a.toString();
       }
       return res;
    }

    public void afficheLocation(Client client){
        client.afficheLocation();
    }

    public void archive(Location location, Client client, Double montant){

    }

    public static boolean checkFiltre(String filtre){
        boolean res = false;
        for(String s : Magasin.filtres){
            if(s == filtre) return true;
        }
        return res;
    }
}
