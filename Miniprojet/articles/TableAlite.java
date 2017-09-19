package articles;

/**
 * Created by E149769S on 19/09/17.
 */
public class TableAlite extends MobilierMedical {
    private int nbRoulette;

    public TableAlite(String reference, String marque, String modele, double prix_j, int nbDispo) {
        super(reference, marque, modele, prix_j, nbDispo);
    }
}
