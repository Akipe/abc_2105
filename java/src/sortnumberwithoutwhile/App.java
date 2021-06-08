package sortnumberwithoutwhile;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Exercice 1.7 : Trie de nombres sans boucle.");

        /**
         * Algorithme
        
        For fun :)
         */
        
        
        int     numberA     = 0,
                numberB     = 0,
                numberC     = 0,
                numberTemp  = 0;
        Scanner scanner     = new Scanner(System.in);


        System.out.println("Rentrez le nombre A :");
        numberA = scanner.nextInt();

        System.out.println("Rentrez le nombre B :");
        numberB = scanner.nextInt();

        System.out.println("Rentrez le nombre C :");
        numberC = scanner.nextInt();

        // while (numberA > numberB || numberB > numberC) {
        //     if (numberA > numberB) {
        //         numberTemp = numberA;
        //         numberA = numberB;
        //         numberB = numberTemp;
        //     }
        //     if (numberB > numberC) {
        //         numberTemp = numberB;
        //         numberB = numberC;
        //         numberC = numberTemp;
        //     }
        // }

        if (numberA > numberB) {
            numberTemp = numberA;
            numberA = numberB;
            numberB = numberTemp;
        }

        if (numberA < numberB) {
            if (numberC < numberB) {
                numberTemp = numberC;
                numberC = numberB;
                numberB = numberTemp;

                if (numberB < numberA) {
                    numberTemp = numberB;
                    numberB = numberA;
                    numberA = numberTemp;
                }
            }
            if (numberC < numberA) {
                numberTemp = numberB;
                numberB = numberA;
                numberA = numberC;
                numberC = numberTemp;
            }
        }

        System.out.println(
            "Liste des nombres (ordre croissant) : " + numberA + " < " + numberB + " < " + numberC
        );

        scanner.close();
    }
}
