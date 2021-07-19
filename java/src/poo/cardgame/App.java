package poo.cardgame;

import poo.cardgame.composants.Player;
import poo.cardgame.composants.card.CardClass;
import poo.cardgame.composants.card.Energy;

public class App {
    public static void main(String[] args) {
        Player joueur1, joueur2, joueur3;
        CardClass carteA, carteB, carteC, carteD;

        joueur1 = new Player("Jojo", "Julian", "Gérad", "joju@test.com");
        joueur2 = new Player("Fifi", "Fabienne", "Martin", "fima@test.com");
        joueur3 = new Player("Rara", "Robert", "Parkinson", "ropa@test.com");

        carteA = new CardClass("Le chevalier", 15, 10, 60, "Paladin", "C'est un grand sauveur", Energy.LIGHT);
        carteB = new CardClass("Grand sorcier", 20, 5, 50, "Mage", "Le plus grand des sorciers", Energy.FIRE);
        carteC = new CardClass("Merlin", 1, 15, 40, "Druid", "Un grand enchanteur", Energy.WILD);
        carteD = new CardClass("Le pirate", 5, 20, 90, "Espion", "Il navigue sur les flots", Energy.FROST);

        joueur1.addCard(carteA);
        joueur1.addCard(carteB);
        joueur1.addCard(carteC);

        for (int index = 0; index < joueur1.getHand().length; index++) {
            System.out.println("Carte " + index + ": " + joueur1.getHand()[index].getName());
        }

        joueur1.removeCard(carteB);

        for (int index = 0; index < joueur1.getHand().length; index++) {
            System.out.println("Carte " + index + ": " + joueur1.getHand()[index].getName());
        }

        joueur1.setOpponent(joueur2);

        joueur3.setOpponent(joueur2);

        System.out.println("Test");

    }
}
