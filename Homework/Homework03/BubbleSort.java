/***********************************************************************
Author: Robert Lafore
Editors: Moriah Tolliver and Tapiwa Tafa
Purpose: Demonstrates bubble sort and odd-even sort
*************************************************************************/

class BubbleSort {

    private long[] a;       // ref to array a
    private int nElems;     // number of data items

    /**
     * Constructor
     * @param int maximum number of slots in the array
     */
    public BubbleSort( int max ) {
        a = new long[max];      // create the array
        nElems = 0;             // no items yet
    }

    /**
     * Inserts input value at the end of the array
     * @param long value to insert in the array
     */
    public void insert( long value ) {
        a[nElems] = value;
        nElems++;
    }

    /**
     * Prints the contents of the array
     */
    public void display() {
        for( int j = 0; j < nElems; j++ ) {
            System.out.print( a[j] + " " );
        }
        System.out.println();
    }

    /**
     * Sorts contents of the array using the Bubble Sort algorithm
     */
    public void bubbleSort() {
        int out, in;

        for( out = nElems-1; out > 1; out-- ) {
            for ( in = 0; in < out; in++ ) {
                if ( a[in] > a[in+1] ) {
                    swap( in , in+1 );
                }
            }
        }
    }

    /**
     * Sorts contents of the array using the Odd Event Sort algorithm
     */
    public void oddEvenSort() {
        for ( int i = 0; i < nElems; i++ ) {
            for ( int j = 1; j < nElems-1; j+=2 ) {
                if ( a[j] > a[j+1] ) {
                    swap( j , j+1 );
                }
            }
            for ( int j = 0; j < nElems-1; j+=2 ) {
                if ( a[j] > a[j+1] ) {
                    swap( j , j+1 );
                }
            }
        }
    }

    /**
     * Swaps the contents of two items in the array
     * @param int one index of the first value to swap
     * @param int two index of the second value to swap
     */
    private void swap( int one, int two ) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    /**
     * Main used for testing
     */
    public static void main( String[] args ) {
        int maxSize = 100;              // array size
        BubbleSort arr;                 // reference to array
        arr = new  BubbleSort(maxSize); // create the array


        System.out.println( "---------------TESTING oddEvenSort()---------------");
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

        arr.display();                 // display items
        arr.oddEvenSort();             // bubble sort them
        arr.display();                 // display sorted items

        System.out.println( "\n---------------TESTING oddEvenSort() with two elements---------------");
        BubbleSort twoItems = new BubbleSort(2);
        twoItems.insert(121);
        twoItems.insert(90);

        twoItems.display();
        twoItems.oddEvenSort();
        twoItems.display();

        System.out.println( "\n---------------TESTING oddEvenSort() with presorted elements---------------");
        BubbleSort alreadySorted = new BubbleSort( 10 );
        alreadySorted.insert( 0 );
        alreadySorted.insert( 12 );
        alreadySorted.insert( 23 );
        alreadySorted.insert( 34 );
        alreadySorted.insert( 45 );
        alreadySorted.insert( 56 );
        alreadySorted.insert( 67 );
        alreadySorted.insert( 78 );
        alreadySorted.insert( 89 );
        alreadySorted.insert( 99 );

        alreadySorted.display();
        alreadySorted.oddEvenSort();
        alreadySorted.display();

        System.out.println( "\n---------------TESTING oddEvenSort() with one element---------------");
        BubbleSort oneItem = new BubbleSort(1);
        oneItem.insert(90);

        oneItem.display();
        oneItem.oddEvenSort();
        oneItem.display();
    }

}
