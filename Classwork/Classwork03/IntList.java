/****************************************************
Author: Professor Johnson Editor: Moriah Tolliver
Date: 09/12/18 Purpose: Create a List implementation
*****************************************************/

public class IntList implements IntListInterface {
      private int[] theList;
      private int   size;

      private static final int STARTING_SIZE = 19;    // defines starting size; don't worry, we'll deal

      public IntList() {                        // doesn't HAVE to be declared public, but doesn't hurt
         theList = new int[STARTING_SIZE];
         size = 0;
      }

      public int getValueAtIndex( int index ) throws ArrayIndexOutOfBoundsException {
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

      private void addCapacity() {
          int[] theListTemp = new int[theList.length + STARTING_SIZE];
          for ( int j = 0; j < size; j++ ) {
              theListTemp[ j ] = theList[j];
          }
          theList = theListTemp;
      }

      public int removeValueAtIndex( int index ) throws ArrayIndexOutOfBoundsException {
          checkIndex( index );
          int value = theList[index];
          holeFiller( index );
          return value;
      }

      // Throws exception for an invalid index
      public void checkIndex( int index ) {
          if( size == 0 ) {
             System.out.println( "The list is empty!" );
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

      // 3 6 18 9 2
      //
      //insertValueAtIndex( 11,2)

      public String toString() {
        String listString = "";
        for ( int i = 0; i < size-1; i++ ) {
            listString += ( theList[i] == 0 ) ? "[ ]" : "[ " + theList[i] + " ]";
        }
        return listString;
      }


      public static void main( String[] args ) {
        IntList list = new IntList();
        list.append( 1 );
        list.append( 2 );
        list.append( 3 );
        list.append( 4 );
        list.append( 5 );
        list.append( 6 );
        list.append( 7 );
        list.append( 8 );
        list.append( 9 );
        list.append( 10 );
        list.append( 11 );
        list.append( 12 );
        list.append( 13 );
        list.append( 14 );
        list.append( 15 );
        list.append( 16 );
        list.append( 17 );
        list.append( 18 );
        list.append( 19 );
        System.out.println( list.toString() );
        System.out.println( list.insertValueAtIndex( 777 , 3 ) );
        System.out.println( list.toString() );
        System.out.println( list.removeValueAtIndex( 3 ) );
        System.out.println( list.toString() );
        // list.removeValueAtIndex( 5 );
        // System.out.println( list.toString() );

         // System.out.println( list.toString() );   // should return the value 7
         // System.out.println( list.toString() );
         // list.removeValueAtIndex( 3 );
         // list.removeValueAtIndex( 5 );
         // System.out.println( list.toString() );
         // System.out.println( list.getValueAtIndex( 3 ) );      // should return the value 11
         // System.out.println( list.getValueAtIndex( 18 ) );     // just to see what happens

      }
   }
