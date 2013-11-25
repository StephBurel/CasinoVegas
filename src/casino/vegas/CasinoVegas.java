/** 
 * @ auteur : Amelie Ouille
 */
package casino.vegas;

import casino.vegas.Demineur;
import casino.vegas.JeuDes;
import static casino.vegas.CasinoVegas.joueur;

import java.util.Random;

/**
 * Classe Principale (contenant le main)
 * contient l'intialisation des differentes classes utilisees dans le programme
 * Permet au joueur d'acceder au menu pour ensuite jouer aux differents jeux
 * 
 */
public class CasinoVegas {

    
   
    // initialsation du joueur
    public static casino.vegas.Client joueur = new casino.vegas.Client();
    
    // ajout des clients fictifs
    public static casino.vegas.Client clientFictif1 = new casino.vegas.Client("Dupont", "Celine", 24, 200, 2, 10, 50, 60);
    public static casino.vegas.Client clientFictif2 = new casino.vegas.Client("Smith", "Paul", 25, 800, 6, 70, 10, 70);
    public static casino.vegas.Client clientFictif3 = new casino.vegas.Client("Gold Fish", "Shark", 32, 50, 1, 20, 90, 95);
    public static casino.vegas.Client clientFictif4 = new casino.vegas.Client("Betanlong", "Ingrid", 52, 19620, 5, 90, 70, 25);
    public static casino.vegas.Client clientFictif5 = new casino.vegas.Client("Federer", "Roger", 22, 150000, 3, 60, 20, 100);
    public static casino.vegas.Client clientFictif6 = new casino.vegas.Client("Fer", "Lucie", 19, 300, 4, 64, 10, 40);
    
    // ajout des employes fictifs
    public static casino.vegas.Employe caissier = new casino.vegas.Employe("Monier", "Charles", 26,  5,200, 1 );
    public static casino.vegas.Employe securite = new casino.vegas.Employe("Rusder", "Thomas", 28,  2 ,100, 2 );
    public static casino.vegas.Employe croupier = new casino.vegas.Employe("Durez", "Victor", 30,  5, 400, 3 );
    public static casino.vegas.Employe psy = new casino.vegas.Employe("Morin", "Stanislas", 40,  6, 1000, 4 );
    public static casino.vegas.Employe barman = new casino.vegas.Employe("Monier", "Charles", 23,  6,200, 5 );
    
    // lancement des actions
    public static casino.vegas.Jeux jeu;// = new casino.vegas.Jeux();
    public static casino.vegas.Chambre chambre = new casino.vegas.Chambre();
    public static casino.vegas.Bar bar = new casino.vegas.Bar();
    
    // initialisation des differents Jeux
    public static casino.vegas.Demineur demineur = new casino.vegas.Demineur();
    public static casino.vegas.Jackpot jackpot = new casino.vegas.Jackpot();
    public static casino.vegas.Roulette roulette = new casino.vegas.Roulette ();
    public static JeuDes jeuDes = new JeuDes();
    
    public static Demineur demin = new Demineur();
    
    
    
    // declarations des variables
    static int arriveBraqueur;
    static boolean jouer = true;
    
    
    /**
     * @param args the command line arguments
     */
    
    
    // main
    public static void main(String[] args) {
        int compteur = 0;
        arriveBraqueur = (int) (Math.random()*5) +1;
        
        int braqueurClientOuEmploye = (int) (Math.random()*2);
        
        // lancement du jeu
        Menu casino = new Menu();
        
        // boucle pour pouvoir effectuer plusieures action consecutives et sortir du jeu
        while (jouer)
        {
            compteur ++;
            casino.activite();
            
            //generer une arrivee aleatoire du Braqueur
            if (compteur == arriveBraqueur)
            {
                if (braqueurClientOuEmploye == 0)
                {
                    clientFictif1.entrerDansLeCasino();
                    clientFictif1.cambrioler();
                    joueur.choixActionBraquage();
                }
                else
                {
                    barman.entrerDansLeCasino();
                    barman.cambrioler();
                    joueur.choixActionBraquage();
                }
                
            }
            
            jouer = casino.rejouer();
        }
        
        
        // payez vos dette avant de partir
        bar.payer(joueur);
        
        // quitter le jeu
        System.out.println("\n\n\nFelicitation vous avez survecue dans le jeu"
                + "\nMerci d'avoir joue"
                + "\nA bientôt dans notre jeu !");
        
    }
        
}
