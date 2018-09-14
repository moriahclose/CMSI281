/*********************************************************
Author: Robert Lafore
Edited by Moriah Tolliver to fit styling preferences
Purpose Demonstrates array class with high-level interface
**********************************************************/

class HighArray {
    private long[] a;   // ref to array a
    private int nElems;  // number of data items

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

    public boolean delete( long value ) {
        int j;
        for ( j = 0; j < nElems; j++ ) {
            if ( value == a[j] ) {
                for ( int k = j; k < nElems; k++ ) {
                    a[k] = a[k + 1];
                }
                nElems--;
                return true;
            }
        }
        return false;
    }

    public void display() {
        for ( int j = 0; j < nElems; j++ ) {
            System.out.print( a[j] + " ");
        }
        System.out.println();
    }

    public static void main( String args[] ) {
        int maxSize = 100;
        HighArray arr = new HighArray( maxSize );

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        int searchKey = 35;
        String findString = ( arr.find( searchKey ) ) ? "Found " + searchKey : "Can't find " + searchKey;
        System.out.println( findString );

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();

    }
}
