/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package casino.vegas;

import static casino.vegas.CasinoVegas.joueur;

import java.util.Scanner;

/**
 *
 * @author STEPHAN
 */
public class Menu {
    Scanner keyboard = new Scanner (System.in);
     
    public Menu ()
    {
        System.out.println("Bienvenue dans le Casino !!!");
        
        System.out.println(" \nLe jeu commencera lorsque vous aurez choisi les réglages");
        
        joueur.réglageJoueur();
      

    }
    
    public void activité()
    {
        joueur.faireActivité();
    }
    
    boolean rejouer()
    {
        String reponse;
        System.out.println("Voullez vous faire une autre activité ou souhaitez vous quitter ?"
                + "\nTapez 1 pour choisir une nouvelle activité (tout autre réponse équivaut à quitter définitivement le jeu)");
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
