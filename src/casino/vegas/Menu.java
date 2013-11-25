/** 
 * @ auteur : Amelie Ouille
 */
package casino.vegas;

import static casino.vegas.CasinoVegas.joueur;

import java.util.Scanner;

/**
 * Classe qui permet au joueur de naviguer dans l'espace de jeu et de quitter celui-ci
 * Elle permet egalement le demarrage du jeu
 * 
 */
public class Menu {
    Scanner keyboard = new Scanner (System.in);
    
    /**
     * constructeur qui permet à l'utilisateur de creer son personnage
     * et de faire les reglages des differents parametres
     */
    public Menu ()
    {
        System.out.println("Bienvenue dans le Casino !!!");
        
        System.out.println(" \nLe jeu commencera lorsque vous aurez defini les reglages");
        
        joueur.reglageJoueur();
      

    }
    
    
    /**
     * Methode qui permet de d'appeler la methode dans Client
     * cette methode permet de choisir l'activite que l'utilisateur souhaite faire
     */
    public void activite()
    {
        joueur.faireActivite();
    }
    
    
    /**
     * fonction qui permet à l'utilisateur de choisir si il souhaite continuer
     * à jouer et donc choisir une nouvelle activite ou si il souhaite quitter 
     * definitivement le jeu
     */
    boolean rejouer()
    {
        String reponse;
        System.out.println("Voulez-vous faire une autre activite ou souhaitez-vous quitter ?"
                + "\nTapez 1 pour choisir une nouvelle activite (tout autre reponse equivaut à quitter definitivement le jeu)");
        reponse = keyboard.nextLine();
        if (reponse.equals("1"))
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }

   
}
