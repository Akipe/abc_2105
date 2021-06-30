package poo.animals;

import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        Animal  cat;
        Bee     bee;
        Dog     dog;
        Labrador labrador;

        cat = new Animal("chat");
        System.out.println("L'espèce de l'animal est " + cat.getSpecies());
        cat.move().feed();

        System.out.println("");

        bee = new Bee();
        System.out.println("L'abeille est... une " + bee.getSpecies());
        bee.move().feed().buzz();
        
        System.out.println("");

        dog = new Dog("Wisky");
        System.out.println("Le chien s'appelle "+ dog.getName());
        dog.feed().bark();

        System.out.println("");

        labrador = new Labrador("Bibou");

        labrador.move().move().move().move().move();

        TimeUnit.SECONDS.sleep(6);

        System.out.println(new java.util.Date().getTime());
    }
}
