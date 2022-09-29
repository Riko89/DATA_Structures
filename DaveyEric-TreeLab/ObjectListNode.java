// ObjectListNode.java
/**
 * Class ObjectListNode is an Object class that contains an info field for holding an Object
 * and a next field for holding a referenced to the next node
 * 
 */
public class ObjectListNode {
    private Object info;
    private ObjectListNode next;
    // Default ctor    
    /**
     * default constructor, ObjectListNode()
     * sets info to null and next to null
     */
    public ObjectListNode() {
        info = null;
        next = null;
    }

    // One-arg ctor
    /**
     * one argument constructor takes in Objectnode and sets the info field to Object o
     * @param Object o
     */
    public ObjectListNode (Object o) {
        info = o;
        next = null;
    }    
    
    // Two-arg ctor
    /**
     * 2 argument constructor takes in an Object and a Node, sets the info field on the node
     * held in this class to Object o and the next field to the Argument taken in by the function
     * ObjectListNode p
     */
    public ObjectListNode (Object o, ObjectListNode p) {
        info = o;
        next = p;
    }       

    // Sets info field
    /**
     * setInfo() method takes in Object o and sets the info field held by node to o
     * @param Object o
     */
    public void setInfo(Object o) {
        info = o;
    }    

    // Returns object in info field
    /**
     * getInfo() method returns the object held by info
     * @return Object info
     */
    public Object getInfo() {
        return info;
    }

    // Sets next field
    /**
     * setNext() method takes in argument ObjectListNode p and sets 
     * next to p
     * @param ObjectListNode p set next top
     */
    public void setNext(ObjectListNode p) {
        next = p;
    }

    // Returns object in info field
    /**
     * getNext returns the next node referenced in the class
     * @return ObjectListNode next
     */
    public ObjectListNode getNext() {
        return next;
    }
}