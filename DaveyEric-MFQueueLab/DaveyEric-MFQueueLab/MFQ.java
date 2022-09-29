import java.io.*;
import java.util.Scanner;
//import java.
/**
 * Class MFQ simulates how a computer can use queues to handle incomming processes onto the cpu
 * prints an arrival message when the process arrives on the cpu and when the job task is finished
 * 
 * instance variables 
 * systemClock - int value designed to keep track of the time starting from when the program starts
 * systemArrival - keeps track of if the current job has just arrived in the system, if it does it is set to 0
 * totalResponseTime - keeps track of the time a job arrives in the system to when it arrives on the cpu(completely arbitrary, always 0)
 * totalCompletionTime - keeps track of the total amount of time needed to complete each job
 * totalWaitTime - keeps track of total time each job spends waiting in a queue
 * sumJobTime - the sum of the amount of time needed for each job to complete it's task
 * queue - the main instance of the queue handler Class
 * inFile - the File the program is reading from "mfq.txt"
 * cpu - the primary instance of CPU class
 * job - needed to pass instances of the Job class to queuehandler and cpu
 * pw - the filewriter variable writes to "csis.txt"
 * 
 * @author Eric Davey
 * @version Final 04/06/2018
 */
public class MFQ
{
    private Clock systemClock;
    private int systemArrival; // check
    private int totalJobs;
    private int totalResponseTime;
    private int totalCompletionTime;
    private int totalWaitTime;
    private int sumJobTime;
    private QueueHandler queue;
    private Scanner inFile;
    private CPU cpu;
    private Job job;
    private PrintWriter pw;
    /**
     * constructor MFQ initializes every variable to 0 
     * passes pw to the printwriter on MFQ and inFile to the scanner on MFQ
     * @param implicit - pw and InFile
     */
    public MFQ(PrintWriter pw, Scanner inFile)throws IOException{
        this.pw = pw;
        this.inFile = inFile;
        systemArrival = 0;
        systemClock = new Clock(0);
        totalJobs = 0;
        sumJobTime = 0;
        totalResponseTime = 0;
        totalCompletionTime = 0;
        totalWaitTime = 0;
        cpu = new CPU();
        queue = new QueueHandler();
    }

    /**
     * method reader() takes in the inFile Scanner object and reads in the integer values
     * arrival time, id and jobClock and creates a new jobClass, sending to the JobQueue
     * @param Scanner inFile reads into 3 different integers and sends to queue.addJob()
     * calls startTable to print the startTable
     */
    public void reader(){
        while(inFile.hasNextLine()){
            String phrase = inFile.nextLine();
            String delims = "[ ]+";
            String[] tokens = phrase.split(delims);
            int i = tokens[0].equals("") ? 1 : 0;
            queue.addJob(new Job(Integer.parseInt(tokens[i]), Integer.parseInt(tokens[i+1]), Integer.parseInt(tokens[i+2])));
            totalJobs++;
        }
        startTable();
    }

    /**
     * method startTable prints to the system and printwriter the formatted start table
     */
    private void startTable(){
        System.out.printf("Event\t\tSystem\t\tPID\t\tCPU   \t\tTotal  \t\tLowest\r\n");
        System.out.printf("     \t\tTime  \t\t   \t\tTime  \t\tTime in\t\tLevel\r\n");
        System.out.printf("     \t\t      \t\t   \t\tNeeded\t\tSystem \t\tQueue\r\n");

        pw.printf("Event\t\tSystem\t\tPID\t\tCPU   \t\tTotal  \t\tLowest\r\n");
        pw.printf("     \t\tTime  \t\t   \t\tTime  \t\tTime in\t\tLevel\r\n");
        pw.printf("     \t\t      \t\t   \t\tNeeded\t\tSystem \t\tQueue\r\n");
    }

    /**
     * method startSimulation begins the MFQ simulation, first increments the systemclock, then checks the system clock against the 
     * arrival time of the job at the front of the Job queue, when it matches it calls method submitNewJob(), after it then checks if the cpu is busy, if any queue is avaiable
     * it calls the sendJob() method then continues to the next itteration of the cycle next the system starts the next cpu cycle (decrementing qclock and jobclock)
     * checks if the job on the cpu is finished, if it is finished it calls the jobFinished method (which prints a finished method and sets the job back to null) then preforms a check
     * to see if all queues are empty(if they are then outputs system finished method and returns to main) otherwise check if any job is available to send to the cpu and start next 
     * cycle.
     * next up the program checks for preEmption by calling the preEmption method, if returned true the job is removed from the cpu, sent to the next LLQ in the queuehandler class 
     * and calls the sendJob method again. start next itteration of the while loop
     * 
     * EXIT CONDITION OF LOOP - allQueuesEmpty AND cpu.isBusy return true and false
     * 
     */
    public void startSimulation()throws IOException{
        while(!queue.allQueuesEmpty() || cpu.isBusy()){//while all queues are not empty
            systemClock.incrementClock();
            while(systemClock.getClock() == queue.checkArrivalTime()){
                submitNewJob();
            }
            if(!cpu.isBusy()){  // if not busy
                if(queue.isAnyQueue())
                    sendJob(); // job sent
                continue;
            }
            cpu.startNextCycle();
            if(cpu.jobFinished()){
                jobFinished();
                if(queue.allQueuesEmpty()){
                    systemFinishedMessage();
                    return;
                }
                if(queue.isAnyQueue())
                    sendJob();
                continue;
            }
            if(preEmption()){
                job = cpu.removeJob();
                sendNextLLQ();
                sendJob();
                job = null;
            }
        }
    }

    /**
     * method submitNewJob calls the queuehandler class to remove a job from whatever queue needs to be removed (handled by queuehandler class)
     * calls the arrivalMessage method to print an arrival message to the system, then sets the arrival time in the current job by sending the time on the systemClock
     * finally sends the job to Q1 
     * @param explicit, Job object job sent to the queuehandler class as an argument
     */
    private void submitNewJob()throws IOException{
        job = queue.removeJob();
        if(systemArrival == 0)
            systemArrival = systemClock.getClock();
        arrivalMessage();
        job.setQueueArrival(systemClock.getClock());
        queue.addQ1(job);
        job = null;
    }

    /**
     * method jobFinished removes the job from the cpu, calculates the TotalCompletion time and calls departure message to print a departure message
     * to the system and printwriter
     */
    private void jobFinished() throws IOException{
        job = cpu.removeJob();
        totalCompletionTime += (systemClock.getClock() - job.getArrivalTime());
        departureMessage();
        job = null;
    }

    /**
     * method preEmption checks the queuehandler Q1 for it's empty status and returns true or false
     * basically if anything is on queue one preEmption returns true or if the Quantum clock on the cpu is equal to 0 return true,
     * else return false
     * @return boolean value true or false depending on whether there is anything on Q1 or if the QuantumClock returns 0
     */
    private boolean preEmption(){
        if(queue.isQ1())
            return true;
        if(cpu.getQClock() == 0)
            return true;
        return false;
    }

    /**
     * sendNextLLQ method 
     * gets the last Lowest level queue the current job ahs been on, sets the queue arrival time of the job via system clock
     * and runes the last LLQ int through a switch to decide which queue it needs to be send to
     */
    private void sendNextLLQ(){
        int Q = job.getLLQ();
        job.setQueueArrival(systemClock.getClock());
        switch(Q){
            case 1: 
            queue.addQ2(job);
            break;
            case 2:
            queue.addQ3(job);
            break;
            case 3:
            queue.addQ4(job);
            break;
            case 4:
            queue.addQ4(job);
            break;
            default:
            System.out.println("What are you doing here (switch case in sendNextLLQ())");
            break;
        }
    }

    /**
     * sendJob method calls the submitLLQ method in the queuehandler class to get the job from the LLQ 
     * updates the totalWaitTime and submits the job to the cpu class 
     * @param explicit, Job object job - passed to cpu class via method sendToCpu
     */
    private void sendJob(){
        job = queue.submitLLQ();
        totalWaitTime += (systemClock.getClock() - job.getQueueArrival());
        cpu.sendToCPU(job);
    }

    /**
     * sytemFinishedMessage method prints to the system, printwriter the departure messages of the simulation, preforms the calculations needed to get 
     * results including casting to doubles
     * 
     */
    private void systemFinishedMessage()throws IOException{
        System.out.printf("\r\n\r\nSystem finished at:\t %6d\r\nTotal job time:\t\t %6d\r\nTotal number of jobs:\t %6d\r\n", systemClock.getClock(), totalCompletionTime, totalJobs);
        System.out.printf("Average response time:\t %6d\r\n", (totalResponseTime/totalJobs));
        System.out.printf("Average turnaround time: %6.2f\r\n", ((double)totalCompletionTime/(double)totalJobs));
        System.out.printf("Average wait time:\t %6.2f\r\n", ((double)totalWaitTime/(double)totalJobs));
        System.out.printf("Average throughput:\t %6.2f\r\n",((double)totalJobs/(double)totalCompletionTime));

        pw.printf("\r\n\r\nSystem finished at:\t %6d\r\nTotal job time:\t\t %6d\r\nTotal number of jobs:\t %6d\r\n", systemClock.getClock(), totalCompletionTime, totalJobs);
        pw.printf("Average response time:\t %6d\r\n", (totalResponseTime/totalJobs));
        pw.printf("Average turnaround time: %6.2f\r\n", ((double)totalCompletionTime/(double)totalJobs));
        pw.printf("Average wait time:\t %6.2f\r\n", ((double)totalWaitTime/(double)totalJobs));
        pw.printf("Average throughput:\t %6.2f\r\n",((double)totalJobs/(double)totalCompletionTime));
    }

    /**
     * departureMessage method is a simple method to print the departure message for each job when they're finished
     */
    private void departureMessage()throws IOException{
        System.out.printf("Departure:\t  %3d\t\t%3d", systemClock.getClock(), job.getPID());
        System.out.printf("\t\t\t\t%3d\t\t%3d\r\n", (systemClock.getClock() - job.getArrivalTime()), job.getLLQ());

        pw.printf("Departure:\t  %3d\t\t%3d", systemClock.getClock(), job.getPID());
        pw.printf("\t\t\t\t%3d\t\t%3d\r\n", (systemClock.getClock() - job.getArrivalTime()), job.getLLQ());
    }

    /**
     * arrivalMessage simply prints the message when a job arrives in the system for the first time.
     */
    private void arrivalMessage()throws IOException{
        System.out.printf("Arrival:  \t  %3d\t\t%3d", job.getArrivalTime(), job.getPID());
        System.out.printf("\t\t%3d\r\n", job.getTimeLeft());

        pw.printf("Arrival:  \t  %3d\t\t%3d", job.getArrivalTime(), job.getPID());
        pw.printf("\t\t%3d\r\n", job.getTimeLeft());
    }

}
