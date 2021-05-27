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
                AFFICHERCALCUL* 4*Math.PI*circle_radius*2
                AFFICHER* "Voici le volume de la sphère :"
                AFFICHERCALCUL* 4/3*Math.PI*circle_radius*3
            FIN_ALGORITHME
         */
    
        int circleRadius    = 0;
        Scanner scanner     = new Scanner(System.in);
    
        System.out.println("Veuillez rentrer le rayon de votre sphère :");
        circleRadius = scanner.nextInt();

        System.out.println("Voici l'air de la sphère :");
        System.out.println(
            (4 * Math.PI * (float)circleRadius * 2)
        );

        System.out.println("Voici le volume de la sphère :");
        System.out.println(
            (4 / 3 * Math.PI * circleRadius * 3)
        );

        scanner.close();
    }
}
