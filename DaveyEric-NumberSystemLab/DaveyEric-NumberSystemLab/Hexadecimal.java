import java.io.*;
import java.util.Scanner;
/**
 * Hexadecimal Class takes in input from user in the form of a hexadecimal 
 * number and outputs either Binary or Decimal Value
 * 
 * 
 * @author  Eric Davey 
 * @version 2/16/2018
 */
public class Hexadecimal
{
    private PrintWriter pw;
    /**
     * Constructor for objects of class Hexadecimal
     * @param  pw  type Implicit param, passed from main
     * assigns private object pw of type PrintWriter to explicit param passed to constructor  
     */
    public Hexadecimal(PrintWriter pw)
    {
        this.pw = pw;
    }

    /**
     *method hexToBin
     *creates variable x of type boolean and passes it as argument to method inputHex
     *@param x type explicit, passed to inputHex as argument 
     *
     */
    public void hexToBin(){
        boolean x = false;
        inputHex(x);
    }

    /**
     * method init takes in arugment String numHex, initializes a String []binary and initalizes 
     * default value of each element to a nibble ('0000')
     * @param String numHex - type implicit
     * @param String numHex, String binary - types explicit, passed to toBin as arguments
     */
    private void init(String numHex){
        String []binary = new String[8];
        for(int i = 0; i < 8; i++){
            binary[i] = "0000";
        }
        toBin(numHex, binary);
    }

    /**
     * method toBin takes in arguments numHex and []binary, checks through value at position i in numHex
     * for a series of matching values in string numHex and assigns that value to position j in binary
     * which starts from the 8'th number out and decrements to 0 converting each value to binary
     * from hexadecimal.
     * @param String numHex, String [] binary - types implicit converts values stored in numHex
     * to binary and stored in String [] binary
     * @param String []binary - type explicit passed as argument to outBin.
     */
    private void toBin(String numHex, String [] binary){
        int j = 7;
        for(int i = numHex.length()-1; i > -1; i--){
            if(numHex.charAt(i) == '0')  
                binary[j--] = "0000"; 
            else if(numHex.charAt(i) == '1')
                binary[j--] = "0001";
            else if(numHex.charAt(i) == '2')
                binary[j--] = "0010";
            else if(numHex.charAt(i) == '3')
                binary[j--] = "0011";
            else if(numHex.charAt(i) == '4')
                binary[j--] = "0100";
            else if(numHex.charAt(i) == '5')
                binary[j--] = "0101";
            else if(numHex.charAt(i) == '6')
                binary[j--] = "0110";
            else if(numHex.charAt(i) == '7')
                binary[j--] = "0111";
            else if(numHex.charAt(i) == '8')
                binary[j--] = "1000";
            else if(numHex.charAt(i) == '9')
                binary[j--] = "1001";
            else if(numHex.charAt(i) == 'A')
                binary[j--] = "1010";
            else if(numHex.charAt(i) == 'B')
                binary[j--] = "1011";
            else if(numHex.charAt(i) == 'C')
                binary[j--] = "1100";
            else if(numHex.charAt(i) == 'D')
                binary[j--] = "1101";
            else if(numHex.charAt(i) == 'E')
                binary[j--] = "1110";
            else if(numHex.charAt(i) == 'F')
                binary[j--] = "1111";
        }
        outBin(binary);
    }

    /**
     * method outBin takes in []binary as an argument and prints it in a loop starting from 
     * index 0 going until index of 7, outputs 32 bit binary number that has been converted from hex
     * @param String []binary - type implicit outputs the string array.
     * 
     */
    private void outBin(String []binary){
        for(int i = 0; i < 8; i++){
            System.out.print(binary[i]);
            pw.print(binary[i]);
            System.out.print(" ");
            pw.print(" ");
        }
        System.out.println();
        pw.println();
        System.out.println();
        pw.println();
    }

    /**
     * method hexToDec initializes variable x type boolean to true, passes to method inputHex
     * @param  boolean x - type explicit, passed as arguement to inputHex
     */
    public void hexToDec(){
        boolean x = true;
        inputHex(x);
    }

    /**
     * method inputHex takes in argument boolean x and uses it to decide whether to pass
     * string numHex (which is taken from user input in the form of a Hexadecimal number) 
     * to either method toDec if x is true, and init is x is false
     * @param boolean x - type implicit, used in if else statement
     * @param String numHex - type explicit, sent to toDec or init as argument
     */
    private void inputHex(boolean x){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number in hexadecimal: ");
        pw.println("Enter your number in hexadecimal: ");
        String numHex = sc.nextLine(); 
        pw.println(numHex);

        if(x)
            toDec(numHex);
        else   
            init(numHex);
    }

    /**
     * method toDec takes in argument String numHex as parameters creates variables int decimal, and int j
     * in order to convert numHex from hexadecimal to decimal the method takes the character at position i from 
     * numHex (which is initialized to the last character in the string) and assigns the value to the sum of itself
     * raised to the power j (the position of the character reading from right to left) and the integer decimal
     * to decimal until all characters are read, the value assigned to decimal is the converted decimal value
     * is then passed to outDec as an argument
     * @param String numHex - type implicit, converted to decimal value and assigned to int decimal
     * @param int decimal - type explicit, decimal value passed to outDec as argument
     * 
     */
    private void toDec(String numHex){
        int decimal = 0, j = 0;
        for(int i = numHex.length()-1; i > -1; i--){
            if((int)numHex.charAt(i) > 64 && (int)numHex.charAt(i) < 71)
                decimal += ((int)Math.pow(16, j++) * ((int)numHex.charAt(i) - 55));
            else
                decimal += ((int)Math.pow(16, j++) * ((int)numHex.charAt(i) - 48));
        }
        outDec(decimal);
    }
    /**
     * method outDec takes in arguments int decimal and outputs it to user screen
     * @param int decimal - type implicit outputted to user
     * 
     */
    private void outDec(int decimal){
        System.out.println(decimal);
        pw.println(decimal);
        System.out.println();
        pw.println();
    }
}