/*****************************************************************************************************
Author: Moriah Tolliver         Date: 09/06/2018          Purpose: Copy an existing file into a new file
*****************************************************************************************************/

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

        //copy the contents of the source file into the new file
        TargetFile targetFile = new TargetFile( fileName , sourceFile.getContents() );
        targetFile.close();

        System.out.println( "File copied into " + targetFile.getTargetFileName() );
    }

}
