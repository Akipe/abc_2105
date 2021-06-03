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
        boolean isUserCommandIsNumber   = false,
                exitApp                 = false;
        String  userCommand             = new String("");
        Scanner scanner                 = new Scanner(System.in);
        

        do {
            System.out.println("Veuillez entrer une distance en kilomètres à convertir en miles :");
            System.out.println("(vous ne pouvez convertir que des distances comprises entre 0.01 et 1 000 000.)");
            System.out.println("Une fois votre valeur convertie, vous pourrez convertir d'autres valeurs.");
            System.out.println("Pour quitter, écrivez \"q\" pour votre commande.");
            userCommand = scanner.nextLine();

            // Check if command is a number
            try {
                kmToConvert = Double.parseDouble(userCommand);
                isUserCommandIsNumber = true;
                System.out.println("This is a number");
            } catch(NumberFormatException e) {
                isUserCommandIsNumber = false; 
                System.out.println("This is not a number");
            }

            // if command is a number, so we can try to convert it to miles
            if (isUserCommandIsNumber) {
                System.out.println("Your distance in km is :" + kmToConvert);
                if (kmToConvert >= 0.01 && kmToConvert <= 1000000) {
                    distanceMiles = (1/1.609) * kmToConvert;
                    System.out.println("La distance " + kmToConvert + " km = " + distanceMiles + " miles");
                } else {
                    System.out.println("Votre distance dépasse la limite autorisé (entre 0.01 et 1 000 000).");
                }
            } else { // else if this is not a number, we check if this is a correct command
                if (userCommand.equals("q")) {
                    System.out.println("You want to quit");
                    exitApp = true;
                } else {
                    System.out.println("Don't know what you want");
                    System.out.println("Your command is : " + userCommand);
                }
            }
        } while (!exitApp);

        scanner.close();
    }
}
