package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import articles.Article;
import articles.ArticleComparator;

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
    public static final String[] filtres = {"refCroiss", "refDecroiss","prixCroiss", "prixDecroiss","marqueCroiss", "marqueDecroiss", "modeleCroiss", "modeleDecroiss"};

    public Magasin(String nom, ArrayList<Article> articleDispos, Archive archives) {
        this.nom = nom;
        this.articlesDispos = articleDispos;
        this.archive = archive;
        this.locations = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.articlesNonDispos = new ArrayList<>();
        Iterator<Article> it = articleDispos.iterator();
        while(it.hasNext()){
            Article article = it.next();
            if(article.getNbDispo() <= 0){
                this.articlesNonDispos.add(article);
                it.remove();
            }
        }
        System.out.println(articlesDispos);
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

    public boolean loue(HashMap<Article, Integer> articles, String dateDebut, String dateFin, Client client){
        if(this.checkDispoLocation(articles)) {
            double montant = 0.0;
            for(Article a : articles.keySet()){
                a.decrementeDispo(articles.get(a));
                montant += a.getPrix_j()*articles.get(a);
                if(a.getNbDispo() == 0){
                    this.articlesNonDispos.add(a);
                    this.articlesDispos.remove(a);
                }
            }


            Location loc = new Location(dateDebut, dateFin, articles, client, montant);
            this.locations.add(loc);
            client.ajouteLocation(loc);
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
        Iterator<Article> it = articlesDispos.iterator();
       while(it.hasNext()){
           res += it.next().toString();
           res += '\n';
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
