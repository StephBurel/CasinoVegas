/** 
 * @ auteur : Amelie Ouille
 */
package casino.vegas;

import java.util.Scanner;

import static casino.vegas.CasinoVegas.joueur;

/**
 * Classe qui permet de definir les employes du casino
 * Elle permet egalement de gerer l'etat de l'utilisateur en fonction de son compte,  son etat d'ebriete, son etat psychologique ainsi que sa dependance au jeu
 * 
 */
public class Employe extends Personnage implements Braqueur{
    
     enum posteEnum { Caissier, Securite , Croupier , Psychologue, Barman}
     String poste;
     
     Scanner keyboard = new Scanner(System.in);
    
     
     /**
      * Constructeur permettant de creer les employes fictifs
      */
     public Employe (String nom, String prenom, int age, int etatPsycho, int soldeCompte, int poste)
     {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.soldeDuCompte = soldeCompte;
        this.etatPsycho = etatPsycho;
        definirEtatPsycho(this.etatPsycho);
        definirPoste(poste);
     }
     
     /**
      * Methode permettant d'associer au nombre code, l'etat psychologique correspondant.
      */
     public void definirPoste(int number)
     {
         switch (number)
        {
            case 1 :
                this.poste = posteEnum.Caissier.toString();
                break;
            case 2 :
                this.poste = posteEnum.Securite.toString();
                break;
            case 3 :
                this.poste = posteEnum.Croupier.toString();
                break;
            case 4 :
                this.poste = posteEnum.Psychologue.toString();
                break;
            case 5 :
                this.poste = posteEnum.Barman.toString();
                break;
        }
     }
     
     
     /**
      * Methode qui permet au croupier et au  barman de verifier l'etat du joueur
      * ainsi, il sait si il doit faire appel à la securite ou à un psychologue
      */
     public void testerJoueur ()
     {
         if(joueur.dependanceJeu > 80)
         {
             System.out.println("\n\n\nVotre dependance au jeu devient trop eleve,"
                     + "\nje suis dans l'obligation de faire appel à un psychologue");
             appelerLePsy();
         }
         if(joueur.tauxAlcoolemie > 90)
         {
             System.out.println("\n\n\nVotre etat d'ebriete est preoccupant,"
                     + "j'appelle la securite");
             appelerLaSecurite();
         }
         if(joueur.etatPsycho <= 2)
         {
             System.out.println("\n\n\nVous êtes depressif, nous vous conseillons d'aller voir le psy");
             appelerLePsy();
         }
         if(joueur.soldeDuCompte <=0)
         {
             System.out.println("\n\n\nVous n'avez plus d'argent !"
                     + "\nJe dois appeler la securite");
             appelerLaSecurite();
         }
     }
     
     
     /**
      * Methode permettant de faire appel à la securite en cas de dette ou d'etat d'ebriete avance
      * La securite peut virer le joueur ou bien lui faire payer une amende.
      */
     public void appelerLaSecurite ()
     {
         if (joueur.soldeDuCompte<=0)
         {
             System.out.println("Securite : Bonjour, je suis dans l'obligation de vous faire sortir du casino car vous êtes en deficit, vous avez une dette envers nous !"
                     + "\n\n       GAME OVER !!!");
             System.exit(0);
         }
         if (joueur.tauxAlcoolemie > 90)
         {
             System.out.println("Il faut vous ressaisir !"
                     + "\nArrêter de boire et suivez moi au poste de securite"
                     + "\nVous resterez ici jusqu'à ce que vous ayez un taux d'alcoolemie decent"
                     + "\nAsseyez-vous et buvez ce verre d'eau"
                     + "\n..."
                     + "\nMaintenant que vous allez mieux, vous devez me payer une amende de 50€ pour etat d'ebriete");
             joueur.tauxAlcoolemie = 40;
             if (joueur.soldeDuCompte < 50)
             {
                 System.out.println("Vous rigolez !!!"
                         + "\nVous ne possede même pas 50€ !!"
                         + "\nSortez d'ici immediatement et que je ne vous revoie plus ici !!"
                         + "\n\n        GAME OVER !!!!");
                 System.exit(0);
             }
             else
                 joueur.soldeDuCompte -= 50;
         }
     }
     
     
     /**
      * Methode permettant d'appeler un psychologue si le joueur est depressif ou suicidaire 
      * mais egalement si celui-ci est trop depend au jeu.
      * Le psychologue utilise une de ses methodes pour regler le probleme.
      * L'utilisateur pourra soit continuer à joueur soit être virer du casino si son etat est trop critique
      */
     public void appelerLePsy()
     {
         int questionNumero;
         String reponse;
         
         System.out.println("Vous avez besoin de consulter un psychologue"
                 + "\nJ'en appelle un immediatement");
         if (joueur.dependanceJeu > 90)
         {
             System.out.println("Psychologue : Bonjour " + joueur.prenom + " " + joueur.nom
                     + "\n    J'ai remarque que vous jouiez enormement aux jeux depuis quelque temps et qu'il vous fallait un peu d'aide"
                     + "\n    Nous allons donc commencer ensemble une therapie rapide et efficace"
                     + "\n    Repondez à la question suivante :");
             
             questionNumero = (int) (Math.random() * 5)+1;
             switch (questionNumero)
             {
                 case 1 :
                     System.out.println("Pensez vous que vous êtes accro aux jeux ?");
                     break;
                 case 2 :
                     System.out.println("Devriez vous arreter de jouer et aller dans un autre espace du casino ?");
                     break;
                 case 3 :
                     System.out.println("Etes vous dans le casino ?");
                     break;
                 case 4 :
                     System.out.println("Avez vous " + joueur.age +" ans ?");
                     break;
                 case 5 :
                     System.out.println("Le pere noel est-il imaginaire ?");
                     break;
             }
             
             System.out.println("Attention repondez correctement sinon votre taux de dependance depassera la limite et nous devrons faire appel à la secutite"
                     + "\n     Repondez par oui ou non");
             reponse = keyboard.nextLine();
             switch (reponse)
             {
                 case "oui" :
                     System.out.println("Bien, vous reconnaissez votre erreur ! "
                             + "\nChangeons d'activite");
                     joueur.faireActivite();
                     joueur.dependanceJeu -= 50;
                     break;
                 case "non" :
                     System.out.println("Attention ! Vous ne vous rendez même pas compte que vous avez un probleme de dependance");
                     appelerLaSecurite ();
                     break;
                 default :
                     System.out.println("Houla ! Vous ne savez même plus ecrire tellement vous avez la tête dans le jeu !");
                     appelerLaSecurite ();       
             }
         }
         else if (joueur.etatPsycho <=2)
         {
             int blague  = (int) (Math.random()*4 +1);
             System.out.println("Psychologue : vous êtes actuellement en depression voir même suicidaire!"
                     + "\nIl faut remedier à cela"
                     + "\nVoici une petite blague pour vous redonner le sourir");
             switch (blague)
             {
                 case 1 :
                     System.out.println("\n\nSi la tour de Pise penche vers la gauche, c'est qu'il va pleuvoir.\n" +
                           "Si elle penche vers la droite, c'est que vous arrivez par l'autre côte de la rue !");
                     break;
                 case 2 :
                     System.out.println("\n\nUn mec rentre dans un bar :\n" +
                            "- Je voudrais une chwirzderkilmaskichtmeurk à la menthe.\n" +
                            "Et le barman :\n" +
                            "- Un chwirzderkilmaskichtmeurk à la quoi ?");
                     break;
                 case 3 :
                     System.out.println("\n\nQue fait un crocodile quand il rencontre une superbe femelle ?\n" +
                            "\n" +
                            "- Il Lacoste !");
                     break;
                 case 4 :
                     System.out.println("\n\nVous connaissez l'histoire de la chaise ???\n" +
                            "\n" +
                            "- Non? C'est dommage elle est pliante...");
                     break;
                 case 5:
                     System.out.println("\n\nDeux patates traversent la route. L'une d'elle se fait ecraser. L'autre dit :\n" +
                        "\"Oh puree !\"");
                     break;
             }
             System.out.println("\n\n\nJ'ai cru vous voir exquisser un sourire, vous allez mieux"
                     + "\nVous êtes joyeux"
                     + "\nRetournez jouer mais attention changer de jeu sinon nous nous reverrons tres vite !\n\n\n");
             joueur.etatPsycho = 5;
             joueur.faireActivite();
         }
         else
         {
             System.out.println("\n\nPsychologue : Votre etat n'est pas encore critique"
                     + "\n    J'ai d'autre patient plus atteint à aller voir, pas le temps de m'occuper de vous !"
                     + "\n    Faites attention je suis succeptible de devoir revenir \n");
         }
     }
        
      
     
/**
 * Methodes implementees par l'interface
 * Cas où le braqueur est un employe de CasinoVegas
 */
     
     public void entrerDansLeCasino()
     {
         System.out.println("\n\n\n\n\n\n"
                 + "Un des employes vous semble suspect"
                 + "\nIl se comporte bizarement"
                 + "\nVous gardez un oeil sur lui tout en continuant vos activites");
     }
     
     public void cambrioler()
    {
        System.out.println("Vous entendez un coup de feu");
        joueur.choixActionBraquage();
    }
     
}

    
    


