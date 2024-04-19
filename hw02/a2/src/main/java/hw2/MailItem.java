package hw2;

import java.util.Objects;

/**
 * Represent a mail item with details - width, height, depth and recipient
 */
// * @mailItem a mail item with parameters price and number of guests

public class MailItem {
  private int width;
  private int height;
  private int depth;
  private Recipient recipient;

  static final int MAILITEM_MIN =1;

  /**
   * Set width, height and depth of the mail item when they are greater 1, otherwise throw exception
   * @param width width of the mail item
   * @param height  height of the mail item
   * @param depth depth of the mail item
   * @throws IllegalArgumentException when width is less than 1, height is less than 1, depth is less than 1
   */
  public void setMailItemSize(int width, int height, int depth){
    if (width<MAILITEM_MIN) {
      throw new IllegalArgumentException("Width of the mail item must be greater than or equal to 1");
    }
    this.width = width;
    if (height<MAILITEM_MIN){
      throw new IllegalArgumentException("Height of the mail item must be greater than equal to 1");
    }
    this.height = height;
    if(depth<MAILITEM_MIN){
      throw new IllegalArgumentException("Depth of the mail item must be greater than equal to 1 ");
    }
    this.depth = depth;
  }


  /**
   * Creates a new mail item given the width, height, depth and recipient
   * @param width width of the mail item
   * @param height height of the mail item
   * @param depth depth of the mail item
   * @param recipient recipient of the mail item
   * @throws IllegalArgumentException when recipient is null
   */

  public MailItem(int width, int height, int depth, Recipient recipient) {

    setMailItemSize(width,height,depth);

    if (recipient == null){
      throw new IllegalArgumentException("Recipient of the mail item cannot be empty/null");
    }
    this.recipient = recipient;
  }

  /**
   * Return recipient of the mail item
   * @return recipient of the mail item
   */

  public Recipient getRecipient(){
    return recipient;
  }

  /**
   * Return width of the mail item
   * @return width of the mail item
   */

  public int getWidth() {
    return width;
  }

  /**
   * Return height of the mail item
   * @return height of the mail item
   */

  public int getHeight() {
    return height;
  }

  /**
   * Return depth of the mail item
   * @return height of the mail item
   */

  public int getDepth() {
    return depth;
  }

  /**
   * Check if MailItem and Object are equal/the same type
   * @param o Object
   * @return boolean result if MailItem and Object are equal/the same type
   */

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailItem mailItem = (MailItem) o;
    return width == mailItem.width && height == mailItem.height && depth == mailItem.depth
        && Objects.equals(recipient, mailItem.recipient);
  }

  /**
   * Generate hash code value for the object
   * @return hash code of the object based on width, height, depth and recipient of mail item
   */
  @Override
  public int hashCode() {
    return Objects.hash(width, height, depth, recipient);
  }
}


