package main;

import java.util.ArrayList;

import articles.Article;

/**
 * Created by E149769S on 19/09/17.
 */
public class Magasin {
    private String nom;
    private ArrayList<Article> listeArticleDispo;

    public Magasin(String nom, ArrayList<Article> listeArticleDispo) {
        this.nom = nom;
        this.listeArticleDispo = listeArticleDispo;
    }

    public void loue(){

    }

    public String afficheArticle(String filtre){
        return null;
    }

    public ArrayList<Location> afficheLocation(){
        return null;
    }
}
