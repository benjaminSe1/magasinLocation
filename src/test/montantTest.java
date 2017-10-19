package test;

import articles.Article;
import exception.ArticleIndispoException;
import exception.LocationImpossibleException;
import main.Client;
import main.Location;
import main.Magasin;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by E145725X on 19/10/17.
 */
public class montantTest {

    public static void main(String[] args) throws ArticleIndispoException, ParseException, LocationImpossibleException {
        ArrayList<Article> articlesDispo = new ArrayList<Article>();
        Article a1 = new Article("ref1", "marque1", "modele1", 1.0, 50);
        Article a2 = new Article("ref2", "marque2", "modele2", 2.0, 50);
        Article a3 = new Article("ref3", "marque3", "modele3", 3.0, 50);
        Article a4 = new Article("ref4", "marque4", "modele4", 4.0, 50);
        Article a5 = new Article("ref5", "marque5", "modele5", 5.0, 50);
        articlesDispo.add(a1);
        articlesDispo.add(a2);
        articlesDispo.add(a3);
        articlesDispo.add(a4);
        articlesDispo.add(a5);
        Client c1 = new Client("Seche", "Benjamin", "3 Rue Maréchal Joffre", "01 02 03 04 05");
        Magasin mag = new Magasin("monMag", articlesDispo);
        HashMap<Article, Integer> tabLoc1 = new HashMap<>();
        tabLoc1.put(a1, 5);
        tabLoc1.put(a2, 1);
        System.out.println("=====================montant=====================");
        System.out.println(mag.getMontantPeriode("16/10/2017", "19/10/2017"));
        Location loc2 = mag.loue(tabLoc1, "17/10/2017", "18/10/2017", c1);
        Location loc3 = mag.loue(tabLoc1, "17/10/2017", "18/10/2017", c1);
        Location loc4 = mag.loue(tabLoc1, "17/10/2017", "18/10/2017", c1);
        Location loc5 = mag.loue(tabLoc1, "17/10/2017", "18/10/2017", c1);
        Location loc6 = mag.loue(tabLoc1, "17/10/2017", "18/10/2017", c1);
        Location loc7 = mag.loue(tabLoc1, "17/10/2017", "18/10/2017", c1);
        Location loc8 = mag.loue(tabLoc1, "17/10/2017", "18/10/2017", c1);
        Location loc9 = mag.loue(tabLoc1, "17/10/2017", "18/10/2017", c1);
        System.out.println("=====================montant=====================");
        System.out.println(mag.getMontantPeriode("16/10/2017", "19/10/2017"));
    }
}


