package areacircularsector;

import java.util.Scanner;

public class App {
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
            LIRE sector_radius
            AFFICHER* "Voici l'air du secteur circulaire :"
            AFFICHERCALCUL Math.PI*sector_radius*2*sector_angle/360
        FIN_ALGORITHME
         */

        float sectorRadius  = 0;
        float sectorAngle   = 0;
        Scanner scanner     = new Scanner(System.in);

        System.out.println("Veuillez entrer le rayon de votre secteur circulaire :");
        sectorRadius = scanner.nextFloat();

        System.out.println("Veuillez entrer l'angle de votre secteur circulaire :");
        sectorAngle = scanner.nextFloat();

        System.out.println("Voici l'air du secteur circulaire :");
        System.out.println(
            (Math.PI * sectorRadius * 2 * sectorAngle / 360)
        );

        scanner.close();
    }
}
