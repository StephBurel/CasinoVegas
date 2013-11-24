/*
 * Classe pour jouer à la roulette
 * 
 * @ auteur : Amélie Ouillé
 */
package casino.vegas;

import static casino.vegas.CasinoVegas.joueur;
import static casino.vegas.CasinoVegas.croupier;

import java.util.Scanner;


public class Roulette extends Jeux {
    
    int nombreSorti, gainPossible, nbLance =0;
    Scanner keyboard = new Scanner(System.in);
    boolean gagner = false, rejouer = true;
    
    
    /*
     * Méthode qui permet de démarrer le jeu,
     * tester l'état du joueur à tout moment
     * et menu pour rejouer
     */
    public void commencer ()
    {
        rejouer = true;
        etatJoueur();
        System.out.println("Bienvenue dans le jeux de la roulette");
        règles();
        while(this.rejouer && joueur.soldeDuCompte > 20)
        {
            this.nbLance ++;
            lancéDuCroupier();
            miseJoueur();
            System.out.println("Les jeux sont faits"
                    + "\n..."
                    + "\nRien ne va plus");
            resultat();
            etatJoueur();
            
            if(joueur.soldeDuCompte <=20)
            {
                System.out.println("Croupier : vous n'avez plus assez d'argent pour continuer à jouer"
                        + "\nJe vais vous demander de quitter la table");
                this.rejouer = false;
            }
            else
            {
                rejouerRoulette();
            }
            
            
        }
    }
    
    
    
    /*
     * methode permettant de tester l'état du joueur et voir si il est necessaire d'appeler la sécurité
     * ou un psychologue.
     */
    public void etatJoueur()
    {
        if (this.nbLance == 7)
            {
                System.out.println("Vous commencez à devenir accro à ce jeu, Attention !");
            }
            else if (this.nbLance > 7 && this.nbLance<13)
            {
                System.out.println("Vous êtes accro, tentez de vous arréter au plus vite !!!");
                joueur.dépendanceJeu --;
            }
            else if(this.nbLance >= 13)
            {
                System.out.println("Votre état devient réellement critique !"
                        + "\nVous devez ralentir la cadence ! "
                        + "\nVous perdez beaucoup d'argent et devenez dangereusement accro");
                joueur.dépendanceJeu -=3;
                joueur.etatPsycho --;
            }
            
            croupier.testerJoueur();
    }
    
    /*
     * Méthode qui permet de rejouer
     */
    public void rejouerRoulette()
    {
        String rejouerStr;
        System.out.println("\n\nVoulez-vous rejouer ?"
                + "\nTapez 1 pour rejouer");
        rejouerStr = keyboard.nextLine();
        
        if (rejouerStr.equals("1"))
        {
            this.rejouer = true;
        }
        else
        {
            this.rejouer = false;
        }
    }
    
    
    /*
     * méthode qui permet d'afficher les règles du jeu
     */
    public void règles()
    {
        System.out.println("Pour jouer : vous devait choisir un ou plusieurs numéros sur lesquels miser et la somme à miser"
                + "\nLa premiere étape sera le nombre de mise que vous souhaitez faire"
                + "\nLa deuxième sera le nombre que vous souhaitez miser et combien vous voullez miser");
    }
    
    
    /*
     * méthode qui permet de dire si l'on a gagné
     * et de créditer la somme sur le compte
     */
    public void resultat()
    {
        if(this.gagner == true)
            {
                System.out.println("Croupier : " + this.nombreSorti + " sorti"
                        + "\nNous avons un gagnant !"
                        + "\nVous remportez "+ this.gainPossible +"€");
                joueur.soldeDuCompte += this.gainPossible;
            }
            else
            {
                System.out.println("Croupier : Rien au numéro");
            }
    }
    
    
    /*
     * methode qui définit le nombre sorti par la roulette
     */
    public void lancéDuCroupier()
    {
        this.nombreSorti = (int) (Math.random()*36);
    }
    
    
    
    /*
     * méthode qui permet au joueur de choisir sur quoi il veut miser et combien
     */
    public void miseJoueur()
    {
        int nbDeMise=0, numeroMise=-1, sommeMise=0;
        String nbDeMiseStr, numeroMiseStr, sommeMiseStr;
        boolean recommencer = true;
        
        System.out.println("Croupier : Faites vos Jeux");
        System.out.println("Sur combien de nombre souhaitez vous miser ?");
        recommencer = true;
            while (recommencer)
            {
                nbDeMiseStr = keyboard.nextLine();
                try
                {
                   nbDeMise = Integer.parseInt(nbDeMiseStr);
                   recommencer = false;
                }
                catch (NumberFormatException e)
                {
                    recommencer = true;
                    System.out.println("Entrez un chiffre !");
                }

            }
            
        this.gainPossible = (int) 35/nbDeMise;
        
        for(int i =0; i<nbDeMise; i++)
        {
            System.out.println("Sur quel chiffre souhaitez-vous miser ?");
            recommencer = true;
            while (recommencer)
            {
                numeroMiseStr = keyboard.nextLine();
                try
                {
                   numeroMise = Integer.parseInt(numeroMiseStr);
                   if (numeroMise<0 || numeroMise >36)
                   {
                       throw new Exception ("Pas entre 0 et 36");
                   }
                   recommencer = false;
                }
                catch (NumberFormatException e)
                {
                    recommencer = true;
                    System.out.println("Entrez un chiffre entre 0 et 36");
                }
                catch (Exception e)
                {
                    recommencer = true;
                    System.out.println("Le chiffre doit être en 0 et 36");
                }

            }
            
            
            System.out.println("Combien souhaitez vous miser dessus ?");
            recommencer = true;
            while (recommencer)
            {
                sommeMiseStr = keyboard.nextLine();
                try
                {
                   sommeMise = Integer.parseInt(sommeMiseStr);
                   recommencer = false;
                }
                catch (NumberFormatException e)
                {
                    recommencer = true;
                    System.out.println("Entrez un chiffre !");
                }

            }
            
            
            joueur.soldeDuCompte -= sommeMise;
            
            if(numeroMise == this.nombreSorti)
            {
                this.gagner = true;
            }
        }
    }
}
