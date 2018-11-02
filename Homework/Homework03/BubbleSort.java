/***********************************************************************
Author: Robert Lafore
Editors: Moriah Tolliver and Tapiwa Tafa
Purpose: Demonstrates bubble sort and odd-even sort
*************************************************************************/

class BubbleSort {

    private long[] a;       // ref to array a
    private int nElems;     // number of data items

    public BubbleSort( int max ) {
        a = new long[max];      // create the array
        nElems = 0;             // no items yet
    }

    public void insert( long value ) {  // put element into array
        a[nElems] = value;              // insert it
        nElems++;                       // increment size
    }

    public void display() {                     // displays array
        for( int j = 0; j < nElems; j++ ) {     // for each element,
            System.out.print( a[j] + " " );   // display it
        }
        System.out.println();
    }

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

    private void swap( int one, int two ) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

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

        System.out.println( "---------------TESTING oddEvenSort() with two elements---------------");
        BubbleSort twoItems = new BubbleSort(2);
        twoItems.insert(121);
        twoItems.insert(90);

        twoItems.display();
        twoItems.oddEvenSort();
        twoItems.display();

        System.out.println( "---------------TESTING oddEvenSort() with presorted elements---------------");
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


    }

}
