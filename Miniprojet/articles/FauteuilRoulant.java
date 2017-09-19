package articles;

/**
 * Created by E149769S on 19/09/17.
 */
public class FauteuilRoulant extends Article{
    private double largeurAssise;
    private double poids;

    public FauteuilRoulant(String reference, String marque, String modele, double prix_j, int nbDispo) {
        super(reference, marque, modele, prix_j, nbDispo);
    }
}
