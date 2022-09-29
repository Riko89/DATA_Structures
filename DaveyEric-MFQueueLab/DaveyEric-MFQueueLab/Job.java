
/**
 * Job Class is a data keeping class intended to be used as an object to be passed to and from the 
 * it contains private variables ArrivalTime - the time the job arrived in the system
 * LLQ - the last queue it was placed on
 * PID - the ID Number of the Job
 * and queueArrival - the time at which the job arrived in a queue
 * 
 * @author Eric Davey 
 * @version Final, 04/06/2017
 */
public class Job
{
    private Clock jobClock;
    private int arrivalTime;
    private int LLQ;
    private int PID;
    private int queueArrival;
    /**
     * constructor Job initializes variables
     * @param implicit arguments arrivalTime, Pid, jobClock
     */
    public Job(int arrivalTime, int PID, int jobClock){
        this.jobClock = new Clock(jobClock);
        this.PID = PID;
        this.arrivalTime = arrivalTime;
        queueArrival = 0;
        LLQ = 0;
    }

    /**
     * method decrementJobClock() decrements the jobClock instance variable by one
     */
    public void decrementJobClock(){
        jobClock.decrementClock();
    }

    /**
     * method setLLQ takes in int Q and sets the LLQ to whatever is passed
     * @param int Q set from the queue it's passed from
     * 
     */
    public void setLLQ(int Q){
        LLQ = Q;
    }

    /**
     * method setQArrival records the time the job arrived in a queue
     * @param int qArrival the time the job arrived in the queue
     */
    public void setQueueArrival(int qArrival){
        queueArrival = qArrival;
    }

    /**
     * method getQueueArrival() returns the time a job arrived in a queue
     * @return int queueArrival the time the job arrived in the queue
     */
    public int getQueueArrival(){
        return queueArrival;
    }

    /**
     * method getLLQ() returns the lowest level queue the job has been in 
     * @return int LLQ, contains the lowest level queue the job has been on
     */
    public int getLLQ(){
        return LLQ;
    }

    /**
     * method getArrivalTime() returns the arrival time of the job
     * @return int arrivalTime returns the time the job arrived in system.`
     */
    public int getArrivalTime(){
        return arrivalTime;
    }

    /**
     * method getPID returns the PID of the job
     * @return int PID the id of the job
     */
    public int getPID(){
        return PID;
    }

    /**
     * method getTimeLeft() returns the time left on the job clock
     * @return int jobClock  time left on job clock
     */
    public int getTimeLeft(){
        return jobClock.getClock();
    }

    /**
     * method isDone() checks to see if the time left on the jobclock is 0
     * @return boolean true or false
     */
    public boolean isDone(){
        if(jobClock.getClock() == 0)
            return true;
        return false;
    }
}
