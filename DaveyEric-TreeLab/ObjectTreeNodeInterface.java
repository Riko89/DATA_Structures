
/**
 * ObjectTreeNodeInterface
 * 
 * @author Eric Davey 
 * @version 5/18/2018
 */
public interface ObjectTreeNodeInterface
{
    public void setInfo(Object o);
    public Object getInfo();
    public void setLeft(ObjectTreeNode p);
    public ObjectTreeNode getLeft();
    public void setRight(ObjectTreeNode p);
    public ObjectTreeNode getRight();
}
