/**
 * Classe permettant de définir l'ensemble des personnages (clients et employés)
 * Elle permet de définir l'état psychologique des personnages
 * 
 * @ auteur : Amélie Ouillé
 */
package casino.vegas;


public class Personnage {
    
    String prénom, nom;
    int age, etatPsycho;
    float soldeDuCompte;
    String etatPsychoStr;
    
    enum etatPsychoEnum { Suicidaire, Dépressif , AccroAuJeu , Anxieux, Joyeux, Amoureux}
    
    
    /**
     * Méthode qui permet de définir l'état psychologique de chacun de joueur.
     * Elle utilise le nombre qui correspond à un état pour y associer son titre.
     */
    public void definirEtatPsycho (int number)
    {
        switch (number)
        {
            case 1 :
                this.etatPsychoStr = casino.vegas.Personnage.etatPsychoEnum.Suicidaire.toString();
                break;
            case 2 :
                this.etatPsychoStr = casino.vegas.Personnage.etatPsychoEnum.Dépressif.toString();
                break;
            case 3 :
                this.etatPsychoStr = casino.vegas.Personnage.etatPsychoEnum.AccroAuJeu.toString();
                break;
            case 4 :
                this.etatPsychoStr = casino.vegas.Personnage.etatPsychoEnum.Anxieux.toString();
                break;
            case 5 :
                this.etatPsychoStr = casino.vegas.Personnage.etatPsychoEnum.Joyeux.toString();
                break;
            case 6 :
                this.etatPsychoStr = casino.vegas.Personnage.etatPsychoEnum.Amoureux.toString();
                break;
        }
    }
     
}
