package lab03;

/**
 * Represents enumerator for arraylist with details - index and string elements
 */

public class ImmutableArrayListEnumerator implements Enumerator {

  private int index = 0;
  private final String[] elementsArray;

  /**
   *Creates a new enumerator given the array
   * @param elementsArray the array that will be given in the constructor
   */

  public ImmutableArrayListEnumerator(String[] elementsArray) {
    this.elementsArray = elementsArray;
  }
  /** Does the enumerator have more strings in the arraylist to visit?
   * @return true if the enumerator has more strings, false otherwise
   */
  public boolean hasNext() {
    if (index < elementsArray.length) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns the next string in the arraylist
   * @return string value
   * @throws IllegalArgumentException if the enumerator has reached the end of the list
   */
  public String getNext() {
    if (!hasNext()) {
      throw new IllegalStateException("Reached the end of the array");
    }
    return elementsArray[index++];
  }
}



