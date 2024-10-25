/**
 * This class initialize Nodes for a double linked list.
 */
public class Node<E> {
    Node<E> next;
    Node<E> prev;
    E val;

    /**
     * Constructor.
     *
     * @param val An element to be stored in a Node
     */
    public Node(E val) {
        next = null;
        prev = null;
        this.val = val;
    }
}
