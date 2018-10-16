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
        Dequeue theDequeue = new Dequeue( 8 );

        System.out.println( "---------------TESTING insertRight---------------");
        theDequeue.insertRight( 10 );
        System.out.println( "   Inserting 10" );
        theDequeue.insertRight( 20 );
        System.out.println( "   Inserting 20" );
        theDequeue.insertRight( 30 );
        System.out.println( "   Inserting 30" );
        theDequeue.insertRight( 40 );
        System.out.println( "   Inserting 40" );
        System.out.print( "   Dequeue: ");
        theDequeue.display();
        System.out.println();

        System.out.println( "---------------TESTING insertLeft---------------");
        theDequeue.insertLeft( 11 );
        System.out.println( "   Inserting 11" );
        theDequeue.insertLeft( 22 );
        System.out.println( "   Inserting 22" );
        theDequeue.insertLeft( 33 );
        System.out.println( "   Inserting 33" );
        theDequeue.insertLeft( 44 );
        System.out.println( "   Inserting 44" );
        System.out.print( "   Dequeue: ");
        theDequeue.display();
        System.out.println();

        System.out.println( "---------------TESTING removeLeft and removeRight---------------");
        theDequeue.removeLeft();
        System.out.println( "   Removing left" );
        System.out.print( "   Dequeue: ");
        theDequeue.display();
        theDequeue.removeLeft();
        System.out.println( "   Removing left" );
        System.out.print( "   Dequeue: ");
        theDequeue.display();
        theDequeue.removeRight();
        System.out.println( "   Removing right" );
        System.out.print( "   Dequeue: ");
        theDequeue.display();
        theDequeue.removeRight();
        System.out.println( "   Removing right" );
        System.out.print( "   Dequeue: ");
        theDequeue.display();
        System.out.println();

        System.out.println( "---------------TESTING isEmpty and isFull---------------");
        System.out.print( "   Dequeue: ");
        theDequeue.display();
        System.out.println( "   Dequeue empty? " + theDequeue.isEmpty() );  //false
        System.out.println( "   Dequeue full? " + theDequeue.isFull() );   //false
        System.out.println( "   Inserting 4 values" );
        theDequeue.insertLeft( 89 );
        theDequeue.insertRight( 103 );
        theDequeue.insertLeft( 7289 );
        theDequeue.insertRight( 8 );
        System.out.print( "   Dequeue: ");
        theDequeue.display();
        System.out.println( "   Dequeue full? " + theDequeue.isFull() );   //true
        System.out.println( "   Removing all values." );
        theDequeue.removeRight();
        theDequeue.removeRight();
        theDequeue.removeRight();
        theDequeue.removeRight();
        theDequeue.removeRight();
        theDequeue.removeRight();
        theDequeue.removeRight();
        theDequeue.removeRight();
        System.out.print( "   Dequeue: ");
        theDequeue.display();
        System.out.println( "   Dequeue empty? " + theDequeue.isEmpty() );  //true
    }
}
