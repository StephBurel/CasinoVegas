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
    public int dette = 0;
    public Client client = new Client();

    public void demarrer(Client perso) {
        this.client = perso;
        boolean wrong = true;
        int choice = -1;
        System.out.println("Bienvenue dans le bar");
        System.out.println("\n Que voulez vous faire?"
                + "\n pour prendre une consommation tapez 1"
                + "\n pour draguer tapez 2"
                + "\n pour payer tapez 3");
        do{
        
        try{
            choice = keyboard.nextInt(); 
            if(choice != 1 && choice!= 2 && choice != 3){
                throw new Exception("not 1, 2 or 3");
            }
            wrong = false;
        }
        catch(Exception e){
            System.out.println("veuillez entrer 1, 2 ou 3");
            keyboard.next();
        }
        }while(wrong);
        switch (choice) {
            case 1 :
                this.PrendreUneConso();
                break;
            case 2 :
                this.draguer();
                break;
            case 3 : 
                this.payer(client);
                break;
            default:
                break;
        }

    }

    public void payer(Personnage client) {

        client.soldeDuCompte -= dette;
        dette = 0;

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
        
        int choice = -1;
        boolean wrong = true;
        Bar.boisson drink;
        System.out.println("Quelle boisson voulez vous choisir?"
                + "\n pour une biere tapez 1"
                + "\n pour une eau tapez 2"
                + "\n pour une limonade tapez 3");
        
         do{
        
        try{
            choice = keyboard.nextInt(); 
            if(choice != 1 && choice!= 2 && choice != 3){
                throw new Exception("not 1, 2 or 3");
            }
            wrong = false;
        }
        catch(Exception e){
            System.out.println("veuillez entrer 1, 2 ou 3");
            keyboard.next();
        }
        }while(wrong);
        switch (choice) {
            case 1 :
                drink = boisson.Biere;
                break;
            case 2 :
                drink = boisson.eau;
                break;
            case 3 :
                drink = boisson.limonade;
                break;
            default: 
                drink = boisson.eau;
                break;
        }
        
        client.tauxAlcoolémie += drink.alcoolemie;
        dette += drink.prix;
    }

    public void draguer() {
        
        System.out.println("Vous venez de rencontrer une jolie fille \nQue lui racontez vous?");
        
    }
}
