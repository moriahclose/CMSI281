/***********************************************************************
Author: Robert Lafore
Editors: Moriah Tolliver and Tapiwa Tafa
Purpose: Demonstrates heaps
***********************************************************************/
import java.io.*;

public class Heap {
    private Node[] heapArray;
    private int maxSize;        // size of array
    private int currentSize;    // number of nodes in array

    /**
     * Internal class for Node creation
     */
    private class Node {
        private int iData; // data item (key)

        public Node( int key ) {
            iData = key;
        }

        public int getKey() {
            return iData;
        }

        public void setKey( int id ) {
            iData = id;
        }
    }

    /**
     * Constructor
     * @param int maximum size of the heap
     */
    public Heap( int mx ) {
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize]; // create array
    }

    /**
     * Return if heap is empty
     * @return boolean true if heap is empty, false otherwise
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Insert value into heap
     * @return false if heap is full, true otherwise
     */
    public boolean insert( int key ) {
        if( currentSize == maxSize ) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    /**
     * Move node upward in heap until it is correctly placed
     * @param int index of node to move
     */
    public void trickleUp( int index ) {
        int parent = (index-1) / 2;
        Node bottom = heapArray[index];

        while( index > 0 && heapArray[parent].getKey() < bottom.getKey() ) {
            heapArray[index] = heapArray[parent];   // move it down
            index = parent;
            parent = (parent-1) / 2;
        }

        heapArray[index] = bottom;
    }

    /**
     * Remove Node with maximum key value
     * @return Node removed
     */
    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = ( currentSize > 0 ) ? heapArray[--currentSize] : heapArray[0];
        trickleDown(0);
        return root;
    }

    /**
     * Get Node with maximum key value
     * @return Node with maximum key value
     */
    public int getRoot() {
        return heapArray[0].getKey();
    }

    /**
     * Get size of the heap
     * @return int number of nodes in the heap
     */
    public int size() {
        return currentSize;
    }

    /**
     * Get array representation of the heap
     * @return Node[] representation of the heap
     */
    public Node[] getArrayRep() {
        return heapArray;
    }

    /**
     * Move node downward in heap until it is correctly placed
     * @param int index of node to move
     */
    public void trickleDown( int index ) {
        int largerChild;
        Node top = heapArray[index];
        while( index < currentSize/2 ) {
            int leftChild = 2*index+1;
            int rightChild = leftChild+1;

            if( rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey() ) {
                largerChild = rightChild;
            }
            else {
                largerChild = leftChild;
            }

            if( top.getKey() >= heapArray[largerChild].getKey() ) {
                break;
            }

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    /**
     * Change value of Node and place Node in correct place in heap
     * @param int index of Node to change value of
     * @param int int value to change Node to
     * @return false if index is invalid, true otherwise
     */
    public boolean change( int index, int newValue ) {
        if( index < 0 || index >= currentSize ) {
            return false;
        }

        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);

        if( oldValue < newValue ) {
            trickleUp( index );
        }
        else {
            trickleDown( index );
        }
        return true;
    }

    /**
     * Display contents and arrangement of heap
     */
    public void displayHeap() {
        System.out.print("heapArray: ");
        for( int m = 0; m < currentSize; m++ ) {
            if( heapArray[m] != null ) {
                System.out.print( heapArray[m].getKey() + " " );
            }
            else {
                System.out.print( "--" );
            }
        }
        System.out.println();

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...............................";
        System.out.println( dots + dots );

        while ( currentSize > 0 ) {
            if ( column == 0 ) {
                for ( int k = 0; k < nBlanks; k++ ) {
                    System.out.print( ' ' );
                }
            }
            System.out.print( heapArray[j].getKey() );
            if ( ++j == currentSize ) {
                break;
            }

            if ( ++column == itemsPerRow ) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            }
            else {
                for ( int k =0; k < nBlanks*2-2; k++ ) {
                    System.out.print( ' ' );
                }
            }
        }
        System.out.println( "\n" + dots + dots );
    }

    /**
     * Get key value of Node
     * @param Node to get value of
     * @return int key value of input node
     */
    public int getNodeKey( Node n ) {
        return n.getKey();
    }
}
