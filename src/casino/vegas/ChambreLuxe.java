/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package casino.vegas;

import static casino.vegas.Chambre.keyboard;

/**
 *
 * @author isen
 */
public class ChambreLuxe extends Chambre {

    /**
     *
     */
    public ChambreLuxe() {


        this.NbrOccupantsMax = 2;


    }
    /**
     * Cette méthode est celle qui se lance lorsqu'on prend un chambre Familliale
     * @param joueur est le personnage joué
     * @return la dette du joueur a la fin de son passage
     */
    static int Action(Client joueur) {
        int tempDette = 0;
        int choiceInt = -1;
        boolean wrong = true;
        System.out.println("Que voulez vous faire?"
                + "\n pour dormir tapez 1"
                + "\n pour appeler le room service tapez 2"
                + "\n pour partir tapez 3");

        do {
            String choice = keyboard.nextLine();
            try {
                choiceInt = Integer.parseInt(choice);
                if (choiceInt != 1 && choiceInt != 2 && choiceInt != 3) {
                    throw new Exception("not 1, 2 or 3");
                }
                wrong = false;
            } catch (Exception e) {
                System.out.println("Mauvaise valeur insérée");
            }
        } while (wrong);
        switch (choiceInt) {
            case 1:
                dormir(joueur);
                break;
            case 2:
                tempDette += RoomService(joueur);
                break;
            default:
                break;

        }
        return tempDette;



    }

    /**
     * Permet au joueur de se reposer et de faire baisser le taux d'alcoolémie
     * @param joueur est le personnage joué
     */
    public static void dormir(Client joueur) {
        joueur.tauxAlcoolémie = 0;
        joueur.etatPsycho += 2;
        if (joueur.etatPsycho > 6) {
            joueur.etatPsycho = 6;
            joueur.definirEtatPsycho(joueur.etatPsycho);
        }



    }

    /**
     *
     * @param joueur est le personnage joué
     * @return la dette que devra le joueur à la fin de son passage
     */
    public static int RoomService(Client joueur) {

        int tempDette = 0;
        int choiceInt = -1;
        boolean wrong = false;
        System.out.println("Que voulez vous prendre?"
                + "/n pour de la nourriture tapez 1 (50€)"
                + "/n pour de la boisson tapez 2");
        do {
            String choice = keyboard.nextLine();
            try {
                choiceInt = Integer.parseInt(choice);
                if (choiceInt != 1 && choiceInt != 2) {
                    throw new Exception("not 1, 2");
                }
                wrong = false;
            } catch (Exception e) {
                System.out.println("Mauvaise valeur insérée");
            }
        } while (wrong);

        switch (choiceInt) {
            case 1:
                prendreNourriture(joueur);
                tempDette += 50;
                break;
            case 2:
                tempDette += prendreBoisson(joueur);

                break;

        }
        return tempDette;




    }

    /**
     *
     * @param joueur est le personnage joué
     */
    protected static void prendreNourriture(Client joueur) {

        System.out.println("Vous venez de manger");
        joueur.tauxAlcoolémie -= 5;
        if (joueur.tauxAlcoolémie < 0) {
            joueur.tauxAlcoolémie = 0;
        }


    }

    /**
     *
     * @param joueur le personnage joué
     * @return la dette que devra le joueur à la fin de son passage
     */
    protected static int prendreBoisson(Client joueur) {
        System.out.println("Vous allez boire une boisson");
        return Bar.PrendreUneConso(joueur);
    }
}