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


        String  sentence    = new String("");
        Scanner scanner     = new Scanner(System.in);


        System.out.println("Veuillez entrer une phrases se terminant par un point \".\" : ");
        sentence = scanner.nextLine();

        // We check if user has enter anything

        // We check if sentence terminate with point

        // We transform the sentence in array for seraching char

        // Ask user a letter to search it to the sentence

        // We check if user has enter anything
        // We check if user has enter a letter

        // Transform the letter to a char


        // If there is a point at the first char, show empty sentence


        // Else,
            // Iterate to all letters in sentence

                // If there is the letter in this index, increment result

            // If there is a result, show it and show how many

            // Else, show there is not result

        scanner.close();
    }
}
