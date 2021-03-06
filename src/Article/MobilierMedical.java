package Article;

/**
 * Classe permettant de modéliser l'Article MobilierMedical.
 * Created by E149769S on 19/09/17.
 */
public class MobilierMedical extends Article {

    private String dimension;
    private double poidsMax;

    /**
     * Constructor
     *
     * @param reference - La référence de l'Article
     * @param marque    - La marque de l'Article
     * @param modele    - Le modèle de l'Article
     * @param prix_j    - Le prix par jour de l'Article
     * @param nbDispo   - Le nombre d'Article disponnibles
     */
    public MobilierMedical(String reference, String marque, String modele, double prix_j, int nbDispo) {
        super(reference, marque, modele, prix_j, nbDispo);
    }
}
