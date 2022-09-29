import java.io.*;
import java.util.Scanner;
/**
 * Driver instantiates an Object xref type Xref, PrintWriter pw, Scanner inFile
 * and Query query. Xref handles most of the progam except Query, which is used to
 * retrieve a word Query.
 * 
 * @author Eric Davey 
 * Palomar ID # 007467548
 * @version 5/18/2018
 */
public class Driver
{
    /**
     * Main instantiates Xref, PrintWriter, Scanner, and Query. 
     */
    public static void main(String [] args) throws IOException{
        Xref xref = new Xref();
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        Scanner inFile = new Scanner(new File("hashWords.txt"));
        Query query = new Query(pw);

        xref.hashHandler(pw, inFile);

        inFile.close();
        inFile = new Scanner(new File("getty.txt"));

        xref.readIn(inFile, pw);
        xref.outputListing(pw);
        String search = "";
        while(search.compareTo("Q")!=0){
            search = query.askWord();
            xref.searchTree(search, pw);
        }

        inFile.close();
        pw.close();
    }
}
