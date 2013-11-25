/** 
 * @ auteur : Amelie Ouille
 */
package casino.vegas;

import java.util.Random;
import java.util.Scanner;

import static casino.vegas.CasinoVegas.joueur;
import static casino.vegas.CasinoVegas.croupier;

/**
 * Class qui permet à l'utilisateur de jouer au jackpot
 * Le jeu est accessible aux plus de 21 ans uniquement
 * 
 */
public class Jackpot extends Jeux {
    
    public static int PRIXPARTIE = 2;
    int  nombreLance = 0, gainEnJeu = 0;
    boolean rejouer = true;
    Scanner keyboard = new Scanner (System.in);
    String reponseJoueur;
    
    /**
     * Methode qui permet de demarrer le jeu,
     * tester l'etat du joueur à tout moment
     * et menu pour rejouer
     */
    public void commencer ()
    {
        rejouer = true;
        etatJoueur();
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
            System.out.println("Voulez-vous rejouer ?"
                    + "\nTapez Y pour rejouer");
            this.reponseJoueur = keyboard.nextLine();
            if (this.reponseJoueur.equalsIgnoreCase("y"))
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
            System.out.println("Vous ne possedez plus assez d'argent...");
        }
    }
    
    /**
     * methode permettant de tester l'etat du joueur et voir si il est necessaire d'appeler la securite
     * ou un psychologue.
     */
    public void etatJoueur()
    {
            if (this.nombreLance == 7)
            {
                System.out.println("Vous commencez à devenir accro à ce jeu, Attention !");
            }
            else if (this.nombreLance > 7 && this.nombreLance<13)
            {
                System.out.println("Vous êtes accro, tentez de vous arreter au plus vite !!!");
                joueur.dependanceJeu --;
            }
            else if(this.nombreLance >= 13)
            {
                System.out.println("Votre etat devient reellement critique !"
                        + "\nVous devez ralentir la cadence ! "
                        + "\nVous perdez beaucoup d'argent et devenez dangereusement accro");
                joueur.dependanceJeu -=3;
                joueur.etatPsycho --;
            }
            
            croupier.testerJoueur();
    }
    
    
    /**
     * methode qui permet de faire tourner la machine
     * il faut obtenir 3 "$" pour gagner
     */
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
                    + "\nFelicitation vous remportez la somme de " + this.gainEnJeu + "€");
            joueur.soldeDuCompte += this.gainEnJeu;
        }
    }
}
    

