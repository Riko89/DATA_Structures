/**
 * Clalss ObjectQueue is a dataStructure that allows any item to be brought in, casted into an object and placed in a queue
 * 
 */

public class ObjectQueue implements ObjectQueueInterface{
    private Object[] item;
    private int front;
    private int rear;
    private int count;
    /**
     * constructor for ObjectQueue
     * initializes all variables, rear to -1 (because it's 1 behind the front)
     * front to 0 and initializes item to a new Object
     */
    public ObjectQueue() {
        item = new Object[1];
        front = 0;
        rear  = -1;
        count = 0;
    }
    /**
     * boolean isEmpty() checks if the count == 0, if it is it returns true else false
     * @return boolean true or false dependant on if count is equal to 0
     */
    public boolean isEmpty() {
        return count == 0;
    }
    /**
     * isFull returns a boolean true or false
     * @reutnr boolean true or false dependant on if the count is equal to the item length(primarily used by itself)
     */
    public boolean isFull() {
        return count == item.length;
    }
    /**
     * method clear() resets the array size to 1, front to 0 rear to -1 and count to 0
     * essentially reinitiallizes all variables in the constructor class
     */
    public void clear() {
        item = new Object[1];
        front = 0;
        rear  = -1;
        count = 0;
    }
    /**
     * method insert takes in an Object o and checks if the array is full, if it is it calls the resize method, otherwise rear is set to rear +1 modulus the itemlength
     * and item indexed at read is set to o
     * increments the count.
     */
    public void insert(Object o) {
        if (isFull())
            resize(2 * item.length);
        rear = (rear+1) % item.length;
        item[rear] = o;
        ++count;
    }
    /**
     * method remove first checks if the array is empty(if it is prints an error message and exits the system
     * otherwise temp is set to the item contained at index front, front is incremented 
     * and count decremented
     * if count is eqaul to 1/4 the item length the resize method is called 
     * @return object temp (returned the object contained at the front of the queue)
     * 
     */
    public Object remove() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            System.exit(1);
        }
        Object temp = item[front];
        item[front] = null;
        front = (front+1) % item.length;
        --count;
        if (count == item.length/4 && item.length != 1)
            resize(item.length/2);
        return temp;
    }
    /**
     * method query checks the front of the queue for what is contained in it
     * @return item indexed at front (does not remove anything from the queue
     */
    public Object query() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            System.exit(1);
        }
        return item[front];
    }
    /**
     * method resize takes in an integer type size and sets the size of the object array to the value of size
     * then runs through a for loop to copy all elements of the array to a new array and reset front and rear to inital values.
     */
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i < count; ++i) {
            temp[i] = item[front];
            front = (front+1) % item.length;
        }
        front = 0;
        rear = count-1;
        item = temp;
    }
}
