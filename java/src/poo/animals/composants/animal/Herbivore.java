package poo.animals.composants.animal;

import poo.animals.composants.Animal;

/**
 * @author Stagiaire
 * @version 1.0
 * @created 29-juin-2021 12:43:33
 */
public class Herbivore extends Animal {

    public Herbivore(String _species)
    {
        super(_species);
    }

    public String feed()
    {
        return "Le " + this.getSpecies() + " mange des végétaux, qu'est ce que c'est bon!";
    }
}