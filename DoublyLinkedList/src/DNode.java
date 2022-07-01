public class DNode {
    // Assuming the list store strings
    protected String element;
    protected DNode prev;
    protected DNode next;


    public DNode(String element, DNode prev, DNode next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setPrev(DNode prev) {
        this.prev = prev;
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }
}
