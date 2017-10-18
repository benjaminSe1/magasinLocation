package articles;

/**
 * Classe permettant de modéliser l'article SouleveMalade.
 * Created by E149769S on 19/09/17.
 */
public class SouleveMalade extends Article {

    private double capacite;

    private double angle;

    /**
     * Constructor
     * @param reference - La référence de l'article
     * @param marque - La marque de l'article
     * @param modele - Le modèle de l'article
     * @param prix_j - Le prix par jour de l'article
     * @param nbDispo - Le nombre d'article disponnibles
     */
    public SouleveMalade(String reference, String marque, String modele, double prix_j, int nbDispo) {
        super(reference, marque, modele, prix_j, nbDispo);
    }
}
