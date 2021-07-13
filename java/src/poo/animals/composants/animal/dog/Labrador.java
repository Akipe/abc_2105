package poo.animals.composants.animal.dog;

import poo.animals.composants.animal.Dog;

/**
 * @author Stagiaire
 * @version 1.0
 * @created 29-juin-2021 12:43:35
 */
public class Labrador extends Dog {
    private Boolean hasMove = false;

    /**
     * 
     * @param _name
     */
    public Labrador(String _name){
        super(_name);
    }

    public String move(){
        if (this.hasMove) {
            this.hasMove = false;
            return this.getName() + " n'a pas envie de se déplacer :(";
        } else {
            this.hasMove = true;
            return this.getName() + " marche tranquillement.";
        }
    }

}