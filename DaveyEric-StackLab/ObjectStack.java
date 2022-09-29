/**
 *  ObjectStack class simulates a stack datatype using Arrays, an arguement an item is passed to
 *  the class which then casts it into an array of objects, this gives it the versatility of maintaining
 *  multiple datatypes in one array stack.
 *  
 *  @author Eric Davey
 *  @version Final 3/9/2018
 */

public class ObjectStack implements ObjectStackInterface{
    private Object[] item; // object item is the stack 
    private int top; // top is the index for the top of the stack
    /**
     * constructor ObjectStack() initializes item as an Object array and 
     * top at -1 to be the starting index of the top of the stack
     */
    public ObjectStack() {
        item = new Object[1];
        top = -1;
    }
    /**
     * method isEmpty() returns a true or false value to indicate whether or not the 
     * stack is empty or not, if top contains an integer value or -1 return true, else false.
     * @return boolean value true or false if top contains an integer value equal to -1.
     */
    public boolean isEmpty() {
        return top == -1;
    }
    /**
     * method isFull() returns a boolean value if top is equal to the length of the stack-1 
     * 
     * @return boolean value true or false if top contains an integer value equal to the length
     * of the stack -1.
     */
    public boolean isFull() {
        return top == item.length-1;
    }
    /**
     * method clear() initializes item as an Object array[1] and resets top back to the starting
     * position of the bottom of the stack(-1)
     */
    public void clear() {
        item = new Object[1];
        top = -1;
    }
    /**
     * method push() takes in an object o as a parameter, checks if the stack is full by calling
     * isFull(), if it is full the array is resized by calling resize and passing argument 2*
     * the length of the current array.
     * then increments top setting that position in the array to object o.
     * 
     * @param Object o, type implicit, set as the top'th item in the array item.
     * ,2 * item.length passed to resize as explicit argument
     */
    public void push(Object o) {
        if (isFull())
            resize(2 * item.length);
        item[++top] = o;
    }
    /**
     * method resize() takes in variables size as an argument, instantiates a new object array temp 
     * of size size, itterates through the array with index i untill i is equal to top
     * copying objects in item to temp, then sets item to temp as a newly resized array with double
     *  the size.
     *  
     *  @param int size type implicit, used to determine the new size of item[]
     */
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i <= top; i++)
            temp[i] = item[i];
        item = temp;
    }  
    /**
     * method pop() returns the object placed at the top of the array item[]
     * first the method checks if the stack is empty, if it is then pop has been called incorrectly 
     * and it exits the program, else an object temp is created and set equal to the value stored 
     * at item indexed at top, and sets item at top to null before decrementing top.
     * then checks if top is equal to item.length divided by 4, then resize the length of the array by
     * 2, 
     * 
     * @return object temp to user, assumed user will cast into wanted data type when recieved 
     */
    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow.");
            System.exit(1);
        }
        Object temp = item[top];
        item[top--] = null;
        if (top == item.length/4)
            resize(item.length/2);
        return temp;
    }
    /**
     * method top() returns the object stored at the top of the stack, without moving the index
     * or getting rid of the item stored in top.
     * @return item[top] object, does not decrement or increment top.
     */
    public Object top() {
        if (isEmpty()) {
            System.out.println("Stack Underflow.");
            System.exit(1);
        }    
        return item[top];
    }
}
