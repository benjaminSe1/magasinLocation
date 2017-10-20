package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import article.Article;
import exception.LocationImpossibleException;
import main.Client;
import main.Location;

import static main.Magasin.stringToDate;

/**
 * Created by E149769S on 21/09/17.
 */
public class ClientTest {

    public static void main(String[] args) throws LocationImpossibleException, ParseException {
        //Création de deux hashmap avec les articles et le nombre d'articles
        HashMap<Article, Integer> articles = new HashMap<Article, Integer>();
        HashMap<Article, Integer> articles2 = new HashMap<Article, Integer>();
        //Création de deux articles
        Article a1 = new Article("ref01", "Nike", "Modele1", 10.0, 5);
        Article a2 = new Article("ref02", "Adidas", "Modele2", 10.0, 5);
        articles.put(a1, 1);
        articles2.put(a2, 2);
        //Création d'un client
        Client c1 = new Client("Seche", "Benjamin", "3 Rue Maréchal Joffre", "01 02 03 04 05");
        Date dateD = stringToDate("21/09/2017");
        Date datef = stringToDate("19/11/2017");
        //Création d'une liste de locations
        ArrayList<Location> locations = new ArrayList<Location>();
        Location l1 = new Location(dateD, datef, articles, c1);
        Location l2 = new Location(dateD, datef, articles2, c1);
        locations.add(l1);
        locations.add(l2);
        //Affichage des locations du client c1
        c1.afficheLocation();
    }
}
