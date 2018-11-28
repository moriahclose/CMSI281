/********************************************************************************************************************************
Authors: Moriah Tolliver and Tapiwa Tafa
Purpose: Demonstrates hash table data structure
********************************************************************************************************************************/
import java.util.*;
import java.io.*;

public class HashTable {
    private ArrayList<String> table;
    private int size;
    private int DIVISOR = 17;

    /**
     * Constructor
     */
    public HashTable() {
        table = new ArrayList<String>();
        size = 0;
    }

    /**
     * Make array list have a minimum size
     * @param int minimum size to make array list
     */
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

    /**
     * Insert key using hashing function
     * @param String string serving as key
     * @throws Exception IllegalArgumentException if key contains characters other than letters
     */
    public void insert( String inputString ) throws IllegalArgumentException {
        if ( table.indexOf( inputString.toLowerCase() ) > -1 ) {
            return;
        }

        int index = hashCode( inputString );
        ensureSize( index + 1);
        while ( table.get( index ) != null ) {
            index++;
            ensureSize( index + 1 );
        }
        ensureSize( index + 1 );
        table.set( index , inputString );
        size++;
    }

    /**
     * Generates hash code for input string
     * @param String to generate hash code for
     * @return int hash code for string
     * @throws IllegalArgumentException if input string contains characters other than letters
     */
    private int hashCode( String inputString ) throws IllegalArgumentException {
        int inputStringValue = 0;
        char[] stringCharArray = inputString.toLowerCase().toCharArray();
        for ( char character : stringCharArray ) {
            if ( character + 0 < 97 || character + 0 > 123 ) {
                throw new IllegalArgumentException();
            }
            inputStringValue += character;
        }

        int index = inputStringValue % DIVISOR;

        return index;
    }

    /**
     * Return if hash table contains a value
     * @param String value to search for
     * @return boolean true if value is in the hash table, false otherwise
     */
    public boolean contains( String value ) {
        return ( table.indexOf( value.toLowerCase() ) > -1 );
    }

    /**
     * Remove value from hash table
     * @param String value to remove
     * @return boolean true if value is successfully removed, false otherwise
     */
    public boolean remove( String value ) {
        boolean removed = table.remove( value );
        if ( removed ) {
            size--;
        }
        return removed;
    }

    /**
     * Return number of elements in the hash table
     * @return int number of elements in the hash table
     */
    public int size() {
        return size;
    }

    /**
     * Return string representation of the hash table
     * @return string represent hash table with '--' representing null
     */
    public String toString() {
        String returnString = "";
        for ( String value : table ) {
            returnString += ( value != null ) ? " " + value + " " : " " + "--" + " ";
        }
        return returnString;
    }

    /**
     * Main used for testing
     */
    public static void main( String args[] ) {
        HashTable table = new HashTable();
        System.out.println( "------------TESTING INSERT------------" );
        System.out.println( "INITINALIZING HASH TABLE" );
        table.insert( "hello" );
        table.insert( "there" );
        table.insert( "sir" );
        table.insert( "melioration" );
        table.insert( "demystify" );
        System.out.println( "   hash table: " + table.toString() );

        System.out.println( "\nINSERT VALUES THAT INITIALLY HAVE EQUAL HASH CODES" );
        table.insert( "ad" );
        table.insert( "bc" );
        System.out.println( "   hash table: " + table.toString() );

        System.out.println( "\nTRY INSERTING DUPLICATE VALUES" );
        table.insert( "melioration" );
        table.insert( "hello" );
        table.insert( "bc" );
        System.out.println( "   hash table: " + table.toString() );

        System.out.println( "\nTRY INSERTING VALUES THAT CONTAIN VALID AND INVALID CHARACTERS" );
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

        System.out.println( "\n------------TESTING CONTAINS------------" );
        System.out.println( "   hash table: " + table.toString() );
        System.out.println( "   The table " + (( table.contains( "hello" ) ) ? "contains " : "does not contain ") + "'hello'" );
        System.out.println( "   The table " + (( table.contains( "November" ) ) ? "contains " : "does not contain ") + "'November'" );
        System.out.println( "   The table " + (( table.contains( "" ) ) ? "contains " : "does not contain ") + "' '" );
        System.out.println( "   The table " + (( table.contains( "melioration" ) ) ? "contains " : "does not contain ") + "melioration" );

        System.out.println( "\n------------TESTING REMOVE------------" );
        System.out.println( "   hash table: " + table.toString() );
        table.remove( "hello" );
        System.out.println( "   Removing 'hello' results in the hash table: " +  table.toString() );
        table.remove( "what" );
        System.out.println( "   Removing 'what' results in the hash table: " +  table.toString() );
        table.remove( "melioration" );
        System.out.println( "   Removing 'melioration' results in the hash table: " +  table.toString() );

        System.out.println( "\n------------TESTING SIZE------------" );
        System.out.println( "   hash table: " + table.toString() );
        System.out.println( "   Hash table currently has size " + table.size() );
        table.remove( "there" );
        System.out.println( "   Removing 'there' results in a hash table of size " +  table.size() );
        table.remove( "demystify" );
        System.out.println( "   Removing 'demystify' results in the hash table of size " +  table.size() );
        table.remove( "ad" );
        System.out.println( "   Removing 'ad' results in the hash table of size " +  table.size() );
        System.out.println( "   hash table: " + table.toString() );

    }
}
