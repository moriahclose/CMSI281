/*********************************************************
Author: Robert Lafore
Edited by Moriah Tolliver to fit styling preferences
Purpose Demonstrates array class with high-level interface
**********************************************************/

class HighArray {
    private long[] a;   // ref to array a
    private in nElems;  // number of data items

    public HighArray( int max ) {
        a = new long[max];
        nElems = 0; //number of elements set to 0
    }

    public boolean find( long searchKey ) {
        int j;
        for ( j = 0; j < nElems; j++ ) {
            if ( a[j] == searchKey )
                break;
            if ( j == nElems )
                return false;
            else
                return true;
        }
    }

    public void insert( long value ) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete( long value ) {
        int j;
        for ( j = 0; j < nElems; j++ ) {
            if ( value == a[j] )
                break;
            if ( j == nElems )
                return false;
            else {
                for ( int k = j; k < nElems; k++ ) {
                    a[k] = a[k + 1];
                }
            }
        }
    }

    public void display() {
        for ( int j = 0; j < nElems; j++ ) {
            System.out.println( a[j] + " " + "\n" );
        }
    }
}
