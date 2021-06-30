package poo.animals;

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

    public Giraffe move()
    {
        System.out.println("La girafe ce déplace tout doucement ... zZzZzZzZz");

        return this;
    }

    public Giraffe moose()
    {
        System.out.println("La girafe \"moose\" !!! La classe!");

        return this;
    }

}