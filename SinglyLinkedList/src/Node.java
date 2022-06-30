public class Node {

    // Assuming that the elements are strings.
    private String element;
    // Next node
    private Node next;

    // Init node with element and the next node pointer
    public Node(String element, Node next) {
        this.element = element;
        this.next = next;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
