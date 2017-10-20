package Application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import Article.Article;
import Article.FauteuilRoulant;
import Article.LitMedicalise;
import Article.MatelasAir;
import Article.SouleveMalade;
import Article.TableAlite;
import Exception.ArticleIndispoException;
import Exception.LocationImpossibleException;
import Main.Client;
import Main.Location;
import Main.Magasin;

import static Main.Magasin.stringToDate;

/**
 * Classe principale permettant de tester notre application.
 * Created by Sejuapig on 19/10/2017.
 */
public class Main {

    public static void main(String[] args) throws ParseException, ArticleIndispoException, LocationImpossibleException {
        boolean run = true;

        //Création de trois nouveaux clients
        Client c1 = new Client("Seche", "Benjamin", "3 Rue Maréchal Joffre", "01 02 03 04 05");
        Client c2 = new Client("Abdelaziz", "Mathis", "3 Rue Maréchal Joffre", "01 02 03 04 05");
        Client c3 = new Client("Chouin", "Nicolas", "3 Rue Maréchal Joffre", "01 02 03 04 05");

        //Création d'une liste d'articles
        ArrayList<Article> articlesDispo = new ArrayList<Article>();
        //Création de cinq articles
        Article a1 = new LitMedicalise("ref1", "marque1", "modele1", 1.0, 5);
        Article a2 = new MatelasAir("ref2", "marque2", "modele2", 2.0, 5);
        Article a3 = new SouleveMalade("ref3", "marque3", "modele3", 3.0, 5);
        Article a4 = new FauteuilRoulant("ref4", "marque4", "modele4", 4.0, 5);
        Article a5 = new TableAlite("ref5", "marque5", "modele5", 5.0, 5);
        //Ajout des articles dans la liste d'articles
        articlesDispo.add(a1);
        articlesDispo.add(a2);
        articlesDispo.add(a3);
        articlesDispo.add(a4);
        articlesDispo.add(a5);

        //Création d'un magasin
        Magasin m1 = new Magasin("monMag", articlesDispo);

        //Création d'HashMaps contenant des articles et le nombre de cet article loués
        HashMap<Article, Integer> tabLoc1 = new HashMap<>();
        tabLoc1.put(a1, 1);

        HashMap<Article, Integer> tabLoc2 = new HashMap<>();
        tabLoc2.put(a2, 1);

        HashMap<Article, Integer> tabLoc3 = new HashMap<>();
        tabLoc3.put(a3, 1);

        //Création des dates de début et fin de locations
        Date dateDebutL1 = stringToDate("17/10/2017");
        Date dateFinL1 = stringToDate("18/10/2017");

        Date dateDebutL2 = stringToDate("19/10/2017");
        Date dateFinL2 = stringToDate("20/10/2017");

        Date dateDebutL3 = stringToDate("21/10/2017");
        Date dateFinL3 = stringToDate("22/10/2017");

        //Création de trois locations (Une pour chaque client)
        Location l1 = new Location(dateDebutL1, dateFinL1, tabLoc1, c1);
        Location l2 = new Location(dateDebutL2, dateFinL2, tabLoc2, c2);
        Location l3 = new Location(dateDebutL3, dateFinL3, tabLoc3, c3);


        //On demande à l'utilisateur de choisir un chiffre de 1 à 7
        Scanner scanner = new Scanner(System.in);
        while(run){
            //Affichage des choix de l'utilisateur
            System.out.println("__________________________________________");
            System.out.println("|       Pour effectuer un action,        |");
            System.out.println("| Veuillez entrer un numéro  :           |");
            System.out.println("| 1: Afficher l'ensemble des articles    |");
            System.out.println("| 2: Louer les articles préféfinis       |");
            System.out.println("| 3: Afficher les locations d'un client  |");
            System.out.println("| 4: Archiver les locations dans le .loc |");
            System.out.println("| 5: Calculer les recettes d'une période |");
            System.out.println("| 6: Quitter l'application               |");
            System.out.println("| 7: Lancement du cas de test préfait    |");
            System.out.println("__________________________________________");

            //Récupération du choix de l'utilisateur
            int choix = scanner.nextInt();
            //Si le choix n'est pas entre 1 et 7, on notifie l'erreur de l'utilisateur
            if(choix < 1 || choix > 7 ){
                flushScreen();
                System.out.println("Erreur de choix !");
            }
            //Pour chaque choix de l'utilisateur, on effectue une action différente
            switch(choix){
                case 1:
                    //Le cas 1 demande par quel moyen l'utilisateur veut trier l'affichage des articles
                    flushScreen();
                    System.out.println("_________________________________________");
                    System.out.println("| Veuillez choisir comment afficher     |" +
                                     "\n| l'ensemble des articles :             |");
                    System.out.println("\n| 1 : Réference Croissante               | " +
                                        "\n| 2 : Réference Décroissante            | " +
                                        "\n| 3 : Modèle Croissant                  | " +
                                        "\n| 4 : Modèle Décroissant                | " +
                                        "\n| 5 : Marque Croissant                  | " +
                                        "\n| 6 : Marque Décroissant                | " +
                                        "\n| 7 : Prix par jour Croissant           | " +
                                        "\n| 8 : Prix par jour Décroissant         |");
                    System.out.println("_________________________________________");
                    int choixFiltre = scanner.nextInt();
                    String filtre = "";
                    switch(choixFiltre) {
                        case 1:
                            filtre = "refCroiss";
                            break;
                        case 2:
                            filtre = "refDecroiss";
                            break;
                        case 3:
                            filtre = "modeleCroiss";
                            break;
                        case 4:
                            filtre = "modeleDecroiss";
                            break;
                        case 5:
                            filtre = "marqueCroiss";
                            break;
                        case 6:
                            filtre = "marqueDecroiss";
                            break;
                        case 7:
                            filtre = "prixCroiss";
                            break;
                        case 8:
                            filtre = "prixDecroiss";
                            break;
                    }
                    flushScreen();
                    m1.afficheArticle(filtre);
                    break;
                case 2:
                    flushScreen();
                    m1.loue(l1);
                    m1.loue(l2);
                    m1.loue(l3);
                    break;
                case 3:
                    flushScreen();

                    System.out.print("Listes des clients louant actuellement : \n"); //Aide pour retenir les clients
                    for (Client c : m1.getClients()){
                        System.out.println("Prenom : " + c.getPrenom() + " | Nom : " + c.getNom());
                    }

                    System.out.println("\nEntrer le nom du client : ");
                    String nom = scanner.next();
                    System.out.println("Entrer le prenom du client : ");
                    String prenom = scanner.next();
                    //Si le client n'existe pas
                    if(!m1.existeClient(nom, prenom)){
                        System.out.println("Le client n'a jamais effectué de location dans le magasin.");
                    } else {
                        m1.getClient(nom, prenom).afficheLocation();
                    }
                    break;
                case 4:
                    flushScreen();
                    System.out.println("Veuillez saisir le mois dont vous souhaitez archiver les locations" +
                        "\nLe mois est à renseigner selon un numéro" +
                        "\nLe 1 étant Janvier, le 12 Décembre");
                    int choixMois = scanner.nextInt();
                    if(choixMois < 1 || choixMois > 12 ){
                        flushScreen();
                        System.out.println("Erreur de choix !");
                    } else{
                        m1.archiveMois(choixMois);
                    }
                    break;
                case 5:
                    flushScreen();
                    System.out.println("Veuillez écrire les dates suivantes de cette facon :" +
                        "\nJJ/MM/AAAA" +
                        "\nAAAA L'annee exemple : 2017" +
                        "\nMM Le mois exemple : 11" +
                        "\nJJ Le jour exemple : 10");
                    System.out.println("Entrez la date de debut : ");
                    String choixDate1 = scanner.next();
                    System.out.println("Entrez la date de fin : ");
                    String choixDate2 = scanner.next();
                    System.out.println(m1.getMontantPeriode(choixDate1, choixDate2));
                    break;
                case 6:
                    flushScreen();
                    System.out.println("_________________________________________");
                    System.out.println("|               Au revoir                |");
                    System.out.println("_________________________________________");
                    run = false;
                    break;
                case 7:
                    flushScreen();
                    //Cas de test automatique
                    System.out.println("Lancement du cas de test");
                    System.out.println("Affichage de la liste des articles du magasin : \n");
                    //On met le filtre de recherche d'articles à marque décroissantes.
                    String articleFiltre = "marqueCroiss";
                    m1.afficheArticle(articleFiltre);
                    System.out.println("\n");
                    System.out.println("Enregistrement des locations.");
                    m1.loue(l1);
                    m1.loue(l2);
                    m1.loue(l3);
                    System.out.println("\n");
                    System.out.println("Affichage des locations pour le client Seche Benjamin : \n");
                    String clientNom = "Seche";
                    String clientPrenom = "Benjamin";
                    m1.getClient(clientNom, clientPrenom).afficheLocation();
                    System.out.println("\n");
                    System.out.println("Archivage des locations du mois d'octobre : \n");
                    int testChoixMois = 10;
                    m1.archiveMois(testChoixMois);
                    System.out.println("\n");
                    System.out.println("Calcul des recettes pour la période du 10 au 23 octobre : \n");
                    System.out.println(m1.getMontantPeriode("10/10/2017", "23/10/2018"));
                    System.out.println("\n");
                    System.out.println("Fin du cas de test.");
                    run = false;
                    break;
            }
        }
    }

    /**
     * Méthode permettant de supprimer le contenu de la sortie standard, ici le terminal.
     */
    private static void flushScreen(){
        System.out.flush();
    }
}
