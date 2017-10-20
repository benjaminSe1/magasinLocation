package Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import Article.Article;
import Exception.LocationImpossibleException;
import Main.Archive;
import Main.Client;
import Main.Location;

import static Main.Magasin.stringToDate;

public class ArchiveTest {

    public static void main(String[] args) throws IOException, LocationImpossibleException, ParseException {
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
        //Création de deux dates à partir de Strings
        Date dateD = stringToDate("21/09/2017");
        Date datef = stringToDate("19/11/2017");
        //Création d'une liste de locations
        ArrayList<Location> locations = new ArrayList<>();
        //Création de deux locations
        Location l1 = new Location(dateD, datef, articles, c1);
        Location l2 = new Location(dateD, datef, articles2, c1);
        locations.add(l1);
        locations.add(l2);
        //Création d'une nouvelle archive
        Archive archiveW = new Archive();
        //Archivage des deux locations
        archiveW.archiver(l1);
        archiveW.archiver(l2);
    }
}
