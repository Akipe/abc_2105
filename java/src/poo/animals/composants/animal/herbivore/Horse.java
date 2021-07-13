package poo.animals.composants.animal.herbivore;

import poo.animals.composants.animal.Herbivore;

/**
 * @author Stagiaire
 * @version 1.0
 * @created 29-juin-2021 12:43:34
 */
public class Horse extends Herbivore {

    public Horse() {
        super("cheval");
    }

    public String feed(){
        return "Le cheval mange de l'herbe et du foin";
    }

    public String neighs(){
        return "Le cheval hennit : Ruhruhruhruh !";
    }

}