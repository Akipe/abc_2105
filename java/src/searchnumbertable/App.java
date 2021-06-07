package searchnumbertable;

import java.util.Scanner;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println("Exercice 3.1: Recherche un nombre dans un tableau.");

        /**
         * 
         * Open the file exo_3.1_recherche_nombre_tableau.png
         * or exo_3.1_recherche_nombre_tableau.eap with Enterprise Architect 7.1
         */

         int        numberToFindInList      = 0,
                    numberToSaveToList      = 0;
         Boolean    userWantAddNumbersToTheList = true;
         String     userCommand             = new String("");
         Scanner    scanner                 = new Scanner(System.in);
         int[]      numberListForSearch     = { 0 };
         String[]   listOfNumberToAddToListSeperate;

        do {
            System.out.println("Veuillez entrer un nombre à ajouter dans la liste, ou \"quit\" pour arréter :");
            userCommand = scanner.nextLine();

            switch (userCommand) {
                case "quit":
                    userWantAddNumbersToTheList = false;
                    break;
                case "clear":
                    userWantAddNumbersToTheList = false;
                    break;
                default:
                    try {
                        numberToSaveToList = Integer.parseInt(userCommand);
                        
                        // Check if the number is bigger than the previous
                        if (numberListForSearch[numberListForSearch.length - 1] <= numberToSaveToList) {
                            if (!(numberListForSearch.length == 1 && numberListForSearch[0] == 0)) { // Check if we have data to the list
                                numberListForSearch = Arrays.copyOf(numberListForSearch, numberListForSearch.length + 1);
                            }

                            numberListForSearch[numberListForSearch.length - 1] = numberToSaveToList;
                        } else {
                            // number is tiny
                        }
                        
                    } catch(NumberFormatException e) { // We check if user has enter a number
                        // error
                    }
            }
        } while (userWantAddNumbersToTheList);
        
        //listOfNumberToAddToListSeperate = userCommand.split(" ");

        // Check if there 2 data or more in the list
        //if ()

        // Check if all data are numbers

        // Check if all number are crescent
    }
}
