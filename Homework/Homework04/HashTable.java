import java.util.*;
import java.io.*;

public class HashTable {
    private ArrayList<String> table;
    private int divisor = 17;

    public HashTable() {
        table = new ArrayList<String>();
    }

    public void ensureSize( int minimumSize ) {
        if ( table.size() == minimumSize ) {
            return;
        }
        table.ensureCapacity( minimumSize );
        int index = 0;
        while ( table.size() < minimumSize ) {
            try {
                table.get( index );
            } catch( Exception e ) {
                table.add( null );
            }
            index++;
        }

    }

    public void insert( String inputString ) throws IllegalArgumentException {
        if ( table.indexOf( inputString.toLowerCase() ) > -1 ) {
            return;
        }
        int inputStringValue = 0;
        char[] stringCharArray = inputString.toLowerCase().toCharArray();
        for ( char character : stringCharArray ) {
            if ( character + 0 < 97 || character + 0 > 123 ) {
                throw new IllegalArgumentException();
            }
            inputStringValue += character;
        }
        int index = inputStringValue % divisor;
        ensureSize( index + 1);
        while ( table.get( index ) != null ) {
            index++;
            ensureSize( index + 1 );
        }
        ensureSize( index + 1 );
        table.set( index , inputString );
    }

    public String get( int index ) {
        return table.get( index );
    }

    public String toString() {
        String returnString = "";
        for ( String value : table ) {
            returnString += ( value != null ) ? " " + value + " " : " " + "--" + " ";
        }
        return returnString;
    }

    public static void main( String args[] ) {
        HashTable table = new HashTable();
        System.out.println( "Initializing Hash Table" );
        table.insert( "hello" );
        table.insert( "there" );
        table.insert( "sir" );
        table.insert( "melioration" );
        table.insert( "demystify" );
        System.out.println( "   hash table: " + table.toString() );

        System.out.println( "\nInsert values that intially have equal hash codes" );
        table.insert( "ad" );
        table.insert( "bc" );
        System.out.println( "   hash table: " + table.toString() );

        System.out.println( "\nTry inserting duplicate values" );
        table.insert( "melioration" );
        table.insert( "hello" );
        table.insert( "bc" );
        System.out.println( "   hash table: " + table.toString() );

        System.out.println( "\nTry inserting values that contain valid and invalid characters" );
        try {
            table.insert( "*****" );
        } catch( Exception e ) {
            System.out.println( "   Correctly threw error for input '*****'" );
        }
        try {
            table.insert( "H3ll0" );
        } catch( Exception e ) {
            System.out.println( "   Correctly threw error for input 'H3ll0'" );
        }
        try {
            table.insert( "How is it going" );
        } catch( Exception e ) {
            System.out.println( "   Correctly threw error for input 'How is it going'" );
        }
        try {
            table.insert( "HELLO" );
        } catch( Exception e ) {
            System.out.println( "   UhOh! Input value 'HELLO' should have been converted to lower case then inserted, but instead an error was thrown." );
        }
        System.out.println( "   hash table: " + table.toString() );
    }
}
