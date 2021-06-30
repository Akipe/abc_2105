package imperative.areacircularsector;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Exercice 1.3 : Calcul de la surface d'un secteur circulaire.");

        /**
         * Algorithme
         * 
        FONCTIONS_UTILISEES
        VARIABLES
            sector_radius EST_DU_TYPE NOMBRE
            sector_angle EST_DU_TYPE NOMBRE
        DEBUT_ALGORITHME
            AFFICHER* "Veuillez entrer le rayon de votre secteur circulaire :"
            LIRE sector_radius
            AFFICHER* "Veuillez entrer l'angle de votre secteur circulaire :"
            LIRE sector_angle
            AFFICHER* "Voici l'air du secteur circulaire :"
            AFFICHERCALCUL Math.PI*pow(sector_radius,2)*sector_angle/360
        FIN_ALGORITHME
         */

        double sectorRadius  = 0;
        double sectorAngle   = 0;

        sectorRadius = askUserNumberNotZeroOrNegative("Veuillez entrer le rayon de votre secteur circulaire : ");
        sectorAngle = askUserNumberNotZeroOrNegative("Veuillez entrer l'angle de votre secteur circulaire : ");

        System.out.println("Voici l'air du secteur circulaire : " + calculAreaCircularSector(sectorRadius, sectorAngle));
    }

    private static double calculAreaCircularSector(double radius, double angle)
    {
        return (Math.PI * Math.pow(radius, 2) * angle / 360);
    }

    private static double askUserNumberNotZeroOrNegative(String askMessage)
    {
        double number       = 0;
        String userInput    = "";

        do {
            try {
                System.out.println(askMessage);
                userInput = scanner.nextLine();

                number = Double.parseDouble(userInput);

                if (number <= 0) {
                    throw new Exception("Erreur : Veuillez entrer un nombre positif supérieur à 0.");
                }

                return number;
            } catch (Exception error) {
                System.err.println("Erreur : Veuillez entrer un nombre, positif et supérieur à 0.");
            }
        } while (true);
    }
}
