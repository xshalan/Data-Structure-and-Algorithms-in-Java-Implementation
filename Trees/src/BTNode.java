/*
@Author: mohammed.shalan 
@Date: 11-Aug-22
*/


import interfaces.Position;

public class BTNode<E> implements Position<E> {
    private Position<E> left,right,parent;
    private E element;

    public BTNode(E element) {
        this.element = element;
    }

    public BTNode(Position<E> parent,Position<E> left, Position<E> right, E element) {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.element = element;
    }

    public Position<E> getLeft() {
        return left;
    }

    public void setLeft(BTNode<E> left) {
        this.left = left;
    }

    public Position<E> getRight() {
        return right;
    }

    public void setRight(BTNode<E> right) {
        this.right = right;
    }

    public Position<E> getParent() {
        return parent;
    }

    public void setParent(BTNode<E> parent) {
        this.parent = parent;
    }

    public void setElement(E element) {
        this.element = element;
    }

    @Override
    public E element() {
        return element;
    }
}
