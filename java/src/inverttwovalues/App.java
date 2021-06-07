package inverttwovalues;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        System.out.println("Exercice 1.4: Inversion de deux valeurs.");

        /**
         * Algorithme
         * 
        FONCTIONS_UTILISEES
        VARIABLES
            numberA EST_DU_TYPE NOMBRE
            numberB EST_DU_TYPE NOMBRE
            tempValueB EST_DU_TYPE NOMBRE
        DEBUT_ALGORITHME
            AFFICHER* "Veuillez entrer la valeur du premier nombre (A) :"
            LIRE numberA
            AFFICHER* "Veuillez entrer la valeur du deuxième nombre (B) :"
            LIRE numberB
            AFFICHER* "Le nombre A vaut actuellement :"
            AFFICHER* numberA
            AFFICHER* "Le nombre B vaut actuellement :"
            AFFICHER* numberB
            tempValueB PREND_LA_VALEUR numberB
            numberB PREND_LA_VALEUR numberA
            numberA PREND_LA_VALEUR tempValueB
            AFFICHER* "Le nombre A vaut maintenant :"
            AFFICHER* numberA
            AFFICHER* "Le nombre B vaut maintenant :"
            AFFICHER* numberB
        FIN_ALGORITHME
         */

        float   numberA     = 0,
                numberB     = 0,
                tempValueB  = 0;
        Scanner scanner     = new Scanner(System.in);
        

        System.out.println("Veuillez entrer la valeur du premier nombre (A) :");
        numberA = scanner.nextFloat();

        System.out.println("Veuillez entrer la valeur du deuxième nombre (B) :");
        numberB = scanner.nextFloat();

        System.out.println("Le nombre A vaut actuellement : " + numberA);
        System.out.println("Le nombre B vaut actuellement : " + numberB);

        tempValueB  = numberB;
        numberB     = numberA;
        numberA     = tempValueB;

        System.out.println("Le nombre A vaut maintenant : " + numberA);
        System.out.println("Le nombre B vaut maintenant : " + numberB);

        scanner.close();
    }
}
