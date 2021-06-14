package volumeareasphere;

import java.util.Scanner;

public class App {
    
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
    
        int     circleRadius    = 0;
        String  userInput       = "";
        Scanner scanner         = new Scanner(System.in);
    
        do {
            try {
                System.out.println("Veuillez rentrer le rayon de votre sphère :");
                userInput = scanner.nextLine();

                circleRadius = Integer.parseInt(userInput);

                if (circleRadius <= 0) {
                    throw new Exception("Le rayon doit être un nombre positif supérieur à 0.");
                }

            } catch(Exception error) {
                System.err.println("Erreur : veuillez n'entrer qu'un nombre positif au dessus de 0.");
                scanner.reset();
            }
        } while (circleRadius <= 0);

        System.out.println("Voici l'air de la sphère :");
        System.out.println(
            (4 * Math.PI * Math.pow((float)circleRadius, 2)) + " m²"
        );

        System.out.println("Voici le volume de la sphère :");
        System.out.println(
            ((4 * Math.PI * Math.pow((float)circleRadius, 3)) / 3) + " m3"
        );

        scanner.close();
    }
}
