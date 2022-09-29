import java.io.*;
/**
 * Word is used frequently as an object in this program, has methods
 * add, getWord, operate, visit, and compareTo
 * 
 * @author  Eric Davey
 * @version 5/17/2018
 */
public class Word implements TreeComparable
{
    private String word;
    private LinePosition linePosition;
    private int count;
    private ObjectList wList;
    private PrintWriter pw;
    /**
     * Word 4 arg constructor, initializes all instance variables, sets count to 1
     * as it knows there is at least 1 instance of the word by its being created.
     * @param String word, int lineNum, linePos, instanced word gets argument word
     * linePos and linNum are passed to linePosition as arguments for constructor
     * 
     */
    public Word(String word, int lineNum, int linePos, PrintWriter pw){
        this.pw = pw;
        this.word = word;
        linePosition = new LinePosition(lineNum, linePos, pw);
        wList = new ObjectList();
        count = 1;
    }

    /**
     * 1 arg constructor Word, used for searching binary tree only, don't pass for any other reason
     * (maybe to delete)
     * @param String word - instance variable word gets word
     */
    public Word(String word){
        this.word = word;
    }

    /**
     * method add takes in big o object, inserts it into a ObjectListNode, inserts into 
     * ObjectList wList
     * @param Object o, contains a reference to THIS word object, inserted into linkedList
     */
    public void add(Object o){
        ObjectListNode node = new ObjectListNode();
        node.setInfo(o);
        wList.addLast(node);
    }

    /**
     * method getWord returns instance variable word
     * @return word - word held by this word object
     */
    public String getWord(){
        return word;
    }

    /**
     * operate method is implementing the TreeComparable interface, takes in an Object o
     * and inserts it into a Linked list full of other word objects.
     * increments count 
     * @param Object o - contains reference to a word object containing the same String, 
     * added to the end of the ObjectList wList
     */
    public void operate(Object o){
        wList.addLast(o);
        count++;
    }

    /**
     * method visit initializes a new ObjectListNode, uses it to get a reference to the begining
     * of the list, traverses through the list until node gets null, invoking the lineObject
     * on each word to print the word name and lineNumbers
     */
    public void visit(){
        int indenter = 0;
        ObjectListNode node = new ObjectListNode();
        node = wList.getFirstNode();
        System.out.printf("%-10s\t%d\t",word,count);
        pw.printf("%-10s\t%d\t",word,count);
        while(node != null){
            if(indenter == 5){
                System.out.printf("\n---------\t\t");
                pw.printf("\r\n---------\t\t");
            }
            ((Word)node.getInfo()).callLineObject();
            node = node.getNext();
            indenter++;
        }
        System.out.println();
        pw.println();
    }

    /**
     * compareTo method used in TreeComparable interface, returns an integer value
     * by using the native java compareTo to compare Strings on the word Object.
     * @param Object o - wrapped in a word object to invoke compareTo java native, 
     * @return integer value between -1 and 1 
     */
    public int compareTo(Object o){
        return word.compareTo(((Word)o).getWord());
    }

    /**
     * callLineObject method invokes the LinePosition method printLinePos()
     * contained by the LinePosition Object on -this- Word object
     */
    private void callLineObject(){
        linePosition.printLinePos();
    }
}
