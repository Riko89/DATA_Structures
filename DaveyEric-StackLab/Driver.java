import java.io.*;
import java.util.Scanner;
/**
 * Project Title: Lab 2 - Infix to PostFix
 * Driver class reads in lines from a text file infix.txt, holds them temperarily in a string
 * and passes that string to the convert() class method inToPost() to convert the string 
 * from infix to post-fix notation, and stores that in an array in main. then passes each array 
 * to the eval class read() method to be calculated and evaluated.
 * 
 * @author Eric Davey, Palomar ID # 007467548
 * @version Final :  3/09/2018
 * user instructions: make sure infix txt file is in the same folder as the program.
 */
public class Driver
{
    /**
     * main instantiates variables of type PrintWriter, Scanner, InfixToPostfix and EvalPostfix
     * declares variables of type Int and declares an array of type int (postFix)
     * scans in lines from text file infix.txt and stores them in temperary variable buf
     * passes buf to inToPost() as arguments to be evaluated and converted to postfix
     * and gets a return value stored in array position [i] 
     * Then passes each array to read() class as arguments to be executed in postfix
     * and gets a return.
     * 
     * @param  String [] args as implicit arguments, passes String buf and array postFix
     * to convert and eval classes as explicit arguments.
     */
    public static void main(String[] args)throws IOException{
        int SIZE = 15, i = 0;  // variables
        int [] solution = new int[SIZE];
        String[] postFix = new String[SIZE];
        
        PrintWriter pw = new PrintWriter (new FileWriter("csis.txt"));
        Scanner fileScan = new Scanner(new File("infix.txt"));
        
        InfixToPostfix convert = new InfixToPostfix();
        EvalPostfix eval = new EvalPostfix();
       

        while(fileScan.hasNext()){
            String buf = fileScan.nextLine();
            System.out.println("Infix   : " + buf);  // Print lines
            pw.println("Infix   : " + buf);           // 
            postFix[i] = convert.inToPost(buf);
            System.out.println("Postfix : " + postFix[i]); //   Print lines
            pw.println("Postfix : " + postFix[i]);         // 
            solution[i] = eval.read(postFix[i]);
            System.out.println("Solution: " + solution[i]); // Print lines
            pw.println("Solution: " + solution[i++]);       // 
            System.out.println();                           //
            pw.println();                                   //
        }

        pw.close();
        fileScan.close();
    }
}
