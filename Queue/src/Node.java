/*
@Author: mohammed.shalan 
@Date: 18-Jul-22
*/

public class Node<T> {
    private T element;
    private Node<T> next;
    private Node<T> prev;

    public Node(T element) {
        this.element = element;
        next = null;
        prev = null;
    }

    public Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}
