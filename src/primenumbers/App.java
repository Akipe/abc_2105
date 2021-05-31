package primenumbers;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Exercice 1.6 : Déterminer si un nombre est premier.");

        /**
         * Algorithme
            FONCTIONS_UTILISEES
            VARIABLES
                numberToTest EST_DU_TYPE NOMBRE
                numberForCheckDivision EST_DU_TYPE NOMBRE
                isPrimeNumber EST_DU_TYPE NOMBRE
                listValidDiviser EST_DU_TYPE CHAINE
            DEBUT_ALGORITHME
                AFFICHER* "Veuillez entrer un nombre pour vérifier s'il est premier :"
                LIRE numberToTest
                numberForCheckDivision PREND_LA_VALEUR numberToTest-1
                isPrimeNumber PREND_LA_VALEUR 1
                TANT_QUE (numberForCheckDivision>1) FAIRE
                    DEBUT_TANT_QUE
                    SI (numberToTest%numberForCheckDivision==0) ALORS
                        DEBUT_SI
                        listValidDiviser PREND_LA_VALEUR listValidDiviser + " " + numberForCheckDivision
                        isPrimeNumber PREND_LA_VALEUR 1
                        FIN_SI
                    numberForCheckDivision PREND_LA_VALEUR numberForCheckDivision-1
                    FIN_TANT_QUE
                SI (isPrimeNumber==1) ALORS
                    DEBUT_SI
                    AFFICHER "Le nombre "
                    AFFICHER numberToTest
                    AFFICHER* " est un nombre premier."
                    FIN_SI
                    SINON
                        DEBUT_SINON
                        AFFICHER "Le nombre "
                        AFFICHER numberToTest
                        AFFICHER " n'est pas un nombre premier, il est divisable par :"
                        AFFICHER* listValidDiviser
                        FIN_SINON
            FIN_ALGORITHME
         */


        int     numberToTest            = 0,
                numberForCheckDivision  = 0;
        boolean isPrimeNumber           = true;
        String  listValidDiviser        = new String("");
        Scanner scanner                 = new Scanner(System.in);


        System.out.println("Veuillez entrer un nombre pour vérifier s'il est premier :");
        numberToTest = scanner.nextInt();
        scanner.close();

        // Verify by testing to divide all numbers from number himself-1 to 2,
        // If the number can be divided without rest, it is not a prime number.
        for (numberForCheckDivision = numberToTest - 1; numberForCheckDivision > 1; numberForCheckDivision--) {
            if ((numberToTest % numberForCheckDivision) == 0) {
                listValidDiviser = listValidDiviser + " " + numberForCheckDivision;
                isPrimeNumber = false;
            }
        }

        if (isPrimeNumber) {
            System.out.println("Le nombre " + numberToTest + " est un nombre premier.");
        } else {
            System.out.println("Le nombre " + numberToTest + " n'est pas un nombre premier, il est divisable par :" + listValidDiviser);
        }
    }
}
