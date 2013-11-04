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
public class Bar {

    static Scanner keyboard = new Scanner(System.in);
    public int dette;

    public void demarrer() {
        System.out.println("Bienvenue dans le bar");
        System.out.println("\n Que voulez vous faire?"
                + "\n pour prendre une consommation tapez 1"
                + "\n pour draguer tapez 2"
                + "\n pour payer tapez 3");

        String choice = keyboard.nextLine();
        switch (choice) {
            case "1" :
                this.PrendreUneConso();
                break;
            case "2" :
                this.draguer();
                break;
            case "3" :
                break;
            default:
                break;
        }

    }

    public void payer(Personnage joueur) {

        //joueur.soldeDuCompte -= this.prix;

    }

    enum boisson {

        Biere(5,6), eau(1,0), limonade(2,0), whisky(10,40);
        private int prix;
        private int alcoolemie;

        boisson(int prix, int alcoolemie) {
            this.prix = prix;
            this.alcoolemie = alcoolemie;
        }
    }

    public void PrendreUneConso() {
        
        Bar.boisson drink;
        System.out.println("Quelle boisson voulez vous choisir?"
                + "\n pour une biere tapez 1"
                + "\n pour une eau tapez 2"
                + "\n pour une limonade tapez 3");
        
        String choice = keyboard.nextLine();
        switch (choice) {
            case "1" :
                drink = boisson.Biere;
                break;
            case "2" :
                drink = boisson.eau;
                break;
            case "3" :
                drink = boisson.limonade;
                break;
            default: 
                drink = boisson.eau;
                break;
        }
        
        dette += drink.prix;
    }

    public void draguer() {
    }
}
