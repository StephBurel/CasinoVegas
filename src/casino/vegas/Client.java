
/** 
 * @ auteur : Amelie Ouille
 */
package casino.vegas;


import java.util.Scanner;
import java.util.Random;
import static casino.vegas.CasinoVegas.jeu;
import static casino.vegas.CasinoVegas.bar;
import static casino.vegas.CasinoVegas.chambre;
import static casino.vegas.CasinoVegas.joueur;


/**
 * Classe qui permet de generer des clients qui vont pouvoir faire de activitees
 * Permet de se rediriger vers les differentes activites (uniquement les classes primaires qui redirigerons elles-mêmes par la suite
 * 
 */
public class Client extends Personnage implements Braqueur{
    
    Scanner keyboard = new Scanner(System.in);
    String ageString;
    String etatPsychoNumStr;
    int motivation, tauxAlcoolemie, tauxHormone, dependanceJeu;
    String choixActivite;
    
    
    /**
     * constructeur vide qui permet de creer le personnage de l'utilisateur.
     * Les parametres du personnages seront inplementes plus tard
     */
    public Client ()
    {
        // constructeur vide pour creer le joueur
    }
    
    
    /**
     * constructeur permettant de creer les personnages fictifs.
     * on les implementes avec tous les parametres regles.
     */
    public Client (String nom, String prenom, int age, int soldeCompte, int etatPsycho, int motivation, int tauxAlcoolemie, int tauxHormones)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.soldeDuCompte = soldeCompte;
        this.etatPsycho = etatPsycho;
        definirEtatPsycho(this.etatPsycho);
        this.motivation = motivation;
        this.tauxAlcoolemie = tauxAlcoolemie;
        this.tauxHormone = tauxHormones ;
    }
    
    
    /**
     * methode qui permet de definir les parametres du personnage de l'utilisateur
     * (gestion des erreurs de saisies)
     */
    public void reglageJoueur()
    {
        boolean recommencer = true ;
        
        System.out.println("Vous allez être un client du Casino Vegas \nNous allons choisir vos caracteristiques \nEntrez votre prenom :");
        this.prenom = keyboard.nextLine();
        System.out.println("Entrez votre nom");
        this.nom = keyboard.nextLine();
        System.out.println("Entrez votre age");
        while (recommencer)
        {
            this.ageString = keyboard.nextLine();
            try
            {
               this.age = Integer.parseInt(this.ageString);
               recommencer = false;
            }
            catch (NumberFormatException e)
            {
                recommencer = true;
                System.out.println("Entrez un chiffre !");
            }
            
        }
        
        
        System.out.println("Choisissez votre etat psychologique : \n   Entrez une valeur comprise entre 1 et 6");
        recommencer = true;
        while (recommencer)
        {
            this.etatPsychoNumStr = keyboard.nextLine();
            try
            {
               this.etatPsycho = Integer.parseInt(this.etatPsychoNumStr);
               if (this.etatPsycho <1 || this.etatPsycho >6)
               {
                   throw new Exception ("Pas entre 1 et 6");
               }
               recommencer = false;
            }
            catch (NumberFormatException e)
            {
                recommencer = true;
                System.out.println("Entrez un chiffre entre 1 et 6");
            }
            catch (Exception e)
            {
                recommencer = true;
                System.out.println("Le chiffre doit être en 1 et 6");
            }
            
        }
        
        
        definirEtatPsycho(this.etatPsycho );
        
        this.soldeDuCompte = 500;
        this.tauxAlcoolemie = 0;
        this.motivation = 50 ;
        this.tauxHormone = 25 ;
        this.dependanceJeu = 20;
        
        
        // reecrire le profil
        System.out.println("\n\nVotre profil est le suivant : "
                + "\n Nom : " + this.nom
                + "\n Prenom : " + this.prenom 
                + "\n Age : " + this.age + " ans"
                + "\n Solde du compte : " + this.soldeDuCompte + " €"
                + "\n Etat Psychologique : " + this.etatPsychoStr
                + "\n Motivation : " + this.motivation + " %"
                + "\n Taux d'alcoolemie : " + this.tauxAlcoolemie + " %"
                + "\n Taux d'hormones : " + this.tauxHormone +" %"
                + "\n Taux de dependance aux jeux : " + this.dependanceJeu + " %");
        
    }
    
    
    
    /**
     * Methode qui permet à l'utilisateur de choisir dans quel lieu il souhaite se rendre
     * Choix entre les classes Jeux, bar et chambre
     */
    public void faireActivite()
    {
        this.choixActivite = "0";
        boolean test = false;
        boolean recommencer = true;
        
        while (!test)
        {
        
            System.out.println("\n\nQuelle activite souhaitez-vous faire ?"
                    + "\n  Tapez 1 pour entrer dans le casino (jeux)"
                    + "\n  Tapez 2 pour aller au bar"
                    + "\n  Tapez 3 pour aller dans une chambre de l'hotel");
            
         // lire le choix avec gestion des exceptions   
        do{
        
            try{
                this.choixActivite = keyboard.nextLine();
                switch (this.choixActivite)
                    {
                    case "1" :
                        recommencer = false;
                        break;
                    case "2" :
                        recommencer = false;
                        break;
                    case "3" :
                        recommencer = false;
                        break;
                    default :
                        throw new Exception("Ni 1 ni 2 ni 3");
                    }
                }
            
            catch(Exception e){
                System.out.println("Veuillez entrer 1, 2 ou 3");
                keyboard.next();
                }
        }while(recommencer);
            
            

            switch (this.choixActivite)
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
                    chambre.demarrer(joueur);
                    test= true;
                    break;
                default :
                    System.out.println("\n\nLa saisie n'est pas valide, veuillez reessayer...");
                 
            }
        }
        
        
    }
    
    
    /**
     * Methode qui permet à l'utilisateur de se cacher lorsque le braqueur fait son apparition.
     * Le temps qu'il met à se cacher est defini par le temps qu'il met à resoudre le jeu du plus ou moins.
     */
    public void seCacher()
    {
        int nombreAtrouver, nombreDuJoueur = 100, nombreEssais = 0;
        String nombreString;
        
        nombreAtrouver = (int) (Math.random() * 50);
        System.out.println("Pour vous cacher à temps, il faut que vous trouviez le nombre recherche en moins de 5 essais"
                + "\nEntrez un nombre compris entre 0 et 50");
        
        while(nombreDuJoueur != nombreAtrouver)
        {
            boolean recommencer = true;
            while (recommencer)
            {
                nombreString = keyboard.nextLine();
                try
                {
                   nombreDuJoueur = Integer.parseInt(nombreString);
                   recommencer = false;
                }
                catch (NumberFormatException e)
                {
                    recommencer = true;
                    System.out.println("Entrez un chiffre !");
                }

            }
            

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
                    + "\nLe braqueur vient d'être arrete par la police, vous pouvez continuer à jouer");
        }
        else
        {
            System.out.println("Vous avez ete trop lent à vous cacher..."
                    + "\nLe braqueur vous a trouve sur sa route et vous a tue"
                    + "\n     GAME OVER");
            System.exit(0);
        }
        
    }
    
    
    
    /**
     * Methode qui permet à l'utilisateur de s'interposer lorsque le braqueur fait son apparition
     * Il a une chance sur deux pour que cela fonctionne, sinon il se fait tuer.
     */
    public void interposerDansBraquage()
    {
        int chance;
        
        System.out.println("Vous avez choisi de vous interposer, attention vous risquez votre vie ...");
        chance = (int) (Math.random() * 100);
        if (chance <= 50)
        {
            System.out.println("Vous avez survecu !! Felicitation vous avez sauvez votre vie et vous avez protege notre cher casino ! "
                    + "\nVeuillez accepter ces 1000 euros en guise de remerciement");
            joueur.soldeDuCompte += 1000;
        }
        else
        {
            System.out.println("Nous gratifions votre courage mais malheureusement celui-ci n'a pas suffit"
                    + "\nLe braqueur a ete plus fort que vous et vous a marlheureusement tue"
                    + "\n     GAME OVER");
            System.exit(0);
        }
    }
    
    
    
    /**
     * Methode qui permet à l'utilisateur de choisir l'action à executer lors de l'apparition du braqueur
     */
    public void choixActionBraquage()
    {
        int choix = 0;
        boolean recommencer = true;
        System.out.println("Que voulez-vous faire ?"
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
    
    
    
/**
 * Methodes implementees par l'interface
 * Cas où le braqueur est un client de CasinoVegas
 */
    
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
