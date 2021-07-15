package poo.cardgame.composants;

import poo.cardgame.composants.helper.AkpArrays;

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
    private Player[]    inHandPlayers;


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

        this.inHandPlayers = new Player [0];
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

    public Player[] getCardOwner(){
        return this.inHandPlayers;
    }

    /**
     * 
     * @param _player
     */
    public Card addCardOwner(Player _player){
        // this.inHandPlayers = Arrays.copyOf(this.inHandPlayers, this.inHandPlayers.length + 1);
        // this.inHandPlayers[this.inHandPlayers.length - 1] = _player;
        this.inHandPlayers = (Player[]) AkpArrays.appendObject(this.inHandPlayers, _player);

        return this;
    }

    /**
     * 
     * @param _player
     */
    public Card removeCardOwner(Player _player){
        try {
            if (this.inHandPlayers.length == 0) {
                throw new Exception("Aucun joueur n'est associé à cette carte!");
            }

            // // Create a new array with 1 less index
            // Player[] inHandPlayersWithRemovedPlayer = new Player[this.inHandPlayers.length - 1];

            // // We add value of old array to the new array, without the player that we want to delete
            // for (int indexOldTab = 0, indexNewTab = 0; indexOldTab < this.inHandPlayers.length; indexNewTab = ++indexOldTab) {

            //     if (this.inHandPlayers[indexOldTab] == _player) {
            //         indexNewTab--;
            //     } else {
            //         inHandPlayersWithRemovedPlayer[indexNewTab] = this.inHandPlayers[indexOldTab];
            //     }
            // }

            // this.inHandPlayers = inHandPlayersWithRemovedPlayer;
            this.inHandPlayers = (Player[]) AkpArrays.removeObject(this.inHandPlayers, _player);

        } catch (Exception error) {
            System.out.println("Erreur : " + error.getMessage());
            System.exit(2);
        }

        return this;
    }
    
    /**
     * 
     * @param _player
     */
    public Card removeAllCardOwners(Player _player){
        this.inHandPlayers = new Player[0];

        return this;
    }
}