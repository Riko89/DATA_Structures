
/**
 * Class EvalPostfix takes a variable postFix type String and checks each character in the read method,
 * passing each character to either operators or operands function depending on the value.
 * if it goes to the operand it is pushed onto the stack, if it enounters an operator it pops the 
 * top two operands from the stack and applies the operator to it. until it reaches the end of the
 * string, then returns the string to the user.
 * 
 * 
 * @author Eric Davey 
 * @version Final 3/08/2018
 */
public class EvalPostfix
{
    private ObjectStack s1;
    /**
     * Constructor EvalPostfix() instantiates the variable s1 as a type ObjectStack.
     */
    public EvalPostfix()
    {
        s1 = new ObjectStack();
    }

    /**
     * method read takes in a string variable postFix as a parameter and takes each character one by 
     * one from the string and checks to see if they're a operator or an operand, if an operator
     * it's sent to the top of the stack, else operands are sent to the method operands to be 
     * executed.
     * 
     * @param  String postFix type implicit, takes as a param and is read into characters which 
     * are sent to operators() and operands() as arguments to be handled
     * @return   a casted integer of whatever value is left on the top of the ObjectStack.  
     */

    public int read(String postFix)
    {
        for(int i = 0; i < postFix.length(); i++){
            if((int)postFix.charAt(i) < 48 || (int)postFix.charAt(i) > 90){
                operators(postFix.charAt(i));
            }

            else
            {
                operands(postFix.charAt(i));
            }
        }
        return (int)s1.pop();
    }
    /**
     *method operators() takes in a variable x type char and sends it to a switch to be checked
     *for what type of operator it is. e.g. if it's division the division method is
     *executed once, if it's subtraction the subtraction method is executed once.
     *@param char x type implicit, used in switch case to determine which method to call
     */
    
    private void operators(char x){
        switch (x) {
            case '^' : powerOf();
            break;
            case '*' : multiplication();
            break;
            case '/' : division();
            break;
            case '+' : addition();
            break;
            case '-' : subtraction();
            break;
            default  : System.out.println("error");   // aslkdfjsa;glkj
            break;
        }
    }
    /**
     * method subtraction() pop's the stack two times, assigning the first pop to
     * num2, and the second to num1, then pushes num1 - num2 onto the stack
     * @param   num1, num2 data type int, passed to s1.push() as explicit arguments 
     */
    public void subtraction(){
        int num2 = (int)s1.pop();
        int num1 = (int)s1.pop();
        s1.push(num1 - num2);
    }
      /**
     * method addition() pop's the stack two times, assigning the first pop to
     * num2, and the second to num1, then pushes num1 + num2 onto the stack
     * @param   num1, num2 data type int, passed to s1.push() as explicit arguments 
     */
    public void addition(){
        int num2 = (int)s1.pop();
        int num1 = (int)s1.pop();
        s1.push(num1 + num2);
    }
      /**
     * method multiplication() pop's the stack two times, assigning the first pop to
     * num2, and the second to num1, then pushes num1 * num2 onto the stack
     * @param   num1, num2 data type int, passed to s1.push() as explicit arguments 
     */
    public void multiplication(){
        int num2 = (int)s1.pop();
        int num1 = (int)s1.pop();
        s1.push(num1 * num2);
    }
      /**
     * method division pop's the stack two times, assigning the first pop to
     * num2, and the second to num1, then pushes num1 / num2 onto the stack
     * @param   num1, num2 data type int, passed to s1.push() as explicit arguments 
     */
    public void division(){
        int num2 = (int)s1.pop();
        int num1 = (int)s1.pop();
        s1.push(num1/num2);
    }
      /**
     * method powerOf() pop's the stack two times, assigning the first pop to
     * num2, and the second to num1, then pushes num1 to the power of num2 onto the stack
     * @param   num1, num2 data type int, passed to s1.push() as explicit arguments 
     */
    public void powerOf(){
        int num2 = (int)s1.pop();
        int num1 = (int)s1.pop();
        s1.push((int)Math.pow(num1, num2));
    }
      /**
       * method operands() takes in a parameter char x and pushes it onto the stack after casting
       * it to an integer and subtracting 48 to attain it's real integer value.
       * @param char x type implicit, passed to push as an argument
       */
    public void operands(char x){
        s1.push((int)x - 48);
    }
}
