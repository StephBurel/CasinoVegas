/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package casino.vegas;

/**
 *
 * @author isen
 */
public class Client extends Personnage {
    
    public void prendreUneChambre(){
        
        Chambre room = new Chambre();
        ChambreFamiliale room2 = (ChambreFamiliale) room;
        System.out.print(room2.getClass());
         
    }
    
}
