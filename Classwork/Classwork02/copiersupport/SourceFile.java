/*****************************************************************************
Name: Moriah Tolliver         Date: 01/15/18          Purpose: Greet the Copy a file
Referenced Greeter.java from my own CMSI186 repository
******************************************************************************/
package copiersupport;

import java.io.FileReader;
import java.io.IOException;

public class SourceFile {

    private static String fileName;
    private static String fileContents;
    private static char[] fileContentsArray;
    private static FileReader fileReader;

    public SourceFile( String inputFileName ) {
        //initialize file variables
        fileName = inputFileName;
        fileContents = "";

        //make sure file reader is properly created
        try {
            fileReader = new FileReader( fileName );
        }
        catch( Exception e ) {
            System.out.println( e );
        }

        //add all characters in file to fileContents variable
        int lastCharRead = 0;
        while ( lastCharRead != -1 ) {
            try { lastCharRead = fileReader.read(); }
            catch( Exception e ) { System.out.println( e ); }
            fileContents += Character.toString((char)lastCharRead);
        }

        //remove extra character added to end
        fileContents = fileContents.substring( 0, fileContents.length()-1 );
    }


    public static String getContents() {
        return fileContents;
    }

    public static void close() {
        try { fileReader.close(); }
        catch( Exception e ) { System.out.println( e ); }
    }

    public static void main(String args[] ) {
    }

}
