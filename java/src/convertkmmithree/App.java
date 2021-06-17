package convertkmmithree;

import java.util.Scanner;
import java.util.Arrays;

public class App {
    private static String   listOfUnits     = new String("");
    private static String   listOfDistances = new String("");
    private static Scanner  scanner         = new Scanner(System.in);

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

                // We check if it is a distance (number) with the try catch
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


            if (!isUserCommandHasError) {
                // if command is a distance, we store it to the list
                if (isUserCommandIsDistance) {
                    // We check if this is the first time we use the list,
                    // otherside we need to recreate a new list to add the new distance
                    if (tabDistanceToConvert.length == 1 && tabDistanceToConvert[0] == 0) {
                        tabDistanceToConvert[0]     = distanceToConvert;
                        tabUnitDistanceToConvert[0] = unitDistanceToConvert;
                    } else {
                        // Recreate a list of distance & unit with one more index
                        // (for distance)
                        tabDistanceToConvert        = Arrays.copyOf(tabDistanceToConvert, tabDistanceToConvert.length + 1);
                        // (and for unit)
                        tabUnitDistanceToConvert    = Arrays.copyOf(tabUnitDistanceToConvert, tabUnitDistanceToConvert.length + 1);

                        // Save distance & unit
                        tabDistanceToConvert[tabUnitDistanceToConvert.length - 1]     = distanceToConvert;
                        tabUnitDistanceToConvert[tabUnitDistanceToConvert.length - 1] = unitDistanceToConvert;
                    }
                } else { // If this is not a number, we check others commands
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
                        // Check if there is a distance to convert
                        if (tabDistanceToConvert.length == 1 && tabDistanceToConvert[0] == 0) {
                            isUserCommandHasError = true;
                            errorMessage = "Vous n'avez pas entré de distances à convertir.";
                        } else {
                            // Show all distances and do the conversion
                            System.out.println("\nVoici la liste des distances à convertir :");
                            for (index = 0; index < tabDistanceToConvert.length; index++) {
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
    
                            // Empty the list of distance for next utilization
                            tabDistanceToConvert        = new double[] { 0 };
                            tabUnitDistanceToConvert    = new String[] { "" };
                        }
                    } else {
                        isUserCommandHasError = true;
                        errorMessage = "Vous avez entré une commande inconnue (tapez \"help\" pour obtenir une aide).";
                    }
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

    private static void askUserCommand()
    {
        String      userCommand;
        String      unitDistanceToConvert;
        Boolean     isUserCommandIsDistance;
        Boolean     isUserCommandHasError;
        String[]    userCommandSplitSpace;

        do {
            System.out.print("Veuillez entrer votre distance à convertir ou une des commandes :\n");
            userCommand = scanner.nextLine();

            try {
                // Check if command is a distance with an unit,
                // so we split the command at space and verify that first word is a number
                // [0] -> distance; [1] -> unit
                userCommandSplitSpace = userCommand.split(" ");

                if (userCommandSplitSpace.length == 0) {
                    throw new Exception("Veuillez entrer une commande.");
                } else if (userCommandSplitSpace.length == 1) {
                    // Check if is distance or command
                    if (isDistance(userCommand)) {
                        // Save distance in km if no unit specify
                        saveUserAskConversion(convertCommandToDistance(userCommandSplitSpace[0]), "km");
                    } else {
                        // Check string commands
                        if (userCommand.equals("quit")) {
                            terminateApp();
                        } else if (userCommand.equals("help")) {
                            showHelp();
                        } else if (userCommand.equals("go")) {
                            executeConversion();
                        } else {
                            throw new Exception("Vous avez entré une commande inconnue (tapez \"help\" pour obtenir une aide).");
                        }
                    }
                } else if (userCommandSplitSpace.length == 2) {
                    // Try convert first number
                    if (isDistance(userCommandSplitSpace[0]) && isUnitCompatible(userCommandSplitSpace[1])) {
                        // Save distance & unit
                        saveUserAskConversion(convertCommandToDistance(userCommandSplitSpace[0]), userCommandSplitSpace[1]);
                    }

                    if (!isDistance(userCommandSplitSpace[0])) {
                        throw new Exception("Vous n'avez pas entré de nombre pour convertir une distance.");
                    }

                    if (!isUnitCompatible(userCommandSplitSpace[1])) {
                        throw new Exception("Vous n'avez pas entré d'unités compatibles pour la conversion (km ou mi).");
                    }
                } else {
                    // Too many word in command
                }

                // We check if it is a distance (number) with the try catch
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
            } catch(Exception error) {

            }
        } while (true);
    }

    private static Boolean isDistance(String input)
    {
        try {
            convertCommandToDistance(input);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    private static Boolean isDistanceIsInLimiter(double distance)
    {
        return distance < 0.01 || distance > 1000000;
    }

    private static double convertCommandToDistance(String input)
    {
        return Double.parseDouble(input);
    }

    private static Boolean isUnitCompatible(String unit)
    {
        return unit.equalsIgnoreCase("km") || unit.equalsIgnoreCase("mi");
    }

    private static void terminateApp()
    {
        System.out.println("Merci d'avoir utilisé cette application. Bonne journée! :)");
        System.exit(0);
    }

    private static void showHelp()
    {
        System.out.println("\nVous pouvez saisir une distance entre 0.01 et 1 000 000.");
        System.out.println("Pour convertir une distance, saisissez un nombre avec l'unité (\"km\" ou \"mi\") séparé par un espace.");
        System.out.println("Exemple : \"150 km\", \"40 mi\" ou \"5\" (km par défaut si aucune unité)");
        System.out.println("Pour afficher la conversion de toutes vos distances : \"go\"");
        System.out.println("Pour afficher l'aide : \"help\"");
        System.out.println("Pour quitter : \"quit\"\n");
    }

    private static void executeConversion()
    {
        // ...
    }

    private static void saveUserAskConversion(double distance, String unit)
    {
        if (listOfDistances.length() == 0) {
            listOfDistances = String.valueOf(distance);
            listOfUnits     = unit;
        } else {
            listOfDistances = listOfDistances + " " + distance;
            listOfUnits     = listOfUnits + " " + unit;
        }
    }
}
