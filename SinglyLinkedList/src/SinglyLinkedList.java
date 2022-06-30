public class SinglyLinkedList {

    protected Node head;
    protected Node tail;
    protected int size; // Linked list size

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(String item) {
        tail = head;
        head = new Node(item, head);
        ++size;
    }

    public void addLast(String item) {
        Node node = new Node(item,null);
        tail.setNext(node);
        tail = node;
        ++size;
    }

    public void removeFirst(){
        if (head==null) throw new NullPointerException("Linked list doesn't have any items to delete.");
        Node temp = head;
        head = temp.getNext();
        temp.setNext(null);
        --size;
    }
}
