/*****************************************************************************
Name: Moriah Tolliver         Date: 01/15/18          Purpose: Greet the user
Referenced Greeter.java from my own CMSI186 repository
******************************************************************************/
import java.util.Scanner;

public class SayHello {
   public static void main( String args[] ) {
       Scanner nameScanner = new Scanner(System.in);
       System.out.println( "What is your name?" );
       String userName = nameScanner.next();
       System.out.println( "\n  Hello, " + userName + "!" );
   }
}
