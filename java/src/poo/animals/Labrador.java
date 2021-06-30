package poo.animals;

/**
 * @author Stagiaire
 * @version 1.0
 * @created 29-juin-2021 12:43:35
 */
public class Labrador extends Dog {
    private Boolean hasMove = false;

    /**
     * 
     * @param name
     */
    public Labrador(String _name){
        super(_name);
    }

    public Animal move(){
        if (this.hasMove) {
            System.out.println(this.getName() + " n'a pas envie de se déplacer :(");
            this.hasMove = false;
        } else {
            System.out.println(this.getName() + " marche tranquillement.");
            this.hasMove = true;
        }

        return this;
    }

}