import NodeBased.NodeBasedList;
import NodeBased.interfaces.PositionList;
import exceptions.InvalidPositionException;
import interfaces.BinaryTree;
import interfaces.Position;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/* 
@Author: mohammed.shalan 
@Date: 15-Aug-22
*/

public class LinkedBinaryTreeTest {

    LinkedBinaryTree<String> cities;
    PositionList<Position<String>> treeList;
    @Before
    public void setup(){
        cities = new LinkedBinaryTree<>();
        treeList = new NodeBasedList<>();
    }
    private String printTree(){
        String str = "";
        for (Position<String> item:treeList){
            str += (item.element());
            str +=",";
        }
        return str;
    }
    @Test
    public void createTreeWithOnlyRoot() {
        cities.addRoot("Africa");

        assertEquals("Africa",cities.root().element());
    }

    @Test
    public void preOrderTraversalThroughTree() {
        Position<String> root = cities.addRoot("root");
        Position<String> rightNode = cities.insertRight(root,"rightNode");
        Position<String> leftNode = cities.insertLeft(root,"leftNode");
        cities.preorderPositions(root,treeList);
        assertEquals("root,leftNode,rightNode,",printTree());
    }

    @Test
    public void addRightNodeToTheRoot() {
        BTNode<String> root = (BTNode<String>) cities.addRoot("Africa");
        Position<String> egypt = cities.insertRight(cities.root(),"Egypt");
        assertEquals("Egypt",root.getRight().element());
    }

    @Test
    public void createTreeWithRootLeftRightNodes() {
        /**
         *                   Africa
         *                     |
         *          |Libya|            |Egypt|
         *           L|R                 L|R
         * |Tarablus | NULL         NULL  |  |Cairo|
         */
        BTNode<String> root = (BTNode<String>) cities.addRoot("Africa");
        BTNode<String> egypt = (BTNode<String>) cities.insertRight(cities.root(),"Egypt");
        BTNode<String> libya = (BTNode<String>) cities.insertLeft(cities.root(),"Libya");
        BTNode<String> tarablus = (BTNode<String>) cities.insertLeft(libya,"Tarablus");
        BTNode<String> cairo = (BTNode<String>) cities.insertRight(egypt,"Cairo");

        assertEquals("Egypt",root.getRight().element());
        assertEquals("Libya",root.getLeft().element());
        assertEquals("Cairo",egypt.getRight().element());
        assertEquals("Tarablus",libya.getLeft().element());
        assertNull(libya.getRight());
        assertNull(egypt.getLeft());
    }

    @Test
    public void createTreeWithNodesToTestIterable() {
        /**
         *                   Africa
         *                     |
         *          |Libya|            |Egypt|
         *           L|R                 L|R
         * |Tarablus | NULL         NULL  |  |Cairo|
         */
        BTNode<String> root = (BTNode<String>) cities.addRoot("Africa");
        BTNode<String> egypt = (BTNode<String>) cities.insertRight(cities.root(),"Egypt");
        BTNode<String> libya = (BTNode<String>) cities.insertLeft(cities.root(),"Libya");
        cities.insertLeft(libya,"Tarablus");
        cities.insertRight(egypt,"Cairo");
        cities.preorderPositions(root,treeList);
        String expected = "Africa,Libya,Tarablus,Egypt,Cairo,";
        assertEquals(expected,printTree());
        for(Position<String> position: cities.positions()){
            System.out.println(position.element());
        }

    }

    @Test(expected = InvalidPositionException.class)
    public void createTreeWithMoreThanTwoNodesToTestException() {
        BTNode<String> root = (BTNode<String>) cities.addRoot("root");
        cities.insertRight(cities.root(),"Right");
        cities.insertRight(cities.root(),"Left");
        // Trying to add another node to the right which produce an exception!
        cities.insertRight(cities.root(),"Another Right");

    }

    @Test
    public void iterateThroughAllNodesUsingIterator () {
        /**
         *        d
         *      /   \
         *     b     f
         *    / \   / \
         *   a   c e   g
         *
         * Iterate Using preOrder traversal
         */
        LinkedBinaryTree<String> tree  = new LinkedBinaryTree<>();
        Position<String> root = tree.addRoot("d");
        Position<String> b = tree.insertLeft(root,"b");
        Position<String> f = tree.insertRight(root,"f");
        Position<String> a = tree.insertLeft(b,"a");
        Position<String> c = tree.insertRight(b,"c");
        Position<String> e = tree.insertLeft(f,"e");
        Position<String> g = tree.insertRight(f,"g");

        for (Iterator<String> it = tree.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
        String expected = "d,b,a,c,f,e,g,";
        tree.preorderPositions(root,treeList);
        assertEquals(expected,printTree());

    }

    @Test
    public void isEmptyWhenSizeZero() {
        assertEquals(0,cities.size());
        assertTrue(cities.isEmpty());
    }
}