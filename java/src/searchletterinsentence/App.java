package searchletterinsentence;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Exercice 3.2: Recherche une lettre dans une chaine de caractère.");

        /**
         * 
         * Open the file exo_3.2_recherche_lettre_chaine_caracteres.png
         * or exo_3.2_recherche_lettre_chaine_caracteres.eap with Enterprise Architect 7.1
         */


        int     index                   = 0,
                howManyCharFind         = 0;
        char    charToSearch            = 'a';
        Boolean isUserHasCorrectInput   = false;
        String  sentence                = new String(""),
                charToSearchInString    = new String("");
        Scanner scanner                 = new Scanner(System.in);
        char[]  tabCharOfSentence       = { '0' },
                tabCharToSearch         = { '0' };


        // We get the sentence
        System.out.println("Veuillez entrer une phrases se terminant par un point \".\" : ");
        sentence = scanner.nextLine();

        // We check if user has enter anything
        if (sentence.isEmpty()) {
            System.err.println("Erreur : Vous n'avez pas défini de phrases !");

            isUserHasCorrectInput = false;
        } else {
            // We transform the sentence in array for searching char
            tabCharOfSentence = sentence.toCharArray();

            // We check if sentence terminate with point
            if (tabCharOfSentence[tabCharOfSentence.length - 1] == '.') {
                System.out.println("Votre phrase est correcte, passons à la recherche d'un caractère...\n");
                
                isUserHasCorrectInput = true;
            } else {
                System.err.println("Erreur : Votre phrase ne se termine pas par un point !");

                isUserHasCorrectInput = false;
            }
        }

        // We get the char
        if (isUserHasCorrectInput) {
            // Ask user a letter to search it to the sentence
            System.out.println("Veuillez entrer une lettre à rechercher dans la phrase :");
            charToSearchInString = scanner.nextLine();

            // We check if user has enter anything
            if (!charToSearchInString.isEmpty()) {
                tabCharToSearch = charToSearchInString.toCharArray();

                // We check if user has only enter one char
                if (tabCharToSearch.length == 1) {
                    // Transform the letter to a char
                    charToSearch = Character.toLowerCase(tabCharToSearch[0]);

                    isUserHasCorrectInput = true;
                } else {
                    // There is too many letters enter by user (only one is needed)
                    System.err.println("Erreur : Vous avez entrer trop de caractères, veuillez n'écrire qu'un seul caractère !");

                    isUserHasCorrectInput = false;
                }
            } else {
                // There is no letters enter by user
                System.err.println("Erreur : Vous n'avez pas écrit de caractère !");

                isUserHasCorrectInput = false;
            }
        }

        scanner.close();

        // We search the char in the sentence
        if (isUserHasCorrectInput) {
            howManyCharFind = 0;

            // If there is a point at the first char, show empty sentence
            if (tabCharOfSentence[0] == '.') {
                System.out.println("La chaine est vide !");
            } else {
                // Iterate to all letters in sentence
                for (index = 0; index < tabCharOfSentence.length; index++) {
                    // If there is the letter in this index, increment result
                    if (Character.toLowerCase(tabCharOfSentence[index]) == charToSearch) {
                        // We change letters find to uppercase, to be more easily find
                        tabCharOfSentence[index] = Character.toUpperCase(tabCharOfSentence[index]);
                        ++howManyCharFind;
                    }
                }

                if (howManyCharFind >= 1) {
                    // We change all letters finds to uppercase
                    sentence = String.valueOf(tabCharOfSentence);
                }
    
                // If there is a result, show it and show how many
                if (howManyCharFind > 0) {
                    System.out.println("La lettre \"" + charToSearch + "\" apparait " + howManyCharFind + " fois dans la phrase \"" + sentence + "\"");
                } else { // Else, show there is not result
                    System.out.println("La lettre \"" + charToSearch + "\" n'existe pas dans la phrase \"" + sentence + "\"");
                }
            }
        }
    }
}
