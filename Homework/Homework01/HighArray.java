/*********************************************************
Author: Robert Lafore
Edited by Moriah Tolliver and Tapiwa Tafa to fit styling preferences
Purpose Demonstrates array class with high-level interface
**********************************************************/

class HighArray {
    private long[] a;   // ref to array a
    private int nElems;  // number of data items
    private static final long EMPTY_ARRAY = -1;

    /*
    * Constructor
    */
    public HighArray( int max ) {
        a = new long[max];
        nElems = 0; //number of elements set to 0
    }

    /**
    * Returns boolean if input value is found in HighArray
    * @return boolean true if value is in HighArray, false otherwise
    */
    public boolean find( long searchKey ) {
        int j;
        for ( j = 0; j < nElems; j++ ) {
            if ( a[j] == searchKey )
                return true;
        }
        return false;
    }

    /**
    * Inserts input value to front of HighArray
    */
    public void insert( long value ) {
        a[nElems] = value;
        nElems++;
    }

    /**
    * Deletes all instances of a value from the HighArray
    * @return boolean true if value has been deleted, false otherwise
    */
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

    /**
    * Display contents of HighArray
    */
    public void display() {
        for ( int j = 0; j < nElems; j++ ) {
            System.out.print( a[j] + " ");
        }
        System.out.println();
    }

    /**
    * Return maximum value in the HighArray
    * @return long with maximum value from HighArray
    */
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

    /**
    * Return array representation of HighArray
    * @return long[] array of values in the HighArray
    */
    public long[] getArray() {
        return this.a;
    }

    /**
    * Moves elements of HighArray down to replace deleted element
    *  
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
