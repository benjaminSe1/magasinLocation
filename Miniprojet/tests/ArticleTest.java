package tests;

import java.util.ArrayList;

import articles.Article;

public class ArticleTest {

    public static void main(String[] args) {
        Article a1 = new Article("ref1", "marque1", "modele1", 1.0, 1);
        Article a2 = new Article("ref2", "marque2", "modele2", 2.0, 2);
        Article a3 = new Article("ref3", "marque3", "modele3", 3.0, 3);
        Article a4 = new Article("ref4", "marque4", "modele4", 4.0, 4);
        ArrayList<Article> articles = new ArrayList<>();
    }

}
