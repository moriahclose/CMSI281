/*********************************************************
Author: Robert Lafore
Edited by Moriah Tolliver to fit styling preferences
Purpose Demonstrates array class with high-level interface
**********************************************************/

class HighArray {
    private long[] a;   // ref to array a
    private int nElems;  // number of data items
    private static final long EMPTY_ARRAY = -1;

    public HighArray( int max ) {
        a = new long[max];
        nElems = 0; //number of elements set to 0
    }

    public boolean find( long searchKey ) {
        int j;
        for ( j = 0; j < nElems; j++ ) {
            if ( a[j] == searchKey )
                return true;
        }
        return false;
    }

    public void insert( long value ) {
        a[nElems] = value;
        nElems++;
    }

    //deletes all instances of a number including duplicates
    public boolean delete( long value ) {
        int j;
        int deleteCheck = 0;    //used this int so loop continues and duplicates can be deleted
        for ( j = 0; j < nElems; j++ ) {
            if ( value == a[j] ) {
                holeFiller( j );
                nElems--;
                deleteCheck--;
            }
        }
        return ( deleteCheck < 0 ) ? true : false;
    }

    public void display() {
        for ( int j = 0; j < nElems; j++ ) {
            System.out.print( a[j] + " ");
        }
        System.out.println();
    }

    public long getMax() {
        long maxValue;

        if ( nElems == 0 )
            return EMPTY_ARRAY;
        else {
            maxValue = a[0];
            for ( int i = 0; i < nElems; i++ ) {
                if ( maxValue < a[i] ) {
                    maxValue = a[i];
                }
            }
        }
        return maxValue;
    }

    public long[] getArray() {
        return this.a;
    }

    //helper method to shift elements when element has been deleted
    public void holeFiller( int index ) {
        for ( int i = index; i < nElems; i++ ) {
            a[i] = a[i + 1];
        }
    }

    //removes duplicate elements
    //returns true if duplicates are removed and false if nothing is removed
    public boolean noDups() {
        HighArray dupless = new HighArray( a.length ); //will be temp HighArray holding only one copy of each number in a
        boolean didRemovedDup = false; //true if a duplicate element is removed, false otherwise

        int tempNumElems = 0; //will construct new array without duplicates so setting number of elements to 0

        for ( int i = 0; i < nElems; i++ ) {
            if ( !dupless.find( a[i] ) ) {
                dupless.insert( a[i] );
                didRemovedDup = true;
                tempNumElems++;
            }
        }
        this.a = dupless.getArray();
        this.nElems = tempNumElems;
        return didRemovedDup;
    }
}
