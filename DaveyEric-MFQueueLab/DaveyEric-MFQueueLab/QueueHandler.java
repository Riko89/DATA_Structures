/**
 * QueueHandler class has one major purpose, to manage all the queues and instances of the ObjectQueue class
 * It creates 5 queue Objects, Jobqueue, Q1, Q2, Q3, and Q4 
 * 
 * @author Eric Davey
 * @version Final 4/6/2018
 */
public class QueueHandler
{
    ObjectQueue jobQueue;
    ObjectQueue Q1;
    ObjectQueue Q2;
    ObjectQueue Q3;
    ObjectQueue Q4;
    /**
     * Constructor QueueHandler initializes the jobQueue, Q1, Q2, Q3 and Q4 Queues as ObjectQueue objects
     */
    public QueueHandler(){
        jobQueue = new ObjectQueue();
        Q1 = new ObjectQueue();
        Q2 = new ObjectQueue();
        Q3 = new ObjectQueue();
        Q4 = new ObjectQueue();
    }

    /**
     * method addJob()
     * adds a job to the jobQueue
     * @param job Obj
     */
    public void addJob(Job job){
        jobQueue.insert(job);
    }

    /**
     * method checkJobClock
     * @return int jobQueue.query().getArrivalTime queries the front of the job queue and returns
     * the arrival time;
     */
    public int checkArrivalTime(){
        if(jobQueue.isEmpty())
            return -1;
        return ((Job)jobQueue.query()).getArrivalTime();
    }

    /**
     * method removeJob() removes a job from the job queue and returns the Job
     * @return Job job
     */
    public Job removeJob(){
        return (Job)jobQueue.remove();
    }

    /**
     * method addQ1() sends a job to Q1 one
     * @param Job job inserts Job obejct into Q1 sets LLQ to 1
     */
    public void addQ1(Job job){
        job.setLLQ(1);
        Q1.insert(job);
    }

    /**
     * method removeQ1()
     * @return Job Q1.remove()
     */
    public Job removeQ1(){
        return (Job)Q1.remove();
    }

    /**
     * method addQ2() sends a job to Q2 one
     * @param Job job inserts Job obejct into Q2 sets LLQ to 2
     */
    public void addQ2(Job job){
        job.setLLQ(2);
        Q2.insert(job);
    }

    /**
     * method removeQ2()
     * @return Job Q2.remove()
     */
    public Job removeQ2(){
        return (Job)Q2.remove();
    }

    /**
     * method addQ3() sends a job to Q3 one
     * @param Job job inserts Job obejct into Q3 sets LLQ to 3
     */
    public void addQ3(Job job){
        job.setLLQ(3);
        Q3.insert(job);
    }

    /**
     * method removeQ3()
     * @return Job Q3.remove()
     */
    public Job removeQ3(){
        return (Job)Q3.remove();
    }

    /**
     * method addQ4() sends a job to Q4 one
     * @param Job job inserts Job obejct into Q4 sets LLQ to 4
     */
    public void addQ4(Job job){
        job.setLLQ(4);
        Q4.insert(job);
    }

    /**
     * method removeQ4()
     * @return Job Q4.remove()
     */
    public Job removeQ4(){
        return (Job)Q4.remove();
    }

    /**
     * method submitLLQ() checks Q2, Q3, and Q4 one by one and returns the first one that isn't empty
     * @return Job object from Q1, Q2, Q3 or Q4 depending on the first one that is not empty
     */
    public Job submitLLQ(){
        if(isQ1())
            return removeQ1();
        if(isQ2())
            return removeQ2();
        if(isQ3())
            return removeQ3();
        if(isQ4())
            return removeQ4();
        System.out.println("Something went wrong, exitting. . .");
        System.exit(1);
        return null;
    }

    /**
     * isAnyQueue method checks if all queues is busy and returns a boolean value either true or false true if any queue is not empty return true, else false
     * @return boolean true or false depending on if any queue is empty or not
     */

    public boolean isAnyQueue(){
        if(isQ1())
            return true;
        if(isQ2())
            return true;
        if(isQ3())
            return true;
        if(isQ4())
            return true;
        return false;
    }

    /**
     * method allQueuesEmpty checks all five queues including jobQueue for their empty status, if all queues are empty return true, else false
     * @return boolean true or false, checks if all queues including jobQueue for empty status
     */
    public boolean allQueuesEmpty(){
        if(jobQueue.isEmpty() && Q1.isEmpty() && Q2.isEmpty() && Q3.isEmpty() && Q4.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * method isQ1() returns whether or not Q1 is occupied
     * @return boolean !Q1.isEmpty() (If Q1 has anything in it then return true) 
     */
    public boolean isQ1(){
        return (!Q1.isEmpty());
    }

    /**
     * private method isQ2() returns whether or not Q2 is occupied
     * @return boolean !Q2.isEmpty() (If Q2 has anything in it then return true) 
     */
    private boolean isQ2(){
        return (!Q2.isEmpty());
    }

    /**
     * private method isQ3() returns whether or not Q3 is occupied
     * @return boolean !Q3.isEmpty() (If Q3 has anything in it then return true) 
     */
    private boolean isQ3(){
        return (!Q3.isEmpty());
    }

    /**
     * private method isQ4() returns whether or not Q4 is occupied
     * @return boolean !Q4.isEmpty() (If Q4 has anything in it then return true) 
     */
    private boolean isQ4(){
        return (!Q4.isEmpty());
    }
}
