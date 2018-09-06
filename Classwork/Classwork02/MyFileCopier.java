/*****************************************************************************
Name: Moriah Tolliver         Date: 01/15/18          Purpose: Greet the Copy a file
Referenced Greeter.java from my own CMSI186 repository
******************************************************************************/

import copiersupport.*;
import java.util.Scanner;

public class MyFileCopier {

    public MyFileCopier() {
        super();
    }

    public static void main(String args[] ) {
        //get the input file name
        Scanner fileNameScanner = new Scanner(System.in);
        System.out.println( "Please enter a file name: " );
        String fileName = fileNameScanner.next();

        //get the contents of the source file
        SourceFile sourceFile = new SourceFile( fileName );
        sourceFile.close();
        TargetFile targetFile = new TargetFile( fileName , sourceFile.getContents() );
        targetFile.close();
    }

}
