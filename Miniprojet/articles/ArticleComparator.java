package articles;

import java.util.Comparator;

/**
 * Classe permettant d'implémenter le comparateur d'article pour trier selon un filtre choisi.
 * Created by E145725x on 19/09/17.
 */
public class ArticleComparator implements Comparator<Article> {
    private String filtre;

    /**
     * Constructor
     * @param filtre - Le filtre de la recherche
     */
    public ArticleComparator(String filtre) {
        this.filtre = filtre;
    }

    /**
     * Méthode permettant de définir le résultat de la recherche.
     * @param o1 - Le premier article
     * @param o2 - Le deuxième article
     * @return - Le classement des articles selon le filtre choisi
     */
    public int compare(Article o1, Article o2) {
        if (o1.equals(o2))return 0;
        int res = 0;
        if(this.filtre == "prixCroiss"){
            if (o1.getPrix_j() < o2.getPrix_j()) {
                res = -1;
            } else if (o1.getPrix_j() == o2.getPrix_j()) {
                res = 0;
            } else {
                res = 1;
            }
        }else if(this.filtre == "prixDecroiss") {
            if (o1.equals(o2))
                return 0;
            if (o1.getPrix_j() > o2.getPrix_j()) {
                res = -1;
            } else if (o1.getPrix_j() == o2.getPrix_j()) {
                res = 0;
            } else {
                res = 1;
            }
        }else if(this.filtre == "refCroiss"){
            if (o1.equals(o2))return 0;
            if (o1.getReference().compareTo(o2.getReference()) < 0) {
                res = -1;
            } else if (o1.getReference().compareTo(o2.getReference()) == 0) {
                res = 0;
            } else {
                res = 1;
            }
        }else if(this.filtre == "refDecroiss"){
            if (o1.equals(o2))return 0;
            res = 0;
            if (o1.getReference().compareTo(o2.getReference()) > 0) {
                res = -1;
            } else if (o1.getReference().compareTo(o2.getReference()) == 0) {
                res = 0;
            } else {
                res = 1;
            }
        }else if(this.filtre == "marqueCroiss"){
            if (o1.equals(o2))return 0;
            res = 0;
            if (o1.getMarque().compareTo(o2.getMarque()) < 0) {
                res = -1;
            } else if (o1.getMarque().compareTo(o2.getMarque()) == 0) {
                res = 0;
            } else {
                res = 1;
            }
        }else if(this.filtre == "marqueDecroiss"){
            if (o1.equals(o2))return 0;
            res = 0;
            if (o1.getMarque().compareTo(o2.getMarque()) > 0) {
                res = -1;
            } else if (o1.getMarque().compareTo(o2.getMarque()) == 0) {
                res = 0;
            } else {
                res = 1;
            }
        }else if(this.filtre == "modeleCroiss"){
            if (o1.equals(o2))return 0;
            res = 0;
            if (o1.getModele().compareTo(o2.getModele()) < 0) {
                res = -1;
            } else if (o1.getModele().compareTo(o2.getModele()) == 0) {
                res = 0;
            } else {
                res = 1;
            }
        }else if(this.filtre == "modeleDecroiss"){
            if (o1.equals(o2))return 0;
            res = 0;
            if (o1.getModele().compareTo(o2.getModele()) > 0) {
                res = -1;
            } else if (o1.getModele().compareTo(o2.getModele()) == 0) {
                res = 0;
            } else {
                res = 1;
            }
        }
        return res;
    }
}