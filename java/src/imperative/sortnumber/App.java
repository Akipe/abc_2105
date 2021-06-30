package imperative.sortnumber;

import java.util.Scanner;

public class App {
    private static double   numberA = 0;
    private static double   numberB = 0;
    private static double   numberC = 0;
    private static Scanner  scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Exercice 1.7 : Trie de nombres.");

        /**
         * Algorithme
            FONCTIONS_UTILISEES
            VARIABLES
                numberA EST_DU_TYPE NOMBRE
                numberB EST_DU_TYPE NOMBRE
                numberC EST_DU_TYPE NOMBRE
                numberTemp EST_DU_TYPE NOMBRE
            DEBUT_ALGORITHME
                AFFICHER* "Rentrez le nombre A :"
                LIRE numberA
                AFFICHER* "Rentrez le nombre B :"
                LIRE numberB
                SI (numberA>numberB) ALORS
                    DEBUT_SI
                    numberTemp = numberA
                    numberA = numberB
                    numberB = numberTemp
                    FIN_SI
                AFFICHER "Liste des nombres (ordre croissant) : "
                AFFICHER numberB
                AFFICHER " < "
                AFFICHER* numberA
                
                AFFICHER* "Rentrez le nombre A :"
                LIRE numberA
                AFFICHER* "Rentrez le nombre B :"
                LIRE numberB
                AFFICHER* "Rentrez le nombre C :"
                LIRE numberC
                TANT_QUE (numberA>numberB OU numberB>numberC) FAIRE
                    DEBUT_TANT_QUE
                    SI (numberA>numberB) ALORS
                        DEBUT_SI
                        numberTemp PREND_LA_VALEUR numberA
                        numberA PREND_LA_VALEUR numberB
                        numberB PREND_LA_VALEUR numberTemp
                        FIN_SI
                    SI (numberB>numberC) ALORS
                        DEBUT_SI
                        numberTemp PREND_LA_VALEUR numberB
                        numberB PREND_LA_VALEUR numberC
                        numberC PREND_LA_VALEUR numberTemp
                        FIN_SI
                    FIN_TANT_QUE
                AFFICHER "Liste des nombres (ordre croissant) : "
                AFFICHER numberA
                AFFICHER " < "
                AFFICHER numberB
                AFFICHER " < "
                AFFICHER* numberC
            FIN_ALGORITHME
         */


        /**
         *  First part of the programm : sort 2 numbers
         */
        numberA = askUserNumber("Rentrez le nombre A :");
        numberB = askUserNumber("Rentrez le nombre B :");

        sortNumbersAandB();

        System.out.println(
            "Liste des nombres (ordre croissant) : " + numberA + " (A) < " + numberB + " (B)"
        );


        /**
         * Second part of the program : sort 3 numbers
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

    private static void sortNumbersAandB()
    {
        double tempStorage = 0;

        if (numberA > numberB) {
            tempStorage = numberA;
            numberA     = numberB;
            numberB     = tempStorage;
        }
    }

    private static void sortNumbersAandBandC()
    {
        double  tempStorage = 0;

        while (numberA > numberB || numberB > numberC) {
            if (numberA > numberB) {
                tempStorage = numberA;
                numberA     = numberB;
                numberB     = tempStorage;
            }
            if (numberB > numberC) {
                tempStorage = numberB;
                numberB     = numberC;
                numberC     = tempStorage;
            }
        }
    }
}
