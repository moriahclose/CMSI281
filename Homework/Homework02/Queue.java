/*********************************************************
Author: Robert Lafore
Editors: Moriah Tolliver and Tapiwa Tafa
Purpose: Demonstrates queue
**********************************************************/
// Write a method for the Queue class in the queue.java program (Listing 4.4) that displays the contents of the queue.
// Note that this does not mean simply displaying the contents of the underlying array.
// You should show the queue contents from the first item inserted to the last, without indicating to the viewer whether the sequence is broken by wrapping around the end of the array.
// Be careful that one item and no items display properly, no matter where front and rear are.

public class Queue  {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    /**
     * Constructor
     * @param int s maximum size of queue
     */
    public Queue( int s ) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * Inserts element at rear of Queue
     * @param long j value of the element
     */
    public void insert( long j ) {
        if ( rear == maxSize-1 ) // deal with wraparound
            rear = -1;
        queArray[++rear] = j;    // increment rear and insert
        nItems++;                // one more item
    }

    /**
     * Removes item at the front of Queue and returns removed value
     * @return long value removed
     */
    public long remove() {
        long temp = queArray[front++]; // get value and increment front
        if ( front == maxSize )        // deal with wraparound
            front = 0;
        nItems--;                      // one less item
        return temp;
    }

    /**
     * Returns value at front of Queue
     * @return long value in element at the front of Queue
     */
    public long peekFront() {
        return queArray[front];
    }

    /**
     * Returns true if the Queue is empty and false otherwise
     * @return boolean true if Queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return ( nItems == 0 );
    }

    /**
     * Returns number of items in Queue
     * @return int size of Queue
     */
    public int size() {
        return nItems;
    }

    public void displayQueue() {
        int index = front;
        for ( int count = 0; count < nItems; count++ ) {
            System.out.print( queArray[index] + " " );
            if ( index == maxSize - 1 ) {   // accounting for wraparound
                index = 0;
            }
            else {
                index++;
            }
        }

        System.out.println();
    }

    /**
     * Main to test methods
     */
    public static void main( String args[] ) {
        Queue theQueue = new Queue(5);

        //testing insert
        System.out.println( "****** TESTING insert( int ) ******" );
        theQueue.insert( 10 );
        System.out.println( "   Inserting 10" );
        theQueue.insert( 20 );
        System.out.println( "   Inserting 20" );
        theQueue.insert( 30 );
        System.out.println( "   Inserting 30" );
        theQueue.insert( 40 );
        System.out.println( "   Inserting 40" );

        //testing remove
        System.out.println( "****** TESTING remove() ******" );
        theQueue.remove();
        System.out.println( "   Removing 10" );
        theQueue.remove();
        System.out.println( "   Removing 20" );
        theQueue.remove();
        System.out.println( "   Removing 30" );

        //testing wraparound
        System.out.println( "****** TESTING wraparound ******" );
        theQueue.insert( 50 );
        System.out.println( "   Inserting 50" );
        theQueue.insert( 60 );
        System.out.println( "   Inserting 60" );
        theQueue.insert( 70 );
        System.out.println( "   Inserting 70" );
        theQueue.insert( 80 );
        System.out.println( "   Inserting 80" );

        // testing displayQueue
        System.out.println( "****** TESTING displayQueue ******" );
        System.out.print( "    Current queue: " );
        theQueue.displayQueue( );
        System.out.println();

        System.out.println( "    Removing all elements..." );
        while ( !theQueue.isEmpty() ) {
            theQueue.remove();
        }
        System.out.print( "    Current queue: " );
        theQueue.displayQueue();
        System.out.println();

        System.out.println( "    Adding [8]..." );
        theQueue.insert( 8 );
        System.out.print( "    Current queue: " );
        theQueue.displayQueue();
    }

}
