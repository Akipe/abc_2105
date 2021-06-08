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

         int        numberToAddToList           = 0,
                    numberUsedToSearchInList    = 0,
                    index                       = 0;
         Boolean    userWantAddNumbersToTheList = true,
                    userWantSearchNumber        = true,
                    isNumberFindInList          = false;
         String     userCommand                 = new String("");
         Scanner    scanner                     = new Scanner(System.in);
         int[]      listOfCrescentNumbers       = { 0 };

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
                    listOfCrescentNumbers = new int[] { 0 };
                    System.out.println("Suppression des nombres sauvegardés...\n");
                    break;
                case "show":
                    System.out.println("\nVoici l'ensemble des nombres de votre liste :");
                    for (index = 0; index < listOfCrescentNumbers.length; index++) {
                        System.out.println("Nombre n°" + (index + 1) + ": " + listOfCrescentNumbers[index]);
                    }
                    System.out.println("");
                    break;
                default:
                    try {
                        numberToAddToList = Integer.parseInt(userCommand);
                        
                        // Check if the number is bigger than the previous (for crescent numbers)
                        if (listOfCrescentNumbers[listOfCrescentNumbers.length - 1] <= numberToAddToList) {
                            if (!(listOfCrescentNumbers.length == 1 && listOfCrescentNumbers[0] == 0)) { // Check if we have a not empty list
                                listOfCrescentNumbers = Arrays.copyOf(listOfCrescentNumbers, listOfCrescentNumbers.length + 1);
                            }

                            listOfCrescentNumbers[listOfCrescentNumbers.length - 1] = numberToAddToList;

                            System.out.println("");
                        } else {
                            System.err.println("Erreur : Veuillez entrer un nombre égale ou plus grand que " + listOfCrescentNumbers[listOfCrescentNumbers.length - 1] + "\n");
                        }
                        
                    } catch(NumberFormatException e) { // We check if user has enter a number
                        System.err.println("Erreur : Veuillez entrer uniquement un nombre, sans espace ni d'autres caractères.\n");
                    }
            }
        } while (userWantAddNumbersToTheList);
        
        do {
            System.out.println("Entrez un nombre à rechercher dans le tableau,");
            System.out.println("Ou \"quit\" pour arréter l'application :");
            userCommand = scanner.nextLine();

            switch (userCommand) {
                case "quit":
                    userWantSearchNumber = false;
                    System.out.println("Au revoir :)\n");
                    break;
                default:
                    try {
                        numberUsedToSearchInList = Integer.parseInt(userCommand);

                        // Iteration of tab
                        if (listOfCrescentNumbers[listOfCrescentNumbers.length - 1] >= numberUsedToSearchInList) {
                            for (index = 0; numberUsedToSearchInList > listOfCrescentNumbers[index] || index < listOfCrescentNumbers.length - 1; index++) {
                                if (numberUsedToSearchInList == listOfCrescentNumbers[index]) {
                                    isNumberFindInList = true; // On a trouvé le nombre !!!
                                }
                            }

                            if (isNumberFindInList) {
                                System.out.println("Le nombre recherché est bien dans la liste !\n");
                                
                                // Reinitialize for next search
                                isNumberFindInList = false;
                            } else {
                                System.out.println("Le nombre recherché n'est pas dans la liste, dommage.\n");
                            }
                        } else {
                            System.out.println("Votre nombre est trop grand par rapport au dernier nombre croissant du tableau.\n");
                        }
                        
                    } catch (NumberFormatException e) { // We check if user has enter a number
                        System.err.println("Erreur : Veuillez entrer uniquement un nombre.\n");
                    }
            }
        } while (userWantSearchNumber);

        scanner.close();
    }
}