package poo.animals;

import poo.animals.composants.Animal;
import poo.animals.composants.animal.Bee;
import poo.animals.composants.animal.Dog;
import poo.animals.composants.animal.dog.Labrador;
import poo.animals.composants.animal.dog.Pinscher;
import poo.animals.composants.animal.Herbivore;
import poo.animals.composants.animal.herbivore.Giraffe;
import poo.animals.composants.animal.herbivore.Horse;

public class App
{
    public static void main(String[] args)
    {
        Animal      cat;
        Bee         bee;
        Dog         dog;
        Labrador    labrador;
        Pinscher    pinscher;
        Herbivore   snail;
        Horse       horse;
        Giraffe     giraffe;


        cat = new Animal("chat");
        System.out.println("L'espèce de l'animal est " + cat.getSpecies());
        cat.move().feed();

        niceSeperation();

        bee = new Bee();
        System.out.println("L'abeille est... une " + bee.getSpecies());
        bee.move().feed().buzz();
        
        niceSeperation();

        dog = new Dog("Wisky");
        System.out.println("Le chien s'appelle "+ dog.getName());
        dog.feed().bark();

        niceSeperation();

        labrador = new Labrador("Bibou");
        labrador.move().move().move().move().move();

        niceSeperation();

        snail = new Herbivore("escargot");
        snail.feed();

        niceSeperation();

        horse = new Horse();
        horse.feed().neighs();

        niceSeperation();

        giraffe = new Giraffe();
        giraffe.move().moose();

        niceSeperation();
        
        pinscher = new Pinscher("George");
        pinscher.bark();
    }

    private static void niceSeperation()
    {
        System.out.println("---------------");
    }
}
