package main;

import java.util.ArrayList;

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

    public void rend(){

    }

    public void afficheLocation(){
        System.out.println("Client : " + this.nom + this.prenom);
        for(Location l : locations){
            System.out.println("Locations : " + l.toString());
        }
    }
}
