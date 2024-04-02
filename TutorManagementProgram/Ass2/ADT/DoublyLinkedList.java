package ADT;

import Control.FilterCriteriaInterface;
import java.util.Iterator;

public class DoublyLinkedList<T> implements ListInterface<T>,Iterable<T> {
    
    // Internal Node class (Entity)
    private class Node {
        T data;
        Node next;
        Node prev;
        
        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // Constructor (Control)
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }    

    @Override
    // Add method (Control)
    public boolean add(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return true;
        } else {
            tail.next = newNode; 
            newNode.prev = tail; 
            tail = newNode; 
            size++;
            return true;
        }
    }
    
    @Override
    // Remove method (Control)
    public boolean remove(T item) {
        Node forward = head;
        Node backward = tail;
        
        while (forward != null && backward != null) {
            
            // Check from the start
            if (forward.data.equals(item)) {
                if (forward.prev != null) {
                    forward.prev.next = forward.next;
                } else {
                    head = forward.next;
                }
                if (forward.next != null) {
                    forward.next.prev = forward.prev;
                } else {
                    tail = forward.prev;
                }
                size--;
                return true;
            }
            
            // Check from the end
            if (backward.data.equals(item)) {
                if (backward.prev != null) {
                    backward.prev.next = backward.next;
                } else {
                    head = backward.next;
                }
                if (backward.next != null) {
                    backward.next.prev = backward.prev;
                } else {
                    tail = backward.prev;
                }
                size--;
                return true;
            }
            
            // Move the pointers
            forward = forward.next;
            backward = backward.prev;
        }
        return false;
    }
    
    @Override
    // Find method (Control)
    public T find(T item) {
        Node forward = head;
        Node backward = tail;
        
        while (forward != null && backward != null) {
            
            // Check the node from the start of the list
            if (forward.data.equals(item)) {
                return forward.data;
            }
    
            // Check the node from the end of the list
            if (backward.data.equals(item)) {
                return backward.data;
            }
            
            forward = forward.next;
            backward = backward.prev;
        }
        
        return null;
    }

    @Override
    // Amend method (Control) with double-ended search
    public void amend(T oldItem, T newItem) {
        Node forwardTemp = head;
        Node backwardTemp = tail;
        while (forwardTemp != null && backwardTemp != null) {
            // Check from the start (head)
            if (forwardTemp.data.equals(oldItem)) {
                forwardTemp.data = newItem;
                return;
            }
            // Check from the end (tail)
            if (backwardTemp.data.equals(oldItem)) {
                backwardTemp.data = newItem;
                return;
            }
            forwardTemp = forwardTemp.next;
            backwardTemp = backwardTemp.prev;
        }
}
    
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
                return null;
            }
        };
    }

    // Filter method (Control)
    public void filter(FilterCriteriaInterface<T> criteria) {
        Node temp = head;
        while (temp != null) {
            if (!criteria.filter(temp.data)) {
                remove(temp.data);
            }
            temp = temp.next;
        }
    }

    //Methods for sorting
    public int getSize() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        
        Node current = head;
        int count = 0;
        
        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        
        return null;
    }

    public void swap(int index1, int index2) {
        if (index1 == index2) return;
        
        Node node1 = getNodeAt(index1);
        Node node2 = getNodeAt(index2);
        
        if (node1 == null || node2 == null) return;
        
        T temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }
    
    private Node getNodeAt(int index) {
        if (index < 0 || index >= size) return null;
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        
        return current;
    }
    
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                current.data = element;
                return;
            }
            count++;
            current = current.next;
        }
    }
    
    public void addLast(T element) {
        Node newNode = new Node(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public DoublyLinkedList<T> deepCopy() {
        DoublyLinkedList<T> newList = new DoublyLinkedList<>();
        Node current = head;
        while (current != null) {
            newList.addLast(current.data);
            current = current.next;
        }
        return newList;
    }

    public String toString(){
        String str = "";
        Node currentNode = head;

        while(currentNode != null){
            str +=  "\n" +currentNode.data.toString();
            currentNode = currentNode.next;
        }

        return str;
    }



    // MF methods
    @Override
    public void clear() {
    }

    @Override
    public T getEntry(int pos) {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public int getNoOfElement() {
        return 0 ;
    }

    @Override
    public Iterator<T> getIterator() {
        return null;
    }
    
}
