/**
 * Interface qui permet de définir un braqueur qui viendra perturber le bon fonctionnement du jeu
 * Le braqueur implémente les classes client et employé
 * 
 * @ auteur : Amélie Ouillé
 */
package casino.vegas;

/**
 *définition des deux méthodes qui seront overridé dans les classes implémentées
 */
public interface Braqueur {
    
    public void entrerDansLeCasino();
    public void cambrioler();
}
