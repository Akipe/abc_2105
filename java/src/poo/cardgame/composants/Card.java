package poo.cardgame.composants;

/**
 * @author Stagiaire
 * @version 1.0
 * @created 15-juil.-2021 09:17:59
 */
public class Card {
    private String      name;
    private int         strength;
    private int         armor;
    private int         power;
    private static int  quantities;


    /**
     * 
     * @param _name
     * @param _strength
     * @param _armor
     * @param _power
     */
    public Card(String _name, int _strength, int _armor, int _power){
        try {
            if (_name.isEmpty()) {
                throw new Exception("Veuillez définir un nom pour cette carte.");
            }
        } catch (Exception error) {
            System.out.println("Erreur : " + error.getMessage());
            System.exit(2);
        }

        this.name       = _name;
        this.strength   = _strength;
        this.armor      = _armor;
        this.power      = _power;

        Card.quantities++;
    }

    public String getName(){
        return this.name;
    }

    public int getStrength(){
        return this.strength;
    }

    public int getArmor(){
        return this.armor;
    }

    public int getPower(){
        return this.power;
    }

    public static int getHowManyQuantities(){
        return Card.quantities;
    }
}