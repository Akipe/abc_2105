package poo.animals.composants.animal.herbivore;

import poo.animals.composants.animal.Herbivore;

/**
 * @author Stagiaire
 * @version 1.0
 * @created 29-juin-2021 12:43:32
 */
public class Giraffe extends Herbivore {

    public Giraffe()
    {
        super("girafe");
    }

    public String move()
    {
        return "La girafe ce déplace tout doucement ... zZzZzZzZz";
    }

    public String moose()
    {
        return "La girafe \"moose\" !!! La classe!";
    }

}