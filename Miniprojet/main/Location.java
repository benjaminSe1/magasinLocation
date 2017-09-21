package main;

import java.util.ArrayList;
import java.util.HashMap;

import articles.Article;

/**
 * Created by E149769S on 19/09/17.
 */
public class Location {
    private String dateDebut;
    private String dateFin;
    private HashMap<Article, Integer> articles;
    private Client client;

    public Location(String dateDebut, String dateFin, HashMap<Article, Integer> articles, Client client) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.articles = articles;
        this.client = client;
    }

    public void rend(){

    }

    public String toString(){
        String s = "";
        s = "\nDate de début : " + dateDebut + " Date de fin : " + dateFin + "\nListe des articles loués : ";
        for(Article a : articles.keySet()){
            s += a.toString();
            s += " nombre d'articles loués : " + this.articles.get(a);
        }
        return s;
    }
}
