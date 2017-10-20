package test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import article.Article;
import exception.ArticleIndispoException;
import exception.LocationImpossibleException;
import main.Archive;
import main.Client;
import main.Location;
import main.Magasin;

public class MagasinTest {

    public static void main(String[] args) throws ArticleIndispoException, ParseException, LocationImpossibleException {
        //Création d'une liste d'articles
        ArrayList<Article> articlesDispo = new ArrayList<Article>();
        //Création de cinq articles et ajout dans la liste
        Article a1 = new Article("ref1", "marque1", "modele1", 1.0, 1);
        Article a2 = new Article("ref2", "marque2", "modele2", 2.0, 2);
        Article a3 = new Article("ref3", "marque3", "modele3", 3.0, 3);
        Article a4 = new Article("ref4", "marque4", "modele4", 4.0, 0);
        Article a5 = new Article("ref5", "marque5", "modele5", 5.0, 18);
        articlesDispo.add(a1);
        articlesDispo.add(a2);
        articlesDispo.add(a3);
        articlesDispo.add(a4);
        articlesDispo.add(a5);
        //Création d'un nouveau Client c1
        Client c1 = new Client("Seche", "Benjamin", "3 Rue Maréchal Joffre", "01 02 03 04 05");
        //Création d'un nouveau magasin
        Magasin mag = new Magasin("monMag", articlesDispo);
        //Affichage des articles par référence croissante
        mag.afficheArticle("refCroiss");
        HashMap<Article, Integer> tabLoc1 = new HashMap<>();
        tabLoc1.put(a1, 1);
        tabLoc1.put(a2, 2);
        Location loc = mag.loue(tabLoc1, "17/10/2017", "18/10/2017", c1);
        mag.afficheArticle("refCroiss");
        //Restitution de la location
        mag.rend(loc);
        //Affichage des articles par référence croissante
        mag.afficheArticle("refCroiss");
    }
}
