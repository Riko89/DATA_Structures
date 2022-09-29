/**
 * Class Infix to postfix takes in a String containing numbers written in infix notation and 
 * returns a variable of type String written in postfix notation back to the class it was called from.
 * 
 * @author Eric Davey
 * @version Final, 03/09/2018
 */
public class InfixToPostfix
{
    private ObjectStack s;
    private String postFix;
    /**
     * Constructor InfixToPostfix() instantiates the instance variables s as type ObjectStack
     * and initializes PostFix type String as an instance variable
     */
    public InfixToPostfix()
    {
        s = new ObjectStack();
        postFix = new String();
    }

    /**
     * Public Method inToPost takes in a value of type String, then reads that string character by character 
     * (knowing to omit spaces by shifting the character read if the function encounters a space) and sending each character to
     * the function priority to be checked if the character is an operator, if it isn't (returned 0), the function assumes the character is
     * either a special character (in which case it is checked that it's not a parenthesis), and if not it appends the character to the 
     * end of the string(postFix).
     * if the character is returned anything but 0, the character is then sent to the else clause of the loop and sent to operatorHandler for 
     * handling of Operators and the stack.
     * Finally the last part of the inToPost pops the stack until empty, casting each character as type char and appending them to the end of the String
     * clears the stack for usage by the next function call it might receieve and returns the converted String to the user
     * 
     * @param    String buf type implicit param (or argument), is read into individual characters that are sent to functions
     * priority()and operatorHandler() as arguments.
     * @return   String postFix to user, String should contain a postfix version of recieved String.
     */
    public String inToPost(String buf)
    {
        postFix = "";
        for(int i = 0; i < buf.length(); i++){
            if(buf.charAt(i) == ' ')
                i++;
            if(priority(buf.charAt(i)) == 0 && buf.charAt(i) != '(' && buf.charAt(i) != ')')
                postFix += buf.charAt(i);
            else{
                operatorHandler(buf.charAt(i));               
            }
        }

        while(!s.isEmpty()){
            if((char)s.top() == '(')
                s.pop();
            else
                postFix += s.pop();
        }
        s.clear();

        return postFix;
    }

    /**
     * private method priority takes in a variable c type character as an argument and runs it in a switch case argument 
     * to check it the character is a ^ operator, * operator, / operator, + or - operator and default which is nothing, and returns a particular value for each
     * the values correspond to the priority the operator has.
     * 
     * @param char c type implicit argument, used for switch case to determine a priority if c is an operator
     * @return number value range from 0 to 3, signifies priority of operator or if not return is 0, 3 for exponents, 2 for multiplication/division, 1 for 
     * subtraction and addition.
     * 
     */
    private int priority(char c){
        switch (c)  {                        
            case '^' : return 3;
            case '*' : 
            case '/' : return 2;
            case '+' :
            case '-' : return 1;           
            default  : return 0;
        }
    }

    /**
     * private method operatorHandler takes in an argument x type char and checks it against the operator at the top of the stack, if x is a closing paren the stack is 
     * popped until a left paren is encountered, and then the left paren is popped from the stack and discarded. if the stack is not empty x is sent to priority method
     * to determine a value, if the value is less than the priority of the top of the stack AND it isn't a opening paren, the stack is popped until the value is less than
     * or equal to the value of the operator, or until the stack is empty. 
     * finally, if x is not a right paren (signifying left paren or an empty stack)
     */
    private void operatorHandler(char x){

        if(x == ')')
        {
            while((char)s.top() != '('){
                postFix += (char)s.pop();
            }
            s.pop();
        }         
        else if(!s.isEmpty()){
            if(priority(x) <= priority((char)s.top()) && x!= '('){
                while(!s.isEmpty() && priority((char)s.top()) >= priority(x) && (char)s.top() != '('){
                    postFix += (char)s.pop();
                }
            }
        }
        if(x != ')')
            s.push(x);

    }

}
