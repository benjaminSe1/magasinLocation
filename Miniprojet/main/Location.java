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
    private double montant;

    public Location(String dateDebut, String dateFin, HashMap<Article, Integer> articles, Client client, double montant) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.articles = articles;
        this.client = client;
        this.montant = montant;
    }

    public void rend(){

    }

    public String toString(){
        String s = "";
        s = "\nDate de début : " + dateDebut + " Date de fin : " + dateFin + " montant : " + this.montant + "\nListe des articles loués : ";
        for(Article a : articles.keySet()){
            s += a.toString();
            s += " nombre d'articles loués : " + this.articles.get(a);
        }
        return s;
    }
}
