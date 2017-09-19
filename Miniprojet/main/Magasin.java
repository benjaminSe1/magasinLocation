package main;

import java.util.ArrayList;

import articles.Article;

/**
 * Created by E149769S on 19/09/17.
 */
public class Magasin {
    private String nom;
    private ArrayList<Article> articleDispos;
    private Archive archive;
    private ArrayList<Location> locations;
    private ArrayList<Client> clients;

    public Magasin(String nom, ArrayList<Article> articleDispos, Archive archive, ArrayList<Location> locations, ArrayList<Client> clients) {
        this.nom = nom;
        this.articleDispos = articleDispos;
        this.archive = archive;
        this.locations = locations;
        this.clients = clients;
    }

    public void loue(){

    }

    public String afficheArticle(String filtre){
        String res = "";
        return "";
    }

    public void afficheLocation(Client client){
        client.afficheLocation();
    }

    public void archive(Location location, Client client, Double montant){

    }
}
