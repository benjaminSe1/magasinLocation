package Article;

/**
 * Classe permettant de modéliser l'Article MatelasAir.
 * Created by E149769S on 19/09/17.
 */
public class MatelasAir extends MobilierMedical {

    private String dimension;
    private double poidsMax;
    private double tempsGonflage;

    /**
     * Constructor
     *
     * @param reference - La référence de l'Article
     * @param marque    - La marque de l'Article
     * @param modele    - Le modèle de l'Article
     * @param prix_j    - Le prix par jour de l'Article
     * @param nbDispo   - Le nombre d'Article disponnibles
     */
    public MatelasAir(String reference, String marque, String modele, double prix_j, int nbDispo) {
        super(reference, marque, modele, prix_j, nbDispo);
    }
}
