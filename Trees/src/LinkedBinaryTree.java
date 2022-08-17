/*
@Author: mohammed.shalan 
@Date: 11-Aug-22
*/

import NodeBased.NodeBasedList;
import NodeBased.interfaces.PositionList;
import exceptions.EmptyTreeException;
import exceptions.InvalidPositionException;
import exceptions.NonEmptyTreeException;
import interfaces.BinaryTree;
import interfaces.Position;

import java.util.Iterator;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
    int size;
    private Position<E> root;

    public LinkedBinaryTree() {
        size = 0 ;
        root = null;
    }

    public Position<E> addRoot(E element){
        if(!isEmpty())
            throw new NonEmptyTreeException("Tree is already have root!");
        size = 1;
        root = createNode(element,null,null,null);
        return root;
    }

    public Position<E> insertLeft(Position<E> parent,E element){
        BTNode<E> node =  checkPosition(parent);
        if(node.getLeft()!=null){
            throw new InvalidPositionException("The node already has a left child!");
        }
        BTNode<E> e = createNode(element,node,null,null);
        node.setLeft(e);
        size++;
        return e;

    }


    public Position<E> insertRight(Position<E> parent,E element){
        BTNode<E> node =  checkPosition(parent);
        if(node.getRight()!=null){
            throw new InvalidPositionException("The node already has a right child!");
        }
        BTNode<E> e = createNode(element,node,null,null);
        node.setRight(e);
        size++;
        return e;

    }


    @Override
    public Position<E> left(Position<E> position) throws InvalidPositionException {
        BTNode<E> node = checkPosition(position);
        if(node.getLeft()==null)
            throw new InvalidPositionException("No left child exists.");
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> position) throws InvalidPositionException {
        BTNode<E> node = checkPosition(position);
        if(node.getRight()==null)
            throw new InvalidPositionException("No Right child exists.");
        return node.getRight();
    }

    @Override
    public boolean hasRight(Position<E> position) throws InvalidPositionException {
        BTNode<E> node = checkPosition(position);
        return node.getRight()!=null;
    }

    @Override
    public boolean hasLeft(Position<E> position) throws InvalidPositionException {
        BTNode<E> node = checkPosition(position);

        return node.getLeft()!=null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    // TODO Implement iterator
    @Override
    public Iterator<E> iterator() {
        /**
         *  Iterate through node using preOrder traversal.
         *  Instead of trying to implement the iterator itself, I'll return the result of preOrder function below which is list using pre-order traversal.
         */
        PositionList<E> allPositions = new NodeBasedList<>();
        for (Position<E> position:positions()){
            allPositions.addLast(position.element());
        }
        return allPositions.iterator();
    }


    @Override
    public Iterable<Position<E>> positions() {
        PositionList<Position<E>> list = new NodeBasedList<>();
        if(root==null)
            throw new EmptyTreeException("The tree is empty!");
        preorderPositions(root,list);
        return list;
    }

    // TODO implement replace
    @Override
    public E replace(Position<E> position, E element) throws InvalidPositionException {
        return null;
    }

    @Override
    public Position<E> root() throws EmptyTreeException {
        return root;
    }

    @Override
    public boolean isRoot(Position<E> position) throws InvalidPositionException {
        return position==root;
    }

    @Override
    public Position<E> parent(Position<E> position) throws InvalidPositionException {
        BTNode<E> node = checkPosition(position);
        if(node.getParent()==null)
            throw new InvalidPositionException("No Parent exists!");
        return node.getParent();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> position) throws InvalidPositionException {
        return null;
    }

    @Override
    public boolean isInternal(Position<E> position) throws InvalidPositionException {
        BTNode<E> node = checkPosition(position);
        return node.getLeft() != null || node.getRight() != null;
    }

    @Override
    public boolean isExternal(Position<E> position) throws InvalidPositionException {
        BTNode<E> node = checkPosition(position);
        return node.getLeft() == null && node.getRight() == null;
    }


    protected BTNode<E> checkPosition(Position<E> position) throws InvalidPositionException {
        if(position == null || !(position instanceof BTNode)){
            throw new InvalidPositionException("The position is invalid!");
        }
        return (BTNode<E>) position;
    }

    protected void preorderPositions(Position<E> root, PositionList<Position<E>> list){
        // visit root first.
        // visit left subtree.
        // visit right subtree.
        // repeat until root == null

        list.addLast(root);
        if(hasLeft(root)){
         preorderPositions(left(root),list);
        }
        if(hasRight(root)){
            preorderPositions(right(root),list);
        }

    }

    protected BTNode<E> createNode(E element,Position<E> parent,Position<E> left,Position<E> right){
        return new BTNode<E>(parent,left,right,element);
    }



}
