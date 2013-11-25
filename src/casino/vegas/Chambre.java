
package casino.vegas;

import static casino.vegas.CasinoVegas.croupier;
import java.util.Scanner;

/**
 * Cette classe permet de pouvoir prendre une chambre et ainsi de changer nos attributs
 */
public class Chambre {

    /**
     * C'est ce que le client devra payer a la fin pour payer tout ce qu'il a consomme
     */
    public int dette = 0;
    /**
     *
     */
    public static Scanner keyboard = new Scanner(System.in);

    

    /**
     * C'est ce qui est lance quand on entre dans la chambre
     *
     * @param joueur : le personnage joue
     */
    public void demarrer(Client joueur) {

        int choiceInt = -1;
        boolean wrong = true;
        System.out.println("Bienvenue dans l'hôtel\nQue voulez-vous faire?");
        System.out.println("Votre solde est de " + joueur.soldeDuCompte + "€");
        System.out.println("Bienvenue à l'hotel du Casino"
                + "\nVeuillez choisir la chambre desiree"
                + "\n pour prendre une chambre de luxe (100€) tapez 1"
                + "\n pour prendre une chambre familiale (60€) tapez 2"
                + "\n pour une chambre standard (50€) tapez 3"
                + "\n pour partir tapez 4");
        do {
            String choice = keyboard.nextLine();
            try {
                choiceInt = Integer.parseInt(choice);
                if (choiceInt != 1 && choiceInt != 2 && choiceInt != 3 && choiceInt != 4) {
                    throw new Exception("not 1, 2 or 3or 4");
                }
                wrong = false;
            } catch (Exception e) {
                System.out.println("Mauvaise valeur inseree");
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
            default : 
                break;
        }
        this.PrendreUneChambre(joueur);


    }

    /**
     * Methode reglant les dettes que doit le joueur
     *
     * @param joueur le personnage joue
     */
    public void PrendreUneChambre(Personnage joueur) {
        
        joueur.soldeDuCompte -= this.dette;
        System.out.println("Vous avez payer " + this.dette + "€");
        System.out.println("Votre solde est de " + joueur.soldeDuCompte + "€");
             if(joueur.soldeDuCompte <0 ){
            croupier.appelerLaSecurite();
        }

    }
}
