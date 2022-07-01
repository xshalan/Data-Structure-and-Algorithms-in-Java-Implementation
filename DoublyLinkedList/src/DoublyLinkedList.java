public class DoublyLinkedList {

    protected DNode head;
    protected DNode tail;
    protected int size;

    public DoublyLinkedList() {
        this.head = new DNode(null, null, null);
        this.tail = new DNode(null, head, null);
        head.setNext(tail);
        this.size = 0;
    }

    public void addAfter(String item, DNode after) {
        DNode node = new DNode(item, null, null);
        DNode temp = after.getNext();
        node.setNext(temp);
        node.setPrev(after);
        temp.setPrev(node);
        after.setNext(node);
        ++size;
    }

    public void addFirst(String item){
        addAfter(item,head);
    }
    public boolean isEmpty(){
        return size==0;
    }
    public DNode getFirst() throws IllegalArgumentException{
        if(isEmpty()) throw new IllegalArgumentException("List is empty!");
        return head.getNext();
    }
    public DNode getLast() throws IllegalArgumentException{
        if(isEmpty()) throw new IllegalArgumentException("List is empty!");
        return tail.getNext();
    }

    public int getSize() {
        return size;
    }

    public DNode getNext(DNode node){
        if(node == tail) throw new IllegalArgumentException("Cannot move next after list's tail. ");
        return node.getNext();
    }

    public DNode getPrev(DNode node){
        if(node == head) throw new IllegalArgumentException("Cannot move back past the header of the list. ");
        return node.getPrev();
    }

    public void remove(DNode node){
        DNode prevTemp = getPrev(node);
        DNode nextTemp = getNext(node);
        prevTemp.setNext(nextTemp);
        nextTemp.setPrev(prevTemp);
        node.setNext(null);
        node.setPrev(null);
        --size;
    }
}
