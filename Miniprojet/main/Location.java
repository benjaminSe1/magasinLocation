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

    public Location(String dateDebut, String dateFin, ArrayList<Article> listeArticleLoues) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.listeArticleLoues = listeArticleLoues;
    }

    public void rend(){

    }
}
