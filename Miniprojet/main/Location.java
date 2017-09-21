package main;

import java.util.ArrayList;

import articles.Article;

/**
 * Created by E149769S on 19/09/17.
 */
public class Location {
    private String dateDebut;
    private String dateFin;
    private ArrayList<Article> articles;
    private Client client;

    public Location(String dateDebut, String dateFin, ArrayList<Article> articles, Client client) {
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
        for(Article a : articles){
            s += a.toString();
        }
        return s;
    }
}
