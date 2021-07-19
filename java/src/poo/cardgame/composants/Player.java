package poo.cardgame.composants;

import java.util.Arrays;

import poo.cardgame.composants.card.CardClass;

/**
 * @author Stagiaire
 * @version 1.0
 * @created 15-juil.-2021 09:17:59
 */
public class Player {
    private String      nickname;
    private String      firstName;
    private String      lastName;
    private String      email;
    private CardClass[] cards;
    private Player      oppenent;


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
        this.cards      = new CardClass[0];
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

    public CardClass[] getHand(){
        return this.cards;
    }

    public Player clearHand(){
        this.cards = new CardClass[0];

        return this;
    }

    /**
     * 
     * @param _card
     */
    public Player addCard(CardClass _card){
        try {
            if (_card == null) {
                throw new Exception("Veuillez definir une carte à assigner au joueur.");
            }
        } catch (Exception error) {
            System.out.println("Erreur : " + error.getMessage());
            System.exit(2);
        }

        if (!this.isCardIsInHand(_card)) {
            this.cards = Arrays.copyOf(this.cards, this.cards.length + 1);
            this.cards[this.cards.length - 1] = _card;
        }

        return this;
    }

    /**
     * 
     * @param _card
     */
    public Player removeCard(CardClass _card){
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

        if (this.isCardIsInHand(_card)) {
            CardClass[] cardsWithRemovedCard = new CardClass[this.cards.length - 1];

            for (int indexAllCards = 0, indexWithoutCard = 0; indexAllCards < this.cards.length; ++indexAllCards) {

                if (this.cards[indexAllCards].equals(_card)) {
                    indexWithoutCard--;
                } else {
                    cardsWithRemovedCard[indexWithoutCard] = this.cards[indexAllCards];
                }
                indexWithoutCard++;
            }

            this.cards =  cardsWithRemovedCard;
        }

        return this;
    }

    private Boolean isCardIsInHand(CardClass _card)
    {
        for (int index = 0; index < this.cards.length; index++) {
            if (this.cards[index].equals(_card)) {
                return true;
            }
        }

        return false;
    }
}