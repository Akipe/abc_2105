package poo.animals.composants.animal.dog;

import poo.animals.composants.animal.Dog;

/**
 * @author Stagiaire
 * @version 1.0
 * @created 29-juin-2021 12:43:36
 */
public class Pinscher extends Dog {
    public final int WAIT_MILISECONDS_BEFORE_BARK = 10000;
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
            System.out.println(this.getName() + " aboie : Woaf woaf !!!");
            setLastBarkTime(currentTimeMiliseconds);
        } else {
            System.out.println(this.getName() + " n'a pas envie d'aboyer...");
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