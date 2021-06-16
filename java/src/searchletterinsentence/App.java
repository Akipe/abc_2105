package searchletterinsentence;

import java.util.Scanner;

public class App {
    private static Scanner scanner                  = new Scanner(System.in);
    private static String  userSentence             = new String("");
    private static char[]  tabCharOfUserSentence    = { '0' };

    public static void main(String[] args) {
        System.out.println("Exercice 3.2: Recherche une lettre dans une chaine de caractère.");

        /**
         * 
         * Open the file exo_3.2_recherche_lettre_chaine_caracteres.png
         * or exo_3.2_recherche_lettre_chaine_caracteres.eap with Enterprise Architect 7.1
         */

        char charToSearch = 'a';

        askUserSentence();
        charToSearch = askUserCharToSearch();
        searchInSentence(charToSearch);
    }

    private static void askUserSentence()
    {
        String userInput = "";

        do {
            try {
                System.out.println("Veuillez entrer une phrase se terminant par un point \".\" : ");
                userInput = scanner.nextLine();

                // We check if user has enter anything
                if (userInput.isEmpty()) {
                    throw new Exception("Erreur : Vous n'avez pas défini de phrases !");
                }

                // We check if sentence terminate with point
                if (isSentenceNotEndWithPoint(userInput)) {
                    throw new Exception("Erreur : Votre phrase ne se termine pas par un point !");
                }

                System.out.println("Votre phrase est correcte, passons à la recherche d'un caractère...\n");
                userSentence            = userInput;
                tabCharOfUserSentence   = userInput.toCharArray();

                return; // Exit the method
            } catch (Exception error) {
                System.err.println("Erreur : veuillez entrer une phrase qui se termine par un point.");
            }
        } while (true);
    }

    private static Boolean isSentenceNotEndWithPoint(String sentence)
    {
        char[] sentenceLetterTab = sentence.toCharArray();

        return (sentenceLetterTab[sentenceLetterTab.length - 1] != '.');
    }

    private static char askUserCharToSearch()
    {
        String userInput = "";

        do {
            try {
                // Ask user a letter to search it to the sentence
                System.out.println("Veuillez entrer une lettre à rechercher dans la phrase :");
                userInput = scanner.nextLine();

                // We check if user has enter anything
                if (userInput.isEmpty()) {
                    // There is no letters enter by user
                    throw new Exception("Erreur : Vous n'avez pas écrit de caractère !");
                }

                if (hasMoreThanOneLetter(userInput)) {
                    throw new Exception("Erreur : Vous avez entré trop de caractères, veuillez n'écrire qu'un seul caractère !");
                }

                return getFirstLetterFromSentence(userInput);
            } catch (Exception error) {
                System.err.println("Erreur : veuillez entrer une seul lettre.");
            }
        } while (true);
    }

    private static Boolean hasMoreThanOneLetter(String sentence)
    {
        return sentence.toCharArray().length != 1;
    }

    private static char getFirstLetterFromSentence(String sentence)
    {
        return sentence.toCharArray()[0];
    }

    private static void searchInSentence(char letter)
    {
        int howManyCharFind = 0;

        // If there is a point at the first char, show empty sentence
        if (hasOnlyOnePoint(tabCharOfUserSentence)) {
            System.out.println("La chaine est vide !");
        } else {
            howManyCharFind = searchHowManyFoundInTabLetters(letter);

            // If there is a result, show it and show how many
            if (howManyCharFind > 0) {
                System.out.println("La lettre \"" + letter + "\" apparait " + howManyCharFind + " fois dans la phrase \"" + userSentence + "\"");
            } else { // Else, show there is not result
                System.out.println("La lettre \"" + letter + "\" n'existe pas dans la phrase \"" + userSentence + "\"");
            }
        }
    }

    private static Boolean hasOnlyOnePoint(char[] tabOfLetters)
    {
        return tabOfLetters[0] == '.';
    }

    private static int searchHowManyFoundInTabLetters(char letterToSearch)
    {
        int index = 0,
            howManyOccurencesFound = 0;
        
        for (index = 0; index < tabCharOfUserSentence.length; index++) {
            // If there is the letter in this index, increment result
            if (isSameAsTabOfCharInPosition(letterToSearch, index)) {
                // We change letters find to uppercase, to be more easily find
                setLetterUpperCaseAtPosition(index);
                ++howManyOccurencesFound;
            }
        }

        if (howManyOccurencesFound >= 1) {
            executeHighlightOfLettersFound();
        }

        return howManyOccurencesFound;
    }

    private static Boolean isSameAsTabOfCharInPosition(char letter, int indexPositionOfLetterTab)
    {
        return Character.toLowerCase(tabCharOfUserSentence[indexPositionOfLetterTab]) == Character.toLowerCase(letter);
    }

    private static void setLetterUpperCaseAtPosition(int indexPositionOfLetterTab)
    {
        tabCharOfUserSentence[indexPositionOfLetterTab] = Character.toUpperCase(tabCharOfUserSentence[indexPositionOfLetterTab]);
    }

    private static void executeHighlightOfLettersFound()
    {
        userSentence = String.valueOf(tabCharOfUserSentence);
    }
}
