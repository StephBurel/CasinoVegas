/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package casino.vegas;

import static casino.vegas.Chambre.prix;

/**
 *
 * @author isen
 */
public class ChambreFamiliale extends Chambre {
    
    
    static int prix;
    
    public ChambreFamiliale(){
    
        this.prix = 100;
        this.NbrOccupantsMax = 4;
    
}
    
    public static void PrendreUneChambre(Personnage joueur){
        
        joueur.soldeDuCompte = joueur.soldeDuCompte - prix;
        
}
    
}
