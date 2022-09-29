
/**
 * ObjectQueueInterface is a prototype for the ObjectQueue class
 * implemented by the ObjectQueue class
 * 
 * @author Eric Davey
 * @version Final, 4/6/2018
 */
public interface ObjectQueueInterface 
{
   public boolean isEmpty();
   public boolean isFull();
   public void clear();
   public void insert(Object o);
   public Object remove();
   public Object query();
}
