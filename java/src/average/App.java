 package average;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Exercice 1.1.1 : Calcul de la moyenne de deux nombres");
        
        /**
         * Algorithme
         * 
         * FONCTIONS_UTILISEES
         * VARIABLES
         *     premierNombre EST_DU_TYPE NOMBRE
         *     deuxiemeNombre EST_DU_TYPE NOMBRE
         * DEBUT_ALGORITHME
         *     AFFICHER* "Bienvenu dans l'app pour calculer la moyenne de deux nombres"
         *     AFFICHER* "Veuillez écrire votre premier nombre :"
         *     LIRE premierNombre
         *     AFFICHER* "Veuillez écrire votre deuxième nombre :"
         *     LIRE deuxiemeNombre
         *     AFFICHERCALCUL (premierNombre+deuxiemeNombre)/2
         * FIN_ALGORITHME
         * 
        */

        int firstNumber     = 0;
        int secondNumber    = 0;

        firstNumber     = askUserNumber("Veuillez écrire votre premier nombre :");
        secondNumber    = askUserNumber("Veuillez écrire votre deuxième nombre :");
    
        System.out.println("La moyenne des deux nombres est égale à : " + numberAverage(firstNumber, secondNumber));
    }

    private static int askUserNumber(String askMessage)
    {
        int     number              = 0;
        String  userInput           = "";

        do {
            try {
                System.out.println(askMessage);
                userInput   = scanner.nextLine();
                number      = Integer.parseInt(userInput);

                return number;
            } catch(Exception error) {
                System.err.println("Erreur : Veuillez entrer un nombre entier.");
            }
        } while (true);
    }

    private static float numberAverage(int firstNumber, int secondNumber)
    {
        return ((float)firstNumber + (float)secondNumber) / 2;
    }
}
