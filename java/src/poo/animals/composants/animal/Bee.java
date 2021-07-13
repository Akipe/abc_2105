package poo.animals.composants.animal;

import poo.animals.composants.Animal;

/**
 * @author Stagiaire
 * @version 1.0
 * @created 29-juin-2021 12:43:31
 */
public class Bee extends Animal {

    /**
     * 
     */
    public Bee(){
        super("abeille");
    }

    public String move(){
        return "L'abeille s'envole !";
    }

    public String feed(){
        return "L'abeille mange du nectar";
    }

    public String buzz(){
        return "L'abeille bourdonne BzZzZzZzZzZz !";
    }

}