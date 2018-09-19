/*********************************************************
Author: Robert Lafore
Editors: Moriah Tolliver and Tapiwa Tafa
Purpose Demonstrates array class with high-level interface
**********************************************************/

/**
* Class with main used for testing
**/
public class HighArrayApp {
    public static void main( String args[] ) {
        int maxSize = 100;
        HighArray arr = new HighArray( maxSize );

        //testing insert
        System.out.println( "******TESTING insert( int )******" );
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
        arr.insert(44);
        System.out.println( "Want: 77 99 44 55 22 88 11 0 66 33 44" );
        System.out.print( "Got : " );
        arr.display();

        //testing find
        System.out.println( "\n******TESTING find( int )******" );
        System.out.print( "Here's the array: " );
        arr.display();

        int searchKey = 35;
        System.out.println( ( arr.find( searchKey ) ) ? "Found " + searchKey : "Can't find " + searchKey );

        searchKey = 77;
        System.out.println( ( arr.find( searchKey ) ) ? "Found " + searchKey : "Can't find " + searchKey );

        searchKey = 33;
        System.out.println( ( arr.find( searchKey ) ) ? "Found " + searchKey : "Can't find " + searchKey );

        arr.delete( 33 );
        System.out.print( "New array: " );
        arr.display();
        System.out.println( ( arr.find( searchKey ) ) ? "Found " + searchKey : "Can't find " + searchKey );

        searchKey = 555;
        arr.insert( 555 );
        System.out.print( "New array: " );
        arr.display();
        System.out.println( ( arr.find( searchKey ) ) ? "Found " + searchKey : "Can't find " + searchKey );


        //testing getMax()
        System.out.println( "\n******TESTING getMax()******");
        System.out.print( "Here's the array: " );
        arr.display();
        System.out.println( "Max nubmer: " + arr.getMax() + "\n" );

        arr.delete( 555 );
        arr.display();
        System.out.println( "Max nubmer: " + arr.getMax()  + "\n" );

        arr.insert( -999 );
        arr.display();
        System.out.println( "Max nubmer: " + arr.getMax()  + "\n" );

        arr.delete( 99 );
        arr.display();
        System.out.println( "Max nubmer: " + arr.getMax()  + "\n" );

        arr.delete( 88 );
        arr.display();
        System.out.println( "Max nubmer: " + arr.getMax()  + "\n" );

        arr.insert( 123 );
        arr.display();
        System.out.println( "Max nubmer: " + arr.getMax()  + "\n" );

        arr.delete( -999 );
        arr.delete( 66 );
        arr.delete( 123 );
        arr.display();
        System.out.println( "Max nubmer: " + arr.getMax() );

        // testing noDupes
        System.out.println( "\n******TESTING NoDupes******" );
        arr.insert( 19 );
        arr.insert( 21 );
        arr.insert( 38 );
        arr.insert( 19 );
        System.out.print( "Array with duplicates: " );
        arr.display();
        arr.noDups();
        System.out.print( "Array without duplicates: " );
        arr.display();

        arr.insert( 19 );
        arr.insert( 21 );
        arr.insert( 38 );
        arr.insert( 55 );
        arr.insert( 55 );
        arr.insert( 55 );
        System.out.print( "\nArray with duplicates: " );
        arr.display();
        arr.noDups();
        System.out.print( "Array without duplicates: " );
        arr.display();

        arr.insert( 555 );
        System.out.print( "\nArray without duplicates: " );
        arr.display();
        arr.noDups();
        System.out.print( "Should be same as above: " );
        arr.display();


        arr.insert( 77 );
        System.out.print( "\nArray with duplicate at front: " );
        arr.display();
        arr.noDups();
        System.out.print( "Array without duplicates: " );
        arr.display();

        arr.insert( 555 );
        System.out.print( "\nArray with duplicates at end: " );
        arr.display();
        arr.noDups();
        System.out.print( "Array without duplicates: " );
        arr.display();
    }
}
