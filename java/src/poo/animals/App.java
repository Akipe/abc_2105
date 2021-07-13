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
        System.out.println(cat.move() + "\n" + cat.feed());

        niceSeperation();

        bee = new Bee();
        System.out.println("L'abeille est... une " + bee.getSpecies());
        System.out.println(bee.move() + "\n" + bee.feed() + "\n" + bee.buzz());
        
        niceSeperation();

        dog = new Dog("Wisky");
        System.out.println("Le chien s'appelle "+ dog.getName());
        System.out.println(dog.feed() + "\n" + dog.bark());

        niceSeperation();

        labrador = new Labrador("Bibou");
        System.out.println(labrador.move() + "\n" + labrador.move() + "\n" + labrador.move() + "\n" + labrador.move());

        niceSeperation();

        snail = new Herbivore("escargot");
        System.out.println(snail.feed());

        niceSeperation();

        horse = new Horse();
        System.out.println(horse.feed() + "\n" + horse.neighs());

        niceSeperation();

        giraffe = new Giraffe();
        System.out.println(giraffe.move() + "\n"  + giraffe.moose());

        niceSeperation();
        
        pinscher = new Pinscher("George");
        System.out.println(pinscher.bark());
    }

    private static void niceSeperation()
    {
        System.out.println("---------------");
    }
}
