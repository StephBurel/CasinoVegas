
package casino.vegas;

import static casino.vegas.Chambre.keyboard;
import static casino.vegas.ChambreLuxe.prendreNourriture;

/**
 * Cette classe herite de chambre et permet de prendre une chambre familliale
 */
public class ChambreFamiliale extends Chambre {

    /**
     * Cette methode est celle qui se lance lorsqu'on prend une chambre Familliale
     *
     * @param joueur est le personnage joue
     * @return la dette que devra le joueur à la fin de son passage
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
                    break;

            }
        } while (quit);
        return tempDette;
    }

    /**
     * Permet au joueur de se reposer et de faire baisser le taux d'alcoolemie
     *
     * @param joueur
     */
    public static void dormir(Client joueur) {
        joueur.tauxAlcoolemie -= 5;
        if (joueur.tauxAlcoolemie < 0) {
            joueur.tauxAlcoolemie = 0;
        }

    }

    /**
     *
     * @param joueur est le personnage joue
     * @return la dette que devra le joueur à la fin de son passage
     */
    public static int RoomService(Client joueur) {

        int tempDette = 0;
        int choiceInt = -1;
        boolean wrong = false;
        System.out.println("Que voulez vous prendre?"
                + "\n pour de la nourriture tapez 1 (50€)"
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
                tempDette += 50;
                break;
            case 2:
                tempDette += prendreBoisson(joueur);

                break;

        }
        return tempDette;

    }

    /**
     * Vous permet de vous nourrir et de faire baisser le taux d'alcoolemie
     *
     * @param joueur est le personnage joue
     */
    protected static void prendreNourriture(Client joueur) {

        System.out.println("Vous venez de manger");
        joueur.tauxAlcoolemie -= 5;
        if (joueur.tauxAlcoolemie < 0) {
            joueur.tauxAlcoolemie = 0;
        }



    }

    /**
     * Cette methode vous permet de prendre une boisson
     *
     * @param joueur
     * @return la dette que vous devrez payer
     */
    protected static int prendreBoisson(Client joueur) {

        return Bar.PrendreUneConso(joueur);

    }
}
