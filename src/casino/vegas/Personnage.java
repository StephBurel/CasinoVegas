/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package casino.vegas;

/**
 *
 * @author STEPHAN
 */
public class Personnage {
    
    String prénom, nom;
    int age, etatPsycho;
    float soldeDuCompte;
    String etatPsychoStr;
    
    enum etatPsychoEnum { Suicidaire, Dépressif , AccroAuJeu , Anxieux, Joyeux, Amoureux}
    
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
