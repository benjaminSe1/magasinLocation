package tests;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import articles.Article;
import exception.ArticleIndispoException;
import exception.LocationImpossibleException;
import main.Archive;
import main.Client;
import main.Location;
import main.Magasin;

public class MagasinTest {

    public static void main(String[] args) throws ArticleIndispoException, ParseException, LocationImpossibleException {
        ArrayList<Article> articlesDispo = new ArrayList<Article>();
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

        Client c1 = new Client("Seche", "Benjamin", "3 Rue Maréchal Joffre", "01 02 03 04 05", new ArrayList<>());
        Archive archive = new Archive();
        Magasin mag = new Magasin("monMag", articlesDispo, archive);

        System.out.println(mag.afficheArticle("refCroiss"));
        HashMap<Article, Integer> tabLoc1 = new HashMap<>();
        tabLoc1.put(a1, 1);
        tabLoc1.put(a2, 2);

        Location loc = mag.loue(tabLoc1, "17/10/2017", "18/10/2017", c1);
        System.out.println(mag.afficheArticle("refCroiss"));
        mag.rend(loc);
        System.out.println(mag.afficheArticle("refCroiss"));

        Location loc2 = mag.loue(tabLoc1, "17/10/2017", "18/10/2017", c1);
        System.out.println(mag.afficheArticle("refCroiss"));
    }
}
