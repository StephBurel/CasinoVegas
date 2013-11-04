/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package casino.vegas;

import static casino.vegas.CasinoVegas.joueur;
import static casino.vegas.CasinoVegas.demineur;
import static casino.vegas.CasinoVegas.jeuDes;
import static casino.vegas.CasinoVegas.jackpot;
import static casino.vegas.CasinoVegas.roulette;

import java.util.Scanner;
/**
 *
 * @author isen
 */
public class Jeux {
    Scanner keyboard = new Scanner(System.in);
    
    public void demarrer(){
        
        String choixJeu;
        
        System.out.println("\n\nBienvenue dans le Casino !");
        if (joueur.age < 21)
        {
            System.out.println ("Vous êtes trop jeune pour jouer aux jeux de casino, vous pouvez uniquement jouer au démineur"
                    + "\nVoulez-vous y jouer ? Dites oui pour y jouer");
            choixJeu = this.keyboard.nextLine();
            if (choixJeu.equals("oui"))
            {
                demineur.demarrer();
            }
        }
        else
        {
            System.out.println("Veuillez choisir votre jeu parmis les suivants :"
                    + "\n Pour jouer au 421 tapez 1"
                    + "\n Pour jouer à la roulette tapez 2"
                    + "\n Pour jouer au Jackpot tapez 3"
                    + "\n Pour jouer au démineur tapez 4");
        }
    }
   
    
}