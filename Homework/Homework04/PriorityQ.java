/***********************************************************************
Authors: Moriah Tolliver and Tapiwa Tafa
Purpose: Demonstrates priority queue implemented with a heap
***********************************************************************/
import java.util.*;

public class PriorityQ {
    private Heap queHeap;   // heap representation of the queue
    private int maxSize;    // maximum size of the queue

    /**
     * Constructor
     * @param int maximum size of the queue
     */
    public PriorityQ( int s ) {
        maxSize = s;
        queHeap = new Heap( maxSize );
    }

    /**
     * Insert and give priority to value
     * @param int value to insert
     */
    public void insert( int data ) {
        queHeap.insert( data );
    }

    /**
     * Remove highest value from the queue
     * @return int value removed
     */
    public int remove() {
        return queHeap.getNodeKey( queHeap.remove() );
    }

    /**
     * Get maximum value from the queue
     * @return int maximum value
     */
    public long peekMax() {
        return queHeap.getRoot();
    }

    /**
     * Return if queue is empty
     * @return boolean true if queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return queHeap.size() == 0;
    }

    /**
     * Return if queue is full
     * @return boolean true if queue is full, false otherwise
     */
    public boolean isFull() {
        return queHeap.size() == maxSize;
    }

    /**
     * Get size of the queue
     * @return int size of the queue
     */
    public int size() {
        return queHeap.size();
    }

    /**
     * Display contents of the queue
     */
    public void display() {
        System.out.print( "queue: " );
        int[] theQueue = new int[queHeap.size()];
        for ( int i = 0; i < queHeap.size(); i++ ) {
            theQueue[i] = queHeap.getNodeKey( queHeap.getArrayRep()[i] );
        }
        Arrays.sort( theQueue );
        for ( int i = queHeap.size()-1; i >= 0; i-- ) {
            System.out.print( theQueue[i] + " " );
        }
        System.out.println();
    }

    public static void main( String args[] ) {
        PriorityQ pq = new PriorityQ( 10 );

        System.out.println( "Testing insert()" );
        System.out.println( "----------------------------" );
        System.out.println( "   Inserting 100 20 30 40 90 20 60 70 80" );
        pq.insert( 100 );
        pq.insert( 20 );
        pq.insert( 30 );
        pq.insert( 40 );
        pq.insert( 90 );
        pq.insert( 20 );
        pq.insert( 60 );
        pq.insert( 70 );
        pq.insert( 80 );
        System.out.print( "   " );
        pq.display();

        System.out.println( "\nTesting remove()" );
        System.out.println( "----------------------------" );
        System.out.println( "   Removed " + pq.remove() );
        System.out.println( "   Removed " + pq.remove() );
        System.out.println( "   Removed " + pq.remove() );
        System.out.println( "   Removed " + pq.remove() );
        System.out.println( "   Removed " + pq.remove() );
        System.out.println( "   Removed " + pq.remove() );
        System.out.println( "   Removed " + pq.remove() );
        System.out.println( "   Removed " + pq.remove() );
        System.out.println( "   Removed " + pq.remove() );
        System.out.print( "   " );
        pq.display();

        System.out.println( "\nTesting peekMax()" );
        System.out.println( "----------------------------" );
        System.out.println( "   Inserting 11 66 22 33 55 44" );
        pq.insert( 11 );
        pq.insert( 66 );
        pq.insert( 22 );
        pq.insert( 33 );
        pq.insert( 55 );
        pq.insert( 44 );
        System.out.print( "   " );
        pq.display();
        System.out.print( "   Peek: " + pq.peekMax() );
        System.out.println( "   Removed: " + pq.remove() );
        System.out.print( "   Peek: " + pq.peekMax() );
        System.out.println( "   Removed: " + pq.remove() );
        System.out.print( "   Peek: " + pq.peekMax() );
        System.out.println( "   Removed: " + pq.remove() );
        System.out.print( "   Peek: " + pq.peekMax() );
        System.out.println( "   Removed: " + pq.remove() );
        System.out.print( "   Peek: " + pq.peekMax() );
        System.out.println( "   Removed: " + pq.remove() );
        System.out.print( "   Peek: " + pq.peekMax() );
        System.out.println( "   Removed: " + pq.remove() );
        System.out.print( "   " );
        pq.display();

        System.out.println( "\nTesting isEmpty()" );
        System.out.println( "----------------------------" );
        System.out.println( "   Inserting 2 3 5" );
        pq.insert( 2 );
        pq.insert( 3 );
        pq.insert( 5 );
        System.out.print( "   " );
        pq.display();
        System.out.println( "   isEmpty: " + pq.isEmpty() + " Removed: " + pq.remove() );
        System.out.println( "   isEmpty: " + pq.isEmpty() + " Removed: " + pq.remove() );
        System.out.println( "   isEmpty: " + pq.isEmpty() + " Removed: " + pq.remove() );
        System.out.println( "   isEmpty: " + pq.isEmpty() );

        System.out.println( "\nTesting isFull()" );
        System.out.println( "----------------------------" );
        System.out.println( "   Inserting 7 11 13 17" );
        pq.insert( 7 );
        pq.insert( 11 );
        pq.insert( 13 );
        pq.insert( 17 );
        System.out.print( "   " );
        pq.display();
        System.out.println( "   isFull: " + pq.isFull() );
        System.out.print( "   Insert: 19");
        pq.insert( 19 );
        System.out.println( "   isFull: " + pq.isFull() );
        System.out.print( "   Insert: 23");
        pq.insert( 23 );
        System.out.println( "   isFull: " + pq.isFull() );
        System.out.print( "   Insert: 29");
        pq.insert( 29 );
        System.out.println( "   isFull: " + pq.isFull() );
        System.out.print( "   Insert: 31");
        pq.insert( 31 );
        System.out.println( "   isFull: " + pq.isFull() );
        System.out.print( "   Insert: 37");
        pq.insert( 37 );
        System.out.println( "   isFull: " + pq.isFull() );
        System.out.print( "   Insert: 41");
        pq.insert( 41 );
        System.out.println( "   isFull: " + pq.isFull() );
        System.out.print( "   " );
        pq.display();
    }
}
