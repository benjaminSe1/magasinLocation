package articles;

import java.util.Comparator;

/**
 * Created by a149769S on 19/09/17.
 */
public class Article {
    private String reference;
    private String marque;
    private String modele;
    private double prix_j;
    private int nbDispo;

    public Article(String reference, String marque, String modele, double prix_j, int nbDispo) {
        this.reference = reference;
        this.marque = marque;
        this.modele = modele;
        this.prix_j = prix_j;
        this.nbDispo = nbDispo;
    }

    public String toString(){
        return "Article ref : " + this.reference + ", Marque : " + this.marque + ", Prix/jour" + this.prix_j + ", Nombre d'articles disponibles : " + this.nbDispo;
    }

    public String getReference() {
        return reference;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public double getPrix_j() {
        return prix_j;
    }

    public int getNbDispo() {
        return nbDispo;
    }

    public boolean equals(Article a){
        return this.reference==a.reference;
    }

    public boolean decrementeDispo(int nbADecrementer){
        if(this.nbDispo > 0) {
            this.nbDispo=-nbADecrementer;
            return true;
        }else{
            return false;
        }
    }
}
