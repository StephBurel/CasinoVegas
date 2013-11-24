/*
 * Classe Principale (contenant le main)
 * contient l'intialisation des différentes classes utilisées dans le programme
 * Permet au joueur d'accéder au menu pour ensuite jouer aux différents jeux
 * 
 * @ auteur : Amélie Ouillé
 */
package casino.vegas;

import casino.vegas.Démineur;
import casino.vegas.JeuDes;
import static casino.vegas.CasinoVegas.joueur;

import java.util.Random;



public class CasinoVegas {

    /**
     * @param args the command line arguments
     */
   
    // initialsation du joueur
    public static casino.vegas.Client joueur = new casino.vegas.Client();
    
    // ajout des clients fictifs
    public static casino.vegas.Client clientFictif1 = new casino.vegas.Client("Dupont", "Celine", 24, 200, 2, 10, 50, 60);
    public static casino.vegas.Client clientFictif2 = new casino.vegas.Client("Smith", "Paul", 25, 800, 6, 70, 10, 70);
    public static casino.vegas.Client clientFictif3 = new casino.vegas.Client("Gold Fish", "Shark", 32, 50, 1, 20, 90, 95);
    public static casino.vegas.Client clientFictif4 = new casino.vegas.Client("Betanlong", "Ingrid", 52, 19620, 5, 90, 70, 25);
    public static casino.vegas.Client clientFictif5 = new casino.vegas.Client("Federer", "Roger", 22, 150000, 3, 60, 20, 100);
    public static casino.vegas.Client clientFictif6 = new casino.vegas.Client("Fer", "Lucie", 19, 300, 4, 64, 10, 40);
    
    // ajout des employés fictifs
    public static casino.vegas.Employé caissier = new casino.vegas.Employé("Monier", "Charles", 26,  5,200, 1 );
    public static casino.vegas.Employé securite = new casino.vegas.Employé("Rusder", "Thomas", 28,  2 ,100, 2 );
    public static casino.vegas.Employé croupier = new casino.vegas.Employé("Durez", "Victor", 30,  5, 400, 3 );
    public static casino.vegas.Employé psy = new casino.vegas.Employé("Morin", "Stanislas", 40,  6, 1000, 4 );
    public static casino.vegas.Employé barman = new casino.vegas.Employé("Monier", "Charles", 23,  6,200, 5 );
    
    // lancement des actions
    public static casino.vegas.Jeux jeu;// = new casino.vegas.Jeux();
    public static casino.vegas.Chambre chambre = new casino.vegas.Chambre();
    public static casino.vegas.Bar bar = new casino.vegas.Bar();
    
    // initialisation des différents Jeux
    public static casino.vegas.Démineur demineur = new casino.vegas.Démineur();
    public static casino.vegas.Jackpot jackpot = new casino.vegas.Jackpot();
    public static casino.vegas.Roulette roulette = new casino.vegas.Roulette ();
    public static JeuDes jeuDes = new JeuDes();
    
    public static Démineur demin = new Démineur();
    
    
    
    // déclarations des variables
    static int arriveBraqueur;
    static boolean jouer = true;
    
    
    /**
     * @param args the command line arguments
     */
    
    
    // main
    public static void main(String[] args) {
        int compteur = 0;
        arriveBraqueur = (int) (Math.random()*5) +1;
        
        // lancement du jeu
        Menu casino = new Menu();
        
        // boucle pour pouvoir effectuer plusieures action consécutives et sortir du jeu
        while (jouer)
        {
            compteur ++;
            casino.activité();
            
            //générer une arrivée aléatoire du Braqueur
            if (compteur == arriveBraqueur)
            {
                
            }
            
            jouer = casino.rejouer();
        }
        
        // quitter le jeu
        System.out.println("\n\n\nFelicitation vous avez survécue dans le jeu"
                + "\nMerci d'avoir joué"
                + "\nA bientôt dans notre jeu !");
        
    }
        
}
