package main;

import java.util.ArrayList;

/**Classe qui permet de représenter une archive de magasin
 * Created by E149769S on 19/09/17.
 */
public class Archive {
    private ArrayList<Location> locations;

    /**
     * Constructeur de la classe Archive qui prend en paramètre une liste de locations
     * @param locations
     */
    public Archive(ArrayList<Location> locations) {
        this.locations = locations;
    }

    /**
     * Constructeur de la classe Archive sans paramètre
     */
    public Archive() {
        this.locations = new ArrayList<>();
    }

    /**
     * Méthode qui permet d'archiver une location
     * @param location Location à archiver
     */
    public void archiver(Location location){

    }

    /**
     * Méthode qui permet d'afficher les locations archivées pour un mois et une année donnée
     * @param annee Annee de la recherche à partir de la création du magasin : 0 --> 0 à 1 an , 1 --> 1 à 2 an, etc...
     * @param numMois Mois de la recherche (1 -->Janvier, 2 --> Fevrier, etc...)
     */
    public void afficher(int annee, int numMois){

    }
}
