package poo.animals;

/**
 * @author Stagiaire
 * @version 1.0
 * @created 29-juin-2021 12:43:31
 */
public class Dog extends Animal {
    private String name;

    /**
     * 
     * @param _name
     */
    public Dog(String _name){
        super("chien");

        try {
            if (!_name.isEmpty()) {
                this.name = _name;
            } else {
                throw new Exception("Veuillez entrer un nom pour votre chient.");
            }
        } catch (Exception error) {
            System.err.println("Erreur : " + error.getMessage());
        }
    }

    public String getName(){
        return this.name;
    }

    public Dog feed(){
        System.out.println("Le " + this.getSpecies() + " " + this.getName() + " est entrain de manger sa pâtée.");

        return this;
    }

    public Dog bark(){
        System.out.println("Le " + this.getSpecies() + " " + this.getName() + " est entrain d'aboyer : woaf woaf!");

        return this;
    }

}