package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import articles.Article;

/**
 * Created by E149769S on 19/09/17.
 */
public class Client {
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private ArrayList<Location> locations;

    public Client(String nom, String prenom, String adresse, String telephone, ArrayList<Location> locations) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.locations = locations;
    }

    public void loue(){

    }

    public void rend(Location location){
        for(Location l : locations){
            if(l == location){
                Map<Article, Integer> articles = new HashMap<>(location.getArticles());
                for(Article a : articles.keySet()){
                    a.setNbDispo(a.getNbDispo() + articles.get(a));
                }
                locations.remove(l);
            }
        }
    }

    public void ajouteLocation(Location loc){
        this.locations.add(loc);
    }

    public void afficheLocation(){
        System.out.println("Client : " + this.nom + " " + this.prenom);
        System.out.println("Liste des locations du client : " + locations.toString());
    }
}
