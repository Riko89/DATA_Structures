/**
 * ObjectTreeNode Class 
 */
// ObjectTreeNode.java

public class ObjectTreeNode implements ObjectTreeNodeInterface{
    private Object info;
    private ObjectTreeNode left;
    private ObjectTreeNode right;
    /**
     * ObjectTreeNode 0 arg constructor
     * intializes info, left and right instance variables to null
     */
    public ObjectTreeNode() {
        info = null;
        left = null;
        right = null;
    }

    /**
     * ObjectTreenode 1 arg constructor
     * @param Object o set to info
     * info is set to o, right and left to null
     */
    public ObjectTreeNode (Object o) {
        info = o;
        left = null;
        right = null;
    }

    /**
     * setInfo method takes in an object o and sets the info field to reference o
     * @param Object o, set to info
     */
    public void setInfo(Object o) {
        info = o;
    }

    /**
     * getInfo method returns info
     * @return Obect info
     */
    public Object getInfo() {
        return info;
    }

    /**
     * setLeft method ObjectTreeNode left is set to p
     * @param ObjectTreeNode p passed to left node
     */
    public void setLeft(ObjectTreeNode p) {
        left = p;
    }

    /**
     * getLeft method returns an Object treeNode containing left child
     * @return ObjectTreeNode left - left child
     */
    public ObjectTreeNode getLeft() {
        return left;
    }

    /**
     * setRight method ObjectTreeNode right is set to p
     * @param ObjectTreeNode p passed to right node
     */
    public void setRight(ObjectTreeNode p) {
        right = p;
    }

    /**
     * method getRight returns reference to right treeNode
     * @return ObjectTreeNode right, contains reference to right child
     */
    public ObjectTreeNode getRight() {
        return right;
    }
}

