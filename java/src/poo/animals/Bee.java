package poo.animals;

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
        System.out.println("L'" + this.getSpecies() + " s'envole !");

        return this;
    }

    public Bee feed(){
        System.out.println("L'" + this.getSpecies() + " mange du nectar");

        return this;
    }

    public Bee buzz(){
        System.out.println("L'" + this.getSpecies() + " bourdonne BzZzZzZzZzZz !");

        return this;
    }

}