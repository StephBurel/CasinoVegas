/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package casino.vegas;

import static casino.vegas.CasinoVegas.joueur;

/**
 *
 * @author STEPHAN
 */
public class Menu {
    
     
    public Menu ()
    {
        System.out.println("Bienvenue dans le Casino !!!");
        
        System.out.println(" \nLe jeu commencera lorsque vous aurez choisi les réglages");
        
        joueur.réglageJoueur();
        activité();

    }
    
    public void activité()
    {
        joueur.faireActivité();
    }
}
