/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package casino.vegas;

/**
 *
 * @author isen
 */
public class Chambre {
    
    static int prix ;
    public int NbrOccupantsMax;
    
    
    public void demarrer()
    {
        
         System.out.println("Bienvenue à l'hotel du Casino"
                + "\nVeuillez choisir la chambre désirée");
        
    }
    
   public static void PrendreUneChambre(Personnage joueur){
        
        joueur.soldeDuCompte = joueur.soldeDuCompte - prix;
        
}
   
}
