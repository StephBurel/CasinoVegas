/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package casino.vegas;
import java.util.Scanner;

/**
 *
 * @author isen
 */
public class Chambre {
    
    static int prix ;
    public int NbrOccupantsMax;
    static Scanner keyboard = new Scanner(System.in);
    
    
    enum chambre{
        luxe(100), familialle(60), standard(50);
        private int prix;
        chambre(int prix){
            this.prix = prix;
        }
        
    }
    
    public void demarrer()
    {
        System.out.println("Bienvenue dans l'hôtel\nQue voulez-vous faire?");
        
        
        
    }
    
   public static void PrendreUneChambre(Personnage joueur){
        
        joueur.soldeDuCompte = joueur.soldeDuCompte - prix;
        
}
   
}
