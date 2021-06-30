package poo.animals;

/**
 * @author Stagiaire
 * @version 1.0
 * @created 29-juin-2021 12:43:34
 */
public class Horse extends Herbivore {

    public Horse() {
        super("cheval");
    }

    public Horse feed(){
        System.out.println("Le cheval mange de l'herbe et du foin");

        return this;
    }

    public Horse neighs(){
        System.out.println("Le cheval hennit : Ruhruhruhruh !");

        return this;
    }

}