// Ceci est un commentaire (non utile à l'app)

package imperative.helloworld; // C'est le namespace du composant

import java.util.Scanner; // Charger un composant, dans ce cas pour lire l'entrée de l'utilisateur

public class App { // C'est une classe ou un composant
    
    public static void main(String[] args) { // Methode de base pour chaque class
        
        /**
         * Déclaration des variables en premier
         */
        int variable_a;
        int variable_b;
        Scanner scanner; // Variable de type "Scanner"
        
        /**
         * Titre de l'exercice
        */
        System.out.println("Exercice Hello World!");

        /** 
         * Ecriture de l'algorithme
         * ...
        */

        /**
         * Programme
        */
        System.out.println("Hello Mulhouse!"); // Affiche du texte dans le terminal
        System.err.println("C'est une erreur :/");

        scanner = new Scanner(System.in); // Initialisation du scanner avec flux en entrée pour lire l'utilisateur
        System.out.println("Veuillez ");
        variable_a = scanner.nextInt();
        variable_b = scanner.nextInt();

        System.out.println("La variable variable_a vaut : " + variable_a + " et la variable_b vaut : " + variable_b);

        scanner.close(); // Ne PAS oublier de fermer le composant (risque de dépassement de mémoire)
    
    }
}
