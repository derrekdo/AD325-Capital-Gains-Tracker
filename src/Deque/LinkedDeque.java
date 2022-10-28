package Deque;

import java.util.Iterator;
import java.util.NoSuchElementException;
import MyUtils.EmptyQueueException;

/**
 * {@inheritDoc}
 */
public class LinkedDeque<T>implements DequeInterface<T>{
    private DLNode<T> first;
    private DLNode<T> last;
    private int size;

    //default constructor
    public LinkedDeque(){
        first = null;
        last = null;
        size = 0;
    }

    public void addToFront(T newEntry) {
        //creates node containing the new entry
        DLNode<T> newNode = new DLNode<>(null, newEntry);

        //checks if the deque is empty
        if(isEmpty()){
            //front and back of deque is now newNode
            first = newNode;
            last = newNode;
        }else{
            //newNode points to the node at the front of the deque
            newNode.setNext(first);
            //makes the newNode the front of the deque
            first = newNode;
        }
        size++;
    }

    public void addToBack(T newEntry) {
        //creates node containing the new entry
        DLNode<T> newNode = new DLNode<>(last, newEntry);

        //checks if deque is empty
        if(isEmpty()){
            //front of deque becomes newNode
            first = newNode;
        }else{
            //current last node points to newNode
            last.setNext(newNode);
        }
        //makes the newNode the back of the deque
        last = newNode;
        size++;
    }

    public T removeFront() throws EmptyQueueException {
        //checks if the deque is empty
        if(isEmpty()){
            //throws an exception
            throw new EmptyQueueException("Empty Deque");
        }
        //variable containing data at front of deque
        T removed = first.getData();
        //if next node is null clears the deque
        if(first.getNext() == null){
            clear();
        }else {
            //front node now equals null
            first.setData(null);
            //first points to the next node in the deque
            first = first.getNext();
        }
        size--;
        return removed;
    }

    public T removeBack() throws EmptyQueueException {
        //checks if deque is empty
        if(isEmpty()){
            //throw exception
            throw new EmptyQueueException("Empty Deque");
        }
        //variable containing data at back of deque
        T removed = last.getData();
        //if prev node is null, clears deque
        if(last.getPrev() == null){
            clear();
        }else{
            //last points to the previous node
            last = last.getPrev();
            //makes next node null
            last.setNext(null);
        }
            size--;
        return removed;
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }

    public T getFront() throws EmptyQueueException {
        //checks if deque is empty
        if(isEmpty()){
            //throws exception
            throw new EmptyQueueException("Empty Deque");
        }
        //returns the entry at the front of the deque
        return first.getData();
    }

    public T getBack() throws EmptyQueueException {
        //checks if deque is empty
        if(isEmpty()){
            //throws exception
            throw new EmptyQueueException("Empty Deque");
        }
        //returns the last entry in the deque
        return last.getData();
    }

    public void clear() {
        //front and back of queue is now null
        first = null;
        last = null;
        size = 0;
        //garbage collection
        System.gc();
    }

    public int size(){
        return size;
    }

    public Iterator<T> iterator() {
        return new IteratorForLinkedList(first);
    }

    public Iterator<T> getIterator() {
        return iterator();
    }

    //String form of the deque
    public String toString(){
        if(isEmpty()){
            return "[]";
        }
        DLNode<T> temp = first;
        StringBuilder result = new StringBuilder("[" + temp.data);
        temp = temp.next;
        while(temp != null){
            result.append(", " + temp.data);
            temp = temp.next;
        }
        return result + "]";
    }

    private static class DLNode<T>{
        DLNode<T> prev;
        DLNode<T> next;
        T data;

        //constructors for the DLNode
        private DLNode(DLNode<T> prev, DLNode<T> next,T data){
            this.prev = prev;
            this.next = next;
            this.data = data;
        }

        private DLNode(DLNode<T> prev, T data){
            this(prev, null, data);
        }

        //Getters and setters for the current,next, and previous nodes
        public T getData(){
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public DLNode<T> getNext() {
            return next;
        }

        public void setNext(DLNode<T> next) {
            this.next = next;
        }

        public DLNode<T> getPrev() {
            return prev;
        }

        public void setPrev(DLNode<T> prev) {
            this.prev = prev;
        }

    }

    public static class IteratorForLinkedList<T> implements Iterator<T>{
        private DLNode<T> nextNode;

        public IteratorForLinkedList(DLNode<T> node){
            nextNode = node;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public T next() {
            T data;
            if(hasNext()){
                data = nextNode.getData();
                nextNode = nextNode.getNext();
            }
            else{
                throw new NoSuchElementException("Reached end of Deque");
            }

            return data;
        }

        public T current(){
            return nextNode.getData();
        }
    }
}
