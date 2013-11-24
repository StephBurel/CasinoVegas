/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package casino.vegas;

/**
 *
 * @author isen
 */
import java.util.Scanner;
import java.util.Random;
import static casino.vegas.CasinoVegas.jeu;
import static casino.vegas.CasinoVegas.bar;
import static casino.vegas.CasinoVegas.chambre;
import static casino.vegas.CasinoVegas.joueur;
/**
 *
 * @author isen
 */
public class Client extends Personnage implements Braqueur{
    
    Scanner keyboard = new Scanner(System.in);
    String ageString;
    String etatPsychoNumStr;
    int motivation, tauxAlcoolémie, tauxHormone, dépendanceJeu;
    String choixActivité;
    
    public Client ()
    {
        // constructeur vide pour créer le joueur
    }
    
    
    // constructeur pour les joueurs fictifs
    public Client (String nom, String prénom, int age, int soldeCompte, int etatPsycho, int motivation, int tauxAlcoolémie, int tauxHormones)
    {
        //System.out.println("\n\nLes clients du casino : ");
        
        this.nom = nom;
        this.prénom = prénom;
        this.age = age;
        this.soldeDuCompte = soldeCompte;
        this.etatPsycho = etatPsycho;
        definirEtatPsycho(this.etatPsycho);
        this.motivation = motivation;
        this.tauxAlcoolémie = tauxAlcoolémie;
        this.tauxHormone = tauxHormones ;
        
        //System.out.println(this.nom + " " + this.prénom + " " + this.age + " " + this.soldeDuCompte + " " + this.etatPsychoStr + " " + this.motivation + " " + this.tauxAlcoolémie + " " + this.tauxHormone);
    }
    
    
    // création de profil du joueur
    public void réglageJoueur()
    {
        System.out.println("Vous aller être un client du casino \nNous allons choisir vos caractéristiques \nEntrez votre prénom :");
        this.prénom = keyboard.nextLine();
        System.out.println("Entrez votre nom");
        this.nom = keyboard.nextLine();
        System.out.println("Entrez votre age");
        this.ageString = keyboard.nextLine();
        this.age = Integer.parseInt(this.ageString);
        
        System.out.println("Choisissez votre état psychologique : \n   Entrez une valeure comprise entre 1 et 6");
        this.etatPsychoNumStr = keyboard.nextLine();
        this.etatPsycho = Integer.parseInt(this.etatPsychoNumStr);
        
        definirEtatPsycho(this.etatPsycho );
        
        this.soldeDuCompte = 500;
        this.tauxAlcoolémie = 0;
        this.motivation = 50 ;
        this.tauxHormone = 25 ;
        this.dépendanceJeu = 20;
        
        
        // réécrire le profil
        System.out.println("\n\nVotre profil est le suivant : "
                + "\n Nom : " + this.nom
                + "\n Prénom : " + this.prénom 
                + "\n Age : " + this.age + " ans"
                + "\n Solde du compte : " + this.soldeDuCompte + " €"
                + "\n Etat Psychologique : " + this.etatPsychoStr
                + "\n Motivation : " + this.motivation + " %"
                + "\n Taux d'alcoolémie : " + this.tauxAlcoolémie + " %"
                + "\n Taux d'hormones : " + this.tauxHormone +" %"
                + "\n Taux de dépendance aux jeux : " + this.dépendanceJeu + " %");
        
    }
    
    
    // choisir l'activité que l'on veut faire
    public void faireActivité()
    {
        this.choixActivité = "0";
        boolean test = false;
        
        while (!test)
        {
        
            System.out.println("\n\nQuelle activité souhaitez vous faire ?"
                    + "\n  Tapez 1 pour entrer dans le casino"
                    + "\n  Tapez 2 pour aller au bar"
                    + "\n  Tapez 3 pour aller dans une chambre de l'hotel");
            this.choixActivité = keyboard.nextLine();

            switch (this.choixActivité)
            {
                case "1" :
                    jeu.demarrer();
                    test = true;
                    break;
                case "2" :
                    bar.demarrer(joueur);
                    test=true;
                    break;
                case "3" :
                    chambre.demarrer();
                    test= true;
                    break;
                default :
                    System.out.println("\n\nLa saisie n'est pas valide, veuillez rééssayer...");
                 
            }
        }
        
        
    }
    
    
    // se cacher en cas d'attaque d'un braqueur
    public void seCacher()
    {
        int nombreAtrouver, nombreDuJoueur = 100, nombreEssais = 0;
        String nombreString;
        
        nombreAtrouver = (int) (Math.random() * 50);
        System.out.println("Pour vous cacher à temps, il faut que vous trouviez le nombre recherché en moins de 5"
                + "\nEntrez un nombre compris entre 0 et 50");
        
        while(nombreDuJoueur != nombreAtrouver)
        {
            nombreString = keyboard.nextLine();
            nombreDuJoueur = Integer.parseInt(nombreString);
            
            if (nombreDuJoueur < nombreAtrouver)
            {
                System.out.println("Le nombre à trouver est plus grand");
            }
            else if (nombreDuJoueur > nombreAtrouver)
            {
                System.out.println("Le nombre à trouver est plus petit");
            }
            nombreEssais ++;
        }
        
        if (nombreEssais <= 5)
        {
            System.out.println("Felicitation, vous avez pu vous cacher à temps, vous êtes sain et sauf !"
                    + "\nLe braqueur vient d'être arrété par la police, vous pouvez continuer à jouer");
        }
        else
        {
            System.out.println("Vous avez été trop lent à vous cacher..."
                    + "\nLe braqueur vous a trouvé sur sa route et vous a tué"
                    + "\n     GAME OVER");
            System.exit(0);
        }
        
    }
    
    
    // s'interposer pendant le braquage
    public void interposerDansBraquage()
    {
        int chance;
        
        System.out.println("Vous avez choisi de vous interposer, attention vous risquez votre vie ...");
        chance = (int) (Math.random() * 100);
        if (chance <= 50)
        {
            System.out.println("Vous avez survécu !! Félicitation vous avez sauvez votre vie et vous avez protégé notre cher casino ! "
                    + "\nVeuillez accepter ces 1000 euros en guise de remerciement");
            joueur.soldeDuCompte += 1000;
        }
        else
        {
            System.out.println("Nous gratifions votre courage mais malheureusement celui-ci n'a pas suffit"
                    + "\nLe braqueur a été plus fort que vous et vous a marlheureusement tué"
                    + "\n     GAME OVER");
            System.exit(0);
        }
    }
    
    
    public void choixActionBraquage()
    {
        int choix = 0;
        boolean recommencer = true;
        System.out.println("Que voullez-vous faire ?"
                + "\nVous avez le choix entre vous cacher (tapez 1) ou vous interposer (tapez 2)");
        
         do{
        
            try{
                choix = keyboard.nextInt(); 
                if(choix != 1 && choix!= 2 ){
                    throw new Exception("Ni 1 ni 2");
                }
                else{
                recommencer = false;
                }
            }
            catch(Exception e){
                System.out.println("veuillez entrer 1, 2 ou 3");
                keyboard.next();
            }
        }while(recommencer);
         
         switch (choix)
         {
             case 1 :
                 joueur.seCacher();
                 break;
             case 2 :
                 joueur.interposerDansBraquage();
                 break;
         }
        
    }
    
    
    
// interface du braqueur
    
    public void entrerDansLeCasino()
    {
        System.out.println("\n\n\n\n\n\n"
                + "Un nouveau personnage entre dans le casino, il vous semble suspect"
                + "\nVous continuez à jouer tout en gardant un oeil sur lui");
    }
         
    public void cambrioler()
    {
        System.out.println("Vous entendez un coup de feu");
        joueur.choixActionBraquage();
    }
    
    
}
