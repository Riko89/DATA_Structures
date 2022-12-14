
/**
 * Write a description of interface ObjectListInterface here.
 * 
 * @author Eric Davey
 * @version 5/18/2018
 */
public interface ObjectListInterface
{
   public ObjectListNode getFirstNode();
   public ObjectListNode getLastNode();
   public Object getFirst();
   public Object getLast();
   public void addFirst(Object o);
   public void addFirst(ObjectListNode p);
   public void addLast(Object o);
   public void addLast(ObjectListNode p);
   public Object removeFirst();
   public Object removeLast();
   public void insertAfter(ObjectListNode p, Object o);
   public void insertAfter(ObjectListNode p, ObjectListNode q);
   public Object deleteAfter(ObjectListNode p);
   public void insert(Object o);
   public void insert(ObjectListNode r);
   public Object remove(Object o);
   public boolean contains(Object o);
   public ObjectListNode select(Object o);
   public boolean isEmpty();
   public void clear();
   public int size();
   public ObjectList copyList();
   public void reverse();
}
