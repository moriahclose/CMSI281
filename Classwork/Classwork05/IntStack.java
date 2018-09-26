/*************************************************************
* Author: B.J. Johnson
* Editor: Moriah Tolliver
* Purpose: Demonstrate a stack implemented using a linked list
*************************************************************/
public class IntStack {

      IntLinkedList myStack; //linked list representation of stack

      /**
       * Constructor
       */
      IntStack() {
         myStack = new IntLinkedList();
      }

      /**
       * Adds element of input value to stack
       * @param int value to add to stack
       */
      public void push( int itemToPush ) {
         myStack.prepend( itemToPush );
      }

      /**
       * Returns last element put in stack
       * @return int value of element at top of stack
       */
      public int peek() {
         return myStack.getIteratorAt( 0 ).getCurrentInt();     // we use the iterator
      }

      /**
       * Removes last element added to stack
       * @return int value removed from stack
       */
      public int pop() {
         return myStack.removeAt( 0 );
      }

      /**
       * Returns number of elements in stack
       * @return int number of elements in stack
       */
      public int getSize() {
          return myStack.getSize();
      }

      /**
       * Displays string representation of stack
       * @return string representation where left is last inserted
       */
      public String toString() {
          return myStack.toString();
      }

      /**
       * Main used for testing
       */
      public static void main( String[] args ) {
         IntStack testStack = new IntStack();

         //testing push( int j)
         System.out.println( "TESTING push( int j ) " );
         System.out.println( "  Adding 10 numbers to the stack..." );
         testStack.push( 19 );
         testStack.push( 23 );
         testStack.push( 29 );
         testStack.push( 31 );
         testStack.push( 37 );
         testStack.push( 41 );
         testStack.push( 43 );
         testStack.push( 47 );
         testStack.push( 51 );
         testStack.push( 57 );
         System.out.println( "  Want: 57 51 47 43 41 37 31 29 23 19" );
         System.out.println( "  Got : " + testStack.toString() );

         //testing peek() and pop()
          System.out.println( "\nTESTING pop() and peek() " );
          System.out.print( "  Popping and peeking five numbers... " );
          for ( int i = 0; i < 5; i++ ) {
              System.out.println( "     Peek: " + testStack.peek() + " Pop: " + testStack.pop() );
          }
          System.out.println("\n  Want: 37 31 29 23 19" );
          System.out.println("  Got : " + testStack.toString() );

         //testing getSize()
         System.out.println( "\nTESTING getSize()" );
         System.out.println( "  Current stack: " + testStack.toString() );
         System.out.println( "      Want: 5" );
         System.out.println( "      Got : " + testStack.getSize() );

         System.out.println( "  Popping 1 element with value " + testStack.pop() );
         System.out.println( "  Current stack: " + testStack.toString() );
         System.out.println( "      Want: 4" );
         System.out.println( "      Got : " + testStack.getSize() );

         System.out.println( "  Popping 1 element with value " + testStack.pop() );
         System.out.println( "  Current stack: " + testStack.toString() );
         System.out.println( "      Want: 3" );
         System.out.println( "      Got : " + testStack.getSize() );

         System.out.println( "  Popping 1 element with value " + testStack.pop() );
         System.out.println( "  Current stack: " + testStack.toString() );
         System.out.println( "      Want: 2" );
         System.out.println( "      Got : " + testStack.getSize() );

         System.out.println( "  Popping 1 element with value " + testStack.pop() );
         System.out.println( "  Current stack: " + testStack.toString() );
         System.out.println( "      Want: 1" );
         System.out.println( "      Got : " + testStack.getSize() );

         //testing special case for peek() and pop()
         System.out.println( "\nTESTING peek() and pop() when size == 0" );
         try {
             System.out.println( "Peek: " + testStack.peek() + " Pop: " + testStack.pop() );
         }
         catch( Exception e ) {
             System.out.println( e );
         }
         //should print error
         try {
             System.out.println( "Peek: " + testStack.peek() + " Pop: " + testStack.pop() );
         }
         catch( Exception e ) {
             System.out.println( e );
         }

      }

   }
