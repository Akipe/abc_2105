package primenumbers;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Exercice 1.6 : Déterminer si un nombre est premier.");

        /**
         * Algorithme
            FONCTIONS_UTILISEES
            VARIABLES
                numberToTestPrimeNumber EST_DU_TYPE NOMBRE
                numberForCheckPrimeNumber EST_DU_TYPE NOMBRE
                isPrimeNumber EST_DU_TYPE NOMBRE
                listDiviserFornumberToTestPrimeNumber EST_DU_TYPE CHAINE
            DEBUT_ALGORITHME
                AFFICHER* "Veuillez entrer un nombre pour vérifier s'il est premier :"
                LIRE numberToTestPrimeNumber
                numberForCheckPrimeNumber PREND_LA_VALEUR numberToTestPrimeNumber-1
                isPrimeNumber PREND_LA_VALEUR 1
                TANT_QUE (numberForCheckPrimeNumber>1) FAIRE
                    DEBUT_TANT_QUE
                    SI (numberToTestPrimeNumber%numberForCheckPrimeNumber==0) ALORS
                        DEBUT_SI
                        listDiviserFornumberToTestPrimeNumber PREND_LA_VALEUR listDiviserFornumberToTestPrimeNumber + " " + numberForCheckPrimeNumber
                        isPrimeNumber PREND_LA_VALEUR 1
                        FIN_SI
                    numberForCheckPrimeNumber PREND_LA_VALEUR numberForCheckPrimeNumber-1
                    FIN_TANT_QUE
                SI (isPrimeNumber==1) ALORS
                    DEBUT_SI
                    AFFICHER "Le nombre "
                    AFFICHER numberToTestPrimeNumber
                    AFFICHER* " est un nombre premier."
                    FIN_SI
                    SINON
                        DEBUT_SINON
                        AFFICHER "Le nombre "
                        AFFICHER numberToTestPrimeNumber
                        AFFICHER " n'est pas un nombre premier, il est divisable par :"
                        AFFICHER* listDiviserFornumberToTestPrimeNumber
                        FIN_SINON
            FIN_ALGORITHME
         */


        int     numberToTestPrimeNumber      = 0,
                numberForCheckPrimeNumber    = 0;
        boolean isPrimeNumber               = true;
        String  listDiviserFornumberToTestPrimeNumber = new String("");
        Scanner scanner                     = new Scanner(System.in);


        System.out.println("Veuillez entrer un nombre pour vérifier s'il est premier :");
        numberToTestPrimeNumber = scanner.nextInt();
        scanner.close();

        // Verify by testing to divide all numbers from number himself-1 to 2,
        // If the number can be divided without rest, it is not a prime number.
        for (numberForCheckPrimeNumber = numberToTestPrimeNumber - 1; numberForCheckPrimeNumber > 1; numberForCheckPrimeNumber--) {
            if ((numberToTestPrimeNumber % numberForCheckPrimeNumber) == 0) {
                listDiviserFornumberToTestPrimeNumber = listDiviserFornumberToTestPrimeNumber + " " + numberForCheckPrimeNumber;
                isPrimeNumber = false;
            }
        }

        if (isPrimeNumber) {
            System.out.println("Le nombre " + numberToTestPrimeNumber + " est un nombre premier.");
        } else {
            System.out.println("Le nombre " + numberToTestPrimeNumber + " n'est pas un nombre premier, il est divisable par :" + listDiviserFornumberToTestPrimeNumber);
        }
    }
}
