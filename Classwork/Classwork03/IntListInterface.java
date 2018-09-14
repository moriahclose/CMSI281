/****************************************************
Author: B.J. Johnson
Date: 09/12/18
Purpose: Create a List implementation
*****************************************************/
public interface IntListInterface {
      int getValueAtIndex( int index );
      boolean append( int valueToAdd );
      boolean insertValueAtIndex( int value, int index );
      int removeValueAtIndex( int index );
}
