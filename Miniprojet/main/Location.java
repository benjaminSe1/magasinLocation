package main;

import java.util.ArrayList;

import articles.Article;

/**
 * Created by E149769S on 19/09/17.
 */
public class Location {
    private String dateDebut;
    private String dateFin;
    private ArrayList<Article> listeArticleLoues;
    private Client client;

    public Location(String dateDebut, String dateFin, ArrayList<Article> listeArticleLoues, Client client) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.listeArticleLoues = listeArticleLoues;
        this.client = client;
    }

    public void rend(){

    }

    public String toString(){
        return "Date de début : " + dateDebut + "\nDate de fin : " + dateFin + "\nListe des articles loués : " + listeArticleLoues;
    }
}
