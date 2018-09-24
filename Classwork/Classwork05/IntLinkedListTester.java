/************************************
* Author: B.J. Johnson
* Editor: Moriah Tolliver
* Purpose: Test IntLinkedList class
*************************************/
public class IntLinkedListTester {

      public static void main( String[] args ) {
         IntLinkedList myList = new IntLinkedList();

         System.out.println( "*******************ADDING ELEMENTS TO LIST*******************" );
         myList.prepend( 23 );
         myList.prepend( 19 );
         myList.prepend( 17 );
         myList.prepend( 13 );
         myList.prepend( 11 );
         myList.prepend(  7 );
         myList.prepend(  5 );
         myList.prepend(  3 );
         myList.prepend(  2 );
         System.out.println( "List looks like 2 3 5 7 11 13 17 19 23 \n" );

         //Testing Iterator
         System.out.println( "*******************TESTING ITERATOR*******************" );
         System.out.println( "Printing current node then using Iterator.next()" );
         IntLinkedList.Iterator myIt = myList.getIteratorAt( 0 );
         System.out.println( "     Current Node is: " + myIt.getCurrentInt() );    // 2
         myIt.next();
         System.out.println( "     Current Node is: " + myIt.getCurrentInt() );    // 3
         myIt.next();
         System.out.println( "     Current Node is: " + myIt.getCurrentInt() );    // 5
         myIt.next();
         System.out.println( "     Current Node is: " + myIt.getCurrentInt() );    // 7
         myIt = myList.getIteratorAt( 3 );
         System.out.println( "     Current Node is: " + myIt.getCurrentInt() );    // 7
         myIt.next();
         System.out.println( "     Current Node is: " + myIt.getCurrentInt() );    // 11
         myIt.next();
         System.out.println( "     Current Node is: " + myIt.getCurrentInt() );    // 13
         myIt.next();
         System.out.println( "     Current Node is: " + myIt.getCurrentInt() );    // 17

         //Testing insertAt()
         System.out.println( "\n*******************TESTING INSERT METHOD*******************" );
         System.out.println( "Inserting value 777 at index 5." );
         myList.insertAt( 5 , 777 );
         System.out.println( "     Want: 2 3 5 7 11 777 13 17 19 23" );
         System.out.print( "     Got : " + myList.toString() + "\n");

         System.out.println( "Inserting value 987 at index 0." );
         myList.insertAt( 0 , 987 );
         System.out.println( "     Want: 987 2 3 5 7 11 777 13 17 19 23" );
         System.out.print( "     Got : " + myList.toString() + "\n");

         System.out.println( "Inserting value 454 at index 10." );
         myList.insertAt( 10 , 454 );
         System.out.println( "     Want: 987 2 3 5 7 11 777 13 17 19 454 23" );
         System.out.print( "     Got : " + myList.toString() + "\n");

         //Testing removeAt()
         System.out.println( "\n*******************TESTING REMOVE METHOD*******************" );
         System.out.println( "Removing value at index 7. Value: " + myList.removeAt( 7 ) );
         System.out.println( "     Want: 987 2 3 5 7 11 777 17 19 454 23" );
         System.out.print( "     Got : " + myList.toString() + "\n" );

         System.out.println( "Removing value at index 0. Value: " + myList.removeAt( 0 ));
         System.out.println( "     Want: 2 3 5 7 11 777 17 19 454 23" );
         System.out.print( "     Got : " + myList.toString() + "\n" );

         System.out.println( "Removing value at index 9. Value: " + myList.removeAt( 9 ));
         System.out.println( "     Want: 2 3 5 7 11 777 17 19 454" );
         System.out.print( "     Got : " + myList.toString() + "\n" );
      }
   }
