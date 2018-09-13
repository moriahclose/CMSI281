/**************************************************************************************
Author: Rion Williams via Stack Overflow
Editor: Moriah Tolliver
Date: 9/13/2018
Purpose: create an exception to throw when trying to perform operations on an empty list
***************************************************************************************/

public class EmptyListException extends ArrayIndexOutOfBoundsException
{
      // Parameterless Constructor
      public EmptyListException() {
          super();
      }

      // Constructor that accepts a message
      public EmptyListException( String message )
      {
         super(message);
      }
 }
