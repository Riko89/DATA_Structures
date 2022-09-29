// ObjectList.java
/**
 * Class ObjectList utilizes the ObjectListNode class and has various return and 
 * get functions but its primary function is to keep and maintain pointers to a list of nodes
 * that can grow or shrink in size accordingly during runtime without bounds(other than memory)
 */
public class ObjectList implements ObjectListInterface{
    private ObjectListNode list;
    private ObjectListNode last;
    /**
     * Constructor sets last and list to null to initialize the list
     */
    // Constructs an empty list
    public ObjectList() {
        list = null;
        last = null;
    }

    /**
     * method getFirstNode() returns the reference to the begining of the list.
     * @return ObjectListNode list
     */
    // Returns the first node in the list
    public ObjectListNode getFirstNode() {
        return list;
    }

    /**
     * getLastNode method returns a reference to the last node in the list
     */
    // Returns the last node in the list
    public ObjectListNode getLastNode() {
        return last;
    }

    /**
     * getFirst method returns the object held by the first node in the list
     * @return object list.getInfo()
     */
    // Returns the first object in the list
    public Object getFirst() {
        if (list == null) {
            System.out.println("Runtime Error: getFirst()");
            System.exit(1);
        }
        return list.getInfo();
    }

    /**
     * Method getLast returns the object held by the last node in the list
     * @return object last.getInfo()
     */
    // Returns the last object in the list
    public Object getLast() {
        if (list == null) {
            System.out.println("Runtime Error: getLast()");
            System.exit(1);
        }
        return last.getInfo();
    }

    // Adds an object to the front of a list
    /**
     * addFirst method takes in an object and stores it on a ObjectListNode then sets a reference to
     * that node as the first node in the list
     * @param Object o, set to the first node in the list
     */
    public void addFirst(Object o) {
        ObjectListNode p = new ObjectListNode(o, list);
        if (list == null)
            last = p;
        list = p;
    }

    // Adds a node to the front of the list
    /**
     * method addFirst takes in a reference to an ObjectListNode and adds it to the 
     * begining of the list
     */
    public void addFirst(ObjectListNode p) {
        if (p == null) {
            System.out.println("Runtime Error: addFirst()");
            System.exit(1);
        }
        p.setNext(list);
        if (list == null)
            last = p;
        list = p;
    }

    // Adds an object to the end of the list
    /**
     * method addLast takes in an argument Object o and stores it on a node contained 
     * at the end of the list
     * @param Object o set to the last node in the list 
     */
    public void addLast(Object o) {
        ObjectListNode p = new ObjectListNode(o);
        if (list == null) 
            list = p;
        else
            last.setNext(p);
        last = p;
    }

    /**
     * method addLast takes in an argument ObjectListNode p which is 
     * set to the last node in the list
     * @param ObjectListNode p reference to a node added to the end of the list
     */
    // Adds a node to the end of the list
    public void addLast(ObjectListNode p) {
        if (p == null) {
            System.out.println("Runtime Error: addLast()");
            System.exit(1);
        }
        p.setNext(null);
        if (list == null)
            list = p;
        else
            last.setNext(p);
        last = p;
    }

    /**
     * method removeFirst() returns the object held by the first node in the list, and then
     * sets the first node in the list to null
     * @return object p.getInfo()
     */
    // Removes the first object from the list
    public Object removeFirst() {
        if (list == null) {
            System.out.println("Runtime Error: removeFirst()");
            System.exit(1);
        }
        ObjectListNode p = list;
        list = p.getNext();
        if (list == null)
            last = null;
        return p.getInfo();
    }

    // Removes the last object from the list
    /**
     * method removeLast() returns the object held by the last node in the list and 
     * then sets the last node to null and the pointer to the last node to null
     * @return Object p.getNext()
     */
    public Object removeLast() {
        if (list == null) {
            System.out.println("Runtime Error: removeLast()");
            System.exit(1);
        }
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p.getNext() != null) {
            q = p;
            p = p.getNext();
        }
        if (q == null) {
            list = null;
            last = null;
        }    
        else {
            q.setNext(null);
            last = q;
        }    
        return p.getInfo();
    }

    // Inserts an object after the node referenced by p
    /**
     * method insertAfter takes in an ObjectListNode p and and Object o and inserts p before q
     * @param ObjectListNode p, Object o insterst o into q and sets p next to q
     * 
     */
    public void insertAfter (ObjectListNode p, Object o) {
        if (list == null || p == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        ObjectListNode q = new ObjectListNode(o, p.getNext());
        p.setNext(q);
        if (q.getNext() == null)
            last = q;
    }

    // Inserts a node after the node referenced by p
    /**
     * method inserAfter takes in arguements ObjectListNode p and ObjectListNode q
     * inserts q into the list after the node referenced by p 
     * @param ObjectListNode p ObjectListNode q
     */
    public void insertAfter(ObjectListNode p, ObjectListNode q) {
        if (list == null || p == null || q == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        q.setNext(p.getNext());
        p.setNext(q);
        if (last.getNext() != null)
            last = q;
    }

    // Deletes the node after the node referenced by p
    /**
     * deleteAfter method takes in arguement p and deletes the node after the node referenced by 
     * p and sets q.next to the node referenced after p
     * @param ObjectLsitNode P 
     * @return Object q.getInfo()
     */
    public Object deleteAfter(ObjectListNode p) {
        if (list == null || p == null || p.getNext() == null) {
            System.out.println("Runtime Error: deleteAfter()");
            System.exit(1);
        }
        ObjectListNode q = p.getNext();
        p.setNext(q.getNext());
        if (p.getNext() == null)
            last = p;
        return q.getInfo();
    }

    // Inserts an item into its correct location within an ordered list
    /**
     * method insert() takes in argument Object o takes in an Object node, traverses the list 
     * comparing the Object to the object held by each node, using the compareTo function referenced
     * by the Comparable interface, if the number returned is less than the node is inserted 
     * after the node found in the while loop referenced by q
     * @param Object o type implicit argument
     */
    public void insert(Object o) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) > 0) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            addFirst(o);
        else
            insertAfter(q, o);
    }

    /**
     * method insert() takes in argument objectListNode r using the compareTo function referenced
     * by the Comparable interface, if the number returned is less than the node is inserted 
     * after the node found in the while loop referenced by q
     * @param ObjectListNode r type implicit argument
     */
    // Inserts a node into its correct location within an ordered list
    public void insert(ObjectListNode r) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null &&
        ((Comparable)r.getInfo()).compareTo(p.getInfo()) > 0) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            addFirst(r);
        else
            insertAfter(q, r);
    }

    // Removes the first occurrence of an item in a list 
    /**
     * Method remove() takes in argument Object o and finds it in the list, retrieves the 
     * node holding the information and returns it to the node holding the information that 
     * matches Object o
     * @param Object o
     * @return ObjectListNode removeFirst()  or deleteAfter(q)
     */
    public Object remove(Object o) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) !=
        0) {
            q = p;
            p = p.getNext();
        }
        if (p == null)
            return null;
        else 
            return q == null ? removeFirst() : deleteAfter(q);
    }

    // Returns true if the item is found in the list
    /**
     * method contains is a boolean method that takes in an Object o and checks if any nodes in
     * the list contain the information held using the comparable interface in any node
     * returns a boolean true or false if the list contains a node with the information
     * @param Object o
     * @return true or false
     */
    public boolean contains(Object o) {
        ObjectListNode p = list;
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) != 0)
            p = p.getNext();
        return p != null;
    }

    // Returns a reference to the node with the requested value
    // Returns null otherwise
    /**
     * Method select takes in an argument Object o and traverses the list to the find the node
     * referenced to that contains the information held in Object o and returns that node
     * @param Object o
     * @return node referenced to that contaisn's information equal to Object o, or null
     */
    public ObjectListNode select(Object o) {
        ObjectListNode p = list;
        while (p != null)
            if (((Comparable)o).compareTo(p.getInfo()) == 0)
                return p;
            else
                p = p.getNext();
        return null;
    }

    // Determines whether or not a list is empty
    /**
     * isEmpty() method is a boolean method, returns true is list is null, else returns false
     * @param true/false
     */
    public boolean isEmpty() {
        return list == null;
    }

    // Removes all elements from a list
    /**
     * method clear() sets both reference points in the list, list and last to null
     */
    public void clear() {
        list = null;
        last = null;
    }

    // Returns the number of elements in the list
    /**
     * method size() returns the size of the list by traversing the list until list is null,
     * counting the amount of times the while loop itterates
     * @return count, size of the list
     */
    public int size() {
        int count = 0;
        ObjectListNode p = list;
        while (p != null) {
            ++count;
            p = p.getNext();
        }
        return count;
    }

    // Makes a copy of a list
    /**
     * method CopyList() creates a copy of list by creating a new ObjectList class 
     * and traverses through the current list, for each itteration of the while loop
     * the a new node is created and the information held on that node is copied to the new node
     * @return null or newList, newList is a duplicate of the current list held by the class
     */
    public ObjectList copyList() {
        ObjectListNode p = null; 
        ObjectListNode q = null; // to satisfy compiler;
        ObjectListNode r = list;

        if (isEmpty())
            return null;
        ObjectList newList = new ObjectList();
        while (r != null) {
            p = new ObjectListNode(r.getInfo());
            if (newList.isEmpty())
                newList.addFirst(p);
            else
                q.setNext(p); 
            q = p;
            r = r.getNext();
        }
        newList.last = p;
        return newList;
    }

    /**
     * reverse method reverses the list in case the user needs to traverse the list backwards
     */
    // Reverses a list
    public void reverse() {
        ObjectListNode p = list;
        ObjectListNode q = null;
        ObjectListNode r;

        while (p != null) {
            r = q;
            q = p;
            p = p.getNext();
            q.setNext(r);
        }
        last = list;
        list = q;
    }   
}

