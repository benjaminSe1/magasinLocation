package main;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

import articles.Article;

import static main.Magasin.dateToString;

/**Classe permettant de modéliser une location
 * Created by E149769S on 19/09/17.
 */
public class Location {

    private Date dateDebut;

    private Date dateFin;

    private HashMap<Article, Integer> articles;

    private Client client;

    private double montant;

    /**
     * Constructeur de la classe Location
     * @param dateDebut représente la date de début de la location
     * @param dateFin représente la date de fin de la location
     * @param articles la Hasmap d'articles loués : pair : <Article loué, nombre loué>
     * @param client Le client qui loue ces articles
     * @param montant montant total de la location
     */
    public Location(Date dateDebut, Date dateFin, HashMap<Article, Integer> articles, Client client, double montant) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.articles = articles;
        this.client = client;
        this.montant = montant;
    }

    /**
     * Méthode qui permet d'afficher les données d'une locations
     * @return La chaine de caractère représenentant la Location
     */
    public String toString() {
        String startDate = null;
        String endDate = null;
        try {
            startDate = dateToString(dateDebut);
            endDate = dateToString(dateFin);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String s = "\nLocation : \nLocation du : " + startDate + " jusqu'au " + endDate + "\nMontant de la location : " + this.montant + " € \nListe des articles loués : ";
        for (Article a : articles.keySet()) {
            s += a.toString();
            s += " nombre d'articles loués : " + this.articles.get(a) + "\n";
        }
        return s;
    }

    /**
     * Getter de l'attribut articles
     * @return la HashMap d'articles
     */
    public HashMap<Article, Integer> getArticles() {
        return articles;
    }

    /**
     * Méthode qui set l'attribu articles
     * @param articles la HashMap<Article, Integer> a laquelle set l'attibut articles
     */
    public void setArticles(final HashMap<Article, Integer> articles) {
        this.articles = articles;
    }

    /**
     * Getter de l'attribut client
     * @return le client
     */
    public Client getClient() {
        return this.client;
    }
}
