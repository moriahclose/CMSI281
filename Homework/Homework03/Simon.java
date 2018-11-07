/***********************************************************************
Authors: Moriah Tolliver and Tapiwa Tafa
Purpose: run game "Simon" with user input
*************************************************************************/
import java.util.*;

class Simon {

    //Main method that runs the game
    public static void main (String[] args) {
        Character[] colorInts  = {'R', 'G', 'B', 'Y'};

        String sequence = "";
        String backspaceString = "";

        System.out.println( "Welcome to Simon!" );

        boolean correctGuess = true;

        Scanner inputScanner = new Scanner(System.in);
        String inputGuess = "";

        //Keep adding new color character to sequence until player makes a wrong guess
        while ( correctGuess ) {
            int addedCharInt = (int)(Math.floor( Math.random() * 4 ));
            sequence += colorInts[addedCharInt];

            System.out.println( "The sequence is: " );
            for ( char color : sequence.toCharArray() ) {
                System.out.print( color );
                backspaceString += "\b";
                try {
                    Thread.sleep( 1000 );
                }
                catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.print( backspaceString );
            System.out.print("\n Enter the sequence: " );
            inputGuess = inputScanner.next();

            if ( inputGuess.equals(sequence) ) {
                correctGuess = true;
            }
            else {
                correctGuess = false;
                System.out.println( "Oops! The sequence was " + sequence + " but you typed " + inputGuess);
            }

        }
    }
}
