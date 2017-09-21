package tests;

import java.util.ArrayList;

import articles.Article;
import main.Client;
import main.Location;

/**
 * Created by E149769S on 21/09/17.
 */
public class ClientTest {

    public static void main(String[] args) {
        ArrayList<Article> articles = new ArrayList<Article>();
        ArrayList<Article> articles2 = new ArrayList<Article>();
        ArrayList<Location> locations = new ArrayList<Location>();
        Article a1 = new Article("ref01", "Nike", "Modele1", 10.0, 5);
        Article a2 = new Article("ref02", "Adidas", "Modele2", 10.0, 5);
        articles.add(a1);
        articles2.add(a2);
        Client c1 = new Client("Seche", "Benjamin", "3 Rue Maréchal Joffre", "01 02 03 04 05", locations);
        //Client c2 = new Client("Abdelaziz", "Mathis", "5 Rue Maréchal Joffre", "02 03 04 05 065", locations);
        Location l1 = new Location("21/09/2017", "21/09/2017", articles, c1);
        Location l2 = new Location("22/09/2017", "22/09/2017", articles2, c1);
        locations.add(l1);
        locations.add(l2);

        c1.afficheLocation();
    }
}
