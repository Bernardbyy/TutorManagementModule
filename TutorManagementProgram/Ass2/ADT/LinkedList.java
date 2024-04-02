package ADT;

import java.util.Iterator;

public class LinkedList<T> implements ListInterface<T> {
    private Node firstNode, lastNode;
    private int numberOfElements = 0;

    @Override
    public boolean add(T newEntry) {
        Node temp = new Node(newEntry);

        if(isEmpty()){
            firstNode = temp;
            lastNode = temp;

            numberOfElements++;

        }else if(contains(newEntry)){
            return false;

        }else{
            lastNode.next = temp;
            lastNode = temp;

            numberOfElements++;
        }

        return true;
    }

    @Override
    public boolean remove(T anEntry) {
        Node currentNode = firstNode;
        Node previousNode = null;
        boolean found = false;

        while(!found && currentNode != null){
            if(anEntry.equals(currentNode.data))
                found = true;
            else{
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }

        if(found){
            if(currentNode == firstNode){
                firstNode = firstNode.next;
            }else if(currentNode == lastNode){
                lastNode = previousNode;
                lastNode.next = null;
            }else{
                previousNode.next = currentNode.next;
            }

            numberOfElements--;
        }

        return found;
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
    }

    @Override
    public T getEntry(int pos) {
        Node currentNode = firstNode;
        T returnData = null;

        if(pos >= 0 && pos < numberOfElements){
            for(int i = 0; i < pos; i++){
                currentNode = currentNode.next;
            }

            returnData = currentNode.data;
        }

        return returnData;
    }

    public T getEntry(T anEntry){
        Node currentNode = firstNode;
        T returnData = null;

        while(currentNode != null){
            if(anEntry.equals(currentNode.data)){
                returnData = currentNode.data;
                break;
            }else if(anEntry.equals(lastNode.data)){
                returnData = lastNode.data;
                break;
            }else{
                currentNode = currentNode.next;
            }
        }

        return returnData;
    }

    @Override
    public T getLast() {
        return lastNode.data;
    }

    @Override
    public boolean contains(T anEntry) {
        Node currentNode = firstNode;
        boolean found = false;

        while(!found && currentNode != null){
            if(anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        }

        return found;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public int getNoOfElement() {
        return numberOfElements;
    }

    @Override
    public Iterator<T> getIterator() {
        return new IteratorForLinkedList();
    }

    //===================PUBLIC METHODS===================
    @Override
    public String toString(){
        String str = "";
        Node currentNode = firstNode;

        while(currentNode != null){
            str +=  "\n" +currentNode.data.toString();
            currentNode = currentNode.next;
        }

        return str;
    }


    //===================PRIVATE METHODS===================
    private class IteratorForLinkedList implements Iterator<T>{

        private Node currentNode;

        public IteratorForLinkedList(){
            currentNode = firstNode;
        }   

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }


        @Override
        public T next() {
            T returnData = null;

            if(hasNext()){
                returnData = currentNode.data;
                currentNode = currentNode.next;
            }

            return returnData;
        }
    }


    private class Node{
        private T data;
        private Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }

        // public Node(T data, Node next){
        //     this.data = data;
        //     this.next = next;
        // }
    }


    @Override
    public void amend(T oldItem, T newItem) {
    }

    @Override
    public T find(T item) {
        return null;
    } 

}
