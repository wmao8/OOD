package lab03;

/**
 * Represents an enumerator for immutable linkedilist with details - current node
 */

public class ImmutableLinkedListEnumerator implements Enumerator {
  private Node current;

  /**
   * Creates a new enumerator given the head node of linkedlist
   * @param head the head node of linkedlist
   */

  public ImmutableLinkedListEnumerator(Node head){
    this.current = head;
  }

  /**
   * Does the enumerator has more node in the linkedlist to visit?
   * @return true if the enumerator has more node; false otherwise.
   */


  public boolean hasNext() {
    if (current == null) {
      return false;
    } else {
      return true;
    }
  }


  /**
   * Returns the next value of the node in the array.
   * @return value of the node
   * @throws IllegalArgumentException if the enumerator has reached end of the linkedlist
   */

  public String getNext() {
    if (!hasNext()) {
      throw new IllegalStateException("Reached the end of list");
    }
    String value = current.getValue();
    current = current.getNext();
    return value;
  }
}


