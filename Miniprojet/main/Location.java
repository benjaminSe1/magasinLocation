package main;

import java.util.Date;
import java.util.HashMap;
import articles.Article;

/**
 * Created by E149769S on 19/09/17.
 */
public class Location {
    private Date dateDebut;
    private Date dateFin;
    private HashMap<Article, Integer> articles;
    private Client client;
    private double montant;

    public Location(Date dateDebut, Date dateFin, HashMap<Article, Integer> articles, Client client, double montant) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.articles = articles;
        this.client = client;
        this.montant = montant;
    }

    public String toString(){
        String s = "\nLocation : \nLocation du : " + dateDebut + " jusqu'au " + dateFin + "\nMontant de la location : " + this.montant + " € \nListe des articles loués : ";
        for(Article a : articles.keySet()){
            s += a.toString();
            s += " nombre d'articles loués : " + this.articles.get(a) + "\n";
        }
        return s;
    }


    public HashMap<Article, Integer> getArticles() {
        return articles;
    }

    public void setArticles(final HashMap<Article, Integer> articles) {
        this.articles = articles;
    }
}
