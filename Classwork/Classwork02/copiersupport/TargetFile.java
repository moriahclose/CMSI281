/********************************************************************************************************************
Author: Moriah Tolliver         Date: 09/06/2018          Purpose: Enter the contents of an input file into a new file
********************************************************************************************************************/
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
        outputFileName = sourceFileName + ".copy";
        fileContents = inputFileContents;

        //make sure file writer is properly created
        try {
            fileWriter = new FileWriter( outputFileName , APPEND_TO_FILE);
        }
        catch( Exception e ) {
            System.out.println( e );
        }

        //add all characters in source file to output file
        try { fileWriter.write( fileContents ); }
        catch( Exception e ) { System.out.println( e ); }
    }

    public static String getTargetFileName() {
        return outputFileName;
    }

    public static void close() {
        try { fileWriter.close(); }
        catch( Exception e ) { System.out.println( e ); }
    }
}
