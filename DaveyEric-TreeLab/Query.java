import java.util.Scanner;
import java.io.*;
/**
 * Class query is used for getting queries from the user
 * 
 * @author Eric Davey
 * @version 5/18/2018
 */
public class Query
{
    private PrintWriter pw;
    private Scanner sc;
    /**
     * Constructor for objects of class Query
     * initializes PrintWriter variable and sc variable as a Scanner
     * @param PrintWriter pw
     * 
     */
    public Query(PrintWriter pw){
        this.pw = pw;
       
    }
    /**
     * method askWord() queries the user to imput a word to use to search the tree
     * @return queryWord - used to insert into tree by xref, passed back to main and to xRef
     */
    public String askWord(){
        sc = new Scanner(System.in);
        String queryWord;
        System.out.println();
        System.out.println("User may search for words to retrieve information, 'Q' to Quit");
        pw.println();
        pw.println("User may search for words to retrieve information, 'Q' to Quit");
        
        queryWord = sc.next();
        sc.close();
        return queryWord;
    }
    
}
