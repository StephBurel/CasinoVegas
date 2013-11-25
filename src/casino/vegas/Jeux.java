/** 
 * @ auteur : Amelie Ouille
 */
package casino.vegas;

import static casino.vegas.CasinoVegas.joueur;
import static casino.vegas.CasinoVegas.demineur;
import static casino.vegas.CasinoVegas.jeuDes;
import static casino.vegas.CasinoVegas.jackpot;
import static casino.vegas.CasinoVegas.roulette;

import java.util.Scanner;


/**
 * Classe abstraite qui permet de mettre en place les differents jeux
 * Elle permet de faire le choix entre les jeux et de rejouer ou non 
 * 
 */
public abstract class Jeux {
    static Scanner keyboard = new Scanner(System.in);
    static boolean resterDansLeCasino = true;
    
    /**
     * Methode qui permettra a chaque jeu de debuter
     */
    public abstract void commencer ();
    
    /**
     * Methode qui permettra de tester l'etat du joueur dans chaque jeu
     */
    public abstract void etatJoueur();
    
    /**
     * Message de bienvenue dans le casino
     * Choix du jeu que l'on souhaite realiser
     * (tous les jeux ne sont pas disponnibles en fonction de l'âge)
     */
    public static void demarrer(){
        
        String choixJeu;
        resterDansLeCasino = true;
        
        System.out.println("\n\nBienvenue dans le Casino !");
        while (resterDansLeCasino)
        {
            if (joueur.age < 21)
            {
                System.out.println ("Vous êtes trop jeune pour jouer aux jeux de casino, vous pouvez uniquement jouer au demineur"
                        + "\nVoulez-vous y jouer ? Dites oui pour y jouer");
                choixJeu = keyboard.nextLine();
                if (choixJeu == "oui")
                {
                    demineur.commencer();
                }
                else
                {
                    System.out.println("A bientot dans le casino");
                }
            }
            else
            {
                System.out.println("Veuillez choisir votre jeu parmis les suivants :"
                        + "\n Pour jouer au 421 tapez 1"
                        + "\n Pour jouer à la roulette tapez 2"
                        + "\n Pour jouer au Jackpot tapez 3"
                        + "\n Pour jouer au demineur tapez 4");
                boolean recommencer = true;
                while (recommencer)
                {
                    choixJeu = keyboard.nextLine();
                    switch (choixJeu)
                    {
                        case "1" :
                            jeuDes.commencer();
                            recommencer = false;
                            break;
                        case "2" :
                            roulette.commencer();
                            recommencer = false;
                            break;
                        case "3" :
                            recommencer = false;
                            jackpot.commencer();
                            break;
                        case "4" :
                            recommencer = false;
                            demineur.commencer();
                            break;
                        default :
                            recommencer = true;
                            System.out.println("Desole, la saisie n'est pas valide... Veuillez recommencer");
                    }
                }
            }
            
            rejouerOuNon();
        }
    }
    
    /**
     * Methode qui permet de rejouer ou de retourner au menu principale pour choisir une autre activite ou quitter
     */
    public static void rejouerOuNon()
    {
        String reponse;
        System.out.println("\n\nVoulez-vous rester dans le casino et faire d'autres jeu, ou souhaitez-vous en sortir ?"
                + "\nTapez 1 pour rester (tout autre caractere pour sortir)");
        reponse = keyboard.nextLine();
        
        if (reponse.equals("1"))
        {
            resterDansLeCasino = true;
        }
        else
        {
            resterDansLeCasino = false;
        }
    }
   
    
}