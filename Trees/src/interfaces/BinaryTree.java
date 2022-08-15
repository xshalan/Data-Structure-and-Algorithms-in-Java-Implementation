package interfaces;
/* 
@Author: mohammed.shalan 
@Date: 11-Aug-22
*/

import exceptions.InvalidPositionException;

public interface BinaryTree<E> extends Tree<E>{
    /**
     * Get the left child of node.
     * @param position The node.
     * @return position refers to the left child of the node.
     * @throws InvalidPositionException
     */
    Position<E> left(Position<E> position) throws InvalidPositionException;
    /**
     * Get the right child of node.
     * @param position The node.
     * @return position refers to the right child of the node.
     * @throws InvalidPositionException
     */
    Position<E> right(Position<E> position) throws InvalidPositionException;

    /**
     * Check if the node has right child.
     * @param position the node to check if it has right child or not.
     * @return True if the node has right child, otherwise false.
     * @throws InvalidPositionException
     */
    boolean hasRight(Position<E> position) throws InvalidPositionException;
    /**
     * Check if the node has left child.
     * @param position the node to check if it has left child or not.
     * @return True if the node has left child, otherwise false.
     * @throws InvalidPositionException
     */
    boolean hasLeft(Position<E> position) throws InvalidPositionException;
}
