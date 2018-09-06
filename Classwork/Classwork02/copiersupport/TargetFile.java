/*****************************************************************************
Name: Moriah Tolliver         Date: 01/15/18          Purpose: Greet the Copy a file
Referenced Greeter.java from my own CMSI186 repository
******************************************************************************/
package copiersupport;

import java.io.FileWriter;
import java.io.IOException;

public class TargetFile {

    private static String sourceFileName;
    private static String outputFileName;
    private static String fileContents;
    private static FileWriter fileWriter;
    private static boolean APPEND_TO_FILE = false;  //program overwrites the ouput file every time there is a new instance of the FileWriter with the same TargetFile


    public TargetFile( String inputSourceFileName , String inputFileContents ) {

        //initialize file variables
        sourceFileName = inputSourceFileName;
        outputFileName = sourceFileName + "copy.txt";
        fileContents = inputFileContents;

        //make sure file writer is properly created
        try {
            fileWriter = new FileWriter( outputFileName , true);
        }
        catch( Exception e ) {
            System.out.println( e );
        }

        //add all characters in file to output file
        try { fileWriter.write( fileContents ); }
        catch( Exception e ) { System.out.println( e ); }
    }

    public static void close() {
        try { fileWriter.close(); }
        catch( Exception e ) { System.out.println( e ); }
    }

    public static void main(String args[] ) {
    }

}
