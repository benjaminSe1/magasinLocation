package Application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import article.Article;
import article.FauteuilRoulant;
import article.LitMedicalise;
import article.MatelasAir;
import article.SouleveMalade;
import article.TableAlite;
import exception.ArticleIndispoException;
import exception.LocationImpossibleException;
import main.Client;
import main.Location;
import main.Magasin;

/**
 * Classe principale permettant de tester notre application.
 * Created by Sejuapig on 19/10/2017.
 */
public class Main {

    public static void main(String[] args) throws ParseException, ArticleIndispoException, LocationImpossibleException {
        boolean res = true;
        Client c1 = new Client("Seche", "Benjamin", "3 Rue Maréchal Joffre", "01 02 03 04 05");
        Client c2 = new Client("Abdelaziz", "Mathis", "3 Rue Maréchal Joffre", "01 02 03 04 05");
        Client c3 = new Client("Chouin", "Nicolas", "3 Rue Maréchal Joffre", "01 02 03 04 05");

        ArrayList<Article> articlesDispo = new ArrayList<Article>();
        Article a1 = new LitMedicalise("ref1", "marque1", "modele1", 1.0, 5);
        Article a2 = new MatelasAir("ref2", "marque2", "modele2", 2.0, 5);
        Article a3 = new SouleveMalade("ref3", "marque3", "modele3", 3.0, 5);
        Article a4 = new FauteuilRoulant("ref4", "marque4", "modele4", 4.0, 5);
        Article a5 = new TableAlite("ref5", "marque5", "modele5", 5.0, 5);
        articlesDispo.add(a1);
        articlesDispo.add(a2);
        articlesDispo.add(a3);
        articlesDispo.add(a4);
        articlesDispo.add(a5);

        Magasin m1 = new Magasin("monMag", articlesDispo);

        HashMap<Article, Integer> tabLoc1 = new HashMap<>();
        tabLoc1.put(a1, 1);

        HashMap<Article, Integer> tabLoc2 = new HashMap<>();
        tabLoc1.put(a2, 1);

        HashMap<Article, Integer> tabLoc3 = new HashMap<>();
        tabLoc1.put(a3, 1);

        Location l1 = m1.loue(tabLoc1, "17/10/2017", "18/10/2017", c1);
        Location l2 = m1.loue(tabLoc2, "19/10/2017", "20/10/2017", c2);
        Location l3 = m1.loue(tabLoc3, "21/10/2017", "22/10/2017", c3);


        Scanner scanner = new Scanner(System.in);
        while(res){
            System.out.println("_________________________________________");
            System.out.println("|       Pour effectuer un action,       |");
            System.out.println("| Entrez un numéro  :                   |");
            System.out.println("| 1: Afficher l'ensemble des articles   |");
            System.out.println("| 2: Enregistrer les locations          |");
            System.out.println("| 3: Afficher les locations d'un client |");
            System.out.println("| 4: Archiver les locations dans .loc   |");
            System.out.println("| 5: Calculer les recettes              |");
            System.out.println("| 6: Quitter le terminal des requetes   |");
            System.out.println("| 7: Lancement du cas de test préfait   |");
            System.out.println("_________________________________________");

            int choix = scanner.nextInt();
            if(choix < 1 || choix > 7 ){
                clearScreen();
                System.out.println("Erreur de choix !");
            }
            switch(choix){
                case 1:
                    clearScreen();
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
                    clearScreen();
                    m1.afficheArticle(filtre);
                    break;
                case 2:
                    clearScreen();
                    m1.loue(l1);
                    m1.loue(l2);
                    m1.loue(l3);
                    break;
                case 3:
                    clearScreen();

                    System.out.print("Listes des clients louant actuellement : \n"); //Aide pour retenir les clients
                    for (Client c : m1.getClients()){
                        System.out.println("Prenom : " + c.getPrenom() + " | Nom : " + c.getNom());
                    }

                    System.out.println("\nEntrer le nom du client : ");
                    String nom = scanner.next();
                    System.out.println("Entrer le prenom du client : ");
                    String prenom = scanner.next();
                    if(!m1.existeClient(nom, prenom)){
                        System.out.println("Le client n'a jamais effectué de location dans le magasin.");
                    }
                    break;
                case 4:
                    clearScreen();
                    System.out.println("Veuillez saisir le mois dont vous souhaitez archiver les locations" +
                        "\nLe mois est à renseigner selon un numéro" +
                        "\nLe 1 étant Janvier, le 12 Décembre");
                    int choixMois = scanner.nextInt();
                    if(choixMois < 1 || choixMois > 12 ){
                        clearScreen();
                        System.out.println("Erreur de choix !");
                    } else{
                        m1.archiveMois(choixMois);
                    }
                    break;
                case 5:
                    clearScreen();
                    System.out.println("Veuillez écrire les dates suivantes de cette facon :" +
                        "\nJJ/MM/YYYY" +
                        "\nYYYY L'annee exemple : 2017" +
                        "\nMM Le mois exemple : 11" +
                        "\nJJ Le jour exemple : 10");
                    System.out.println("Entrez la date de debut : ");
                    String choixDate1 = scanner.next();
                    System.out.println("Entrez la date de fin : ");
                    String choixDate2 = scanner.next();
                    m1.getMontantPeriode(choixDate1, choixDate2);
                    break;
                case 6:
                    clearScreen();
                    System.out.println("_________________________________________");
                    System.out.println("|               Au revoir                |");
                    System.out.println("_________________________________________");
                    res = false;
                    break;
                case 7:
                    clearScreen();
                    System.out.println("Lancement du cas de test");
                    //m1.afficheEnsArticle(1);
                    System.out.println("\n");
                    m1.loue(l1);
                    m1.loue(l2);
                    m1.loue(l3);
                    System.out.println("\n");
                    m1.existeClient(c1.getNom(), c1.getPrenom());
                    System.out.println("\n");
                    m1.existeClient(c2.getNom(), c2.getPrenom());
                    System.out.println("\n");
                    m1.existeClient(c3.getNom(), c3.getPrenom());
                    System.out.println("\n");
                    //m1.archiveLoc();
                    System.out.println("\n");
                    System.out.println(m1.getMontantPeriode("10/10/2017", "01/10/2018"));
            }
        }
    }

    private static void clearScreen(){
        System.out.flush();
    }
}
