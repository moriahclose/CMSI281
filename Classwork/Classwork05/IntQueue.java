/*************************************************************
* Author: B.J. Johnson
* Editor: Moriah Tolliver
* Purpose: Demonstrate a queue implemented using a linked list
*************************************************************/
public class IntQueue {

      IntLinkedList myQueue;    // linked list representation of queue

      /**
       * Constructor
       */
      IntQueue() {
         myQueue = new IntLinkedList();         // constructor
      }

      /**
       * Adds element of input value to queue
       * @param int value to add to queue
       */
      public void enqueue( int itemToEnqueue ) {
         myQueue.prepend( itemToEnqueue );
      }

      /**
       * Returns first element put in queue
       * @return int value of element at front of queue
       */
      public int peek() {
         return myQueue.getIteratorAt( myQueue.getSize() - 1 ).getCurrentInt();
      }

      /**
       * Removes first element added to queue
       * @return int value removed from queue
       */
      public int dequeue() {
         return myQueue.removeAt( myQueue.getSize() - 1 );
      }

      /**
       * Returns number of elements in queue
       * @return int number of elements in queue
       */
      public int getSize() {
          return myQueue.getSize();
      }

      /**
       * Displays string representation of queue
       * @return string representation where left is last queue
       */
      public String toString() {
          String returnString = "";
          int index = myQueue.getSize()-1;

          while ( index >= 0 ) {
              returnString += myQueue.getIteratorAt( index ).getCurrentInt() + " ";
              index--;
          }
          return returnString;
      }

      /**
       * Main for testing
       */
      public static void main( String[] args ) {
         IntQueue testQueue = new IntQueue();

         //testing enqueue( int j)
         System.out.println( "TESTING enqueue( int j ) " );
         System.out.println( "  Adding 10 numbers to the queue..." );
         testQueue.enqueue( 19 );
         testQueue.enqueue( 23 );
         testQueue.enqueue( 29 );
         testQueue.enqueue( 31 );
         testQueue.enqueue( 37 );
         testQueue.enqueue( 41 );
         testQueue.enqueue( 43 );
         testQueue.enqueue( 47 );
         testQueue.enqueue( 51 );
         testQueue.enqueue( 57 );
         System.out.println( "  Want: 19 23 29 31 37 41 43 47 51 57" );
         System.out.println( "  Got : " + testQueue.toString() );

         //testing peek() and dequeue()
          System.out.println( "\nTESTING dequeue() and peek() " );
          System.out.println( "  dequeueing and peeking five numbers... " );
          for ( int i = 0; i < 5; i++ ) {
              System.out.println( "     Peek: " + testQueue.peek() + " dequeue: " + testQueue.dequeue() );
          }
          System.out.println("\n  Want: 41 43 47 51 57" );
          System.out.println("  Got : " + testQueue.toString() );

         //testing getSize()
         System.out.println( "\nTESTING getSize()" );
         System.out.println( "  Current queue: " + testQueue.toString() );
         System.out.println( "      Want: 5" );
         System.out.println( "      Got : " + testQueue.getSize() );

         System.out.println( "  dequeueing 1 element with value " + testQueue.dequeue() );
         System.out.println( "  Current queue: " + testQueue.toString() );
         System.out.println( "      Want: 4" );
         System.out.println( "      Got : " + testQueue.getSize() );

         System.out.println( "  dequeueing 1 element with value " + testQueue.dequeue() );
         System.out.println( "  Current queue: " + testQueue.toString() );
         System.out.println( "      Want: 3" );
         System.out.println( "      Got : " + testQueue.getSize() );

         System.out.println( "  dequeueing 1 element with value " + testQueue.dequeue() );
         System.out.println( "  Current queue: " + testQueue.toString() );
         System.out.println( "      Want: 2" );
         System.out.println( "      Got : " + testQueue.getSize() );

         System.out.println( "  dequeueing 1 element with value " + testQueue.dequeue() );
         System.out.println( "  Current queue: " + testQueue.toString() );
         System.out.println( "      Want: 1" );
         System.out.println( "      Got : " + testQueue.getSize() );

         //testing special case for peek() and dequeue()
         System.out.println( "\nTESTING peek() and dequeue() when size == 0" );
         try {
             System.out.println( "Peek: " + testQueue.peek() + " dequeue: " + testQueue.dequeue() );
         }
         catch( Exception e ) {
             System.out.println( e );
         }
         //expecting error for dequeueing and peeking from empty queue
         try {
             System.out.println( "Peek: " + testQueue.peek() + " dequeue: " + testQueue.dequeue() );
         }
         catch( Exception e ) {
             System.out.println( e );
         }

      }

   }
