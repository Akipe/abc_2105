package imperative.volumeareasphere;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Exercice 1.2 : Calcul d'un volume d'une sphere.");

        /**
         * Algorithme
         * 
            FONCTIONS_UTILISEES
            VARIABLES
                circle_radius EST_DU_TYPE NOMBRE
            DEBUT_ALGORITHME
                AFFICHER* "Veuillez rentrer le rayon de votre sphère :"
                LIRE circle_radius
                AFFICHER* "Voici l'air de la sphère :"
                AFFICHERCALCUL* 4*Math.PI*pow(circle_radius,2)
                AFFICHER* "Voici le volume de la sphère :"
                AFFICHERCALCUL* (4*Math.PI*pow(circle_radius,3))/3
            FIN_ALGORITHME
         */
    
        double  circleRadius    = 0;


        circleRadius = askUserCircleRadius();

        System.out.println("Voici l'air de la sphère : " + sphereAir(circleRadius) + " m²");
        System.out.println("Voici le volume de la sphère :" + sphereVolume(circleRadius) + " m3");
    }

    private static double askUserCircleRadius()
    {
        double circleRadius = 0;
        String userInput    = "";

        do {
            try {
                System.out.println("Veuillez rentrer le rayon de votre sphère :");
                userInput = scanner.nextLine();

                circleRadius = Double.parseDouble(userInput);

                if (circleRadius <= 0) {
                    throw new Exception("Le rayon doit être un nombre positif supérieur à 0.");
                }

                return circleRadius;

            } catch(Exception error) {
                System.err.println("Erreur : veuillez n'entrer qu'un nombre positif au dessus de 0.");
            }
        } while (true);
    }

    private static double sphereAir(double circleRadius)
    {
        return (4 * Math.PI * Math.pow(circleRadius, 2));
    }

    private static double sphereVolume(double circleRadius)
    {
        return ((4 * Math.PI * Math.pow(circleRadius, 3)) / 3);
    }
}
