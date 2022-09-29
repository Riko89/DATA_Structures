
/**
 * Clock Class is a Data container class for Clocks
 * contains methods getClock incrementClock decrementClock and setClock
 * instance variable clock 
 * 
 * @author Eric Davey 
 * @version Final 4/06/2018
 */
public class Clock
{
    private int clock;

    /**
     * Constructor for class Clock
     * takes in an int time and assigns it to clock
     * @param implicit argument time assigns it to clock
     */
    public Clock(int time)
    {
        clock = time;
    }

    /**
     * method setClock takes in a variable int time and assigns it to clock
     * @param implicit arguemnet time assigned to clock
     * 
     */
    public void setClock(int time)
    {
        clock = time;
    }
    /**
     * method getClock return's the instance variable clock
     * @return int clock 
     */
    public int getClock(){
        return clock;
    }
    /**
     * method incrementClock increments the clock instance variable by one
     * 
     */
    public void incrementClock(){
        clock++;
    }
    /**
     * method decrementClock decrements the instance variable clock by one
     */
    public void decrementClock(){
        clock--;
    }
}
