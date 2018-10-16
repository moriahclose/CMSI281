/***********************************************************************
Author: Robert Lafore
Editors: Moriah Tolliver and Tapiwa Tafa
Purpose: Demonstrates circular linked list that takes objects as values
******************************************************************/
public class CircularList {
    private Node current;
    private int  size;

    /**
     * Constructor
     */
    public CircularList() {
        current = null;
        size = 0;
    }

    /**
     * Internal class that creates node object
     */
    private class Node {

       int data;            // int circular list
       Node next;           // here's the self-referential part

       /**
        * Constructor
        * @param int value node will contain
        */
       Node( int d ) {
          data = d;
          next = null;
       }
    }

    /**
     * Returns number of elements in the list
     * @return int number of elements in the list
     */
    public int getSize() {
       return size;
    }

    /**
     * Moves current to next node an input amount of times
     * @param int number of steps for current to go
     */
     public void step( int numOfSteps ) {
         for ( int i = 0; i < numOfSteps; i++ ) {
             current = current.next;
         }
     }

    /**
     * Insert value at given index
     * @param int value to insert
     */
    public void insert( int value ) {
        Node newNode = new Node( value );

        if ( size == 0 ) {
            current = newNode;
            newNode.next = newNode;
        }
        else {
            newNode.next = current.next;
            current.next = newNode;
            current = newNode;
        }

        size++;
    }


    /**
     * Search for value in the list
     * @param int value to search for
     * @return int index where value was found or -1 if value was not found
     */
    public int find( int value ) {
        return -1;
    }

    /**
     * Remove value from list
     * @param int value to remove
     */
    public void remove( int value ) {

    }

    public String toString() {
        String stringRepresenation = "";
        for ( int i = 0; i < size; i++ ) {
            stringRepresenation += current.data + " ";
            step( 1 );
        }
        return stringRepresenation;
    }

    public static void main ( String args[] ) {

        CircularList theList = new CircularList();

        System.out.println( "---------------TESTING insert---------------");
        System.out.println( "   Inserting 5" );
        theList.insert( 5 );
        System.out.println( "   Inserting 10" );
        theList.insert(  10 );
        System.out.println( "   Inserting 15" );
        theList.insert( 15 );
        System.out.println( "   Inserting 20" );
        theList.insert( 20 );
        System.out.println( "   The list: " + theList.toString() );




    }
}
