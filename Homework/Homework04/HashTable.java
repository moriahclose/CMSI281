/********************************************************************************************************************************
Authors: Moriah Tolliver and Tapiwa Tafa
Purpose: Demonstrates hash table data structure and folding-digit hash function
********************************************************************************************************************************/
import java.util.*;
import java.io.*;

public class HashTable {
    private ArrayList<Object> table;
    private int size;
    private int DIVISOR = 17;

    /**
     * Constructor
     */
    public HashTable() {
        table = new ArrayList<Object>();
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
     * @throws Exception IllegalArgumentException if key is string and contains characters other than letters
     */
    public void insert( Object input ) throws IllegalArgumentException {
        int index;
        if ( input.getClass().equals( String.class ) ) {
            String inputString = input.toString();
            if ( table.indexOf( inputString.toLowerCase() ) > -1 ) {
                return;
            }
            index = hashCode( inputString );
        }
        else if ( input.getClass().equals( Integer.class ) ) {
            index = foldHashCode( Integer.parseInt( input.toString() ) );
        }
        else {
            throw new IllegalArgumentException();
        }

        ensureSize( index + 1);
        while ( table.get( index ) != null ) {
            index++;
            ensureSize( index + 1 );
        }
        ensureSize( index + 1 );

        if ( input.getClass().equals( String.class ) ) {
            table.set( index , input.toString() );
        }
        else {
            table.set( index , Integer.parseInt( input.toString() ) );
        }
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
     * Uses digit folding to generate hash code for input number
     * @param int number to generate hash code for
     * @return int hash code of input number
     */
    private int foldHashCode( int inputNumber ) {
        String numberString = Integer.toString( inputNumber );
        int chunkLength = 3;
        int hashCode = 0;

        while ( numberString.length() >= 3 ) {
            hashCode += Integer.parseInt( numberString.substring( 0 , 3) );
            numberString = numberString.substring( 3 );
        }
        if ( numberString.length() > 0 ) {
            hashCode += Integer.parseInt( numberString );
        }
        return hashCode % DIVISOR;
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
        for ( Object value : table ) {
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

        System.out.println( "\n------------TESTING FOLDING-DIGIT HASH------------" );
        HashTable myNums = new HashTable();
        System.out.println( "   Inserting 103, 107, 109, 113, 127" );
        myNums.insert( 103 );
        System.out.println( "   hash code for 103: " + myNums.foldHashCode( 103 ) );
        myNums.insert( 107 );
        System.out.println( "   hash code for 107: " + myNums.foldHashCode( 107 ) );
        myNums.insert( 109 );
        System.out.println( "   hash code for 109: " + myNums.foldHashCode( 109 ) );
        myNums.insert( 113 );
        System.out.println( "   hash code for 113: " + myNums.foldHashCode( 113 ) );
        myNums.insert( 127 );
        System.out.println( "   hash code for 127: " + myNums.foldHashCode( 127 ) );
        System.out.println( "   hash table: " + myNums.toString() );

        System.out.println( "\n   Inserting 0" );
        myNums.insert( 0 );
        System.out.println( "   hash code for 0: " + myNums.foldHashCode( 0 ) );
        System.out.println( "   hash table: " + myNums.toString() );

        System.out.println( "\n   Inserting 123456" );
        myNums.insert( 123456 );
        System.out.println( "   hash code for 123456: " + myNums.foldHashCode( 123456 ) );
        System.out.println( "   hash table: " + myNums.toString() );

        System.out.println( "\n   Inserting 9876543" );
        myNums.insert( 9876543 );
        System.out.println( "   hash code for 9876543: " + myNums.foldHashCode( 9876543 ) );
        System.out.println( "   hash table: " + myNums.toString() );

        System.out.println( "\n   Inserting 20" );
        myNums.insert( 20 );
        System.out.println( "   hash code for 20: " + myNums.foldHashCode( 20 ) );
        System.out.println( "   hash table: " + myNums.toString() );
    }
}
