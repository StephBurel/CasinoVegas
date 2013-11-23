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
    int ligne, colonne, nbRejoue = 0;
    boolean rejouer = true;
    String reponseJoueur;
    
    
    public void commencer ()
    {
        System.out.println("\n\n\n    Bienvenue dans le Démineur !"
                + "\n Le but du jeu est de ne pas tomber sur les bombes "
                + "\n Vous disposé d'une grille de 10 par 10"
                + "\n\n A vous de jouer et surtout bonne chance !");
        while (rejouer)
        {
            jouer();
            System.out.println("\nVoullez-vous rejouer ?"
                    + "\nSi oui tapez oui");
            this.reponseJoueur = keyboard.nextLine();
                    
            if (this.reponseJoueur.equalsIgnoreCase("oui"))
            {
                this.rejouer = true;
                this.nbRejoue ++;
            }
            else
            {
                this.rejouer = false;
                System.out.println("A bientot dans le démineur !");
            }
            
            if(this.nbRejoue == 5)
            {
                System.out.println("Vous devenez accro, faites attention !");
            }
            else if (this.nbRejoue > 5)
            {
                System.out.println("Vous êtes accro, arrêtez-vous au plus vite !!! "
                        + "\nDans le cas contraire nous serons dans l'obligation de vous faire consulter un psy");
            }
        }
    }
    
    public void jouer ()
    {
        
        char[][] tb = new char[12][12] ;
        char[][] demin = new char[12][12];
        int x = 0;

        initialiser (tb);
        placerLesBombes (tb);
        affichage (tb);

        connaitreNbBombesAlentours (tb);
        affichage (tb);

        ajouterLesEtoiles (demin);
        affichage (demin);


        System.out.println ("les lignes et les colonnes vont de 1 à 10 \n");


        do
        {
            choixDuJoueur ();

            demin[this.ligne][this.colonne] = tb [this.ligne][this.colonne];

            if (tb[this.ligne][this.colonne]=='b')
            {
                System.out.println ("Vous avez perdu");

            }
            else
            {
                affichage (demin);
                x=fin(demin);
                if(x==10)
                {
                    System.out.println("vous avez gagné!!!!");
                }

            }
        }
        while (tb[this.ligne][this.colonne]!='b'&& x>10);

        
    }
    
    
    public void affichage(char[][] matrice)
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
    
    public void initialiser(char[][] matrice)
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
        int a=0;
        
        for (int l=1; l<11; l++)                                                         
        {
            for (int c=1 ; c<11 ; c++)                                                    // selection de la case
            {    
                if (matrice[l][c]!='b')
                {
                    a=0;                                                                 // test autour de la case
                    for (int i=c-1; i<c+2 ; i++)
                    {
                        if (matrice[l-1][i]=='b')
                            a=a+1;
                        if (matrice[l+1][i]== 'b')
                            a=a+1;          
                    }
                    if (matrice[l][c-1] == 'b')
                        a=a+1;
                    if(matrice[l][c+1] == 'b')
                        a=a+1;

                    // une fois avoir comptabilisé, on entre la valeur dans la case
                    if (a==1)
                        matrice[l][c]= '1';
                    if (a==2)
                        matrice[l][c]= '2';
                    if (a==3)
                        matrice[l][c]= '3';
                    if (a==4)
                        matrice[l][c]= '4';
                    if (a==5)
                        matrice[l][c]= '5';
                    if (a==6)
                        matrice[l][c]= '6';
                    if (a==7)
                        matrice[l][c]= '7';
                    if (a==8)
                        matrice[l][c]= '8';

                }
            }
        } 
    }
    
    
    
    
    int fin (char matrice[][])
    {
        int c,l,z;
        z=0;
        for (l=1 ; l<11 ; l++)
        {
            for (c=1; c<11; c++)
            {
                if(matrice[l][c]=='*')
                {
                z=z+1; 
                }  
                 }

        }
        return(z);
    }
    
    
}
