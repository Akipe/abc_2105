 package average;

import java.util.Scanner;

public class App {
    
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

        int firstNumber         = 0;
        int secondNumber        = 0;
        Boolean isInputHasError = true;
        String  userInput       = "";
        Scanner scanner         = new Scanner(System.in);
        

        // Use boolean because number can be 0 or negative, so we can't test that in condition
        do {
            try {
                System.out.println("Veuillez écrire votre premier nombre :");
                userInput = scanner.nextLine();

                firstNumber = Integer.parseInt(userInput);
                isInputHasError = false;

            } catch(Exception error) {
                System.err.println("Erreur : Veuillez entrer un nombre entier.");
                isInputHasError = true;
            }

            scanner.reset();
        } while (isInputHasError);

        do {
            try {
                System.out.println("Veuillez écrire votre deuxième nombre :");
                userInput = scanner.nextLine();

                secondNumber = Integer.parseInt(userInput);
                isInputHasError = false;

            } catch(Exception error) {
                System.err.println("Erreur : Veuillez entrer un nombre entier.");
                isInputHasError = true;
            }

            scanner.reset();
        } while (isInputHasError);
        
        System.out.println("La moyenne des deux nombres est égale à : " + (((float)firstNumber + (float)secondNumber) / 2));

        scanner.close();
    }
}
