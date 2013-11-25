/**
 * @ auteur : Amelie Ouille
 */

package casino.vegas;
/**
 * Interface qui permet de definir un braqueur qui viendra perturber le bon fonctionnement du jeu
 * Le braqueur implemente les classes client et employe
 * 
 */

public interface Braqueur {
 
 //definition des deux methodes qui seront override dans les classes implementees
 
    public void entrerDansLeCasino();
    public void cambrioler();
}
