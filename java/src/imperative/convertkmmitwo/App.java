package imperative.convertkmmitwo;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Exerice 2.1.2: Conversion kilomètres et Miles.");

        /**
         * 
         * Open the file exo_2.1.2_conversion_kilometres_miles.png
         * or exo_2.1.2_conversion_kilometres_miles.eap with Enterprise Architect 7.1
         */

        
        double      distanceToConvert               = 0,
                    distanceConverted               = 0;
        Boolean     isUserCommandIsDistance         = false,
                    isUserCommandHasError           = false,
                    isAppKeepRunning                = true;
        String      userCommand                     = new String(""),
                    unitDistanceToConvert           = new String(""),
                    unitDistanceConverted           = new String(""),
                    errorMessage                    = new String("");
        Scanner     scanner                         = new Scanner(System.in);
        String[]    userCommandSplitSpace;


        System.out.println("Cette Application vous permets de convertir des kilomètres et des miles dans les deux sens.");
        System.out.println("Vous ne pouvez convertir que des distances comprises entre 0.01 et 1 000 000.)");
        System.out.println("Une fois votre valeur convertie, vous pourrez convertir d'autres valeurs.");
        System.out.println("Pour quitter, écrivez \"q\" pour votre commande.\n");


        do {
            System.out.println("Veuillez entrer une distance (entre 0.01 et 1 000 000),");
            System.out.println("avec l'unité (km ou mi) séparé par un espace (ex: \"150 km\" ou \"10 mi\"),");
            System.out.println("ou \"q\" pour quitter :");
            userCommand = scanner.nextLine();

            // Check if command is a distance with an unit,
            // so we split the command at space and verify that first word is a number
            // [0] -> distance; [1] -> unit
            try {
                userCommandSplitSpace = userCommand.split(" ");
                distanceToConvert = Double.parseDouble(userCommandSplitSpace[0]);

                if (userCommandSplitSpace.length == 2) {
                    unitDistanceToConvert = userCommandSplitSpace[1];
                }
                
                // If user enter too much informations than necessary
                if (userCommandSplitSpace.length > 2) {
                    isUserCommandHasError = true;
                    errorMessage = "vous devez entrer un nombre à convertir, et optionnelement une unité (\"km\" ou \"mi\").";
                } else {
                    isUserCommandIsDistance = true;
                }
            } catch(NumberFormatException e) {
                isUserCommandIsDistance = false;
            }


            // if command is a number, so we can try to convert it to miles
            if (isUserCommandIsDistance) {

                // If no unit is defined, set to kilometers
                if (unitDistanceToConvert.isEmpty()) {
                    unitDistanceToConvert = "km";
                }

                // Check the distance limit
                if (distanceToConvert >= 0.01 && distanceToConvert <= 1000000) {
                    // Process in function of unit
                    if (unitDistanceToConvert.equals("km")) {
                        distanceConverted = convertKilometersToMiles(distanceToConvert);
                        unitDistanceConverted = "mi";
                    } else if (unitDistanceToConvert.equals("mi")) {
                        distanceConverted = convertMilesToKilometers(distanceToConvert);
                        unitDistanceConverted = "km";
                    } else {
                        isUserCommandHasError = true;
                        errorMessage = "Votre unité est incorrecte, vous ne pouvez que mettre \"km\" ou \"mi\".";
                    }

                    // Show result of conversion
                    if (unitDistanceToConvert.equals("km") || unitDistanceToConvert.equals("mi")) {
                        showDistanceConverted(distanceToConvert, unitDistanceToConvert, distanceConverted, unitDistanceConverted);
                    }
                    
                } else {
                    isUserCommandHasError = true;
                    errorMessage = "Votre distance dépasse la limite autorisée (entre 0.01 et 1 000 000).";
                }

            } else { // else if this is not a number, we check others possibilities

                if (userCommand.equals("q")) {
                    System.out.println("Merci d'avoir utiliser le logiciel, à bientôt !");
                    isAppKeepRunning = false;
                } else {
                    isUserCommandHasError = true;
                    errorMessage = "Vous n'avez ni entré une distance, ni une commande correcte.";
                }
            }

            if (isUserCommandHasError) {
                System.err.println("Votre commande est incorrecte :");
                System.err.println(errorMessage + "\n");

                // Reset error for next iteration
                isUserCommandHasError = false;
                errorMessage          = "";
            }
        } while (isAppKeepRunning);

        scanner.close();
    }

    private static double convertKilometersToMiles(double kilometers)
    {
        return ((1/1.609) * kilometers);
    }

    private static double convertMilesToKilometers(double miles)
    {
        return (1.609 * miles);
    }

    private static void showDistanceConverted(
        double distanceToConvert,
        String unitDistanceToConvert,
        double distanceConverted,
        String unitDistanceConverted
    )
    {
        System.out.println(
            "La distance " + distanceToConvert + " " + unitDistanceToConvert + " = " + distanceConverted + " " + unitDistanceConverted + "\n"
        );
    }
}
