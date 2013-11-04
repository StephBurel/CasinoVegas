/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package casino.vegas;

import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author isen
 */
public class Démineur extends Jeux {
    
    Scanner keyboard = new Scanner(System.in);
    int ligne, colonne;
    
    
    public void commencer ()
    {
        System.out.println("\n\n\n    Bienvenue dans le Démineur !"
                + "\n Le but du jeu est de ne pas tomber sur les bombes "
                + "\n Vous disposé d'une grille de 10 par 10"
                + "\n\n A vous de jouer et surtout bonne chance !");
        jouer();
    }
    
    public void jouer ()
    {
        
    }
    
    
    public void affichage(char matrice [][])
    {
        for (int i=1 ; i<11; i++)
        {
            for (int j=1; j<11 ; j++)
            {
                System.out.print(matrice[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    
    public void initialiser(char matrice [][])
    {
        for (int i=0 ; i<12; i++)
        {
            for (int j=0; j<12 ; j++)
            {
                matrice[i][j] = '0';
            }
        }
    }
    
    public void placerLesBombes(char matrice [][])
    {
        int a,b;
        for (int i =0; i<10 ; i++)
        {
            a = (int) (Math.random() * 9) + 1;
            b = (int) (Math.random() * 9) + 1;
            
            if (matrice[a][b]== 'b')
            {
                i--;
            }
            else
            {
                matrice[a][b] = 'b';
            }
        }
    }
    
    // pour ce que le joueur voit
    public void ajouterLesEtoiles(char matriceVue[][])
    {
        for (int i=1 ; i<11; i++)
        {
            for (int j=1; j<11; j++)
            {
                matriceVue[i][j] = '*';
            }
        }
    }
    
    
    // choisir ou appuyer
    public void choixDuJoueur ()
    {
        String ligneStr, colonneStr;
        System.out.println("Veuillez entrer la ligne que vous souhaitez :");
        ligneStr = this.keyboard.nextLine();
        this.ligne = Integer.parseInt(ligneStr);
        System.out.println("Veuillez entrer la colonne que vous souhaitez :");
        colonneStr = this.keyboard.nextLine();
        this.colonne = Integer.parseInt(colonneStr);
    }
    
    
    // savoir combien il y a de bombes aux alentours d'une case
    public void connaitreNbBombesAlentours (char matrice[][])
    {
        
    }
    
    
    
}
