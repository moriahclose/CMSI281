/***********************************************************************
Author: Robert Lafore
Editors: Moriah Tolliver and Tapiwa Tafa
Purpose: Implement stack of ints using circular linked list
***********************************************************************/

public class CircularListStack {
    CircularList theList;
    int lastInserted;

    /**
     * Constructor
     */
    public CircularListStack() {
        theList = new CircularList();
    }

    /**
     * Inserts value at end of stack
     * @param int value to push
     */
    public void push( int value ) {
        theList.insert( value );
        lastInserted = value;
    }

    /**
     * Remove value at end of stack and return removed value
     * @return int value removed
     */
    public int pop() {
        int removeInt = lastInserted;
        theList.remove( removeInt );
        lastInserted = theList.getCurrentValue();
        return removeInt;
    }

    /**
     * Return the value at the end of the stack
     * @return int value at end of stack
     */
    public int peek() {
        return theList.getCurrentValue();
    }

    /**
     * Returns string representation of stack where first inserted is first in string
     * @return String representing the stack
     */
    public String toString() {
        return theList.toString();
    }


    /**
     * Main used for testing
     */
    public static void main ( String args[] ) {
        CircularListStack theStack = new CircularListStack();

        System.out.println( "---------------TESTING push---------------");
        System.out.println( "   Push 5" );
        theStack.push( 5 );
        System.out.println( "   Push 10" );
        theStack.push(  10 );
        System.out.println( "   Push 15" );
        theStack.push( 15 );
        System.out.println( "   Push 20" );
        theStack.push( 20 );
        System.out.println( "   The stack: " + theStack.toString() );

        System.out.println( "---------------TESTING peek and pop---------------");
        System.out.println( "   Peek: " + theStack.peek() );
        System.out.println( "   Pop" );
        theStack.pop();
        System.out.println( "   The stack: " + theStack.toString() );

        System.out.println( "   Peek: " + theStack.peek() );
        System.out.println( "   Pop" );
        theStack.pop();
        System.out.println( "   The stack: " + theStack.toString() );

        System.out.println( "   Peek: " + theStack.peek() );
        System.out.println( "   Pop" );
        theStack.pop();
        System.out.println( "   The stack: " + theStack.toString() );

        System.out.println( "   Peek: " + theStack.peek() );
        System.out.println( "   Pop" );
        theStack.pop();
        System.out.println( "   The stack: " + theStack.toString() );

        System.out.println( "   Peek: " + theStack.peek() );
        System.out.println( "   Pop" );
        theStack.pop();
        System.out.println( "   The stack: " + theStack.toString() );

    }
}
