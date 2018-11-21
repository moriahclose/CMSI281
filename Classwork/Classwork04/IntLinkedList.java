/************************************************
* Author: B.J. Johnson
* Editor: Moriah Tolliver
* Purpose: Demonstrate mechanics of a Linked List
************************************************/

public class IntLinkedList {

      private Node head;
      private int  size;

      /**
       * Constructor
       */
      IntLinkedList() {
         head = null;
         size = 0;
      }

      /**
       * Returns number of elements in the list
       * @return int number of elements in the list
       */
      public int getSize() {
         return size;
      }

      /**
       * Adds node to the beginning of the list
       * @param int value for new node
       */
      public void prepend( int dataToAdd ) {
         Node currentHead = head;
         head = new Node( dataToAdd );
         head.next = currentHead;
         size++;
      }

      /**
       * Internal class that creates node object
       */
      private class Node {

         int data;            // remember this is an IntLinkedList
         Node next;           // here's the self-referential part

         /**
          * Constructor
          * @param int value node will contain
          */
         Node( int d ) {
            data = d;
            next = null;
         }
      }

      /**
       * Creates iterator whose current node points to the input Index
       * @param int index for currentNode to point at
       */
      public Iterator getIteratorAt( int index ) {
         if( (index > size) || (index < 0) ) {
            throw new IllegalArgumentException();
         }
         Iterator it = new Iterator();
         while( index > 0 ) {
            it.next();
            index--;
         }
         return it;
      }

      /**
       * Internal class that creates an Iterator that goes through the list sequentially
       */
      public class Iterator {
         private Node currentNode;

         /**
          * Constructor
          */
         Iterator() {
            currentNode = head;
         }

         /**
          * Moves the currentNode the next node in the list
          */
         public void next() {
            if( currentNode == null ) {
               return;
            } else {
               currentNode = currentNode.next;
            }
         }

         /**
          * Returns boolean representing if there is a node after the current node
          * @return boolean true if there is a node sequentially after the current node, false otherwise
          */
         public boolean hasNext() {
            return ((currentNode != null) && (currentNode.next != null));
         }

         public int getCurrentInt() {
            return currentNode.data;
         }

      }

      /**
       * Inserts a new node of input value at input index into the list
       * @param int index for new node to be inserted at
       * @param int value for the new node to hold
       */
      public void insertAt( int index , int value ) {
          if ( index > size - 1 || index < 0 ) {
              throw new IllegalArgumentException( "Index is invalid." );
          }
          if ( index == 0 ) {
              Node newNode = new Node( value );
              newNode.next = this.head;
              this.head = newNode;
          }
          else {
              Iterator myIt = this.getIteratorAt( index - 1 );
              Node newNode = new Node( value );
              newNode.next = myIt.currentNode.next;
              myIt.currentNode.next = newNode;
          }
          size++;
      }

      /**
       * Removes a node at the input index
       * @param int index where node is to be removed
       * @return int value of node that was removed
       */
      public int removeAt( int index ) {
          if ( index > size - 1 || index < 0 ) {
              throw new IllegalArgumentException( "Index is invalid." );
          }

          int deletedValue;
          if ( index == 0 ) {
              deletedValue = this.head.data;
              this.head = this.head.next;
          }
          else if ( index == size - 1 ) {
              Iterator myIt = this.getIteratorAt( index - 1 );
              deletedValue = myIt.currentNode.next.data;
              myIt.currentNode.next = null;
          }
          else {
              Iterator myIt = this.getIteratorAt( index - 1 );
              deletedValue = myIt.currentNode.next.data;
              myIt.currentNode.next = myIt.currentNode.next.next;
          }
          size--;
          return deletedValue;
      }

      /**
       * Returns a string representation of the IntLinkedList
       * @return string space delminated list of IntLinkedList values
       */
      public String toString() {
          String stringRepresenation = "";
          Iterator myIt = this.getIteratorAt( 0 );
          while ( myIt.hasNext() ) {
              stringRepresenation += myIt.getCurrentInt() + " ";
              myIt.next();
          }
          stringRepresenation += myIt.getCurrentInt();
          return stringRepresenation;
      }
  }
