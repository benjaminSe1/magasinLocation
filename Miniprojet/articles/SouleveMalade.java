package articles;

/**
 * Created by E149769S on 19/09/17.
 */
public class SouleveMalade extends Article {
    private double capacite;
    private double angle;

    public SouleveMalade(String reference, String marque, String modele, double prix_j, int nbDispo) {
        super(reference, marque, modele, prix_j, nbDispo);
    }
}
