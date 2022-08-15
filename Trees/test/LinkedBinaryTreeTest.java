import NodeBased.NodeBasedList;
import NodeBased.interfaces.PositionList;
import interfaces.BinaryTree;
import interfaces.Position;
import org.junit.Before;
import org.junit.Test;

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
        cities.preorderPositions(cities.root(),treeList);
        assertEquals("Africa,",printTree());
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
    public void hasLeft() {
    }

    @Test
    public void size() {
    }

    @Test
    public void isEmpty() {
    }
}