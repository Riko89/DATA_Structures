import java.io.*;
/**
 * LinePosition class has two integers, linePosition, and lineNumber,
 * linePosition contains the word count position in the line
 * lineNumber contains the line number the word is on
 * 
 * 
 * @author Eric Davey
 * @version 5/18/2018
 */
public class LinePosition
{
    private int lineNumber;
    private int linePosition;
    private PrintWriter pw;
    /**
     * LinePosition constructor, takes in lineNumber, linePosition, PrintWriter pw
     * assigns them to instance variables
     * 3 arg constructor
     * @param int lineNumber, linePosition, PrintWriter pw
     * 
     */
    public LinePosition(int lineNumber, int linePosition, PrintWriter pw){
        this.pw = pw;
        this.lineNumber = lineNumber;
        this.linePosition = linePosition;
    }
    /**
     * printLinePos method simply prints the line number and line position
     */
    public void printLinePos(){
        System.out.printf("%d-%d\t",lineNumber,linePosition);
        pw.printf("%d-%d\t",lineNumber,linePosition);
    }
}
