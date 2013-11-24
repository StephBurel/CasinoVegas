/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package casino.vegas;

import java.util.Random;
import java.util.Scanner;

import static casino.vegas.CasinoVegas.joueur;
import static casino.vegas.CasinoVegas.croupier;
/**
 *
 * @author isen
 */
public class Jackpot extends Jeux {
    
    public static int PRIXPARTIE = 2;
    int  nombreLance = 0, gainEnJeu = 0;
    boolean rejouer = true;
    Scanner keyboard = new Scanner (System.in);
    String reponseJoueur;
    
    public void commencer ()
    {
        joueur.soldeDuCompte -= PRIXPARTIE;
        this.gainEnJeu = (int) (Math.random()*300) +50;
        System.out.println("Bienvenue dans le jeu du jackpot"
                + "\nCe jeu vous coûte 2€"
                + "\nBonne chance");
        joueur.soldeDuCompte -= 2;
        while (rejouer && (joueur.soldeDuCompte>=2))
        {
            lancer();
            etatJoueur();
            System.out.println("Voullez-vous rejouer ?"
                    + "\nTapez O pour rejouer");
            this.reponseJoueur = keyboard.nextLine();
            if (this.reponseJoueur.equalsIgnoreCase("o"))
            {
                this.rejouer = true;
                this.gainEnJeu += 2;
                this.nombreLance ++;
                joueur.motivation +=2;
            }
            else
            {
                this.rejouer = false;
            }
            
            
           
        }
        if (joueur.soldeDuCompte<PRIXPARTIE)
        {
            System.out.println("Vous ne possédez plus assez d'argent...");
        }
    }
    
    
    public void etatJoueur()
    {
         // si on joue trop, notre état empire
            if (this.nombreLance == 7)
            {
                System.out.println("Vous commencez à devenir accro à ce jeu, Attention !");
            }
            else if (this.nombreLance > 7 && this.nombreLance<13)
            {
                System.out.println("Vous êtes accro, tentez de vous arréter au plus vite !!!");
                joueur.dépendanceJeu --;
            }
            else if(this.nombreLance >= 13)
            {
                System.out.println("Votre état devient réellement critique !"
                        + "\nVous devez ralentir la cadence ! "
                        + "\nVous perdez beaucoup d'argent et devenait dangereusement accro");
                joueur.dépendanceJeu -=3;
                joueur.etatPsycho --;
            }
            
            croupier.testerJoueur();
    }
    
    public void lancer()
    {
        int rand1 = (int) (Math.random()*3) + 1;
        int rand2 = (int) (Math.random()*3) + 1;
        int rand3 = (int) (Math.random()*3) + 1;
        
        for (int i=1 ; i<4 ; i++)
        {
            int nombre = 0;
            if(i == 1)
                nombre = rand1;
            if (i == 2)
                nombre = rand2;
            if (i == 3)
                nombre = rand3;
            
              
            switch (nombre)
            {
                case 1 :
                    System.out.println("   " + i + ". bar");
                    break;
                case 2 :
                    System.out.println("   " + i + ". fruit");
                    break;
                case 3 :
                    System.out.println("   " + i + ". $");
                    break;
            }
        }
        
        if (rand1 == 3 && rand2 == 3 && rand3 == 3)
        {
            System.out.println("JACKPOT !!!!!"
                    + "\nFélicitation vous remporter la somme de " + this.gainEnJeu + "€");
            joueur.soldeDuCompte += this.gainEnJeu;
        }
    }
}
    

