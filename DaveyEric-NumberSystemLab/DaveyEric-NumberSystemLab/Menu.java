import java.util.Scanner;
import java.io.*;
/**
 * Menu Class outputs a menu to the user informing them of the options and operations they 
 * ask the program to perform converting from decimal to binary decimal to hexadecimal
 * binary to decimal, binary to hexadecimal, hexidecimal to decimal, hexidecimal to binary
 * and 7 to quit
 * 
 * @author Eric Davey 
 * @version 2/16/2018
 */
public class Menu
{
    private PrintWriter pw;
    /**
     * Constructor for objects of class Menu
     * @param  pw  type Implicit param, passed from main
     * assigns private object pw of type PrintWriter to explicit param passed to constructor  
     */
    public Menu(PrintWriter pw)
    {
        this.pw = pw;
    }

    /**
     * method display
     * outputs menu to user asking what conversion they wish to preform
     *  
     */
 
    public void display(){
        System.out.printf("Menu, input number coresponding to the selection:\n");
        pw.printf("Menu, input number coresponding to the selection:\r\n");
        System.out.printf("1  :  Decimal to Binary\n2  :  Decimal to Hexidecimal\n3  :  Binary to Decimal\n");
        pw.printf("1  :  Decimal to Binary\r\n2  :  Decimal to Hexidecimal\r\n3  :  Binary to Decimal\r\n");
        System.out.printf("4  :  Binary to Hexideximal\n5  :  Hexidecimal to Decimal\n6  :  Hexidecimal to Binary\n");
        pw.printf("4  :  Binary to Hexideximal\r\n5  :  Hexidecimal to Decimal\r\n6  :  Hexidecimal to Binary\r\n");
        System.out.println("7   :  Quit");
        pw.println("7   :  Quit");
    }
    /**
     * method getSelection declares variables int sel and prompts the user for an input to assign to 
     * variable sel, (preforms error checking, though not complete)
     * and returns selection
     * @return int sel, returns integer with value that will be used to determine which menu choice the user
     * whats to select.
     */
    public int getSelection(){
        int sel = 0;
        Scanner sc = new Scanner(System.in);
        
        while(!sc.hasNextInt()){
        sc.nextLine();
        System.out.println("Integer please!");
        }
        sel = sc.nextInt();
        pw.println(sel);
        if(sel < 1 || sel  >7)
        System.out.println("number is not a menu choice");
        return sel;
    }
}
