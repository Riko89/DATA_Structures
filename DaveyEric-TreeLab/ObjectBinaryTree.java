/**
 * ObjectBinaryTree class
 */
// ObjectBinaryTree.java

public class ObjectBinaryTree implements ObjectBinaryTreeInterface{
    private ObjectTreeNode root;
    /**
     * ObjectBinaryTree constructor, intializes root to null
     */
    public ObjectBinaryTree() {
        root = null;
    }

    /**
     * getRoot method returns ObjectTreeNode root - the root of the tree
     * @return root tree root ObjectTreeNode
     */
    public ObjectTreeNode getRoot() {
        return root;
    }

    /**
     * setLeftChild method sets the child of the current node select to r
     * @param ObjectTreeNode parent reference for parent node, ObjectTreeNode r, 
     * set as left child
     */
    public void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r) {
        if (parent == null || parent.getLeft() != null) {
            System.out.println("Runtime Error: setLeftChild()");
            System.exit(1);
        }
        parent.setLeft(r);
    }

    /** setRightChild method sets the child of the current node select to r
     * @param ObjectTreeNode parent reference for parent node, ObjectTreeNode r, 
     * set as right child
     */
    public void setRightChild(ObjectTreeNode parent, ObjectTreeNode r){
        if (parent == null || parent.getRight() != null) {
            System.out.println("Runtime Error: setRightChild()");
            System.exit(1);
        }
        parent.setRight(r);
    }

    /**
     * insertBST takes in object o, inserts it into a treeNode and traverses the tree 
     * invoking getLeft or getLeft depending on the integer value returned by the TreeComparable
     * compareTo method, when q is null, r is passed to setLeftChild with q p as the lag pointer
     * being the parent
     * @param Object o - inserted into an ObjectTreeNode then inserted into tree
     * @param ObjectTreeNode p and r, passed to setLeftChild or setRightChild
     */
    public void insertBST(Object o) {
        ObjectTreeNode p, q;

        ObjectTreeNode r = new ObjectTreeNode(o);
        if (root == null)
            root = r;
        else {
            p = root;
            q = root;
            while (q != null) {
                p = q;
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0 )
                    q = p.getLeft();
                else
                    q = p.getRight();
            }
            if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                setLeftChild(p, r);
            else
                setRightChild(p, r);
        }
    }

    /**
     * method insertBstDUP is identical to insertBST with the exception that 
     * a third comparison is made to check for 0 , if the compareTo method returns 0, the operate
     * method defined in TreeComarable is called
     * @param Object o, inserted into an ObjectTreeNode and inserted into BST
     * 
     */
    public void insertBSTDup(Object o) {
        ObjectTreeNode p, q;

        ObjectTreeNode r = new ObjectTreeNode(o);
        if (root == null)
            root = r;
        else {
            p = root;
            q = root;
            while (q != null && ((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) != 0) {
                p = q;
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                    q = p.getLeft();
                else
                    q = p.getRight();
            }
            if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                setLeftChild(p, r);
            else if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) > 0)
                setRightChild(p, r);
            else ((TreeComparable)(p.getInfo())).operate((TreeComparable)(r.getInfo()));
        }
    }

    /**
     * searchBST traverses the tree in the same way as insertBST and insertBSTDup use
     * with the exception that there is no intent to insert the object into the Tree
     * instead, comparisons are made to find a node containing the information asked for by the user
     * @param Object o, used to search BST by inserting into an ObjectTreeNode r
     * @return ObjectTreeNode p, or null
     */
    public ObjectTreeNode searchBST(Object o) {
        ObjectTreeNode p;

        ObjectTreeNode r = new ObjectTreeNode(o);
        if(root != null) {
            p = root;
            while (p != null) {
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                    p = p.getLeft();
                else if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) > 0)
                    p = p.getRight();
                else 
                    return p;
            }
        }
        return null;
    }

    /**
     * method preTrav recursively calls itself until ObjectTreeNode is referencing null
     * for everyNode passed to itself, the TreeComparable method visit() is invoked
     * this is a preorder Traversal of the tree
     * @param ObjectTreeNode 
     */
    public void preTrav(ObjectTreeNode tree) {
        if (tree != null) {
            ((TreeComparable)tree.getInfo()).visit();
            preTrav(tree.getLeft());
            preTrav(tree.getRight());
        }
    }

    /**
     * method inTrav recursively calls itself until ObjectTreeNode is referencing null
     * for everyNode passed to itself, the TreeComparable method visit() is invoked
     * this is a inorder Traversal of the tree
     * @param ObjectTreeNode 
     */
    public void inTrav(ObjectTreeNode tree) {
        if (tree != null) {
            inTrav(tree.getLeft());
            ((TreeComparable)tree.getInfo()).visit();
            inTrav(tree.getRight());
        }
    }

    /**
     * method postTrav recursively calls itself until ObjectTreeNode is referencing null
     * for everyNode passed to itself, the TreeComparable method visit() is invoked
     * this is a post order Traversal of the tree
     * @param ObjectTreeNode 
     */
    public void postTrav(ObjectTreeNode tree) {
        if (tree != null) {
            postTrav(tree.getLeft());
            postTrav(tree.getRight());
            ((TreeComparable)tree.getInfo()).visit();
        }
    }

    /**
     * method delete takes in an Object o, 
     * inserts that object into a ObjectTreeNode and traverses the tree until the node is found 
     * if the node is found the node is removed by the tree, and the tree is reorganized to fill
     * in the null spot now found, many different situations arise and are handled by the method
     * involving the nodes position in the tree.
     * @param Object o - reference to Object user wants deleted from the tree.
     */
    public void delete(Object o) {
        ObjectTreeNode s, t, v;
        boolean found = false;

        ObjectTreeNode r = new ObjectTreeNode(o);
        ObjectTreeNode p = root;
        ObjectTreeNode q = null;
        // Search for the node with info key, set p to point to 
        //that node and set q to point to its parent, if any.
        while (p != null && !found) {
            if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) == 0)
                found = true;
            else {
                q = p;
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                    p = p.getLeft();
                else
                    p = p.getRight();
            }
        }
        if (found) {
            // Set v to point to the node that will replace the node 
            // that p points to.
            if (p.getLeft() == null)
                v = p.getRight();
            else if (p.getRight() == null)
                v = p.getLeft();
            else {
                // the node that p points to has two children;
                // set v to the inorder successor of p;
                // set t to the parent of v
                t = p;
                v = p.getRight();
                s = v.getLeft();  // s is the left child of v
                while (s != null) {
                    t = v;
                    v = s;
                    s = v.getLeft();
                }
                // At this point, v is the inorder successor of p
                if (t != p) {
                    // p is not the parent of v and v = t.getLeft()
                    t.setLeft(v.getRight());
                    // Remove the node that v points to from its
                    // current position to take the place of the 
                    // node that p points to.
                    v.setRight(p.getRight());
                }
                v.setLeft(p.getLeft());
            }
            // Insert the node that v points to into the position
            // formally occupied by the node that p points to
            if (q == null)
            // The node that p points to was the root of the tree
                root = v;
            else if (p == q.getLeft())
                q.setLeft(v);
            else q.setRight(v);
        }
    }
}