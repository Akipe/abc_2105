package poo.cardgame.composants;

/**
 * @author Stagiaire
 * @version 1.0
 * @created 15-juil.-2021 09:17:59
 */
public class Card {
    private String  name;
    private int     strength;
    private int     armor;
    private int     power;


    /**
     * 
     * @param _name
     * @param _strength
     * @param _armor
     * @param _power
     */
    public Card(String _name, int _strength, int _armor, int _power){

    }

    public String getName(){
        return "";
    }

    public int getStrength(){
        return 0;
    }

    public int getArmor(){
        return 0;
    }

    public int getPower(){
        return 0;
    }

    public Player[] getCardOwner(){
        return null;
    }

    /**
     * 
     * @param _player
     */
    public void setCardOwner(Player _player){

    }
}