import java.util.Scanner;
import java.io.*;
/**
 * Hash class contains methods Hash, createTable, printTableand isHash
 * functions create a hashtable, print out a hash table, return loadFactor and collisions
 * 
 * @author Eric Davey 
 * @version 5/18/2018
 */
public class Hash
{
    private ObjectList []hashTable;
    private int collisions;
    private int tableSize;
    private int occupied;
    private int buckets;
    private double loadFactor;
    /**
     * constructor for hash, initializes tableSize to 37, hashTable to an array of ObjectList's (then initalizes all the lists)
     * sets collisions to 0, occupied to 0, buckets to 0, loadFactor to 0.00 (double)
     */
    public Hash(){
        tableSize = 37;
        hashTable = new ObjectList[tableSize];
        for(int i = 0; i < 37; i++){
            hashTable[i] = new ObjectList();
        }
        collisions = 0;
        occupied = 0;
        buckets = 0;
        loadFactor = 0.00;
    }
    /**
     * createTable takes in argument inFile which contains the hashTable text file, reads in each word(adding delims for spaces
     * in case user accidentally adds them to the text file, applies the hash function to each String(word) to get a value
     * from 0 to 36, checks to see if that spot is occupied in the hash table, if it is the occupied variable is incremented
     * and the collision is resolved by chaining via linked lists by added the word to the end of the list.
     * @param Scanner inFile contains the hashWords.txt reference, read in to  the table
     */
    public void createTable(Scanner inFile){
        while(inFile.hasNext()){
            ObjectListNode node = new ObjectListNode();
            String phrase = inFile.nextLine();
            String delims = "[ ]+";
            String[] tokens = phrase.split(delims);
            int i = tokens[0].equals("") ? 1 : 0;
            node.setInfo(tokens[i]);
            int index = getHash(tokens[i]);
            if(hashTable[index].size() == 0)
                occupied++;
            else
                collisions++;
            hashTable[index].addLast(node);
        }
        buckets = tableSize - occupied;
        loadFactor = occupied/buckets;
    }
    /**
     * printTable method prints a formatted list of the HashTable contained in the Hash Class
     * while traversing through the hashTable array, each index is checked for certain parameters, if empty the 
     * array index is skipped, if the size is greater than 1, a reference to the first node in the array index list is
     * created and traversed through until null, printing the strings held by the nodes in the list, 
     * if the size is 1 the string held by the first node is printed
     * @param PrintWriter pw - used for printing a formatted table Index for the hash words
     */
    public void printTable(PrintWriter pw)throws IOException{
        System.out.println("Printing Hash Table, Collisions are resolved via chaining with linked lists.");
        System.out.println("\t\t\tTABLE INDEX: ");
        System.out.println("------------------------------------------------------");
        pw.println("Printing Hash Table, Collisions are resolved via chaining with linked lists.");
        pw.println("\t\t\tTABLE INDEX: ");
        pw.println("--------------------------------------------------------");
        int counter = 0;//used for formatting
        for(int i = 0; i < hashTable.length; i++){
            if(hashTable[i].isEmpty()){
                continue;
            }
            if(hashTable[i].size() > 1){
                ObjectListNode node = new ObjectListNode();
                node = hashTable[i].getFirstNode();
                while(node != null){
                    counter++;
                    System.out.printf("[%2d]%-8s ",i,node.getInfo());
                    pw.printf("[%2d]%-8s ",i,node.getInfo());
                    if(counter == 4){
                        System.out.println();
                        pw.println();
                        counter = 0;
                    }
                    node = node.getNext();
                }
            }
            else{
                counter++;
                System.out.printf("[%2d]%-8s ",i,hashTable[i].getFirstNode().getInfo());
                pw.printf("[%2d]%-8s ",i,hashTable[i].getFirstNode().getInfo());
                if(counter == 4){
                    System.out.println();
                    pw.println();
                    counter = 0;
                }
            }
        }
        System.out.println();
        pw.println();
        System.out.println("--------------------------------------------------------");
        pw.println("--------------------------------------------------------");
        System.out.println("Collisions : " + collisions);
        pw.println("Collisions : " + collisions);
        System.out.println("Load Factor: " + loadFactor);
        pw.println("Load Factor: " + loadFactor);
        System.out.println();
        System.out.println("Hash function was found through brute force, initial value "); 
        System.out.println("is set as the sum of the integer value of each of character ");
        System.out.println("in the string, then assigned the value the sum of initial");
        System.out.println("value divided by 3, and modulated by 832, then by tableSize.");
        pw.println();
        pw.println("Hash function was found through brute force, initial value "); 
        pw.println("is set as the sum of the integer value of each of character ");
        pw.println("in the string, then assigned the value the sum of initial");
        pw.println("value divided by 3, and modulated by 832, then by tableSize.");
    }
    /**
     * isHash takes in a String s, and calls the getHash function by passing the string
     * if the index (represented by the return integer value from getHash) of the hashArray containeds the same String
     * a true value is returned, if the String is not contained in the hashTable, false is returned.
     * @param String s, passed to getHash to get hashValue for the array table
     * @return boolean true of false
     */
    public boolean isHash(String s){
        if(hashTable[getHash(s)].size() != 0){
            ObjectListNode node = new ObjectListNode();
            node = hashTable[getHash(s)].getFirstNode();
            while(node != null){
                if(((String)(hashTable[getHash(s)].getFirstNode().getInfo())).compareTo(s) == 0){
                    return true;
                }
                node = node.getNext();
            }
        }
        return false;
    }
    /**
     * method getHash() takes in a String s, applies a series of calculations (that were predetermined by another
     * program I wrote to brute force a good equation) each character is read and multiplied by itself and added to a sum
     * value, arbitrarily named x and y integers divide by 3 and modulated by 832, added together and modulated by tableSize
     * returns an integer Value from 0 to 36.
     * @param String s - converted into an integer value modulated by tableSize and returned
     * @return integer value between 0 and 36
     * 
     * Since you will be moving this to your own program for testing, this is Eric Davey's hash function.
     */
    private int getHash(String s){
        int value = 0, x = 0, y = 0;
        for(int i = 0; i < s.length(); i++){
            value += s.charAt(i) * s.charAt(i);
        }
        x = value / 3;
        y = value % 832;
        value = x + y;
        value = value % tableSize;
        return value;
    }
}
