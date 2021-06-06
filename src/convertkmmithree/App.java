package convertkmmithree;

import java.util.Scanner;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println("Exercice 2.1.3: Conversion kilomètres et Miles.");

        /**
         * 
         * Open the file exo_2.1.3_conversion_kilometres_miles.png
         * or exo_2.1.3_conversion_kilometres_miles.eap with Enterprise Architect 7.1
         */
        
        
        int         index                           = 0;
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
        double[]    tabDistanceToConvert            = new double[] { 0 };
        String[]    tabUnitDistanceToConvert        = new String[] { "" },
                    userCommandSplitSpace;


        System.out.println("Cette application vous permet de convertir plusieurs distances en kilomètres ou en miles dans les deux sens.");
        System.out.println("Une fois votre valeur saisie, vous pourrez définir d'autres distances à convertir, ou une des commandes listées ci-dessous.\n\n");

        System.out.println("Vous pouvez saisir une distance entre 0.01 et 1 000 000.");
        System.out.println("Pour convertir une distance, saisissez un nombre avec l'unité (\"km\" ou \"mi\") séparé par un espace.");
        System.out.println("Exemple : \"150 km\", \"40 mi\" ou \"5\" (km par défaut si aucune unité)");
        System.out.println("Pour afficher la conversion de toutes vos distances : \"go\"");
        System.out.println("Pour afficher l'aide : \"help\"");
        System.out.println("Pour quitter : \"quit\"\n");

        do {
            System.out.print("Veuillez entrer votre distance à convertir ou une des commandes :\n");
            userCommand = scanner.nextLine();

            // Checking all errors
            try {
                // Check if command is a distance with an unit,
                // so we split the command at space and verify that first word is a number
                // [0] -> distance; [1] -> unit
                userCommandSplitSpace = userCommand.split(" ");

                if (userCommandSplitSpace.length == 1) {
                    unitDistanceToConvert = "km";
                    isUserCommandIsDistance = true;
                } else if (userCommandSplitSpace.length == 2) {
                    unitDistanceToConvert = userCommandSplitSpace[1];
                    isUserCommandIsDistance = true;
                } else { // If user enter too much informations than necessary
                    isUserCommandHasError = true;
                    errorMessage = "Vous devez entrer un nombre à convertir, et optionnellement une unité (\"km\" ou \"mi\").";
                }

                // We check if it is a double with the try catch
                distanceToConvert = Double.parseDouble(userCommandSplitSpace[0]);

                // We check distance limit
                if (distanceToConvert < 0.01 || distanceToConvert > 1000000) {
                    isUserCommandHasError = true;
                    errorMessage = "Votre distance dépasse la limite autorisée (entre 0.01 et 1 000 000).";
                }

                // We check if unit is correct
                if (!(unitDistanceToConvert.equals("km") || unitDistanceToConvert.equals("mi"))) {
                    isUserCommandHasError = true;
                    errorMessage = "Votre unité est incorrecte, vous ne pouvez que mettre \"km\" ou \"mi\".";
                }
            } catch(NumberFormatException e) { // We check if user has enter a number, else we will try other commands
                isUserCommandIsDistance = false;
            }


            // if command is a distance, we store it to the list
            if (isUserCommandIsDistance && !isUserCommandHasError) {
                // We use list if it is the first distance,
                // but we need to recreate a new list
                if (tabDistanceToConvert.length == 1 && tabDistanceToConvert[0] == 0) {
                    tabDistanceToConvert[0]     = distanceToConvert;
                    tabUnitDistanceToConvert[0] = unitDistanceToConvert;
                } else {
                    // Recreate list of distance & unit with one more emplacement
                    // For distance
                    tabDistanceToConvert        = Arrays.copyOf(tabDistanceToConvert, tabDistanceToConvert.length + 1);
                    // For unit
                    tabUnitDistanceToConvert    = Arrays.copyOf(tabUnitDistanceToConvert, tabUnitDistanceToConvert.length + 1);

                    // Save distance & unit
                    tabDistanceToConvert[tabUnitDistanceToConvert.length - 1]     = distanceToConvert;
                    tabUnitDistanceToConvert[tabUnitDistanceToConvert.length - 1] = unitDistanceToConvert;
                }

            } else if (!isUserCommandHasError) { // else if this is not a number, we check others possibilities
                if (userCommand.equals("quit")) {
                    System.out.println("\nAu revoir :)");
                    isAppKeepRunning = false;
                } else if (userCommand.equals("help")) {
                    System.out.println("\nVous pouvez saisir une distance entre 0.01 et 1 000 000.");
                    System.out.println("Pour convertir une distance, saisissez un nombre avec l'unité (\"km\" ou \"mi\") séparé par un espace.");
                    System.out.println("Exemple : \"150 km\", \"40 mi\" ou \"5\" (km par défaut si aucune unité)");
                    System.out.println("Pour afficher la conversion de toutes vos distances : \"go\"");
                    System.out.println("Pour afficher l'aide : \"help\"");
                    System.out.println("Pour quitter : \"quit\"\n");
                } else if (userCommand.equals("go")) {
                    // Check if there are a distance to convert
                    if (tabDistanceToConvert.length == 1 && tabDistanceToConvert[0] == 0) {
                        isUserCommandHasError = true;
                        errorMessage = "Vous n'avez pas entré de distances à convertir.";
                    } else {
                        // Show all distances
                        System.out.println("\nVoici la liste des distances à convertir :");
                        for (index = 0; index < tabDistanceToConvert.length; index++) {
                            // Do convertion
                            if (tabUnitDistanceToConvert[index].equals("km")) {
                                distanceConverted = (1/1.609) * tabDistanceToConvert[index];
                                unitDistanceConverted = "mi";
                            } else if (tabUnitDistanceToConvert[index].equals("mi")) {
                                distanceConverted = 1.609 * tabDistanceToConvert[index];
                                unitDistanceConverted = "km";
                            }
                            System.out.println(index + ": " + tabDistanceToConvert[index] + " " + tabUnitDistanceToConvert[index] + " = " + distanceConverted + " " + unitDistanceConverted);
                        }
                        System.out.println("");

                        // No more need to show this distances
                        tabDistanceToConvert        = new double[] { 0 };
                        tabUnitDistanceToConvert    = new String[] { "" };
                    }
                } else {
                    isUserCommandHasError = true;
                    errorMessage = "Vous avez entré une commande inconnue (tapez \"help\" pour obtenir une aide).";
                }
            }

            if (isUserCommandHasError) {
                System.err.println("\nErreur : "+ errorMessage);
                System.err.println("Veuillez réessayer.\n");

                // Reset error for next iteration
                isUserCommandHasError = false;
                errorMessage          = "";
            }
        } while (isAppKeepRunning);

        scanner.close();
    }
}
