package ADT;

import java.util.Iterator;

public interface ListInterface<T> {
    public boolean add(T newEntry);             //YY
  
    public boolean remove(T anEntry);           //YY
  
    public void clear();
  
    public T getEntry(int pos);

    public T getLast();
  
    public boolean contains(T anEntry);
  
    public boolean isEmpty();                  //YY
  
    public int getNoOfElement();
  
    public Iterator<T> getIterator();


    //YY
    public void amend(T oldItem, T newItem);    //YY
    T find(T item);                             //YY     
}
