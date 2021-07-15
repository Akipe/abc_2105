package poo.cardgame.composants;

import java.util.Arrays;

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
    private Card[]  cards;
    private Player  oppenent;


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
            } else if (_email.isEmpty()) {
                throw new Exception("Veuillez entrer un email pour le joueur.");
            } else if (_firstName.isEmpty()) {
                throw new Exception("Veuillez entrer un prénom pour le joueur.");
            } else if (_lastName.isEmpty()) {
                throw new Exception("Veuillez entrer un nom pour le joueur.");
            }
        } catch (Exception error) {
            System.out.println("Erreur : " + error.getMessage());
            System.exit(2);
        }

        this.nickname   = _nickname;
        this.email      = _email;
        this.firstName  = _firstName;
        this.lastName   = _lastName;
        this.cards      = new Card[0];
        this.oppenent   = null;
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

    /**
     * 
     * @param _email
     */
    public Player setEmail(String _email){
        try {
            if (_email.isEmpty()) {
                throw new Exception("Veuillez entrer un email pour le joueur.");
            }
        } catch (Exception error) {
            System.out.println("Erreur : " + error.getMessage());
            System.exit(2);
        }
        
        this.email = _email;

        return this;
    }

    public String getEmail(){
        return this.email;
    }

    /**
     * 
     * @param _player
     */
    public Player setOpponent(Player _player){
        this.oppenent = _player;

        // if (this.oppenent.getOpponent() != null) {
        //     if (! this.oppenent.getOpponent().equals(this)) {
        //         System.out.println("Objet pas égale");
        //     } else {
        //         System.out.println("Objet égale");
        //     }
        // }

        // If the other player has already an other opponent,
        // we need to ensure to remove them
        if (this.oppenent.getOpponent() != null) {
            if (! this.oppenent.getOpponent().equals(this)) {
                this.oppenent.removeOpponent();
                this.oppenent.setOpponent(this);
            }
        } else {
            this.oppenent.setOpponent(this);
        }

        return this;
    }

    public Player getOpponent(){
        return this.oppenent;
    }

    public Player removeOpponent(){
        this.oppenent.removeOnlyOneOpponent();
        this.oppenent = null;
        
        return this;
    }

    private void removeOnlyOneOpponent(){
        this.oppenent = null;
    }

    public Card[] getHand(){
        return this.cards;
    }

    public Player clearHand(){
        this.cards = new Card[0];

        return this;
    }

    /**
     * 
     * @param _card
     */
    public Player addCard(Card _card){
        try {
            if (_card == null) {
                throw new Exception("Veuillez definir une carte à assigner au joueur.");
            }
        } catch (Exception error) {
            System.out.println("Erreur : " + error.getMessage());
            System.exit(2);
        }

        for (int index = 0; index < this.cards.length; index++) {
            if (this.cards[index].equals(_card)) {
                this.cards = Arrays.copyOf(this.cards, this.cards.length + 1);
                this.cards[this.cards.length - 1] = _card;
                _card.addCardOwner(this);
                index = this.cards.length - 1; // Stop for
            }
        }

        return this;
    }

    /**
     * 
     * @param _card
     */
    public Player removeCard(Card _card){
        Boolean isCardIsOwn = false;

        try {
            if (this.cards.length == 0) {
                throw new Exception("Aucune cartes n'est associé à ce joueur.");
            } else if (_card == null) {
                throw new Exception("Veuillez définir une carte à supprimer de la main du joueur.");
            }
        } catch (Exception error) {
            System.out.println("Erreur : " + error.getMessage());
            System.exit(2);
        }

        for (int index = 0; index < this.cards.length; index++) {
            if (this.cards[index].equals(_card)) {
                isCardIsOwn = true;
            }
        }

        if (isCardIsOwn) {
            Card[] arrayWithRemoveCard = new Card[this.cards.length - 1];

            for (int indexOldTab = 0, indexNewTab = 0; indexOldTab < this.cards.length; ++indexOldTab) {

                if (this.cards[indexOldTab].equals(_card)) {
                    indexNewTab--;
                } else {
                    arrayWithRemoveCard[indexNewTab] = this.cards[indexOldTab];
                }
                indexNewTab++;
            }

            this.cards =  arrayWithRemoveCard;
            _card.removeCardOwner(this);
        }

        return this;
    }
}