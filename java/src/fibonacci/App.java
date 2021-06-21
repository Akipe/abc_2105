package fibonacci;

public class App {
    private static long allCurrentRabbitCouple;
    private static long adultsRabbitsCouple;
    private static long newTotalRabbitsCouple;

    public static void main(String[] args) {
        for (int howManyIterator = 1; howManyIterator < 20; howManyIterator++) {
            calcFibonacci(howManyIterator);
            showResult(howManyIterator);
        }
    }

    private static void calcFibonacci(int howManyMonth)
    {
        allCurrentRabbitCouple  = 1;
        adultsRabbitsCouple     = 0;
        newTotalRabbitsCouple   = 0;

        for (int month = 1; month < howManyMonth; month++) {
            newTotalRabbitsCouple   = allCurrentRabbitCouple + adultsRabbitsCouple;
            adultsRabbitsCouple     = allCurrentRabbitCouple;
            allCurrentRabbitCouple  = newTotalRabbitsCouple;
        }
    }

    private static void showResult(int howManyMonth)
    {
        System.out.println(howManyMonth + ": Le nombre total de lapin : " + allCurrentRabbitCouple);
    }
}
