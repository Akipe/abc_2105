package poo.animals;

/**
 * @author Stagiaire
 * @version 1.0
 * @created 29-juin-2021 12:43:29
 */
public class Animal {

    private String species;

    /**
     * 
     * @param species
     */
    public Animal Animal(String _species){
        if (!_species.isEmpty()) {
            this.species = _species;
        }

        return this;
    }

    public Animal move(){
        return null;
    }

    public Animal feed(){
        return null;
    }

    public String getSpecies(){
        return "";
    }

}