package averageoneonetwo;

import java.util.Scanner;

public class App {
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

        int firstNumber             = 0;
        int secondNumber            = 0;
        float averageResult         = 0;
        boolean doRemakeCalculation = false;
        Scanner scanner             = new Scanner(System.in);

        do {
            System.out.println("Veuillez écrire votre premier nombre :");
            firstNumber = scanner.nextInt();

            System.out.println("Veuillez écrire votre deuxième nombre :");
            secondNumber = scanner.nextInt();

            averageResult = ((float)firstNumber + (float)secondNumber) / 2;

            System.out.println("La moyenne des deux nombres est égale à : " + averageResult);

            System.out.println("Voulez-vous faire un autre calcul ? (Oui=\"True\", Non=\"False\")");
            doRemakeCalculation = scanner.nextBoolean();
        } while (doRemakeCalculation);

        scanner.close();
    }
}
