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

         int        numberToFindInList          = 0,
                    numberToSaveToList          = 0,
                    index                       = 0;
         Boolean    userWantAddNumbersToTheList = true,
                    userWantSearchNumber        = true,
                    isNumberFind                = false;
         String     userCommand                 = new String("");
         Scanner    scanner                     = new Scanner(System.in);
         int[]      numberListForSearch         = { 0 };
         String[]   listOfNumberToAddToListSeperate;

        do {
            System.out.println("Veuillez entrer un nombre à ajouter dans la liste,");
            System.out.println("Ou \"clear\" pour supprimer les nombres sauvegardé, \"show\" pour les afficher, \"search\" pour passer à la recherche :");
            userCommand = scanner.nextLine();

            switch (userCommand) {
                case "search":
                    userWantAddNumbersToTheList = false;
                    //System.out.println("Au revoir :)");
                    break;
                case "clear":
                    numberListForSearch = new int[] { 0 };
                    System.out.println("Suppression des nombres sauvegardés...");
                    break;
                case "show":
                    System.out.println("Voici l'ensemble des nombres de votre liste :");
                    for (index = 0; index < numberListForSearch.length; index++) {
                        System.out.println("Nombre n°" + (index + 1) + ": " + numberListForSearch[index]);
                    }
                    break;
                default:
                    try {
                        numberToSaveToList = Integer.parseInt(userCommand);
                        
                        // Check if the number is bigger than the previous (for crescent numbers)
                        if (numberListForSearch[numberListForSearch.length - 1] <= numberToSaveToList) {
                            if (!(numberListForSearch.length == 1 && numberListForSearch[0] == 0)) { // Check if we have a not empty list
                                numberListForSearch = Arrays.copyOf(numberListForSearch, numberListForSearch.length + 1);
                            }

                            numberListForSearch[numberListForSearch.length - 1] = numberToSaveToList;
                        } else {
                            System.err.println("Erreur : Veuillez entrer un nombre égale ou plus grand que " + numberListForSearch[numberListForSearch.length - 1]);
                        }
                        
                    } catch(NumberFormatException e) { // We check if user has enter a number
                        System.err.println("Erreur : Veuillez entrer uniquement un nombre, sans espace ni d'autres caractères.");
                    }
            }
        } while (userWantAddNumbersToTheList);
        
        do {
            System.out.println("Entrez un nombre à rechercher dans le tableau,");
            System.out.println("Ou \"quit\" pour arréter l'application.");
            userCommand = scanner.nextLine();

            switch (userCommand) {
                case "quit":
                    userWantSearchNumber = false;
                    System.out.println("Au revoir :)");
                    break;
                default:
                    try {
                        numberToFindInList = Integer.parseInt(userCommand);

                        // Iteration of tab
                        if (numberListForSearch[numberListForSearch.length - 1] >= numberToFindInList) {
                            for (index = 0; numberToFindInList > numberListForSearch[index] || index < numberListForSearch.length - 1; index++) {
                                if (numberToFindInList == numberListForSearch[index]) {
                                    isNumberFind = true; // On a trouvé le nombre !!!
                                }
                            }

                            if (isNumberFind) {
                                System.out.println("Le nombre recherché est bien dans la liste !");
                                
                                // Reinitialize for next search
                                isNumberFind = false;
                            } else {
                                System.out.println("Le nombre recherché n'est pas dans la liste, dommage.");
                            }
                        } else {
                            System.out.println("Votre nombre est trop grand par rapport au dernier nombre croissant du tableau.");
                        }
                        
                    } catch (NumberFormatException e) { // We check if user has enter a number
                        System.err.println("Erreur : Veuillez entrer uniquement un nombre.");
                    }
            }
        } while (userWantSearchNumber);
    }
}