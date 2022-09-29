import java.util.Scanner;
import java.io.*;
/**
 * Decimal Class takes in input from user in the form of a decimal 
 * number and outputs either Binary or Hexidecimal Value
 * 
 * @author  Eric Davey 
 * @version 2018
 */
public class Decimal
{
    private PrintWriter pw;

    /**
     * Constructor for objects of class Decimal
     * @param  pw  type Implicit param, passed from main
     * assigns private object pw of type PrintWriter to explicit param passed to constructor  
     */
    public Decimal(PrintWriter pw)
    {
        this.pw = pw;
    }

    /**
     *method decToHex
     *creates variable x of type boolean and passes it as argument to method inputDec
     *@param x type explicit, passed to inputDec as argument 
     *
     */
    public void decToHex(){
        boolean x = false;
        inputDec(x);
    }

    /**
     * method toHex takes in param int numDec and uses the modulus operator by 16 and assigns to position i in numHex, 
     * i is incremented each time the loop itterates to keep track of the most right number to be printed first once passed
     * to outHex.
     * @param  int numDec - type implicit carries value of decimal to be converted to numHex (hexidecimal)
     * @param  numHex, int i - both type explicit passed to method outHex
     */
    private void toHex(int numDec){
        String numHex = "";
        int i = 0;
        while(numDec != 0){
            if(numDec % 16 < 10)
                numHex += (char)(numDec % 16 + 48);
            else
                numHex += (char)(numDec % 16 + 'A' - 10);

            numDec /= 16;
            i++;
        }
        outHex(numHex, --i);
    }

    /**
     * method outHex takes in params numHex and i and prints them from position i in numHex, 
     * decrementing until reaching position 0
     * @param String numHex - type implicit 
     * @param int i - type implicit position of last number converted in string numHex
     * 
     */
    private void outHex(String numHex, int i){
        for(; i > -1; i--){
            System.out.print(numHex.charAt(i));
            pw.print(numHex.charAt(i));
        }
        System.out.println();
        pw.println();
        System.out.println();
        pw.println();
    }

    /**
     * method decToBin
     * 
     * @param  boolean x - type explicit - assigned value to true. passed to inputDec.
     * 
     */
    public void decToBin()
    {
        boolean x = true;
        inputDec(x);
    }

    /**
     * method inputDec takes in variable x and uses its value to determine which method to call
     * takes in input from user of type decimal and assigns the value to numDec and passes it to methods toBin or toHex
     * @param  boolean x type: implicit
     */
    private void inputDec(boolean x){
        Scanner sc = new Scanner(System.in);
        int numDec = 0;
        System.out.println("Enter your number in Decimal: ");
        pw.println("Enter your number in Decimal: ");
        numDec = sc.nextInt();       
        pw.println(numDec);
        if(x)
            toBin(numDec);
        else

            toHex(numDec);
    }

    /**
     * method toBin takes in integer numDec as a parameter, declares integer i and array binary type integer. preforms modulus operation on numDec by 2 and assigns the value to i position in binary[] incrementing each itteration
     * then uses the divide operation on numDec by two and assigns the new value to numDec, while loop breaks when numDec value reaches 0
     * @param  int numDec - type implicit
     * @param  int[] binary  - type explicit - passed to outBin as argument 
     */
    private void toBin(int numDec){
        int [] binary = new int [32];
        String numBin = "";
        int i = 0;
        while(numDec != 0){
            binary[i++] = numDec % 2;
            numDec /= 2;
        }
        outBin(binary);
    }

    /**
     * method outBin takes in int[] binary as parameter and prints each value of the array until i reaches 0, skipping a space every time i is divisible by 4
     * @param   int [] binary - type implicit 
     * 
     */
    private void outBin(int [] binary){
        for(int i = 31; i > -1; i--){
            System.out.print(binary[i]);
            pw.print(binary[i]); 
            if((i) % 4 == 0){
                System.out.print(" ");
                pw.print(" ");
            }
        }
        System.out.println();
        pw.println();
        System.out.println();
        pw.println();
    }
}
