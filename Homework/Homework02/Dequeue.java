/*********************************************************
Author: Robert Lafore
Editors: Moriah Tolliver and Tapiwa Tafa
Purpose: Demonstrates dequeue
**********************************************************/
public class Dequeue {
    private int maxSize;
    private long[] dequeueArray;
    private int front;
    private int rear;
    private int nItems;

    /**
     * Constructor
     * @param int s maximum size of queue
     */
    public Dequeue( int s ) {
        maxSize = s;
        dequeueArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * Inserts item at front of dequeue
     * @param long value to insert
     */
    public void insertLeft( long j ) {
        if ( front == 0 ) {
            front = maxSize;
        }
        dequeueArray[--front] = j;
        nItems++;
    }

    /**
     * Inserts item at rear of dequeue
     * @param long value to insert
     */
    public void insertRight( long j ) {
        if ( rear == maxSize-1 ) { // deal with wraparound
            rear = -1;
        }
        dequeueArray[++rear] = j;    // increment rear and insert
        nItems++;                // one more item
    }

    /**
     * Removes item at front of dequeue
     * @return long value removed
     */
    public long removeLeft() {
        long temp = dequeueArray[front++]; // get value and increment front
        if ( front == maxSize ) {           // deal with wraparound
            front = 0;
        }
        nItems--;                         // one less item
        return temp;
    }

    /**
     * Removes item at rear of dequeue
     * @return long value removed
     */
    public long removeRight() {
        long temp = dequeueArray[rear--]; // get value and increment front
        if ( rear == -1 ) {                 // deal with wraparound
            rear = maxSize-1;
        }
        nItems--;                         // one less item
        return temp;
    }

    /**
     * Retruns true if dequeue is empty and false otherwise
     * @return boolean true if dequeue is empty and false otherwise
     */
    public boolean isEmpty() {
        return ( nItems == 0 );
    }

    /**
     * Retruns true if dequeue is full and false otherwise
     * @return boolean true if dequeue is full and false otherwise
     */
    public boolean isFull() {
        return ( nItems == maxSize );
    }

    /**
     * Displays elements in the dequeue from front to rear
     */
    public void display() {
        int index = front;
        for ( int count = 0; count < nItems; count++ ) {
            System.out.print( dequeueArray[index] + " " );
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
        Dequeue theDequeue = new Dequeue( 5 );

        System.out.println( "---------------TESTING insertRight---------------");
        theDequeue.insertRight( 10 );
        System.out.println( "   Inserting 10" );
        theDequeue.insertRight( 20 );
        System.out.println( "   Inserting 20" );
        theDequeue.insertRight( 30 );
        System.out.println( "   Inserting 30" );
        theDequeue.insertRight( 40 );
        System.out.println( "   Inserting 40" );
        theDequeue.display();

        System.out.println( "---------------TESTING removeLeft---------------");
        theDequeue.removeLeft();
        System.out.println( "   Removing left" );
        theDequeue.display();
        // theDequeue.removeLeft();
        // System.out.println( "   Removing left" );
        // theDequeue.display();
        // theDequeue.removeLeft();
        // System.out.println( "   Removing left" );
        // theDequeue.display();

        // System.out.println( "---------------TESTING insertLeft---------------");
        // theDequeue.insertLeft( 13 );
        // System.out.println( "   Inserting 13" );
        // theDequeue.insertLeft( 17 );
        // System.out.println( "   Inserting 17" );
        // theDequeue.insertLeft( 19 );
        // System.out.println( "   Inserting 19" );
        // theDequeue.insertLeft( 23 );
        // System.out.println( "   Inserting 23" );
        // theDequeue.display();

        theDequeue.insertLeft( 50 );
        System.out.println( "   Inserting 50 left" );
        theDequeue.insertLeft( 60 );
        System.out.println( "   Inserting 60 left" );
        theDequeue.display();

        System.out.println( "---------------TESTING removeRight---------------");
        theDequeue.removeRight();
        theDequeue.display();
        theDequeue.removeRight();
        theDequeue.display();

        System.out.println( "---------------TESTING isEmpty()---------------");
        System.out.println( " Dequeue empty? " + theDequeue.isEmpty() );  //false
        System.out.println( " Dequeue full? " + theDequeue.isFull() );   //false
        theDequeue.insertLeft( 89 );
        theDequeue.insertRight( 103 );
        theDequeue.display();
        theDequeue.getSize();
        System.out.println( " Dequeue full? " + theDequeue.isFull() );   //true
        theDequeue.removeRight();
        theDequeue.removeRight();
        theDequeue.removeRight();
        theDequeue.removeRight();
        theDequeue.removeRight();
        theDequeue.display();
        System.out.println( " Dequeue empty? " + theDequeue.isEmpty() );  //true
    }
}
