
/**
 * Write a description of interface ObjectListNodeInterface here.
 * 
 * @author Eric Davey
 * @version 5/18/2018
 */
public interface ObjectListNodeInterface
{
    public void setInfo(Object o);
    public Object getInfo();
    public void setNext(ObjectListNode p);
    public ObjectListNode getNext();
}