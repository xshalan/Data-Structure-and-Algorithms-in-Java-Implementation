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
         *                Africa
         *               /      \
         *          Libya       Egypt
         *          /   \        /  \
         *    Tarablus  NULL  NULL  Cairo
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

    @Test
    public void removeNodeWithOneChildFromTree_ReturnTheRemovedNode(){
        /**
         *        d
         *      /   \
         *     b     f
         *    / \   / \
         *   a   c e
         * remove f node
         * */
        LinkedBinaryTree<String> tree  = new LinkedBinaryTree<>();
        Position<String> root = tree.addRoot("d");
        Position<String> b = tree.insertLeft(root,"b");
        Position<String> f = tree.insertRight(root,"f");
        Position<String> a = tree.insertLeft(b,"a");
        Position<String> c = tree.insertRight(b,"c");
        Position<String> e = tree.insertLeft(f,"e");
        String removed_f = tree.remove(f);
        assertEquals("f",removed_f);
        String expected = "d,b,a,c,e,";
        tree.preorderPositions(root,treeList);
        assertEquals(expected,printTree());
    }

    @Test(expected = InvalidPositionException.class)
    public void removeNodeWithTwoChildrenFromTree_RaiseException(){
        /**
         *        d
         *      /   \
         *     b     f
         *    / \   / \
         *   a   c e
         * remove f node
         * */
        LinkedBinaryTree<String> tree  = new LinkedBinaryTree<>();
        Position<String> root = tree.addRoot("d");
        Position<String> b = tree.insertLeft(root,"b");
        Position<String> f = tree.insertRight(root,"f");
        Position<String> a = tree.insertLeft(b,"a");
        Position<String> c = tree.insertRight(b,"c");
        Position<String> e = tree.insertLeft(f,"e");
        tree.remove(root);
    }


    @Test
    public void checkIfTheNodeIsLead_External(){
        /**
         *        d
         *      /   \
         *     b     f
         * */
        LinkedBinaryTree<String> tree  = new LinkedBinaryTree<>();
        Position<String> root = tree.addRoot("d");
        Position<String> b = tree.insertLeft(root,"b");
        Position<String> f = tree.insertRight(root,"f");
        assertTrue(tree.isExternal(b));
        assertTrue(tree.isExternal(f));
    }

    @Test
    public void iterateThroughTree_UsingBreadthFirstAlgorithm(){
        /**
         *        1
         *      /   \
         *     2     3
         *    / \   / \
         *   4   5 6   7
         *
         * Iterate Using preOrder traversal
         */
        LinkedBinaryTree<String> tree  = new LinkedBinaryTree<>();
        Position<String> root = tree.addRoot("1");
        Position<String> b = tree.insertLeft(root,"2");
        Position<String> f = tree.insertRight(root,"3");
        Position<String> a = tree.insertLeft(b,"4");
        Position<String> c = tree.insertRight(b,"5");
        Position<String> e = tree.insertLeft(f,"6");
        Position<String> g = tree.insertRight(f,"7");
        Iterable<Position<String>> positions = tree.breadthFirst();
        String result = "";
        String expected = "1,2,3,4,5,6,7,";
        for(Position<String> node:positions){
            result += node.element() + ",";

        }
        assertEquals(expected,result);
    }

    @Test
    public void checkTheDepthOfTreeAtSpecificPosition_ReturnDepth(){
        /**
         *        1   d=0
         *      /   \
         *     2     3  d=1
         *    / \   / \
         *   4   5 6   7  d=2
         *
         */
        LinkedBinaryTree<String> tree  = new LinkedBinaryTree<>();
        Position<String> root = tree.addRoot("1");
        Position<String> b = tree.insertLeft(root,"2");
        Position<String> f = tree.insertRight(root,"3");
        Position<String> a = tree.insertLeft(b,"4");
        Position<String> c = tree.insertRight(b,"5");
        Position<String> e = tree.insertLeft(f,"6");
        Position<String> g = tree.insertRight(f,"7");
        int expected_depth_0 = 0;
        int expected_depth_1 = 1;
        int expected_depth_2 = 2;
        assertEquals(expected_depth_0,tree.depth(root));
        assertEquals(expected_depth_1,tree.depth(f));
        assertEquals(expected_depth_2,tree.depth(g));
        assertEquals(expected_depth_2,tree.depth(e));
    }


}