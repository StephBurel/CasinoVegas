
package casino.vegas;

import static casino.vegas.CasinoVegas.croupier;
import java.util.Scanner;

/**
 * Cette classe permet d'acceder au bar et de se detendre
 * 
 */
public class Bar {

    static Scanner keyboard = new Scanner(System.in);
    /**
     * represente le cumul du prix total des boissons du consommateur
     */
    public int dette = 0;
    
    private boolean paid = false;

    /**
     * Cette methode est la methode lancee au demarrage du bar
     *
     * @param perso est la personne que l'on joue actuellement
     */
    public void demarrer(Client perso) {

        int choiceInt = -1;
        this.dette = 0;
        boolean wrong = true;
        boolean continuer = true;
        String choice;
        char quit = 'N';
        System.out.println("Bienvenue dans le bar");
        System.out.println("Votre solde est de " + perso.soldeDuCompte);
        do {
            
            System.out.println("Votre dette actuelle  est de " + this.dette);
            System.out.println(" Que voulez vous faire?"
                    + "\n pour prendre une consommation tapez 1"
                    + "\n pour draguer tapez 2"
                    + "\n pour payer tapez 3"
                    + "\n pour quitter le bar taper 4");
            do {
                choice = keyboard.nextLine();
                try {
                    choiceInt = Integer.parseInt(choice);
                    if (choiceInt != 1 && choiceInt != 2 && choiceInt != 3 && choiceInt != 4) {
                        throw new Exception("not 1, 2 or 3 or 4");
                    }
                    wrong = false;
                } catch (Exception e) {
                    System.out.println("veuillez entrer 1, 2 ou 3 ou 4");
                    keyboard.next();
                }
            } while (wrong);
            wrong = true;
            switch (choiceInt) {
                case 1:
                    this.dette -= this.PrendreUneConso(perso);
                    break;
                case 2:
                    this.dette = this.draguer(perso,this.dette);
                    break;
                case 3:
                    this.payer(perso);
                    croupier.testerJoueur();
                    break;
                default:
                    if (paid) {
                        continuer = false;
                    } else {
                        System.out.println("\nVous ne pouvez partir sans avoir payer");
                    }
                    break;
            }

            wrong = true;
        } while (continuer);

    }

    /**
     * cette methode enleve au credit du client la somme equivalent de la
     * boisson choisi
     *
     * @param client ce paramceetre represente le client que l'on joue
     */
    public void payer(Personnage client) {

        System.out.println("vous devez payer " + this.dette);
        client.soldeDuCompte -= dette;
        dette = 0;
        paid = true;
        System.out.println("Votre solde est de " + client.soldeDuCompte + "€");
        if(client.soldeDuCompte <0 ){
            croupier.appelerLaSecurite();
        }

    }

    /**
     * cette enumeration represente toutes les choix de boissons possibles
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
     * Cette methode permet de choisir la boisson que l'on veut prendre et
     * calcul la dette en consequence
     *
     * @param joueur ce paramceetre represente le client que l'on joue
     * @return  la somme de la dette accumule
     */
    public static int PrendreUneConso(Client joueur) {

        String choix;
        int choixInt = -1;
        boolean wrong = true;
        Bar.boisson drink;
        System.out.println("Quelle boisson voulez vous choisir?"
                + "\n pour une biere tapez 1 " + boisson.Biere.prix + "€"
                + "\n pour une eau tapez 2 " + boisson.eau.prix + "€"
                + "\n pour une limonade tapez 3" + boisson.limonade.prix + "€"
                + "\n pour un whisky tapez 4 " + boisson.whisky.prix + "€");

        do {
        choix = keyboard.nextLine();
            try {
                choixInt = Integer.parseInt(choix);
                if (choixInt != 1 && choixInt != 2 && choixInt != 3 && choixInt != 4) {
                    throw new Exception("not 1, 2 or 3");
                }
                wrong = false;
            } catch (Exception e) {
                System.out.println("veuillez entrer 1, 2, 3 ou 4");
                keyboard.next();
            }
        } while (wrong);
        switch (choixInt) {
            case 1:
                drink = boisson.Biere;
                break;
            case 2:
                drink = boisson.eau;
                break;
            case 3:
                drink = boisson.limonade;
                break;
            case 4 : 
                drink = boisson.whisky;
                break;
            default:
                drink = boisson.eau;
                break;
        }

        joueur.tauxAlcoolemie += drink.alcoolemie;
        return drink.prix;
    }

    /**
     * Cette methode permet de se detendre et tenter de draguer pour annuler sa dette et faire baisser son taux d'hormones
     * 
     * @param joueur ce paramceetre represente le client que l'on joue
     * @param dette la dette que l'on avait initialement
     * @return  le montant de la dette apres les differentes opération
     */
    public int draguer(Client joueur, int dette) {
        
        int nombreAtrouver, nombreDuJoueur = 100, nombreEssais = 0;
        String nombreString;
        nombreAtrouver = (int) (Math.random() * 50);
        System.out.println("Si vous êtes bon en drague, l'autre personne paiera pour vous et votre dette sera efface");
        
        while(nombreDuJoueur != nombreAtrouver)
        {
            boolean recommencer = true;
            while (recommencer)
            {
                nombreString = keyboard.nextLine();
                try
                {
                   nombreDuJoueur = Integer.parseInt(nombreString);
                   recommencer = false;
                }
                catch (NumberFormatException e)
                {
                    recommencer = true;
                    System.out.println("Entrez un chiffre !");
                }

            }
            
            if (nombreDuJoueur < nombreAtrouver)
            {
                System.out.println("Le nombre à trouver est plus grand");
            }
            else if (nombreDuJoueur > nombreAtrouver)
            {
                System.out.println("Le nombre à trouver est plus petit");
            }
            nombreEssais ++;
        }
        
        if (nombreEssais <= 5)
        {
            System.out.println("Felicitation, quelqu'un vient de payer pour vous");
            dette = 0;
        }
        
        joueur.tauxHormone -= 10;
        if (joueur.tauxHormone < 0) {
            joueur.tauxHormone = 0;
        }
        return dette;
    }
}
