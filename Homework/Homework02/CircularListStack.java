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

    public void push( int value ) {
        theList.insert( value );
        lastInserted = value;
    }

    public int pop() {
        int removeInt = lastInserted;
        theList.remove( removeInt );
        lastInserted = theList.getCurrentValue();
        return removeInt;
    }

    public int peek() {
        return theList.getCurrentValue();
    }

    public String toString() {
        return theList.toString();
    }



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
