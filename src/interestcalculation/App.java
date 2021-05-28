package interestcalculation;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Exercice 1.5 : Calcul d'intérêts.");

        /**
         * Algorithme
         * 
        FONCTIONS_UTILISEES
        VARIABLES
            initialSumS EST_DU_TYPE NOMBRE
            interestOfferedI EST_DU_TYPE NOMBRE
            numberYearsPlacementN EST_DU_TYPE NOMBRE
            simpleInterest EST_DU_TYPE NOMBRE
            compoundInterest EST_DU_TYPE NOMBRE
        DEBUT_ALGORITHME
            AFFICHER* "Veuillez entrer la somme initial sur votre compte en banque :"
            LIRE initialSumS
            AFFICHER* "Veuillez entrer l'intérêt offert par la banque :"
            LIRE interestOfferedI
            AFFICHER* "Veuillez entrer le nombre d'années pendant lequel vous laissez fructifier votre argent :"
            LIRE numberYearsPlacementN
            simpleInterest PREND_LA_VALEUR initialSumS*(1+numberYearsPlacementN*(interestOfferedI/100))
            compoundInterest PREND_LA_VALEUR initialSumS*(pow((1+(interestOfferedI/100)),numberYearsPlacementN))
            AFFICHER "Voici le résultat suite à l'intérêt simple : "
            AFFICHER* simpleInterest
            AFFICHER "Voici le résultat suite à l'intérêt composé : "
            AFFICHER* compoundInterest
        FIN_ALGORITHME
         */

        double  initialSumS             = 0,
                interestOfferedI        = 0,
                numberYearsPlacementN   = 0,
                simpleInterest          = 0,
                compoundInterest        = 0;
        Scanner scanner                 = new Scanner(System.in);


        System.out.println("Veuillez entrer la somme initial sur votre compte en banque :");
        initialSumS = scanner.nextFloat();

        System.out.println("Veuillez entrer l'intérêt offert par la banque :");
        interestOfferedI = scanner.nextFloat();

        System.out.println("Veuillez entrer le nombre d'années pendant lequel vous laissez fructifier votre argent :");
        numberYearsPlacementN = scanner.nextFloat();

        // Calculation of simple interest (interestOfferedI/100 because it is a pourcent)
        simpleInterest      = initialSumS * (1 + numberYearsPlacementN * (interestOfferedI/100));

        // Calculation of compound interest
        compoundInterest    = initialSumS * (Math.pow((1 + (interestOfferedI / 100)), numberYearsPlacementN));

        System.out.println("Voici le résultat suite à l'intérêt simple : " + simpleInterest);
        System.out.println("Voici le résultat suite à l'intérêt composé : " + compoundInterest);

        scanner.close();
    }
}
