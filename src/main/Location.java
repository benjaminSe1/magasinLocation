package main;

import articles.Article;
import exception.LocationImpossibleException;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

import static main.Magasin.dateToString;

/**
 * Classe permettant de modéliser une location
 * Created by E149769S on 19/09/17.
 */
public class Location {

    private Date dateDebut;

    private Date dateFin;

    private HashMap<Article, Integer> articles;

    private Client client;

    private double montant;

    private boolean isArchived;


    /**
     * Constructeur de la classe Location
     *
     * @param dateDebut représente la date de début de la location
     * @param dateFin   représente la date de fin de la location
     * @param articles  la Hasmap d'articles loués : pair : Article loué, nombre loué
     * @param client    Le client qui loue ces articles
     * @throws LocationImpossibleException Exception levée lorsqu'une location est impossible à effectuer
     */
    public Location(Date dateDebut, Date dateFin, HashMap<Article, Integer> articles, Client client) throws LocationImpossibleException {
        if (dateDebut.after(dateFin)) {
            throw new LocationImpossibleException("Date de début de location doit être avant date de fin de location");
        }
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.articles = articles;
        this.client = client;
        this.isArchived = false;
        this.montant = 0.0;
        for (Article a : articles.keySet()) {
            this.montant = this.montant + (a.getPrix_j() * articles.get(a));
        }
    }

    /**
     * Méthode qui permet d'afficher les données d'une locations
     *
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
        String s = "==============Location============== \nLocation du : " + startDate + " jusqu'au " + endDate + "\nMontant de la location : " + this.montant + " € \nListe des articles loués : ";
        for (Article a : articles.keySet()) {
            s += a.toString();
            s += " nombre d'articles loués : " + this.articles.get(a) + "\n";
        }
        return s;
    }

    /**
     * Getter de l'attribut articles
     *
     * @return la HashMap d'articles
     */
    public HashMap<Article, Integer> getArticles() {
        return articles;
    }

    /**
     * Méthode qui set l'attribu articles
     *
     * @param articles la HashMap{@literal <}Article, Integer{@literal >} a laquelle set l'attibut articles
     */
    public void setArticles(final HashMap<Article, Integer> articles) {
        this.articles = articles;
    }

    /**
     * Getter de l'attribut client
     *
     * @return la valeur de client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Getter de l'attribut dateDebut
     *
     * @return la valeur de dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * Getter de l'attribut dateFin
     *
     * @return la valeur de dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * Getter de l'attribut montant
     *
     * @return la valeur de montant
     */
    public double getMontant() {
        return montant;
    }

    /**
     * setter de l'attribut dateDebut
     *
     * @param dateDebut nouvelle valeur de l'attribut
     */
    public Location setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
        return this;
    }

    /**
     * setter de l'attribut dateFin
     *
     * @param dateFin nouvelle valeur de l'attribut
     */
    public Location setDateFin(Date dateFin) {
        this.dateFin = dateFin;
        return this;
    }

    /**
     * setter de l'attribut client
     *
     * @param client nouvelle valeur de l'attribut
     */
    public Location setClient(Client client) {
        this.client = client;
        return this;
    }

    /**
     * setter de l'attribut montant
     *
     * @param montant nouvelle valeur de l'attribut
     */
    public Location setMontant(double montant) {
        this.montant = montant;
        return this;
    }
}
