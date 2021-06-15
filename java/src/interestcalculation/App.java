package interestcalculation;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

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

        int     numberYearsPlacementN   = 0;
        double  initialSumS             = 0,
                interestOfferedI        = 0;


        initialSumS             = askUserNumberDouble("Veuillez entrer la somme initial sur votre compte en banque :");
        interestOfferedI        = askUserNumberDouble("Veuillez entrer l'intérêt offert par la banque :");
        numberYearsPlacementN   = askUserNumberYears();

        System.out.println(
            "Voici le résultat suite à l'intérêt simple : " + calculSimpleInterest(initialSumS, interestOfferedI, numberYearsPlacementN)
        );
        System.out.println(
            "Voici le résultat suite à l'intérêt composé : " + calculationCompoundInterest(initialSumS, interestOfferedI, numberYearsPlacementN)
        );
    }

    private static double askUserNumberDouble(String askMessage)
    {
        String userInput    = "";
        double number       = 0;

        do {
            try {
                System.out.println(askMessage);
                userInput = scanner.nextLine();
                number = Double.parseDouble(userInput);

                if (number <= 0) {
                    throw new Exception("Erreur: veuillez entrer un nombre positif supérieur à 0.");
                }

                return number;
            } catch (Exception error) {
                System.err.println("Erreur : veuillez entrer un nombre positif supérieur à 0.");
            }
        } while (true);
    }

    private static int askUserNumberYears()
    {
        String  userInput   = "";
        int     years       = 0;

        do {
            try {
                System.out.println("Veuillez entrer le nombre d'années pendant lequel vous laissez fructifier votre argent :");
                userInput = scanner.nextLine();
                years = Integer.parseInt(userInput);

                if (years <= 0) {
                    throw new Exception("Erreur : veuillez entrer un nombre d'années positif et supérieur à 0.");
                }

                return years;
            } catch (Exception error) {
                System.err.println("Erreur : veuillez entrer au moin 1 année ou plus.");
            }
        } while (true);
    }

    private static double calculSimpleInterest(double initialSumS, double interestOfferedI, int numberYearsPlacementN)
    {
        return (initialSumS * (1 + (double)numberYearsPlacementN * (interestOfferedI/100)));
    }

    private static double calculationCompoundInterest(double initialSumS, double interestOfferedI, int numberYearsPlacementN)
    {
        return (initialSumS * (Math.pow((1 + (interestOfferedI / 100)), (double)numberYearsPlacementN)));
    }
}
