package Main;

import java.util.ArrayList;

/**
 * Méthode qui permet de reprensenter un client du magasin
 * Created by E149769S on 19/09/17.
 */
public class Client {

    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private ArrayList<Location> locations;

    /**
     * Constructeur de la classe Client
     *
     * @param nom       Nom du client
     * @param prenom    Prénom du client
     * @param adresse   Adresse du client
     * @param telephone Télésphone du client
     */
    public Client(String nom, String prenom, String adresse, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.locations = new ArrayList<>();
    }

    /**
     * Méthode qui permet au client de rendre une de ses locations, c'est-a-dire de la supprimer de sa liste de locations
     *
     * @param location La location qu'il a rendu
     */
    public void rend(Location location) {
        this.locations.remove(location);
    }

    /**
     * Méthode qui permer d'ajouter un location à la liste de location du client
     *
     * @param loc La location à ajouter
     */
    public void ajouteLocation(Location loc) {
        this.locations.add(loc);
    }

    /**
     * Méthode qui permet d'afficher les locations en cours d'un client
     */
    public void afficheLocation() {
        System.out.println("Client : " + this.nom + " " + this.prenom);
        System.out.println("Liste des locations du client : \n" + locations.toString());
    }

    /**
     * Méthode accesseur du nom
     * @return String - Le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode accesseur du prénom
     * @return String - Le prénom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Méthode permettant de comparer deux Clients
     * @param o - Le client à comparer au client courrant
     * @return - True si ils sont égaux, faux sinon.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Client client = (Client) o;
        if (nom != null ? !nom.equals(client.nom) : client.nom != null) {
            return false;
        }
        return prenom != null ? prenom.equals(client.prenom) : client.prenom == null;
    }

    /**
     * Méthode permettant de récupérer un client à partir de son nom et son prénom
     * @param nom - Le nom du client recherché
     * @param prenom - Le prénom du client recherché
     * @return Client - Le client recherché
     */
    public Client getClient(String nom, String prenom){
        if (this.getNom().equals(nom) && this.getPrenom().equals(prenom)) {
            return this;
        } else {
            return null;
        }
    }
}
