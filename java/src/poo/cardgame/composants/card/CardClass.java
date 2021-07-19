package poo.cardgame.composants.card;

import poo.cardgame.composants.Card;

/**
 * @author Stagiaire
 * @version 1.0
 * @created 15-juil.-2021 09:17:59
 */
public class CardClass extends Card {
    private int     classID;
    private String  className;
    private String  classDescription;
    private Energy  classEnergy;


    /**
     * 
     * @param _name
     * @param _description
     * @param _energy
     */
    public CardClass(String _name, int _strength, int _armor, int _power, String _className, String _description, Energy _energy){
        super(_name, _strength, _armor, _power);

        try {
            if (_className.isEmpty()) {
                throw new Exception("Veuillez entrer un surnom pour le joueur.");
            } else if (_description.isEmpty()) {
                throw new Exception("Veuillez entrer un email pour le joueur.");
            } else if (_energy == null) {
                throw new Exception("Veuillez entrer un prénom pour le joueur.");
            }
        } catch (Exception error) {
            System.out.println("Erreur : " + error.getMessage());
            System.exit(2);
        }

        this.classID = Card.getHowManyQuantities() - 1;
        this.className = _className;
        this.classDescription = _description;
        this.classEnergy = _energy;
    }

    public int getClassID(){
        return this.classID;
    }

    public String getClassName(){
        return this.className;
    }

    /**
     * 
     * @param _description
     */
    public CardClass setClassDescription(String _description){
        try {
            if (_description.isEmpty()) {
                throw new Exception("Veuillez entrer une description.");
            }
        } catch (Exception error) {
            System.err.println("Erreur : " + error.getMessage());
            System.exit(2);
        }

        this.classDescription = _description;

        return this;
    }

    public String getClassDescription(){
        return this.classDescription;
    }

    public Energy getClassEnergy(){
        return this.classEnergy;
    }
}