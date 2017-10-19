package tests;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import articles.Article;
import exception.LocationImpossibleException;
import main.ArchiveWriter;
import main.Client;
import main.Location;

public class ArchiveTest {

    public static void main(String[] args) throws IOException, LocationImpossibleException {
        HashMap<Article, Integer> articles = new HashMap<Article, Integer>();
        HashMap<Article, Integer> articles2 = new HashMap<Article, Integer>();
        Article a1 = new Article("ref01", "Nike", "Modele1", 10.0, 5);
        Article a2 = new Article("ref02", "Adidas", "Modele2", 10.0, 5);
        articles.put(a1, 1);
        articles2.put(a2, 2);
        Client c1 = new Client("Seche", "Benjamin", "3 Rue Maréchal Joffre", "01 02 03 04 05");
        //Client c2 = new Client("Abdelaziz", "Mathis", "5 Rue Maréchal Joffre", "02 03 04 05 065", locations);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        Date dateD = null;
        Date datef = null;
        try {
            dateD = dateFormat.parse("21/09/2017");
            datef = dateFormat.parse("19/11/2017");
        } catch (Exception e) {
            System.err.println("Format de date invalide. Usage : dd/MM/YYYY");
            System.err.println(e.getMessage());
        }
        ArrayList<Location> locations = new ArrayList<>();
        Location l1 = new Location(dateD, datef, articles, c1);
        Location l2 = new Location(dateD, datef, articles2, c1);
        locations.add(l1);
        locations.add(l2);
        ArchiveWriter archiveW = new ArchiveWriter();
        archiveW.writeIntoFile(l1);
        archiveW.writeIntoFile(l2);
    }
}
