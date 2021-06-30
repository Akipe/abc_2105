package imperative.primenumbers;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

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
                        isPrimeNumber PREND_LA_VALEUR 0
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


        int     numberToTest        = 0;
        String  listValidDiviser    = new String("");

        numberToTest = askUserNumber("Veuillez entrer un nombre pour vérifier s'il est premier :");

        listValidDiviser = returnDiviserToNumber(numberToTest);

        if (listValidDiviser.isEmpty()) {
            System.out.println("Le nombre " + numberToTest + " est un nombre premier.");
        } else {
            System.out.println("Le nombre " + numberToTest + " n'est pas un nombre premier, il est divisable par :" + listValidDiviser);
        }
    }

    private static int askUserNumber(String askMessage)
    {
        int     number = 0;
        String  userInput = "";

        do {
            try {
                System.out.println(askMessage);
                userInput = scanner.nextLine();
                number = Integer.parseInt(userInput);

                if (number <= 1) {
                    throw new Exception("Erreur : veuillez entrer un nombre supérieur à 1.");
                }

                return number;
            } catch (Exception error) {
                System.err.println("Erreur : veuillez entrer un nombre entier supérieur à 1.");
            }
        } while (true);
    }

    private static String returnDiviserToNumber(int numberToTest)
    {
        int     numberForCheckDivision = 0;
        String  listValidDiviser = "";

        for (numberForCheckDivision = numberToTest - 1; numberForCheckDivision > 1; numberForCheckDivision--) {
            if ((numberToTest % numberForCheckDivision) == 0) {
                listValidDiviser = listValidDiviser + " " + numberForCheckDivision;
            }
        }

        return listValidDiviser;
    }
}
