package interfaces;
/* 
@Author: mohammed.shalan 
@Date: 10-Aug-22
*/

import exceptions.EmptyTreeException;
import exceptions.InvalidPositionException;

import java.util.Iterator;

public interface Tree<E> extends Iterable<E> {
    /**
     *
     * @return number of nodes in the tree.
     */
    int size();

    /**
     *
     * @return true if the tree is empty, otherwise false.
     */
    boolean isEmpty();

    /**
     *
     * @return an iterator of the nodes stored in the tree.
     */
    Iterator<E> iterator();

    /**
     *
     * @return an iterable collection of the nodes.
     */
    Iterable<Position<E>> positions();

    /**
     * Replace the element at specific position with another element.
     * @param position The position where the element will be replaced.
     * @param element the new element.
     * @return The old element at that position.
     * @throws InvalidPositionException
     */
    E replace(Position<E> position,E element) throws InvalidPositionException;

    /**
     * get the root of the tree
     * @return position that refers to root
     * @throws EmptyTreeException
     */
    Position<E> root() throws EmptyTreeException;


    /**
     * Check whether the node is a root node or not.
     * @param position position of the node.
     * @return true if the node is root, otherwise false.
     * @throws InvalidPositionException
     */
    boolean isRoot(Position<E> position) throws InvalidPositionException;

    /**
     * get the parent of specific node.
     * @return position that refers to the parent of the node.
     * @throws InvalidPositionException
     */
    Position<E> parent(Position<E> position) throws InvalidPositionException;

    /**
     * get the children of specific node.
     * @return iterable collection of the children of the node.
     * @throws InvalidPositionException
     */
    Iterable<Position<E>> children(Position<E> position) throws InvalidPositionException;

    /**
     * Check if the node is internal. node is internal if has one or more than children
     * @param position the position of the node.
     * @return true if the node is internal, otherwise false.
     * @throws InvalidPositionException
     */
    boolean isInternal(Position<E> position) throws InvalidPositionException;
    /**
     * Check if the node is external. node is external if has no children
     * @param position the position of the node.
     * @return true if the node is external, otherwise false.
     * @throws InvalidPositionException
     */
    boolean isExternal(Position<E> position) throws InvalidPositionException;
}
