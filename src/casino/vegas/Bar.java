/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package casino.vegas;

import java.util.Scanner;

/**
 * @author isen
 */
public class Bar {

    static Scanner keyboard = new Scanner(System.in);
    /**
     * représente le cumul des du prix total des boissons du consommateur
     */
    public int dette = 0;
    public Client client = new Client();

    /**
     * Cette méthode est la méthode lancée au démarrage du bar
     *
     * @param perso est la personne que l'on joue actuellement
     */
    public void demarrer(Client perso) {

        int choiceInt = -1;
        dette = 0;
        this.client = perso;
        boolean wrong = true;
        boolean continuer = true;
        String choice;
        char quit = 'N';
        do {
            System.out.println("Bienvenue dans le bar");
            System.out.println("\n Que voulez vous faire?"
                    + "\n pour prendre une consommation tapez 1"
                    + "\n pour draguer tapez 2"
                    + "\n pour payer tapez 3");
            do {
                choice = keyboard.nextLine();
                try {
                    choiceInt = Integer.parseInt(choice);
                    if (choiceInt != 1 && choiceInt != 2 && choiceInt != 3) {
                        throw new Exception("not 1, 2 or 3");
                    }
                    wrong = false;
                } catch (Exception e) {
                    System.out.println("veuillez entrer 1, 2 ou 3");
                    keyboard.next();
                }
            } while (wrong);
            wrong = true;
            switch (choiceInt) {
                case 1:
                    this.dette -= this.PrendreUneConso(client);
                    break;
                case 2:
                    this.draguer(client);
                    break;
                case 3:
                    this.payer(client);
                    break;
                default:
                    break;
            }
            System.out.println("Voulez vous partir? Y/N");
            do {
                try {
                    String quitStr = keyboard.nextLine();
                    quit = quitStr.charAt(0);
                    if (quit != 'Y' && quit != 'N') {
                        throw new Exception("not Y or N");
                    } else if (quit == 'Y') {
                        continuer = false;
                    }
                    wrong = false;
                } catch (Exception e) {
                    System.out.println("Veuillez entre Y ou N");
                    keyboard.next();
                }
            } while (wrong);
            wrong = true;
        } while (continuer);

    }

    /**
     * cette méthode enlève au crédit du client la somme équivalent de la
     * boisson choisi
     *
     * @param client ce paramètre représente le client que l'on joue
     */
    public void payer(Personnage client) {

        client.soldeDuCompte -= dette;

    }

    /**
     * cette énumération représente toutes les choix de boissons possibles
     */
    enum boisson {

        Biere(5, 6), eau(1, 0), limonade(2, 0), whisky(10, 40);
        private int prix;
        private int alcoolemie;

        boisson(int prix, int alcoolemie) {
            this.prix = prix;
            this.alcoolemie = alcoolemie;
        }
    }

    /**
     * Cette méthode permet de choisir la boisson que l'on veut prendre et
     * calcul la dette en conséquence
     *
     */
    public static int PrendreUneConso(Client joueur) {

        int choice = -1;
        boolean wrong = true;
        Bar.boisson drink;
        System.out.println("Quelle boisson voulez vous choisir?"
                + "\n pour une biere tapez 1"
                + "\n pour une eau tapez 2"
                + "\n pour une limonade tapez 3");

        do {

            try {
                choice = keyboard.nextInt();
                if (choice != 1 && choice != 2 && choice != 3) {
                    throw new Exception("not 1, 2 or 3");
                }
                wrong = false;
            } catch (Exception e) {
                System.out.println("veuillez entrer 1, 2 ou 3");
                keyboard.next();
            }
        } while (wrong);
        switch (choice) {
            case 1:
                drink = boisson.Biere;
                break;
            case 2:
                drink = boisson.eau;
                break;
            case 3:
                drink = boisson.limonade;
                break;
            default:
                drink = boisson.eau;
                break;
        }

        joueur.tauxAlcoolémie += drink.alcoolemie;
        return drink.prix;
    }

    /**
     * Cette méthode permet de se détendre et tenter de draguer
     */
    public void draguer(Client joueur) {
        joueur.tauxHormone -= 10;
        if (joueur.tauxHormone < 0) {
            joueur.tauxHormone = 0;
        }
        System.out.println("Vous venez de rencontrer une jolie fille \nQue lui racontez vous?");

    }
}
