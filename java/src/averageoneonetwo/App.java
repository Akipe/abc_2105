package averageoneonetwo;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Exercice 1.1.2 : Calcul de la moyenne de deux nombres avec boucle.");

        /**
         * Algorithme
         * 
            FONCTIONS_UTILISEES
            VARIABLES
                premierNombre EST_DU_TYPE NOMBRE
                deuxiemeNombre EST_DU_TYPE NOMBRE
                refaireCalculs EST_DU_TYPE NOMBRE
            DEBUT_ALGORITHME
                refaireCalculs PREND_LA_VALEUR 1
                TANT_QUE (refaireCalculs) FAIRE
                    DEBUT_TANT_QUE
                    AFFICHER* "Veuillez écrire votre premier nombre :"
                    LIRE premierNombre
                    AFFICHER* "Veuillez écrire votre deuxième nombre :"
                    LIRE deuxiemeNombre
                    AFFICHER* "Résulat :"
                    AFFICHERCALCUL* (premierNombre+deuxiemeNombre)/2
                    AFFICHER "Voulez-vous faire un autre calcul ? (Oui=1/Non=0)"
                    LIRE refaireCalculs
                    FIN_TANT_QUE
            FIN_ALGORITHME
         */

        int     firstNumber         = 0,
                secondNumber        = 0;
        Boolean doRemakeCalculation = false;

        do {
            firstNumber     = askUserNumber("Veuillez écrire votre premier nombre :");
            secondNumber    = askUserNumber("Veuillez écrire votre deuxième nombre :");

            System.out.println("La moyenne des deux nombres est égale à : " + numberAverage(firstNumber, secondNumber));

            doRemakeCalculation = askUserRemakeCalculation();
        } while (doRemakeCalculation);
    }

    private static int askUserNumber(String askMessage)
    {
        int     number      = 0;
        String  userInput   = "";

        do {
            try {
                System.out.println(askMessage);
                userInput   = scanner.nextLine();
                number      = Integer.parseInt(userInput);

                return number;
            } catch(Exception error) {
                System.err.println("Erreur : Veuillez entrer un nombre entier.");
            }
        } while(true);
    }

    private static float numberAverage(int firstNumber, int secondNumber)
    {
        return ((float)firstNumber + (float)secondNumber) / 2;
    }

    private static Boolean askUserRemakeCalculation()
    {
        String userInput = "";

        do {
            try {
                System.out.println("Voulez-vous faire un autre calcul ? (\"oui\" ou \"non\")");
                userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("oui")) {
                    return true;
                } else if (userInput.equalsIgnoreCase("non")) {
                    return false;
                } else {
                    throw new Exception("Erreur : Veuillez écrire \"oui\" ou \"non\".");
                }
            } catch(Exception error) {
                System.err.println("Erreur: Veuillez entrer uniquement \"oui\" ou \"non\".");
            }
        } while(true);
    }
}
