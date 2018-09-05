/*****************************************************************************
Name: Moriah Tolliver         Date: 01/15/18          Purpose: Greet the Copy a file
Referenced Greeter.java from my own CMSI186 repository
******************************************************************************/

import copiersupport.*;
import java.util.Scanner;

public class MyFileCopier {


    public MyFileCopier() {

    }

    public static void main(String args[] ) {
        //get the input file name
        Scanner fileNameScanner = new Scanner(System.in);
        System.out.println( "Please enter a file name: " );
        String fileName = fileNameScanner.next();

        SourceFile sourceFile = new SourceFile( fileName );
    }

}
