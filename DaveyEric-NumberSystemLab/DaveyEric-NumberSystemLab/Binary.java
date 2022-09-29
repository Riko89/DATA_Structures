import java.io.*;
import java.util.Scanner;
/**
 * Binary Class takes in input from user in the form of a 32 bit binary  
 * number and outputs either hexadecimal or Decimal Value
 * 
 * 
 * @author  Eric Davey 
 * @version 2/16/2018
 */
public class Binary
{
    private PrintWriter pw;
    /**
     * Constructor for objects of class Binary
     * @param  pw  type Implicit param, passed from main
     * assigns private object pw of type PrintWriter to explicit param passed to constructor  
     */
    public Binary(PrintWriter pw)
    {
        this.pw = pw;
    }

    /**
     * Method binToHex creates a variable boolean x and assigns it to false then passes it to inputbin
     * @param boolean x - type explicit passed to inputBin
     * 
     */
    public void binToHex(){
        boolean x = false;
        inputBin(x);
    }

    /**
     * Method binToDec creates a variable boolean x and assigns it to true then passes it to inputbin
     * @param boolean x - type explicit passed to inputBin
     */
    public void binToDec(){
        boolean x = true;
        inputBin(x);
    }

    /**
     * Method toHex takes in argument numBin and initializes an object type StringBuilder to '00000000'
     * and declares variable int j to 0, the method then cycles through positions i, i+4 in 
     * numBin to see if it matches a binary value between 0 and 15, then assigns that value to
     * numHex at position j (incrementing j by 1). then passes numHex to to outHex
     * @param String numBin - type implicit, used to convert values to hexadecimal and assign to numHex
     * @param numHex Object type StringBuilder - type explicit contains hexadecimal value, passes to outHex
     */
    private void toHex(String numBin){
        StringBuilder numHex = new StringBuilder("00000000"); 
        int j = 0;
        for(int i = 0; i < numBin.length()-1; i+=4){
            if(numBin.substring(i, i +4).equals("0000"))
                numHex.setCharAt(j++, '0');
            else if(numBin.substring(i, i +4).equals("0001"))
                numHex.setCharAt(j++, '1');
            else if(numBin.substring(i, i +4).equals("0010"))
                numHex.setCharAt(j++, '2');
            else if(numBin.substring(i, i +4).equals("0011"))
                numHex.setCharAt(j++, '3');
            else if(numBin.substring(i, i +4).equals("0100"))
                numHex.setCharAt(j++, '4');
            else if(numBin.substring(i, i +4).equals("0101"))
                numHex.setCharAt(j++, '5');
            else if(numBin.substring(i, i +4).equals("0110"))
                numHex.setCharAt(j++, '6');
            else if(numBin.substring(i, i +4).equals("0111"))
                numHex.setCharAt(j++, '7');
            else if(numBin.substring(i, i +4).equals("1000"))
                numHex.setCharAt(j++, '8');
            else if(numBin.substring(i, i +4).equals("1001"))
                numHex.setCharAt(j++, '9');
            else if(numBin.substring(i, i +4).equals("1010"))
                numHex.setCharAt(j++, 'A');
            else if(numBin.substring(i, i +4).equals("1011"))
                numHex.setCharAt(j++, 'B');
            else if(numBin.substring(i, i +4).equals("1100"))
                numHex.setCharAt(j++, 'C');
            else if(numBin.substring(i, i +4).equals("1101"))
                numHex.setCharAt(j++, 'D');
            else if(numBin.substring(i, i +4).equals("1110"))
                numHex.setCharAt(j++, 'E');
            else if(numBin.substring(i, i +4).equals("1111"))
                numHex.setCharAt(j++, 'F');
        }
        outHex(numHex);
    }

    /**
     * method outHex takes in argument numHex and outputs the value it holds to the user
     * @param numHex Object StringBuilder - type implicit param outputted to user
     */
    private void outHex(StringBuilder numHex){
        System.out.println(numHex);
        pw.println(numHex);
        System.out.println();
        pw.println();
    }

    /**
     * method inputBin takes in argument boolean x (uses x to decide whether to send numBin to
     * toDec or toHex
     * prompts user for a value in binary and assigns it to String numBin.
     * @param boolean x - type implicit, used to determine whether to pass numBin to toHex or toDec
     * @param String numBin - type explicit, passed to toHex or toDec 
     */
    private void inputBin(boolean x){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number in binary: ");
        pw.println("Enter your number in binary: ");
        String numBin = sc.nextLine();
        pw.println(numBin);
        if(x)
            toDec(numBin);
        else
            toHex(numBin);
    }

    /**
     * method toDec takes in argument numBin and creates variables numDec and j of type integer
     * assigns numDec to the sum of itself and 2 to the exponent raised to the power of j, multiplied
     * by the character held by numBin at position i. the final result is the converted value from binary
     * to decimal.
     * @param String numBin - type implicit param, used in the conversion to decimal and assigned value
     * to numDec
     * @param int numDec - type explicit param, passed to outDec as argument.
     */
    private void toDec(String numBin){
        int numDec = 0, j = 0;
        for(int i = numBin.length()-1; i > -1; i--){
            numDec += ((int)Math.pow(2, j++)*((int)numBin.charAt(i) - 48)); 
        }
        outDec(numDec);
    }

    /**
     * method outDec takes in argument numDec and outputs the value stored in numDec to the user
     * @param int numDec - type implicit, outputted to user.
     */
    private void outDec(int numDec){
        System.out.println(numDec);
        pw.println(numDec);
        System.out.println();
        pw.println();
    }
}
