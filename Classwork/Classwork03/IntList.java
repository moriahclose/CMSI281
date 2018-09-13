/****************************************************
Author: Professor Johnson
Editor: Moriah Tolliver
Date: 09/12/18
Purpose: Create a List implementation
*****************************************************/
public class IntList implements IntListInterface {
      private int[] theList;
      private int   size;

      private static final int STARTING_SIZE = 19;    // defines starting size; don't worry, we'll deal

      public IntList() {                        // doesn't HAVE to be declared public, but doesn't hurt
         theList = new int[STARTING_SIZE];
         size = 0;
      }

      public int getValueAtIndex( int index ) throws EmptyListException, ArrayIndexOutOfBoundsException {
         checkIndex( index );
         return theList[index];
      }

      public boolean append( int valueToAdd ) {
         if( size >= theList.length ) {
            addCapacity();
         }
         theList[size] = valueToAdd;
         size++;
         return true;
      }

      public boolean prepend( int valueToAdd ) {
          if( size >= theList.length ) {
             addCapacity();
          }
          holeMaker( 0 );
          theList[ 0 ] = valueToAdd;
          size++;
          return true;
      }

      private void holeFiller( int index ) {
          for( int i = index; i < size - 1; i++ ) {
              theList[i] = theList[i+1];
          }
          size--;
      }

      private void holeMaker( int index ) {
          //move all the elements at or above the index up
          for ( int i = size; i >= index; i-- ) {
              if ( i + 1 >= theList.length ) { //if the list is not big enough, increase the capacity of the list by the starting size
                  addCapacity();
              }
              theList[ i + 1 ] = theList[ i ];
          }
      }

      //adds more space to a list
      private void addCapacity() {
          int[] theListTemp = new int[theList.length + STARTING_SIZE];
          for ( int j = 0; j < size; j++ ) {
              theListTemp[ j ] = theList[j];
          }
          theList = theListTemp;
      }

      public int removeValueAtIndex( int index ) throws EmptyListException, ArrayIndexOutOfBoundsException {
          checkIndex( index );
          int value = theList[index];
          holeFiller( index );
          return value;
      }

      // Throws exception for an invalid index
      public void checkIndex( int index ) {
          if( size == 0 ) {
            throw new EmptyListException( "The list is empty!" );
          } else if( index > size ) {
             throw new ArrayIndexOutOfBoundsException( "The index value is too large" );
          } else if( index < 0 ) {
             throw new ArrayIndexOutOfBoundsException( "The index value is too small");
          }
      }

      public boolean insertValueAtIndex( int value, int index ) {
          checkIndex( index );
          int replacedValue = theList[ index ];
          holeMaker( index );
          theList[ index ] = value;
          size++;
          return true;
      }

      public String toString() {
        String listString = "";
        for ( int i = 0; i < size; i++ ) {
            listString += ( theList[i] == 0 ) ? "[ ]" : "[ " + theList[i] + " ]";
        }
        return listString;
      }

      //main for testing
      public static void main( String[] args ) {
        IntList list = new IntList();

        //testing append
        list.append( 1 );
        list.append( 2 );
        list.append( 3 );
        list.append( 4 );
        list.append( 5 );
        System.out.println( list.toString() );

        //testing getValueAtIndex
        System.out.println( "Value at index 0: " + list.getValueAtIndex( 0 ) );
        System.out.println( "Value at index 1: " + list.getValueAtIndex( 1 ) );
        System.out.println( "Value at index 2: " + list.getValueAtIndex( 2 ) );
        System.out.println( "Value at index 3: " + list.getValueAtIndex( 3 ) );
        System.out.println( "Value at index 4: " + list.getValueAtIndex( 4 ) );

        //testing prepend
        list.append( 6 );
        System.out.println( "Appending 6" );
        list.append( 7 );
        System.out.println( "Appending 7" );
        list.append( 8 );
        System.out.println( "Appending 8" );
        list.append( 9 );
        System.out.println( "Appending 9" );
        list.append( 10 );
        System.out.println( "Appending 10" );
        System.out.println( list.toString() + "\n" );

        //testing removeValueAtIndex
        System.out.println( "Removing all odds" );
        list.removeValueAtIndex( 0 );
        list.removeValueAtIndex( 1 );
        list.removeValueAtIndex( 2 );
        list.removeValueAtIndex( 3 );
        list.removeValueAtIndex( 4 );
        System.out.println( list.toString() + "\n" );

        //testing insertValueAtIndex
        System.out.println( "Inserting negative odds" );
        list.insertValueAtIndex( -1 , 0 );
        list.insertValueAtIndex( -3 , 2 );
        list.insertValueAtIndex( -5 , 4 );
        list.insertValueAtIndex( -7 , 6 );
        list.insertValueAtIndex( -9 , 8 );
        System.out.println( list.toString() + "\n" );


        //testing prepend
        System.out.println( "Prepending pallindromes" );
        list.prepend( 98789 );
        list.prepend( 11122111 );
        list.prepend( 0101010 );
        System.out.println( list.toString() );
      }
   }
