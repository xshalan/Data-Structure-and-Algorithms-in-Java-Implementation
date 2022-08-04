package NodeBased;
/* 
@Author: mohammed.shalan 
@Date: 03-Aug-22
*/

import NodeBased.exceptions.InvalidPositionException;
import NodeBased.interfaces.Position;

public class DNode<E> implements Position<E> {

    private DNode<E> prev,next  ;
    private  E element;

    public DNode(E element) {
        prev = null;
        next = null;
        this.element = element;
    }

    public DNode(E element,DNode<E> prev, DNode<E> next) {
        this.prev = prev;
        this.next = next;
        this.element = element;
    }

    @Override
    public E element() {
        if(prev==null && next == null)
            throw new InvalidPositionException("Position is not in the list");
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public DNode<E> getPrev() {
        return prev;
    }

    public void setPrev(DNode<E> prev) {
        this.prev = prev;
    }

    public DNode<E> getNext() {
        return next;
    }

    public void setNext(DNode<E> next) {
        this.next = next;
    }
}
