package Article;

/**
 * Classe permettant de modéliser un Article
 * Created by E149769S on 19/09/17.
 */
public class Article {

    private String reference;
    private String marque;
    private String modele;
    private double prix_j;
    private int nbDispo;

    /**
     * Constructor
     *
     * @param reference - La référence de l'Article
     * @param marque    - La marque de l'Article
     * @param modele    - Le modèle de l'Article
     * @param prix_j    - Le prix par jour de l'Article
     * @param nbDispo   - Le nombre d'Article disponnibles
     */
    public Article(String reference, String marque, String modele, double prix_j, int nbDispo) {
        this.reference = reference;
        this.marque = marque;
        this.modele = modele;
        this.prix_j = prix_j;
        this.nbDispo = nbDispo;
    }

    /**
     * Méthode permettant de définir l'affichage d'un Article.
     *
     * @return String - L'affichage d'un Article sous forme de String.
     */
    public String toString() {
        return "Référence Article : " + this.reference + ", Marque : " + this.marque + ", Modèle : " + this.modele + ", Prix/jour : " + this.prix_j + ", Nombre d'articles disponibles : " + this.nbDispo;
    }

    /**
     * Méthode permettant de récupérer la référence de l'Article
     *
     * @return String - La référence de l'Article
     */
    public String getReference() {
        return reference;
    }

    /**
     * Méthode permettant de récupérer la marque de l'Article
     *
     * @return String - La marque de l'Article
     */
    public String getMarque() {
        return marque;
    }

    /**
     * Méthode permettant de récupérer le modèle de l'Article
     *
     * @return String - Le modèle de l'Article
     */
    public String getModele() {
        return modele;
    }

    /**
     * Méthode permettant de récupérer le prix par jour de l'Article
     *
     * @return Double - Le prix par jour de l'Article
     */
    public double getPrix_j() {
        return prix_j;
    }

    /**
     * Méthode permettant de récupérer le nombre d'articles disponnibles
     *
     * @return int - Le nombre d'articles disponnibles
     */
    public int getNbDispo() {
        return nbDispo;
    }

    /**
     * Méthode permettant de mettre à jour le nombre d'articles disponnibles
     *
     * @param nbDispo - Le nombre d'articles disponnibles
     */
    public void setNbDispo(int nbDispo) {
        this.nbDispo = nbDispo;
    }

    /**
     * Méthode permettant de redéfinir la méthode equals
     *
     * @param a - L'Article à comparer
     * @return Boolean - True si vrai, False sinon
     */
    public boolean equals(Article a) {
        return this.reference == a.reference;
    }

    /**
     * Méthode qui permet de décrémenter le nombre d'articles dispo de la classe.
     *
     * @param nbADecrementer - Le nombre d'articles à enlever au nombre d'articles disponnibles
     * @return Boolean - True si l'opération est possible, False sinon.
     */
    public boolean decrementeDispo(int nbADecrementer) {
        if (this.nbDispo >= nbADecrementer) {
            this.nbDispo -= nbADecrementer;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Méthode qui permet d'incrémenter le nombre d'articles dispo de la classe.
     *
     * @param nbAIncrementer - Le nombre d'articles à ajouter au nombre d'articles disponnibles
     */
    public void incrementeDispo(int nbAIncrementer) {
        this.nbDispo += nbAIncrementer;
    }
}
