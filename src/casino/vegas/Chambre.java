/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package casino.vegas;

import java.util.Scanner;

/**
 *
 * @author isen
 */
public class Chambre {

    /**
     *
     */
    protected Client perso;
    /**
     *
     */
    public int NbrOccupantsMax;
    /**
     * C'est ce que le client devra payer a la fin pour payer tout ce qu'il a
     * consommer
     */
    public int dette = 0;
    /**
     *
     */
    public static Scanner keyboard = new Scanner(System.in);

    enum chambre {

        luxe(100), familialle(60), standard(50);
        private int prix;

        chambre(int prix) {
            this.prix = prix;
        }
    }

    /**
     * C'est ce qui est lancé quand on entre dans la chambre
     *
     * @param joueur : le personnage joué
     */
    public void demarrer(Client joueur) {

        int choiceInt = -1;
        boolean wrong = true;
        System.out.println("Bienvenue dans l'hôtel\nQue voulez-vous faire?");

        System.out.println("Bienvenue à l'hotel du Casino"
                + "\nVeuillez choisir la chambre désirée"
                + "\n pour prendre une chambre de luxe tapez 1"
                + "\n pour prendre une chambre familiale tapez 2"
                + "\n pour une chambre standard tapez 3");
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
                this.dette += 100;
                this.dette += ChambreLuxe.Action(joueur);

                break;
            case 2:
                this.dette += 60;
                this.dette += ChambreFamiliale.Action(joueur);
                break;
            case 3:
                this.dette += 50;
                this.dette += ChambreStandard.Action(joueur);
                break;
        }
        this.PrendreUneChambre(joueur);


    }

    /**
     * Méthode réglant les dettes que doit le joueur
     *
     * @param joueur le personnage joué
     */
    public void PrendreUneChambre(Personnage joueur) {

        joueur.soldeDuCompte -= this.dette;

    }
}
