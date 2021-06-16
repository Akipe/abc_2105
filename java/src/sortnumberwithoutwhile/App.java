package sortnumberwithoutwhile;

import java.util.Scanner;

public class App {
    private static double   numberA = 0;
    private static double   numberB = 0;
    private static double   numberC = 0;
    private static Scanner  scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Exercice 1.7 : Trie de nombres sans boucle.");

        /**
         * Algorithme
        
        For fun :)
         */

        numberA = askUserNumber("Rentrez le nombre A :");
        numberB = askUserNumber("Rentrez le nombre B :");
        numberC = askUserNumber("Rentrez le nombre C :");

        sortNumbersAandBandC();

        System.out.println(
            "Liste des nombres (ordre croissant) : " + numberA + " (A) < " + numberB + " (B) < " + numberC + " (C)"
        );
    }

    private static double askUserNumber(String askMessage)
    {
        String userInput = "";

        do {
            try {
                System.out.println(askMessage);
                userInput = scanner.nextLine();
                return Double.parseDouble(userInput);
            } catch (Exception error) {
                System.out.println("Erreur : veuillez entrer un nombre.");
            }
        } while (true);
    }

    private static void sortNumbersAandBandC()
    {
        double  tempStorage = 0;

        if (numberA > numberB) {
            tempStorage = numberA;
            numberA     = numberB;
            numberB     = tempStorage;
        }

        if (numberA < numberB) {
            if (numberC < numberB) {
                tempStorage = numberC;
                numberC     = numberB;
                numberB     = tempStorage;

                if (numberB < numberA) {
                    tempStorage = numberB;
                    numberB     = numberA;
                    numberA     = tempStorage;
                }
            }
            if (numberC < numberA) {
                tempStorage = numberB;
                numberB     = numberA;
                numberA     = numberC;
                numberC     = tempStorage;
            }
        }
    }
}
