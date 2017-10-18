package articles;

/**
 * Classe permettant de modéliser l'article MobilierMedical.
 * Created by E149769S on 19/09/17.
 */
public class MobilierMedical extends Article {

    private String dimension;

    private double poidsMax;

    /**
     * Constructor
     * @param reference - La référence de l'article
     * @param marque - La marque de l'article
     * @param modele - Le modèle de l'article
     * @param prix_j - Le prix par jour de l'article
     * @param nbDispo - Le nombre d'article disponnibles
     */
    public MobilierMedical(String reference, String marque, String modele, double prix_j, int nbDispo) {
        super(reference, marque, modele, prix_j, nbDispo);
    }
}
