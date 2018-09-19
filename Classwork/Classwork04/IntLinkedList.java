public class IntLinkedList {

      private Node head;
      private int  size;

     // the constructor
      IntLinkedList() {
         head = null;
         size = 0;
      }

      public int getSize() {
         return size;
      }

      public void prepend( int dataToAdd ) {
         Node currentHead = head;
         head = new Node( dataToAdd );
         head.next = currentHead;
         size++;
      }

      private class Node {

         int data;            // remember this is an IntLinkedList
         Node next;           // here's the self-referential part

         // constructor
         Node( int d ) {
            data = d;
            next = null;
         }
      }

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

      public class Iterator {
         private Node currentNode;

         Iterator() {
            currentNode = head;
         }

         public void next() {
            if( currentNode == null ) {
               return;
            } else {
               currentNode = currentNode.next;
            }
         }

         public boolean hasNext() {
            return ((currentNode != null) && (currentNode.next != null));
         }

         public int getCurrentInt() {
            return currentNode.data;
         }

      }

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
