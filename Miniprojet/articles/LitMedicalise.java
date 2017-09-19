package articles;

/**
 * Created by E149769S on 19/09/17.
 */
public class LitMedicalise extends MobilierMedical{
    private boolean isElectric;

    public LitMedicalise(String reference, String marque, String modele, double prix_j, int nbDispo) {
        super(reference, marque, modele, prix_j, nbDispo);
    }
}
