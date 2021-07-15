package poo.cardgame;

import poo.cardgame.composants.Card;
import poo.cardgame.composants.Player;

public class App {
    public static void main(String[] args) {
        Player joueur1, joueur2, joueur3;
        Card carteA, carteB, carteC, carteD;

        joueur1 = new Player("Jojo", "Julian", "Gérad", "joju@test.com");
        joueur2 = new Player("Fifi", "Fabienne", "Martin", "fima@test.com");
        joueur3 = new Player("Rara", "Robert", "Parkinson", "ropa@test.com");

        carteA = new Card("Carapuce", 15, 10, 60);
        carteB = new Card("Tortanque", 20, 5, 50);
        carteC = new Card("Bulbizare", 1, 15, 40);
        carteD = new Card("Salaméche", 5, 20, 90);

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

        System.out.println(carteB.getCardOwner());
    }
}
