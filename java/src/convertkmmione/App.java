package convertkmmione;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Exerice 2.1.1: Conversion kilomètres et Miles.");
    
        /**
         * Algorithme
         * 
         * Open the file exo_2.1.1_conversion_kilometres_miles.png
         * or exo_2.1.1_conversion_kilometres_miles.eap with Enterprise Architect 7.1
         */

        
        double  kmToConvert             = 0,
                distanceMiles           = 0;
        Boolean isUserCommandIsNumber   = false,
                isAppKeepRunning        = true;
        String  userCommand             = new String("");
        Scanner scanner                 = new Scanner(System.in);
        
        System.out.println("Cette Application vous permets de convertir des kilomètres en miles.");
        System.out.println("Vous ne pouvez convertir que des distances comprises entre 0.01 et 1 000 000.)");
        System.out.println("Une fois votre valeur convertie, vous pourrez convertir d'autres valeurs.");
        System.out.println("Pour quitter, écrivez \"q\" pour votre commande.\n");

        do {
            System.out.println("Veuillez entrer une distance (entre 0.01 et 1 000 000) ou \"q\" pour quitter :");
            userCommand = scanner.nextLine();

            // Check if command is a number
            try {
                kmToConvert = Double.parseDouble(userCommand);
                isUserCommandIsNumber = true;
            } catch(NumberFormatException e) {
                isUserCommandIsNumber = false;
            }

            // if command is a number, so we can try to convert it to miles
            if (isUserCommandIsNumber) {
                System.out.println("Your distance in km is :" + kmToConvert);
                if (isDistanceIsWithinLimit(kmToConvert)) {
                    distanceMiles = convertKilometersToMiles(kmToConvert);
                    
                    System.out.println("La distance " + kmToConvert + " km = " + distanceMiles + " miles");
                } else {
                    System.out.println("Votre distance dépasse la limite autorisée (entre 0.01 et 1 000 000).");
                }
            } else { // else if this is not a number, we check if this is a correct command
                if (userCommand.equals("q")) {
                    System.out.println("Merci d'avoir utiliser le logiciel, à bientôt !");
                    isAppKeepRunning = false;
                } else {
                    System.out.println("Commande incorrecte :/ veuillez réessayer.");
                }
            }
        } while (isAppKeepRunning);

        scanner.close();
    }

    private static Boolean isDistanceIsWithinLimit(double distance)
    {
        return (distance >= 0.01 && distance <= 1000000);
    }

    private static double convertKilometersToMiles(double kilometers)
    {
        return ((1/1.609) * kilometers);
    }
}
