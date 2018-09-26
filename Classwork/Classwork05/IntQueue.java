/*************************************************************
* Author: B.J. Johnson
* Editor: Moriah Tolliver
* Purpose: Demonstrate a queue implemented using a linked list
*************************************************************/
public class IntQueue {

      IntLinkedList myQueue;

      IntQueue() {
         myQueue = new IntLinkedList();         // constructor
      }

      public void push( int itemToPush ) {
         myQueue.prepend( itemToPush );
      }

      public int peek() {
         return myQueue.getIteratorAt( myQueue.getSize() - 1 ).getCurrentInt();
      }

      public int pop() {
         return myQueue.removeAt( myQueue.getSize() - 1 );
      }

      public int getSize() {
          return myQueue.getSize();
      }

      public String toString() {
          String returnString = "";
          int index = myQueue.getSize()-1;

          while ( index >= 0 ) {
              returnString += myQueue.getIteratorAt( index ).getCurrentInt() + " ";
              index--;
          }
          return returnString;
      }

      public static void main( String[] args ) {
         IntQueue testQueue = new IntQueue();

         //testing push( int j)
         System.out.println( "TESTING push( int j ) " );
         System.out.println( "  Adding 10 numbers to the queue..." );
         testQueue.push( 19 );
         testQueue.push( 23 );
         testQueue.push( 29 );
         testQueue.push( 31 );
         testQueue.push( 37 );
         testQueue.push( 41 );
         testQueue.push( 43 );
         testQueue.push( 47 );
         testQueue.push( 51 );
         testQueue.push( 57 );
         System.out.println( "  Want: 19 23 29 31 37 41 43 47 51 57" );
         System.out.println( "  Got : " + testQueue.toString() );

         //testing peek() and pop()
          System.out.println( "\nTESTING pop() and peek() " );
          System.out.println( "  Popping and peeking five numbers... " );
          for ( int i = 0; i < 5; i++ ) {
              System.out.println( "     Peek: " + testQueue.peek() + " Pop: " + testQueue.pop() );
          }
          System.out.println("\n  Want: 41 43 47 51 57" );
          System.out.println("  Got : " + testQueue.toString() );

         //testing getSize()
         System.out.println( "\nTESTING getSize()" );
         System.out.println( "  Current queue: " + testQueue.toString() );
         System.out.println( "      Want: 5" );
         System.out.println( "      Got : " + testQueue.getSize() );

         System.out.println( "  Popping 1 element with value " + testQueue.pop() );
         System.out.println( "  Current queue: " + testQueue.toString() );
         System.out.println( "      Want: 4" );
         System.out.println( "      Got : " + testQueue.getSize() );

         System.out.println( "  Popping 1 element with value " + testQueue.pop() );
         System.out.println( "  Current queue: " + testQueue.toString() );
         System.out.println( "      Want: 3" );
         System.out.println( "      Got : " + testQueue.getSize() );

         System.out.println( "  Popping 1 element with value " + testQueue.pop() );
         System.out.println( "  Current queue: " + testQueue.toString() );
         System.out.println( "      Want: 2" );
         System.out.println( "      Got : " + testQueue.getSize() );

         System.out.println( "  Popping 1 element with value " + testQueue.pop() );
         System.out.println( "  Current queue: " + testQueue.toString() );
         System.out.println( "      Want: 1" );
         System.out.println( "      Got : " + testQueue.getSize() );

         //testing special case for peek() and pop()
         System.out.println( "\nTESTING peek() and pop() when size == 0" );
         try {
             System.out.println( "Peek: " + testQueue.peek() + " Pop: " + testQueue.pop() );
         }
         catch( Exception e ) {
             System.out.println( e );
         }
         try {
             System.out.println( "Peek: " + testQueue.peek() + " Pop: " + testQueue.pop() );
         }
         catch( Exception e ) {
             System.out.println( e );
         }

      }

   }
