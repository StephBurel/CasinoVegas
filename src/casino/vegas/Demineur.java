/** 
 * @ auteur : Amelie Ouille
 */
package casino.vegas;

import java.util.Random;
import java.util.Scanner;

import static casino.vegas.CasinoVegas.joueur;
import static casino.vegas.CasinoVegas.croupier;


/**
 * Classe qui permet à l'utilisateur de jouer au demineur
 * Seul jeu accessible aux moins de 21 ans.
 * 
 */
public class Demineur extends Jeux {
    
    Scanner keyboard = new Scanner(System.in);
    int ligne, colonne, nbRejoue = 0;
    boolean rejouer = true;
    String reponseJoueur;
    
    /**
     * Methode qui permet de lancer le jeu et faire appel aux autres methodes :
     *  test de l'etat du joueur
     *  rejouer
     */
    public void commencer ()
    {
        rejouer = true;
        etatJoueur();
        System.out.println("\n\n\n    Bienvenue dans le Demineur !"
                + "\n Le but du jeu est de ne pas tomber sur les bombes "
                + "\n Vous dispose d'une grille de 10 par 10"
                + "\n\n A vous de jouer et surtout bonne chance !");
        while (rejouer)
        {
            jouer();
            etatJoueur();
            System.out.println("\nVoullez-vous rejouer ?"
                    + "\nSi oui tapez oui");
            this.reponseJoueur = keyboard.nextLine();
                    
            if (this.reponseJoueur.equalsIgnoreCase("oui"))
            {
                this.rejouer = true;
                this.nbRejoue ++;
                joueur.motivation ++;
            }
            else
            {
                this.rejouer = false;
                System.out.println("A bientot dans le demineur !");
            }
            
            
        }
    }
    
    
    /**
     * methode permettant de tester l'etat du joueur et voir si il est necessaire d'appeler la securite
     * ou un psychologue.
     */
    public void etatJoueur()
    {
            if(this.nbRejoue == 5)
            {
                System.out.println("Vous devenez accro, faites attention !");
            }
            else if (this.nbRejoue > 5 && this.nbRejoue<10)
            {
                System.out.println("Vous êtes accro, arrêtez-vous au plus vite !!! "
                        + "\nDans le cas contraire nous serons dans l'obligation de vous faire consulter un psy");
                joueur.dependanceJeu--;
            }
            else if (this.nbRejoue >= 10)
            {
                System.out.println("Vous commencez vraiment à beaucoup trop jouer"
                        + "\nVotre dependance au jeu augmente fortement !"
                        + "\nVotre etat psycholique empire"
                        + "\nNous n'hesiterons pas à contacter un psychologue si vous continue comme ça !");
                joueur.etatPsycho --;
                joueur.dependanceJeu -= 2;
            }
            
            croupier.testerJoueur();
    }
    
    
    /**
     * methode principale pour jouer
     * fait appel à toutes les methodes du jeu
     */
    public void jouer ()
    {
        
        char[][] tb = new char[12][12] ;
        char[][] demin = new char[12][12];
        int x = 0;

        initialiser (tb);
        placerLesBombes (tb);
        //affichage (tb);

        connaitreNbBombesAlentours (tb);
        //affichage (tb);

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
                    System.out.println("vous avez gagne!!!!");
                }

            }
        }
        while (tb[this.ligne][this.colonne]!='b'&& x>10);

        
    }
    
    /**
     * Methode qui permet d'afficher le plateau de jeu
     * et de le reafficher à chaque etape
     */
    public void affichage(char[][] matrice)
    {
        for (int i=1 ; i<11; i++)
        {
            for (int j=1; j<11 ; j++)
            {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    
    
    /**
     * Methode pour initialiser le plateau de jeu cache
     */
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
    
    
    /**
     * methode qui permet de placer les bombes de maniere aleatoire
     * sur le plateau de jeu cache
     */
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
    
   
    /**
     * Methode qui permet d'initialiser le plateau de jeu vu par le joueur
     * matrice remplie d'etoiles
     */
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
    
    
    /**
     * methode qui permet au joueur de definir les coordonnees de la case
     * ou il souhaite tester s'il y a une bombe ou non
     */
    public void choixDuJoueur ()
    {
        boolean recommencer ;
        String ligneStr, colonneStr;
        System.out.println("Veuillez entrer la ligne que vous souhaitez :");
        recommencer = true;
        while (recommencer)
        {
            ligneStr = this.keyboard.nextLine();
            try
            {
               this.ligne = Integer.parseInt(ligneStr);
               if (this.ligne<1 || this.ligne >10)
               {
                   throw new Exception ("Pas entre 1 et 10");
               }
               recommencer = false;
            }
            catch (NumberFormatException e)
            {
                recommencer = true;
                System.out.println("Entrez un chiffre entre 1 et 10");
            }
            catch (Exception e)
            {
                recommencer = true;
                System.out.println("Le chiffre doit être en 1 et 10");
            }
            
        }
        
        
        System.out.println("Veuillez entrer la colonne que vous souhaitez :");
        recommencer = true;
        while (recommencer)
        {
            colonneStr = this.keyboard.nextLine();
            try
            {
               this.colonne = Integer.parseInt(colonneStr);
               if (this.colonne<1 || this.colonne >10)
               {
                   throw new Exception ("Pas entre 1 et 10");
               }
               recommencer = false;
            }
            catch (NumberFormatException e)
            {
                recommencer = true;
                System.out.println("Entrez un chiffre entre 1 et 10");
            }
            catch (Exception e)
            {
                recommencer = true;
                System.out.println("Le chiffre doit être en 1 et 10");
            }
            
        }
        
        
    }
    
    
    /**
     * Methode qui permet de definir dans le plateau cache
     * le nombre de bombes alentours
     */
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

                    // une fois avoir comptabilise, on entre la valeur dans la case
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
