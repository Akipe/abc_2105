package poo.animals.composants.animal.dog;

import java.util.Timer;
import poo.animals.composants.animal.Dog;

/**
 * @author Stagiaire
 * @version 1.0
 * @created 29-juin-2021 12:43:36
 */
public class Pinscher extends Dog {
    public final int WAIT_MILISECONDS_BEFORE_BARK = 10000;
    private Timer timer;

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
        timer = new Timer();
        timer.schedule(new PinscherBarkTask(), 0, WAIT_MILISECONDS_BEFORE_BARK);

        return this;
    }
}