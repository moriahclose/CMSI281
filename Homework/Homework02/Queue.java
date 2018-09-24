/*********************************************************
Author: Robert Lafore
Editors: Moriah Tolliver and Tapiwa Tafa
Purpose: Demonstrates queue
**********************************************************/

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

    /**
     * Main to test methods
     */
    public static void main( String args[] ) {
        Queue theQueue = new Queue(5);

        //testing insert
        System.out.println( "****** TESTING insert( int ) ******" );
        theQueue.insert( 10 );
        theQueue.insert( 20 );
        theQueue.insert( 30 );
        theQueue.insert( 40 );

        //testing remove
        System.out.println( "****** TESTING remove() ******" );
        theQueue.remove();
        theQueue.remove();
        theQueue.remove();

        //testing wraparound
        System.out.println( "****** TESTING wraparound ******" );
        theQueue.insert( 50 );
        theQueue.insert( 60 );
        theQueue.insert( 70 );
        theQueue.insert( 80 );

        // displaying Queue
        while ( !theQueue.isEmpty() ) {
            long n = theQueue.remove(); // (40, 50, 60, 70, 80)
            System.out.print( n );
            System.out.print( " " );
        }

        System.out.println();
    }

}
