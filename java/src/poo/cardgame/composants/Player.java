package poo.cardgame.composants;

/**
 * @author Stagiaire
 * @version 1.0
 * @created 15-juil.-2021 09:17:59
 */
public class Player {
    private String  nickname;
    private String  firstName;
    private String  lastName;
    private String  email;
    private Card    cards;


    /**
     * 
     * @param _nickname
     * @param _firstName
     * @param _lastName
     * @param _email
     */
    public Player(String _nickname, String _firstName, String _lastName, String _email){
        try {
            if (_nickname.isEmpty()) {
                throw new Exception("Veuillez entrer un surnom pour le joueur.");
            } else if (_firstName.isEmpty()) {
                throw new Exception("Veuillez entrer un prénom pour le joueur.");
            } else if (_lastName.isEmpty()) {
                throw new Exception("Veuillez entrer un nom pour le joueur.");
            } else if (_email.isEmpty()) {
                throw new Exception("Veuillez entrer une adresse courriel pour le joueur.");
            }
        } catch (Exception error) {
            System.out.println("Erreur : " + error.getMessage());
            System.exit(2);
        }

        this.nickname = _nickname;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.email = _email;
    }

    /**
     * 
     * @param _nickname
     */
    public Player setNickname(String _nickname){
        try {
            if (_nickname.isEmpty()) {
                throw new Exception("Veuillez entrer un surnom pour le joueur.");
            }
        } catch (Exception error) {
            System.out.println("Erreur : " + error.getMessage());
            System.exit(2);
        }
        
        this.nickname = _nickname;

        return this;
    }

    public String getNickname(){
        return this.nickname;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getEmail(){
        return this.email;
    }

    /**
     * 
     * @param _player
     */
    public Player setOpponent(Player _player){
        return null;
    }

    public Player getOpponent(){
        return null;
    }

    public Player removeOpponent(){
        return null;
    }

    public Card[] getHand(){
        return null;
    }

    public Player clearHand(){
        return null;
    }

    /**
     * 
     * @param _card
     */
    public Player addCard(Card _card){
        return null;
    }

    /**
     * 
     * @param _card
     */
    public Player removeCard(Card _card){
        return null;
    }
}