import java.io.*;
import java.util.Scanner;
/**
 * Xref is the main body of the program, has methods hashHandler, readIn, outputListing,
 * and searchTree. 
 * instance variables Object Hash hash, ObjectBinaryTree object gettyTree
 * 
 * 
 * @author Eric Davey
 * @version (5/18/2018)
 */
public class Xref
{   
    private Hash hash;
    private ObjectBinaryTree gettyTree;
    /**
     * Xref constructor, initializes hash and gettyTree instance variables
     */
    public Xref(){
        hash = new Hash();
        gettyTree = new ObjectBinaryTree();
    }
    /**
     * hashHandler method invokes the createTable method and printTable method - see Hash class
     * @param PrintWriter pw, Scanner inFile, taken in as arguments and passed as params to 
     * creatTable and printTable
     * 
     */
    public void hashHandler(PrintWriter pw, Scanner inFile)throws IOException{
        hash.createTable(inFile);
        hash.printTable(pw);
        System.out.println();
        pw.println();
    }
    /**
     * method readIn() sets int linNum to 1, reads in from inFile containing text and
     * splits all un-wanted characters from each string, then checks to see if the word has
     * an uppercase letter, in which case converts it to a lower case. passes each word as an
     * Argument to the isHash() method in Hash, if returned true the word is skipped and the program
     * still has the number of words in the line, if returned false a word object is created,
     * and the String is added to a Word Object, along with the lineNum and linePosition, and pw.
     * The reference to the word is then passed to the same word in the word.add() function 
     * to be used for a linked list. Finally, the word is inserted into the binary Search Tree
     * with the .insertBSTDup method. Before continuing the loop the linenumber is incremented.
     * @param Scanner inFile, PrintWriter pw for reading and writing to the text files.
     * @param Word word, containing a string and linepos/line number passed to add and insertBSTDup
     * 
     */
    public void readIn(Scanner inFile, PrintWriter pw){
        int lineNum = 1;
        while(inFile.hasNext()){
            String phrase = inFile.nextLine();
            String delims = "[ ,.; -]+";
            String[] tokens = phrase.split(delims);
            int i = tokens[0].equals("") ? 1 : 0;
            for(int j = 0; j < tokens.length; j++){
                if(tokens[i+j].charAt(0) > 64 && tokens[i+j].charAt(0) < 91){
                    String temp = "";
                    temp += (char)(tokens[i+j].charAt(0) + 32);
                    for(int read = 1; read < tokens[i+j].length(); read++)
                    {
                        temp += tokens[i+j].charAt(read);
                    }
                    tokens[i+j] = temp;
                }
                if(hash.isHash(tokens[i+j]))
                    continue;
                Word word = new Word(tokens[i+j], lineNum, (j+1), pw);
                word.add((Object)word);
                gettyTree.insertBSTDup(word);
            }
            lineNum++;
        }
    }
    /**
     * method outputListing() prints the list alphabetically by preforming an inorder 
     * traversal of the Binary Search Tree, passing the Root of the tree as an argument
     * @param PrintWriter pw, for printing a few lines of text.
     * @param treeNode, a reference to the root node of the tree.
     */
    public void outputListing(PrintWriter pw)throws IOException{
        System.out.println("Printing formatted List.");
        System.out.println();
        pw.println("Printing formatted List.");
        pw.println();
        ObjectTreeNode treeNode = new ObjectTreeNode(); 
        treeNode = gettyTree.getRoot();
        gettyTree.inTrav(treeNode);
    }
    /**
     * method searchTree() takes in a string s, compares it to Q to make sure the user does not
     * want to quit the program, if not the string is inserted into a new word object and inserted
     * into the tree, the tree invokes searchBST method to find the word and returns a reference to
     * a treeNode, if treeNode is null the program assumes it is not contained in the tree and
     * informs the user, returning to the main program,
     * otherwise the word invokes the visit method in Word, printing the information of the word.
     * @param String s, PrintWriter pw - s is wrapped in a Word object and (possibly) inserted into 
     * tree
     */
    public void searchTree(String s, PrintWriter pw){
        if(s.compareTo("Q") == 0){
            System.out.println("Exiting Program....");
            pw.println("Exiting Program....");
            return;
        }
        ObjectTreeNode treeNode = new ObjectTreeNode(); 
        Word word = new Word(s);
        treeNode = gettyTree.searchBST(word);
        if(treeNode == null){
            System.out.println("Word is not contained in file");
            pw.println("Word is not contained in file");
            return;
        }
        ((Word)treeNode.getInfo()).visit();
    }
}
