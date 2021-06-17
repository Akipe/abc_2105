package convertkmmithree;

import java.util.Scanner;

public class App {
    private static String   listOfDistances = new String("");
    private static String   listOfUnits     = new String("");
    private static Scanner  scanner         = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Exercice 2.1.3: Conversion kilomètres et Miles.");

        /**
         * 
         * Open the file exo_2.1.3_conversion_kilometres_miles.png
         * or exo_2.1.3_conversion_kilometres_miles.eap with Enterprise Architect 7.1
         */

        System.out.println("Cette application vous permet de convertir plusieurs distances en kilomètres ou en miles dans les deux sens.");
        System.out.println("Une fois votre valeur saisie, vous pourrez définir d'autres distances à convertir, ou une des commandes listées ci-dessous.\n\n");

        showHelp();
        askUserCommand();
    }

    private static void askUserCommand()
    {
        String      userCommand;
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
                        saveUserAskConversion(convertToDistance(userCommandSplitSpace[0]), "km");
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
                        saveUserAskConversion(convertToDistance(userCommandSplitSpace[0]), userCommandSplitSpace[1]);
                    }

                    if (!isDistance(userCommandSplitSpace[0])) {
                        throw new Exception("Vous n'avez pas entré de nombre pour convertir une distance.");
                    }

                    if (!isUnitCompatible(userCommandSplitSpace[1])) {
                        throw new Exception("Vous n'avez pas entré d'unités compatibles pour la conversion (km ou mi).");
                    }
                } else {
                    // Too many word in command
                    throw new Exception("Commande incorrect, veuillez entrer une distance à convertir ou une commande prise en charge (saisissez \"help\" pour afficher l'aide).");
                }
            } catch(Exception error) {
                System.err.println("Erreur : " + error.getMessage());
            }
        } while (true);
    }

    private static Boolean isDistance(String input)
    {
        try {
            convertToDistance(input);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    private static double convertToDistance(String input)
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
        try {
            if (isThereIsDistanceToConvert()) {
                executeAndShowAllUserConversions();
            } else {
                throw new Exception("Vous n'avez pas entré de distances à convertir.");
            }
        } catch (Exception error) {
            System.err.println("Erreur : " + error.getMessage());
        }
    }

    private static void executeAndShowAllUserConversions()
    {
        int         distanceSelected;
        double      distanceToConvert;
        String[]    tabOfDistances;
        String[]    tabOfUnites;

        tabOfDistances  = listOfDistances.split(" ");
        tabOfUnites     = listOfUnits.split(" ");

        System.out.println("\nVoici la liste des distances à convertir :");

        for (distanceSelected = 0; distanceSelected < tabOfDistances.length; distanceSelected++) {
            distanceToConvert = convertToDistance(tabOfDistances[distanceSelected]);

            if (tabOfUnites[distanceSelected].equals("km")) {
                showConversionToMiles(distanceSelected, distanceToConvert);
            } else if (tabOfUnites[distanceSelected].equals("mi")) {
                showConversionToKilometers(distanceSelected, distanceToConvert);
            }
        }

        System.out.println("");

        // Empty the list of distance for next utilization
        listOfDistances = "";
        listOfUnits = "";
    }

    private static double convertToMiles(double kilometers)
    {
        return (1/1.609) * kilometers;
    }

    private static double convertToKilometers(double miles)
    {
        return 1.609 * miles;
    }

    private static void showConversionToMiles(int whichDistanceNumber, double distanceKilometers)
    {
        showResultDistanceConverted(whichDistanceNumber, distanceKilometers, "km", convertToMiles(distanceKilometers), "mi");
    }

    private static void showConversionToKilometers(int whichDistanceNumber, double distanceMiles)
    {
        showResultDistanceConverted(whichDistanceNumber, distanceMiles, "mi", convertToKilometers(distanceMiles), "km");
    }

    private static void showResultDistanceConverted(int whichDistanceNumber, double originalDistance, String originalUnit, double convertedDistance, String convertedUnit)
    {
        System.out.println(whichDistanceNumber + ": " + originalDistance + " " + originalUnit + " = " + convertedDistance + " " + convertedUnit);
    }

    private static void saveUserAskConversion(double distance, String unit)
    {
        try {
            if (isDistanceDoesntExceedLimit(distance)) {
                if (listOfDistances.length() == 0) {
                    listOfDistances = String.valueOf(distance);
                    listOfUnits     = unit;
                } else {
                    listOfDistances = listOfDistances + " " + distance;
                    listOfUnits     = listOfUnits + " " + unit;
                }
                System.out.println("Distance enregistré...");
            } else {
                throw new Exception("Votre distance est en dehors de la limite autorisé (entre 0.01 et 1000000).");
            }
        } catch (Exception error) {
            System.err.print("Erreur : " + error.getMessage());
        }
    }

    private static Boolean isDistanceDoesntExceedLimit(double distance)
    {
        return distance > 0.01 && distance < 1000000;
    }

    private static Boolean isThereIsDistanceToConvert()
    {
        return listOfDistances.length() > 0;
    }
}
