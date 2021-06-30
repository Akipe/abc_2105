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
     * @param _species
     */
    public Animal(String _species){
        try {
            if (!_species.isEmpty()) {
                this.species = _species;
            } else {
                throw new Exception("Veuillez enter une éspéce pour cette animal.");
            }
        } catch (Exception error) {
            System.out.println("Erreur : " + error.getMessage());
            System.exit(2);
        }
    }

    public Animal move(){
        System.out.println("L'animal "+ this.getSpecies() + " ce déplace.");

        return this;
    }

    public Animal feed(){
        System.out.println("L'animal "+ this.getSpecies() + " mange : miam miam.");

        return this;
    }

    public String getSpecies(){
        return this.species;
    }
}