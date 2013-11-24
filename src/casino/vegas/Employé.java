/*
 * Classe qui permet de définir les employés du casino
 * Elle permet également de gérer l'état de l'utilisateur en fonction de son compte,  son état d'ébriété, son état psychologique ainsi que sa dépendance au jeu
 * 
 * @ auteur : Amélie Ouillé
 */
package casino.vegas;

import java.util.Scanner;

import static casino.vegas.CasinoVegas.joueur;


public class Employé extends Personnage implements Braqueur{
    
     enum posteEnum { Caissier, Sécurité , Croupier , Psychologue, Barman}
     String poste;
     
     Scanner keyboard = new Scanner(System.in);
    
     
     /*
      * Constructeur permettant de créer les employés fictifs
      */
     public Employé (String nom, String prénom, int age, int etatPsycho, int soldeCompte, int poste)
     {
        this.nom = nom;
        this.prénom = prénom;
        this.age = age;
        this.soldeDuCompte = soldeCompte;
        this.etatPsycho = etatPsycho;
        definirEtatPsycho(this.etatPsycho);
        definirPoste(poste);
     }
     
     /*
      * Méthode permettant d'associer au nombre code, l'état psychologique correspondant.
      */
     public void definirPoste(int number)
     {
         switch (number)
        {
            case 1 :
                this.poste = posteEnum.Caissier.toString();
                break;
            case 2 :
                this.poste = posteEnum.Sécurité.toString();
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
     
     
     /*
      * Méthode qui permet au croupier et au  barman de vérifier l'état du joueur
      * ainsi, il sait si il doit faire appel à la sécurité ou à un psychologue
      */
     public void testerJoueur ()
     {
         if(joueur.dépendanceJeu > 80)
         {
             System.out.println("\n\n\nVotre dépendance au jeu devient trop élevé,"
                     + "\nje suis dans l'obligation de faire appel à un psychologue");
             appelerLePsy();
         }
         if(joueur.tauxAlcoolémie > 90)
         {
             System.out.println("\n\n\nVotre état d'ébriété est préoccupant,"
                     + "j'appelle la sécurité");
             appelerLaSécurité();
         }
         if(joueur.etatPsycho <= 2)
         {
             System.out.println("\n\n\nVous êtes dépressif, nous vous conseillons d'aller voir le psy");
             appelerLePsy();
         }
         if(joueur.soldeDuCompte <=0)
         {
             System.out.println("\n\n\nVous n'avez plus d'argent !"
                     + "\nJe dois appeler la sécurité");
             appelerLaSécurité();
         }
     }
     
     
     /*
      * Méthode permettant de faire appel à la sécurité en cas de dette ou d'état d'ébriété avancé
      * La sécurité peut virer le joueur ou bien lui faire payer une amende.
      */
     public void appelerLaSécurité ()
     {
         if (joueur.soldeDuCompte<=0)
         {
             System.out.println("Sécurité : Bonjour, je suis dans l'obligation de vous faire sortir du casino car vous êtes en déficit, vous avez une dette envers nous !"
                     + "\n\n       GAME OVER !!!");
             System.exit(0);
         }
         if (joueur.tauxAlcoolémie > 90)
         {
             System.out.println("Il faut vous ressaisir !"
                     + "\nArrêter de boire et suivez moi au poste de sécurité"
                     + "\nVous resterez ici jusqu'à ce que vous ayez un taux d'alcoolémie décent"
                     + "\nAsseyez-vous et buvez ce verre d'eau"
                     + "\n..."
                     + "\nMaintenant que vous allez mieux, vous devez me payer une amende de 50€ pour état d'ébriété");
             joueur.tauxAlcoolémie = 40;
             if (joueur.soldeDuCompte < 50)
             {
                 System.out.println("Vous rigolez !!!"
                         + "\nVous ne possédé même pas 50€ !!"
                         + "\nSortez d'ici immédiatement et que je ne vous revoie plus ici !!"
                         + "\n\n        GAME OVER !!!!");
                 System.exit(0);
             }
             else
                 joueur.soldeDuCompte -= 50;
         }
     }
     
     
     /*
      * Méthode permettant d'appeler un psychologue si le joueur est dépressif ou suicidaire 
      * mais également si celui-ci est trop dépend au jeu.
      * Le psychologue utilise une de ses méthodes pour régler le problème.
      * L'utilisateur pourra soit continuer à joueur soit être virer du casino si son état est trop critique
      */
     public void appelerLePsy()
     {
         int questionNumero;
         String reponse;
         
         System.out.println("Vous avez besoin de consulter un psychologue"
                 + "\nJ'en appelle un immédiatement");
         if (joueur.dépendanceJeu > 90)
         {
             System.out.println("Psychologue : Bonjour " + joueur.prénom + " " + joueur.nom
                     + "\n    J'ai remarqué que vous jouiez énormément aux jeux depuis quelque temps et qu'il vous fallait un peu d'aide"
                     + "\n    Nous allons donc commencer ensemble une thérapie rapide et efficace"
                     + "\n    Répondez à la question suivante :");
             
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
                     System.out.println("Le père noel est-il imaginaire ?");
                     break;
             }
             
             System.out.println("Attention répondez correctement sinon votre taux de dépendance dépassera la limite et nous devrons faire appel à la sécutité"
                     + "\n     Répondez par oui ou non");
             reponse = keyboard.nextLine();
             switch (reponse)
             {
                 case "oui" :
                     System.out.println("Bien, vous reconnaissez votre erreur ! "
                             + "\nChangeons d'activité");
                     joueur.faireActivité();
                     joueur.dépendanceJeu -= 50;
                     break;
                 case "non" :
                     System.out.println("Attention ! Vous ne vous rendez même pas compte que vous avez un probleme de dépendance");
                     appelerLaSécurité ();
                     break;
                 default :
                     System.out.println("Houla ! Vous ne savez même plus écrire tellement vous avez la tête dans le jeu !");
                     appelerLaSécurité ();       
             }
         }
         else if (joueur.etatPsycho <=2)
         {
             int blague  = (int) (Math.random()*4 +1);
             System.out.println("Psychologue : vous êtes actuellement en dépression voir même suicidaire!"
                     + "\nIl faut remédier à cela"
                     + "\nVoici une petite blague pour vous redonner le sourir");
             switch (blague)
             {
                 case 1 :
                     System.out.println("\n\nSi la tour de Pise penche vers la gauche, c'est qu'il va pleuvoir.\n" +
                           "Si elle penche vers la droite, c'est que vous arrivez par l'autre côté de la rue !");
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
                     System.out.println("\n\nDeux patates traversent la route. L'une d'elle se fait écraser. L'autre dit :\n" +
                        "\"Oh purée !\"");
                     break;
             }
             System.out.println("\n\n\nJ'ai cru vous voir exquisser un sourire, vous allez mieux"
                     + "\nVous êtes joyeux"
                     + "\nRetournez jouer mais attention changer de jeu sinon nous nous reverrons très vite !\n\n\n");
             joueur.etatPsycho = 5;
             joueur.faireActivité();
         }
         else
         {
             System.out.println("\n\nPsychologue : Votre état n'est pas encore critique"
                     + "\n    J'ai d'autre patient plus atteint à aller voir, pas le temps de m'occuper de vous !"
                     + "\n    Faites attention je suis succeptible de devoir revenir \n");
         }
     }
        
      
     
/*
 * Méthodes implémentées par l'interface
 * Cas où le braqueur est un employé de CasinoVegas
 */
     
     public void entrerDansLeCasino()
     {
         System.out.println("\n\n\n\n\n\n"
                 + "Un des employés vous semble suspect"
                 + "\nIl se comporte bizarement"
                 + "\nVous gardez un oeil sur lui tout en continuant vos activités");
     }
     
     public void cambrioler()
    {
        System.out.println("Vous entendez un coup de feu");
        joueur.choixActionBraquage();
    }
     
}

    
    


