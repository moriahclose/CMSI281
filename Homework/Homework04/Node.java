/********************************************************************************************************************************
Authors: Moriah Tolliver and Tapiwa Tafa
Purpose: Demonstrates in-order tree traversal
Note: In-order traversal method adapted from B.J. Johnson Class Notes Week 9 (https://bjohnson.lmu.build/cmsi281web/week09.html)
********************************************************************************************************************************/
public class Node {
    public int data;
    public Node leftChild;
    public Node rightChild;

    /**
     * Constructor
     */
    public Node( int inputData ) {
        data = inputData;
    }

    /**
     * Inserts left child node with input data value
     * @param int value to insert
     */
    public void insertLeft( int inputData ) {
        leftChild = new Node( inputData );
    }

    /**
     * Inserts right child node with input data value
     * @param int value to insert
     */
    public void insertRight( int inputData ) {
        rightChild = new Node( inputData );
    }

    /**
     * Displays in-order traversal of tree starting with given root node
     * @param Node root of subtree to print traversal of
     */
    public void inOrderTraversal( Node currentNode ) {
        if( currentNode == null ) {
            return;
        }
        inOrderTraversal( currentNode.leftChild );
        System.out.print( " " + currentNode.data + " " );
        inOrderTraversal( currentNode.rightChild );
    }

    /**
     * Main used for testing
     */
    public static void main( String args[] ) {
        System.out.println( "To help with testing, all trees have been constructed so that their in-order traversals produce a list sorted in ascending order." );
        System.out.println( "__________Testing in order traversal with binary search tree__________");
        Node root = new Node( 50 );
        root.insertLeft( 25 );
        root.insertRight( 75 );
        root.leftChild.insertLeft( 12 );
        root.leftChild.insertRight( 33 );
        root.rightChild.insertLeft( 62 );
        root.rightChild.insertRight( 87 );
        root.inOrderTraversal( root );

        System.out.println( "\n\n__________Testing in order traversal for tree with one node__________");
        Node root2 = new Node( 10050 );
        root.inOrderTraversal( root2 );

        System.out.println( "\n\n__________Testing in order traversal for tree with only left children__________");
        Node root3 = new Node( 50 );
        root3.insertLeft( 25 );
        root3.leftChild.insertLeft( 12 );
        root3.leftChild.leftChild.insertLeft( 6 );
        root3.leftChild.leftChild.leftChild.insertLeft( 3 );
        root3.leftChild.leftChild.leftChild.leftChild.insertLeft( 1 );
        root3.inOrderTraversal( root3 );

        System.out.println( "\n\n__________Testing in order traversal for tree with only right children__________");
        Node root4 = new Node( 50 );
        root4.insertRight( 75 );
        root4.rightChild.insertRight( 87 );
        root4.rightChild.rightChild.insertRight( 99 );
        root4.rightChild.rightChild.rightChild.insertRight( 111 );
        root4.rightChild.rightChild.rightChild.rightChild.insertRight( 134 );
        root4.inOrderTraversal( root4 );

        System.out.println( "\n\n__________Testing in order traversal for incomplete, symmetrical tree__________");
        Node root5 = new Node( 50 );
        root5.insertLeft( 25 );
        root5.leftChild.insertLeft( 12 );
        root5.leftChild.leftChild.insertLeft( 6 );
        root5.leftChild.leftChild.leftChild.insertLeft( 3 );
        root5.leftChild.leftChild.leftChild.leftChild.insertLeft( 1 );
        root5.insertRight( 75 );
        root5.rightChild.insertRight( 87 );
        root5.rightChild.rightChild.insertRight( 99 );
        root5.rightChild.rightChild.rightChild.insertRight( 111 );
        root5.rightChild.rightChild.rightChild.rightChild.insertRight( 134 );
        root5.inOrderTraversal( root5 );

        System.out.println( "\n\n__________Testing in order traversal for incomplete, asymmetrical tree__________");
        Node root6 = new Node( 50 );
        root6.insertLeft( 25 );
        root6.leftChild.insertLeft( 12 );
        root6.leftChild.insertRight( 37 );
        root6.leftChild.leftChild.insertLeft( 6 );
        root6.leftChild.leftChild.insertRight( 13 );
        root6.leftChild.rightChild.insertLeft( 30 );
        root6.insertRight( 75 );
        root6.rightChild.insertLeft( 62 );
        root6.rightChild.leftChild.insertRight( 68 );
        root6.inOrderTraversal( root6 );
    }
}
