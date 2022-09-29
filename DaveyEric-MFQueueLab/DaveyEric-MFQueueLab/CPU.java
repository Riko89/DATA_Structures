
/**
 * Class CPU takes in a Job object and processes the job
 * instance variables 
 * Clock - quantumClock used to determine how much time a process gets before being placed back on the Queue
 * boolean busy - busyflag to let other classes know whether or not the cpu is currently busy
 * Job job - job that is placed on the clock
 * 
 * @author Eric Davey
 * @version Final, 4/6/2018
 */
public class CPU
{
    private Clock quantumClock;
    private boolean busy;
    private Job job;
    /**
     * constructor CPU initializes the quantum clock to 0
     * sets busyflag to false
     */
    public CPU(){
        quantumClock = new Clock(0);
        busy = false;
    }

    /**
     * method sendToCPU() passes a Job object to the CPU, sets the busy Flag to true
     * gets the LLQ the job came from and sets the quantumClock accordingly
     * @param Job job   Job object sent from whichever queue MFQ sent it from.
     */
    public void sendToCPU(Job job){
        this.job = job;
        busy = true;
        switch(job.getLLQ()){
            case 1 : 
            quantumClock.setClock(2);
            break;
            case 2 : 
            quantumClock.setClock(4);
            break;
            case 3 : 
            quantumClock.setClock(8);
            break;
            case 4 :
            quantumClock.setClock(16);
            break;
            default : 
            quantumClock.setClock(0);
            break;
        }
        //System.out.println(quantumClock + " test Qclock message");   // REMOVE LATER
    }

    /**
     * method startNextCycle decrements the quantum clock 
     * and decrements the jobclock ON the jobclock class
     * simulate's the next cycle of what happens on the cpu
     */
    public void startNextCycle(){
        quantumClock.decrementClock();
        job.decrementJobClock();
    }

    /**
     * method removeJob sets the busyflag to false and returns the current job on the cpu
     * @return the job curently sitting on the cpu;
     * 
     */
    public Job removeJob(){
        busy = false;
        return job;
    }

    /**
     * method jobFinished returns whether the job on the cpu is finished or not, if it is return true else false
     * @return true / false boolean value dependant on whether job.isDone returns true/false
     */
    public boolean jobFinished(){
        if(job.isDone())
            return true;
        return false;
    }

    /**
     * method isBusy returns boolean true or false dependant on whether or not the cpu is busy
     * @return boolean value busy
     */
    public boolean isBusy(){
        return busy;
    }

    /**
     * method getQClock returns the value currently held by the object quantumClock
     * @return int value held by quantumClock.getClock
     */
    public int getQClock(){
        return quantumClock.getClock();
    }
}
