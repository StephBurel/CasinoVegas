/**
 * Classe qui permet de jouer au 421
 * 
 * @ auteur : Amélie Ouillé
 */
package casino.vegas;

import static casino.vegas.CasinoVegas.joueur;
import static casino.vegas.CasinoVegas.croupier;

import java.util.Scanner;


public class JeuDes extends Jeux {
    
    public static int PRIXPARTIE = 3;
    public static int GAINPOSSIBLE = 10;
    
    int diceA = 0, diceB = 0, diceC = 0, diceAbis = 0, diceBbis = 0, diceCbis = 0;
    int nbJeu =0 , nbLance = 0;
    boolean rejouer = true;
    String reponseString = null;
   
    
    Scanner keyboard = new Scanner(System.in);
    
    /**
     * Méthode qui permet de démarrer le jeu,
     * tester l'état du joueur à tout moment
     * et menu pour rejouer
     */
    public void commencer ()
    {
        rejouer = true;
        etatJoueur();
        this.nbJeu = 0;
        System.out.println("\nBienvenue dans le jeu 421 !"
                + "\nCe jeu vous coute 3€, vous pouvez en gagner 10"
                + "\nBonne Chance !");
        regles();
        while(rejouer && joueur.soldeDuCompte<PRIXPARTIE)
        {
            joueur.soldeDuCompte -= PRIXPARTIE;
            this.diceA = 0;
            this.diceB = 0;
            this.diceC = 0;
            this.diceAbis = 0;
            this.diceBbis = 0;
            this.diceCbis = 0;
            jouer();
            resultat();
            etatJoueur();
            System.out.println("Voulez-vous rejouer?"
                    + "\nSi oui tapez 1");
            this.reponseString = keyboard.nextLine();
            if (this.reponseString.equals("1") )
            {
                this.rejouer = true ;
                nbJeu ++;
                joueur.motivation +=2;
            }    
            else
            {
                this.rejouer = false;
            }
            
            
            
            
            if (joueur.soldeDuCompte< PRIXPARTIE)
            {
                System.out.println("Désolé vous n'avez plus assez d'argent pour jouer !");
            }
            
        }
    }
    
    /**
     * méthode qui permet d'afficher les règles du jeu
     */
    public void regles()
    {
        System.out.println("\nVoici les règles du jeu :"
                + "\n  Si vous faites 421 en moins de 3 lancés vous gagné les 10 €"
                + "\n  Si vous faites 421 en moins de 5 lancés vous gagné 5€"
                + "\n  Si il vous faut plus de lancés, vous ne gagné rien...");
    }
    
    
    
    /**
     * methode permettant de tester l'état du joueur et voir si il est necessaire d'appeler la sécurité
     * ou un psychologue.
     */
    public void etatJoueur()
    {
        if (this.nbJeu == 7)
            {
                System.out.println("Vous commencez à devenir accro à ce jeu, Attention !");
            }
            else if (this.nbJeu > 7 && this.nbJeu<13)
            {
                System.out.println("Vous êtes accro, tentez de vous arréter au plus vite !!!");
                joueur.dépendanceJeu --;
            }
            else if(this.nbJeu >= 13)
            {
                System.out.println("Votre état devient réellement critique !"
                        + "\nVous devez ralentir la cadence ! "
                        + "\nVous perdez beaucoup d'argent et devenez dangereusement accro");
                joueur.dépendanceJeu -=3;
                joueur.etatPsycho --;
            }
            
            croupier.testerJoueur();
    }
    
    
    /**
     * Méthode qui permet de savoir combien le joueur gagne
     * et le créditer sur son compte.
     */
    public void resultat()
    {
        if (this.nbLance < 3)
        {
            System.out.println("Félicitation vous avez réussi en moins de 3 lancés !"
                    + "\nVous remportez donc 10€");
            joueur.soldeDuCompte += GAINPOSSIBLE;
        }
        else if (this.nbLance <5)
        {
            System.out.println("Vous avez réussi en moins de 5 lancés"
                    + "\nVous remportez donc 5€");
            joueur.soldeDuCompte += (GAINPOSSIBLE/2);
        }
        else
        {
            System.out.println("Désolé vous ne gagnez rien");
        }
    }
    

    /**
     * Méthode qui permet de jouer et de lancer les dès
     * jusqu'à obtention de 421
     */
    public void jouer()
    {
        
            this.diceA = 0;
            this.diceB = 0; 
            this.diceC = 0; 
            this.diceAbis = 0; 
            this.diceBbis = 0; 
            this.diceCbis = 0;
            this.nbLance = 0;
            
            while (this.diceAbis == 0 || this.diceBbis == 0 || this.diceCbis ==0)
            {
                this.nbLance ++;
                // test du dé A
                if (this.diceA != 4 && this.diceA != 2 && this.diceA != 1 && this.diceAbis == 0)
                {
                    this.diceA = (int) (Math.random() * 6 ) +1;
                }
                else if ((this.diceA == 4 || this.diceA == 2 || this.diceA == 1) && this.diceA != this.diceBbis && this.diceA != this.diceCbis)
                {
                    this.diceAbis = this.diceA;
                }
                else
                {
                    this.diceA = (int) (Math.random() * 6 ) +1;
                }

                // test du dé B
                if (this.diceB != 4 && this.diceB != 2 && this.diceB != 1 && this.diceBbis == 0)
                {
                    this.diceB = (int) (Math.random() * 6 ) +1;
                }
                else if ((this.diceB == 4 || this.diceB == 2 || this.diceB == 1) && this.diceB != diceAbis && this.diceB != this.diceCbis)
                {
                    this.diceBbis = this.diceB;
                }
                else
                {
                    this.diceB = (int) (Math.random() * 6 ) +1;
                }

                // test du dé C
                if (this.diceC != 4 && this.diceC != 2 && this.diceC != 1 && this.diceCbis == 0)
                {
                    this.diceC = (int) (Math.random() * 6 ) +1;
                }
                else if ((this.diceC == 4 || this.diceC == 2 || this.diceC == 1) && this.diceC != this.diceAbis && this.diceC != this.diceBbis)
                {
                    this.diceCbis = this.diceC;
                }
                else
                {
                    this.diceC = (int) (Math.random() * 6 ) +1;
                }


                System.out.println(this.diceA + " " + this.diceB + " " + this.diceC );
                
        

            }
            
            this.nbLance --;
        
        
    }
    
}
    

