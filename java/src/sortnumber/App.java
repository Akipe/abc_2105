package sortnumber;

import java.util.Scanner;

public class App {
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
        
        int     numberA     = 0,
                numberB     = 0,
                numberC     = 0,
                numberTemp  = 0;
        Scanner scanner     = new Scanner(System.in);


        /**
         *  First part of the programm : sort 2 numbers
         */
        System.out.println("Rentrez le nombre A :");
        numberA = scanner.nextInt();

        System.out.println("Rentrez le nombre B :");
        numberB = scanner.nextInt();

        if (numberA > numberB) {
            numberTemp = numberA;
            numberA = numberB;
            numberB = numberTemp;
        }

        System.out.println(
            "Liste des nombres (ordre croissant) : " + numberA + " < " + numberB
        );


        /**
         * Second part of the program : sort 3 numbers
         */
        System.out.println("Rentrez le nombre A :");
        numberA = scanner.nextInt();

        System.out.println("Rentrez le nombre B :");
        numberB = scanner.nextInt();

        System.out.println("Rentrez le nombre C :");
        numberC = scanner.nextInt();

        while (numberA > numberB || numberB > numberC) {
            if (numberA > numberB) {
                numberTemp = numberA;
                numberA = numberB;
                numberB = numberTemp;
            }
            if (numberB > numberC) {
                numberTemp = numberB;
                numberB = numberC;
                numberC = numberTemp;
            }
        }

        System.out.println(
            "Liste des nombres (ordre croissant) : " + numberA + " < " + numberB + " < " + numberC
        );

        scanner.close();
    }
}
