import java.util.Scanner;
import java.io.*;
/**
 * Driver class instantiates a printwriter class pw, Scanner class inFile 
 * and class mfq, calls the mfq reader function and the mfq startSimulation method
 * 
 * @author Eric Davey 
 * Palomar Student ID # 007467548
 * Multilevel feedback queue Lab
 * Csis 210 Data Structs Richard Stegman
 * @version Final 04/06/2018
 */
public class Driver
{
    /**
     * main simply creates the inFile scanner and pw Printer and passes them to MFQ, calls the reader method in MFQ and the 
     * start simulation in MFQ, after the similation is finished 
     * closes pw and inFile.
     * Just the Driver method, all the meat and bones of the simulation are done in MFQ
     */
    public static void main(String [] args)throws IOException{
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        Scanner inFile = new Scanner(new File("mfq.txt"));
        MFQ mfq = new MFQ(pw, inFile);
        
        mfq.reader();
        mfq.startSimulation();
        
        pw.close();
        inFile.close();
    }
}
