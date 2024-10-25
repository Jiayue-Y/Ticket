/**
 * This program is a Generic Queue with implementation of Linked List.
 *
 * @author Jiayue Yang
 * @version 1.0
 */
public class Queue<E> {

    private Node<E> head; //The front of the list
    private Node<E> tail; //The back of the list

    /**
     * Constructor.
     */
    public Queue() {
        head = null;
        tail = null;
    }

    /**
     * Deep copy one double linked list to another.
     *
     * @return the cloned list.
     */
    public Queue<E> copy() {
        Queue<E> copy = new Queue<>();
        Node<E> temp = head;
        while (temp!= null) {
            copy.enqueue(temp.val);
            temp = temp.next;
        }
        return copy;
    }

    /**
     * Determine if the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean empty() {return head == null;}

    /**
     * Returns the head of the Queue.
     *
     * @return the head Node of the linked list.
     */
    public Node<E> getHead() {return head;}

    /**
     * Get the size of the queue.
     *
     * @return integer of the size of the list.
     */
    public int getSize() {
        Node<E> temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * Return the head of the list and remove it, set the next node to be the
     * new head.
     *
     * @return The element in the head of the list.
     */
    public E dequeue(){
        if (empty())
            throw new IllegalArgumentException("Queue is empty");
        Node<E> temp = head;
        if(temp.next != null) {
            head = head.next;
            head.prev = null;
        }
        else head = null;
        return temp.val;
    }

    /**
     * Add the input element as a Node to the end of the list
     *
     * @param input element to be added to the end of the list
     */
    public void enqueue(E input){
        if(empty()){
            tail = new Node<>(input);
            head = tail;
        }
        else {
            tail.next = new Node<>(input);
            tail = tail.next;
        }
    }

    /**
     * Return the value at the head of the queue
     *
     * @return value of the head Node
     */
    public E peek(){
        if(empty())
            throw new IllegalArgumentException("Queue is empty");
        return head.val;
    }

    /**
     * Add a list to the end of another list.
     *
     * @param newTail the list to be added to another list
     */
    public void append(Queue<E> newTail){
        Queue<E> newTailCopy = newTail.copy();
        if(empty()){
            head = newTailCopy.head;
        }
        else {
            tail.next = newTailCopy.head;
            newTailCopy.head.prev = tail;
        }
        tail = newTailCopy.tail;
    }

    /**
     * A toString method for the double linked list.
     *
     * @return A String with all elements stored in the list in order with a
     * String between each element.
     */
    public String toString() {
        StringBuilder output = new StringBuilder();
        Node<E> temp = head;
        while (temp != null) {
            output.append(temp.val).append(" ");
            temp = temp.next;
        }
        return output.toString();
    }
}
