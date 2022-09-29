import java.io.*;
/**
 * Project Title: Lab 1 - Number Systems
 * Project Description: Program takes in an input from the user in Decimal, 32 bit Binary, or Hexidecimal and converts that number to one of the 2 other forms, 6 options in total.
 * @version Final: Febuary 16, 2018
 * How to start the project: Start by running the main function inside of the Driver class.
 * @author Eric Davey, Palomar ID # 007467548
 * User instructions: There is very little error checking for inputs, please avoid entering the wrong input. 7 to exit from the main menu.
 *
 */
public class Driver
{

    /**
     * Main Method: Driver class, calls the menu in a while loop untill variable choice gets 7.
     * 
     * @param  Explicit parameter: pw   type PrintWriter Object, passes pw to classes dec, bin, hex, and menu.
     * @param Explicit parameter: "csis.txt" passed to pw type PrintWriter Object. 
     * 
     */
    public static void main(String[] args) throws IOException {
        int choice;

        PrintWriter pw = new PrintWriter (new FileWriter("csis.txt"));
        Decimal dec = new Decimal(pw);
        Binary bin = new Binary(pw);
        Hexadecimal hex = new Hexadecimal(pw);
        Menu menu = new Menu(pw);

        do {
            menu.display();
            choice = menu.getSelection();
            switch(choice) {
                case 1 : dec.decToBin(); break;
                case 2 : dec.decToHex(); break;
                case 3 : bin.binToDec(); break;
                case 4 : bin.binToHex(); break;
                case 5 : hex.hexToDec(); break;
                case 6 : hex.hexToBin(); break;
            }
        }while (choice != 7);
        pw.close();
    }
}