/*
 * Classe qui permet au joueur de naviguer dans l'espace de jeu et de quitter celui-ci
 * Elle permet également le démarrage du jeu
 * 
 * @ auteur : Amélie Ouillé
 */
package casino.vegas;

import static casino.vegas.CasinoVegas.joueur;

import java.util.Scanner;


public class Menu {
    Scanner keyboard = new Scanner (System.in);
    
    /*
     * constructeur qui permet à l'utilisateur de créer son personnage
     * et de faire les réglages des différents paramètres
     */
    public Menu ()
    {
        System.out.println("Bienvenue dans le Casino !!!");
        
        System.out.println(" \nLe jeu commencera lorsque vous aurez défini les réglages");
        
        joueur.réglageJoueur();
      

    }
    
    
    /*
     * Méthode qui permet de d'appeler la méthode dans Client
     * cette méthode permet de choisir l'activité que l'utilisateur souhaite faire
     */
    public void activité()
    {
        joueur.faireActivité();
    }
    
    
    /*
     * fonction qui permet à l'utilisateur de choisir si il souhaite continuer
     * à jouer et donc choisir une nouvelle activité ou si il souhaite quitter 
     * définitivement le jeu
     */
    boolean rejouer()
    {
        String reponse;
        System.out.println("Voulez-vous faire une autre activité ou souhaitez-vous quitter ?"
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
