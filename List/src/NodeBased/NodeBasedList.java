package NodeBased;
/* 
@Author: mohammed.shalan 
@Date: 31-Jul-22
*/

import NodeBased.exceptions.EmptyListException;
import NodeBased.exceptions.InvalidPositionException;
import NodeBased.interfaces.Position;
import NodeBased.interfaces.PositionList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeBasedList<E> implements PositionList<E> {
    private DNode head,tail;
    private int size;

    public NodeBasedList() {
        head = new DNode(null,null,null);
        tail = new DNode(null,head,null);
        head.setNext(tail);
        size = 0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public DNode<E> getFirst() {
        if(isEmpty())
            throw new EmptyListException("The list is empty.");
        return head.getNext();
    }

    @Override
    public DNode<E> getLast() {
        if(isEmpty())
            throw new EmptyListException("The list is empty.");
        return tail.getPrev();
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        DNode<E> node = checkPosition(p);
        if(node.getPrev()==head)
            return null;
//            throw new InvalidPositionException("Cannot advance past the beginning of the list.");
        return node.getPrev();
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        DNode<E> node = checkPosition(p);
        if(node.getNext()==tail)
            throw new InvalidPositionException("Cannot advance past the beginning of the list.");
        return node.getNext();
    }

    @Override
    public Position<E> addFirst(E e) {
        DNode<E> node = new DNode<>(e);
        node.setPrev(head);
        node.setNext(head.getNext());
        head.getNext().setPrev(node);
        head.setNext(node);

        size++;
        return node;
    }

    @Override
    public Position<E> addLast(E e) {
        DNode<E> node = new DNode<>(e);
        node.setNext(tail);
        node.setPrev(tail.getPrev());
        tail.getPrev().setNext(node);
        tail.setPrev(node);

        size++;
        return node;
    }

    @Override
    public DNode<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        DNode<E> position = checkPosition(p);
        DNode<E> node = new DNode<>(e);
        node.setNext(position);
        node.setPrev(position.getPrev());
        position.getPrev().setNext(node);
        position.setPrev(node);

        size++;
        return node;
    }

    @Override
    public DNode<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        DNode<E> position = checkPosition(p);
        DNode<E> node = new DNode<>(e);
        node.setPrev(position);
        node.setNext(position.getNext());
        position.getNext().setPrev(node);
        position.setNext(node);

        size++;
        return node;
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        DNode<E> position = checkPosition(p);
        E temp = position.element();
        position.setElement(e);
        return temp;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        DNode<E> position = checkPosition(p);
        DNode<E> next = position.getNext();
        DNode<E> prev = position.getPrev();
        next.setPrev(prev);
        prev.setNext(next);
        E temp  = position.element();
        position.setElement(null);
        position.setPrev(null);
        position.setNext(null);
        size--;
        return temp;
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return new ElementIterator<>(this);
    }

    private DNode<E> checkPosition(Position<E> position){
        // [head] --> POSITION <-- [tail]
        if (position==null)
            throw new InvalidPositionException("The position is null.");
        if (position==head)
            throw new InvalidPositionException("The head node cannot be position.");
        if (position==tail)
            throw new InvalidPositionException("The tail node cannot be position.");
        try{
            DNode<E> node = (DNode<E>) position;
            if(node.getNext()==null || node.getPrev()==null)
                throw new InvalidPositionException("Position is not belong to the list.");
            return node;
        }catch (ClassCastException exception){
            throw new InvalidPositionException("Position is a wrong type for the list.");
        }
    }

    private class ElementIterator<E> implements Iterator<Position<E>>{
        PositionList<E> list; // the list itself
        Position<E> cursor; // represents the NODE

        public ElementIterator(PositionList<E> list) {
            this.list = list;
            cursor = (!list.isEmpty())? list.getFirst() : null;
        }

        @Override
        public boolean hasNext() {
            return cursor!=null;
        }

        @Override
        public Position<E> next() {
            if(cursor==null)
                throw new NoSuchElementException("There is no next element");
            Position<E> temp = cursor;
            cursor = (cursor==getLast()) ? null : list.after(cursor);
            return temp ;
        }

    }
}
