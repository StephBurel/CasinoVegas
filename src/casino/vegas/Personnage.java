/** 
 * @ auteur : Amelie Ouille
 */
package casino.vegas;

/**
 * Classe permettant de definir l'ensemble des personnages (clients et employes)
 * Elle permet de definir l'etat psychologique des personnages
 * 
 */
public class Personnage {
    
    String prenom, nom;
    int age, etatPsycho;
    float soldeDuCompte;
    String etatPsychoStr;
    
    enum etatPsychoEnum { Suicidaire, Depressif , AccroAuJeu , Anxieux, Joyeux, Amoureux}
    
    
    /**
     * Methode qui permet de definir l'etat psychologique de chacun de joueur.
     * Elle utilise le nombre qui correspond à un etat pour y associer son titre.
     */
    public void definirEtatPsycho (int number)
    {
        switch (number)
        {
            case 1 :
                this.etatPsychoStr = casino.vegas.Personnage.etatPsychoEnum.Suicidaire.toString();
                break;
            case 2 :
                this.etatPsychoStr = casino.vegas.Personnage.etatPsychoEnum.Depressif.toString();
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
