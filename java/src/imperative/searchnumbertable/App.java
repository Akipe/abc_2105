package imperative.searchnumbertable;

import java.util.Scanner;
import java.util.Arrays;

public class App {
    private static Scanner  scanner                 = new Scanner(System.in);
    private static int[]    listOfCrescentNumbers   = { 0 };

    public static void main(String[] args) {
        System.out.println("Exercice 3.1: Recherche un nombre dans un tableau.");

        /**
         * 
         * Open the file exo_3.1_recherche_nombre_tableau.png
         * or exo_3.1_recherche_nombre_tableau.eap with Enterprise Architect 7.1
         */

        askUserToPrepareCrescentNumberList();
        askUserToSearchNumberInCrescentNumberListOrExit();
    }

    private static void askUserToPrepareCrescentNumberList()
    {
        String  userCommand                 = "";
        Boolean userWantAddNumbersToTheList = true;

        do {
            System.out.println("Veuillez entrer un nombre à ajouter dans la liste,");
            System.out.println("Ou \"clear\" pour supprimer les nombres sauvegardé, \"show\" pour les afficher, \"search\" pour passer à la recherche :");
            userCommand = scanner.nextLine();

            switch (userCommand) {
                case "search":
                    userWantAddNumbersToTheList = false;
                    System.out.println("");
                    break;
                case "clear":
                    clearListOfCrescentNumbers();
                    break;
                case "show":
                    showListCrescentNumbersSave();
                    break;
                default:
                    askUserAddCrescentNumberToList(userCommand);
            }
        } while (userWantAddNumbersToTheList);
    }

    private static void clearListOfCrescentNumbers()
    {
        listOfCrescentNumbers = new int[] { 0 };
        System.out.println("Suppression des nombres sauvegardés...\n");
    }

    private static void showListCrescentNumbersSave()
    {
        int index = 0;

        System.out.println("\nVoici l'ensemble des nombres de votre liste :");

        for (index = 0; index < listOfCrescentNumbers.length; index++) {
            System.out.println("Nombre n°" + (index + 1) + ": " + listOfCrescentNumbers[index]);
        }
        System.out.println("");
    }

    private static void askUserAddCrescentNumberToList(String userCommand)
    {
        int numberToAddToList = 0;

        try {
            numberToAddToList = Integer.parseInt(userCommand);
            
            if (isSameOrBiggerThanLastNumberCrescentList(numberToAddToList)) {
                if (isCrescentListIsNotEmpty()) {
                    createBiggerCrescentList();
                }

                addNumberCrescentList(numberToAddToList);

                System.out.println("");
            } else {
                System.err.println("Erreur : Veuillez entrer un nombre égale ou plus grand que " + listOfCrescentNumbers[listOfCrescentNumbers.length - 1] + "\n");
            }
            
        } catch(NumberFormatException e) { // We check if user has enter a number
            System.err.println("Erreur : Veuillez entrer uniquement un nombre, sans espace ni d'autres caractères.\n");
        }
    }

    private static Boolean isSameOrBiggerThanLastNumberCrescentList(int numberToAddToList)
    {
        return listOfCrescentNumbers[listOfCrescentNumbers.length - 1] <= numberToAddToList;
    }
    
    private static Boolean isCrescentListIsNotEmpty()
    {
        return !(listOfCrescentNumbers.length == 1 && listOfCrescentNumbers[0] == 0);
    }

    private static void createBiggerCrescentList()
    {
        listOfCrescentNumbers = Arrays.copyOf(listOfCrescentNumbers, listOfCrescentNumbers.length + 1);
    }

    private static void addNumberCrescentList(int numberToAddToList)
    {
        listOfCrescentNumbers[listOfCrescentNumbers.length - 1] = numberToAddToList;
    }

    private static void askUserToSearchNumberInCrescentNumberListOrExit()
    {
        String userCommand = new String("");

        do {
            System.out.println("Entrez un nombre à rechercher dans le tableau,");
            System.out.println("Ou \"quit\" pour arréter l'application :");
            userCommand = scanner.nextLine();

            switch (userCommand) {
                case "quit":
                    System.out.println("Au revoir :)\n");
                    System.exit(0); // Terminate the app
                    break;
                default:
                    tryToFindNumberInCrescentNumberList(userCommand);
            }
        } while (true);
    }

    private static void tryToFindNumberInCrescentNumberList(String userCommand)
    {
        int numberUsedToSearchInList = 0;

        try {
            numberUsedToSearchInList = Integer.parseInt(userCommand);

            // Iteration of tab
            if (isSmallerThanLastCrescentNumberList(numberUsedToSearchInList)) {
                if (isNumberFindInCrescentNumberList(numberUsedToSearchInList)) {
                    System.out.println("Le nombre recherché est bien dans la liste !\n");
                } else {
                    System.out.println("Le nombre recherché n'est pas dans la liste, dommage.\n");
                }
            } else {
                System.out.println("Votre nombre est trop grand par rapport au dernier nombre croissant du tableau.\n");
            }
            
        } catch (NumberFormatException e) { // We check if user has enter a number
            System.err.println("Erreur : Veuillez entrer uniquement un nombre ou \"quit\".\n");
        }
    }

    private static Boolean isSmallerThanLastCrescentNumberList(int number)
    {
        return listOfCrescentNumbers[listOfCrescentNumbers.length - 1] >= number;
    }

    private static Boolean isNumberFindInCrescentNumberList(int number)
    {
        int index = 0;

        for (index = 0; index < listOfCrescentNumbers.length; index++) {
            if (number == listOfCrescentNumbers[index]) {
                return true; // We find the number
            }
        }

        return false;
    }
}