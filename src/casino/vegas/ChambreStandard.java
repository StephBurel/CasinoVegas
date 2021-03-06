
package casino.vegas;

import static casino.vegas.Chambre.keyboard;
import static casino.vegas.ChambreLuxe.prendreNourriture;

/**
 * Cette classe herite de chambre et permet de prendre une chambre standard
 */
public class ChambreStandard extends Chambre {

    /**
     * Cette methode est celle qui se lance lorsqu'on prend une chambre standard
     *
     * @param joueur est le personnage joue
     * @return la dette que doit le joueur à la fin
     */
    public static int Action(Client joueur) {
        int tempDette = 0;
        int choiceInt = -1;
        boolean wrong = true;
        boolean quit = true;
        do {
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
                    System.out.println("Mauvaise valeur inseree");
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
                    quit = false;

            }
        } while (quit);
        return tempDette;
    }

    /**
     * Permet au joueur de se reposer et de faire baisser le taux d'alcoolemie
     *
     * @param joueur est le personnage joue
     */
    public static void dormir(Client joueur) {
        joueur.tauxAlcoolemie -= 5;
        if (joueur.tauxAlcoolemie < 0) {
            joueur.tauxAlcoolemie = 0;
        }
        joueur.etatPsycho++;
        if (joueur.etatPsycho > 6) {
            joueur.etatPsycho = 6;
        }

        joueur.definirEtatPsycho(joueur.etatPsycho);
    }

    /**
     * Cette methode permet d'appeler le room service donc soit de prendre une
     * boisson soit de la nourriture
     *
     * @param joueur est le personnage joue
     * @return la dette que doit le joueur à la fin
     */
    public static int RoomService(Client joueur) {

        int tempDette = 0;
        int choiceInt = -1;
        boolean wrong = false;
        System.out.println("Que voulez vous prendre?"
                + "\n pour de la nourriture tapez 1 (20€)"
                + "\n pour de la boisson tapez 2");
        do {
            String choice = keyboard.nextLine();
            try {
                choiceInt = Integer.parseInt(choice);
                if (choiceInt != 1 && choiceInt != 2) {
                    throw new Exception("not 1, 2");
                }
                wrong = false;
            } catch (Exception e) {
                System.out.println("Mauvaise valeur inseree");
            }
        } while (wrong);

        switch (choiceInt) {
            case 1:
                prendreNourriture(joueur);
                tempDette += 20;
                break;
            case 2:
                tempDette += prendreBoisson(joueur);
                break;

        }
        return tempDette;




    }

    /**
     * Cette methode permet de prendre de la nourriture
     *
     * @param joueur est le personnage joue
     */
    protected static void prendreNourriture(Client joueur) {

        System.out.println("Vous venez de manger");
        joueur.tauxAlcoolemie -= 2;
        if (joueur.tauxAlcoolemie < 0) {
            joueur.tauxAlcoolemie = 0;
        }



    }

    /**
     * Cette methode permet de prendre des boissons
     *
     * @param joueur est le personnage joue
     * @return la somme des boissons qu'a pris le joueur
     */
    protected static int prendreBoisson(Client joueur) {

        return Bar.PrendreUneConso(joueur);
    }
}
