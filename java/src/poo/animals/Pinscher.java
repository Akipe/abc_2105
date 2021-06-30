package poo.animals;

/**
 * @author Stagiaire
 * @version 1.0
 * @created 29-juin-2021 12:43:36
 */
public class Pinscher extends Dog {
    public static final int WAIT_MILISECONDS_BEFORE_BARK = 10000;
    private long lastBarkTimeMiliseconds;

    /**
     * 
     * @param _name
     */
    public Pinscher(String _name)
    {
        super(_name);
    }

    public Dog bark()
    {
        long currentTimeMiliseconds = getCurrentTime();

        if (hasWaitEnoughBeforeBark(currentTimeMiliseconds)) {
            System.out.println("Woaf woaf !!!");
            setLastBarkTime(currentTimeMiliseconds);
        } else {
            System.out.println("...");
        }

        return this;
    }

    private Boolean hasWaitEnoughBeforeBark(long _currentTimeMiliseconds)
    { 
        return ((_currentTimeMiliseconds - this.lastBarkTimeMiliseconds) >= (long) WAIT_MILISECONDS_BEFORE_BARK);
    }

    private void setLastBarkTime(long _currentTimeMiliseconds)
    {
        this.lastBarkTimeMiliseconds = _currentTimeMiliseconds;
    }

    private long getCurrentTime()
    {
        return System.currentTimeMillis();
    }
}