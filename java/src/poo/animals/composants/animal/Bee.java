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

    public Bee move(){
        System.out.println("L'abeille s'envole !");

        return this;
    }

    public Bee feed(){
        System.out.println("L'abeille mange du nectar");

        return this;
    }

    public Bee buzz(){
        System.out.println("L'abeille bourdonne BzZzZzZzZzZz !");

        return this;
    }

}