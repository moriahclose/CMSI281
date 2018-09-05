/*****************************************************************************
Name: Moriah Tolliver         Date: 01/15/18          Purpose: Greet the Copy a file
Referenced Greeter.java from my own CMSI186 repository
******************************************************************************/
package copiersupport;

import copiersupport.*;
import java.io.FileReader;

public class SourceFile {

    private String fileName;
    private String fileContents;
    private FileReader fileReader;

    public SourceFile( String inputFileName ) {
        fileName = inputFileName;

        try {
            fileReader = new FileReader( fileName );
        }
        catch( Exception e ) {
            System.out.println( e );
        }

        int readText;
        while( (readText = fileReader.read()) != -1 ) {
            fileContents += readText;
        }
    }

    public String getContents() {
        return fileContents;
    }

    public static void main(String args[] ) {
        TargetFile targetFile = new TargetFile( "output.txt" );
    }

}
