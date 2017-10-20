package Test;

import java.util.ArrayList;

import Article.Article;
import Article.ArticleComparator;

public class ArticleTest {

    public static void main(String[] args) {
        //Création de quatre articles
        Article a1 = new Article("ref1", "marque1", "modele1", 1.0, 1);
        Article a2 = new Article("ref2", "marque2", "modele2", 2.0, 2);
        Article a3 = new Article("ref3", "marque3", "modele3", 3.0, 3);
        Article a4 = new Article("ref4", "marque4", "modele4", 4.0, 4);
        //Création d'une liste d'articles
        ArrayList<Article> articles = new ArrayList<>();
        articles.add(a1);
        articles.add(a2);
        articles.add(a3);
        articles.add(a4);
        //Test de l'affichage trié des articles
        articles.sort(new ArticleComparator("refCroiss"));
        System.out.println("refCroiss " + articles.toString());
        articles.sort(new ArticleComparator("refDecroiss"));
        System.out.println("refDecroiss " + articles.toString());
        articles.sort(new ArticleComparator("prixCroiss"));
        System.out.println("prixCroiss " + articles.toString());
        articles.sort(new ArticleComparator("prixDecroiss"));
        System.out.println("prixDecroiss " + articles.toString());
        articles.sort(new ArticleComparator("marqueCroiss"));
        System.out.println("marqueCroiss " + articles.toString());
        articles.sort(new ArticleComparator("marqueDecroiss"));
        System.out.println("marqueDecroiss " + articles.toString());
        articles.sort(new ArticleComparator("modeleCroiss"));
        System.out.println("modeleCroiss " + articles.toString());
        articles.sort(new ArticleComparator("modeleDecroiss"));
        System.out.println("modeleDecroiss " + articles.toString());
    }
}