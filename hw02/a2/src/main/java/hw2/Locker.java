package hw2;

import java.util.Objects;

/**
 * Represent a locker with details - max width, max height, max depth and mail item
 */
// * @locker a locker with parameters -  max width, max height, max depth and mail item

public class Locker {


  private int maxWidth;

  private int maxHeight;

  private int maxDepth;


  private MailItem mailItem;

  static final int LOCKER_MIN =1;

  /**
   * Set locker's size based on given width, height, and depth. They need to be greater than 1
   * @param maxWidth Width of locker
   * @param maxHeight Height of the locker
   * @param maxDepth Depth of the locker
   * @throws IllegalArgumentException when width, height, depth of locker is less than 1
   */

  public void setLockerSize(int maxWidth, int maxHeight, int maxDepth){
    if (maxWidth<LOCKER_MIN){
      throw new IllegalArgumentException("Width of the locker must be greater than or equal to 1");
    }
    this.maxWidth = maxWidth;
    if (maxHeight<LOCKER_MIN){
      throw new IllegalArgumentException("Height of the locker must be greater than or equal to 1");
    }
    this.maxHeight = maxHeight;
    if (maxDepth<LOCKER_MIN){
      throw new IllegalArgumentException("Depth of the locker must be greater than or equal to 1 ");
    }
    this.maxDepth = maxDepth;
  }

  /**
   * Creates a new locker given the locker's max width, max height and max depth. Locker also has a field/detail called mailItem
   * @param maxWidth Width of locker
   * @param maxHeight Height of the locker
   * @param maxDepth Depth of the locker
   */
  public Locker(int maxWidth, int maxHeight, int maxDepth) {
    setLockerSize(maxWidth,maxHeight,maxDepth);
    this.mailItem = null;
  }

  /**
   *Fetch max width of locker
   * @return the max width
   */
  public int getMaxWidth() {

    return maxWidth;
  }

  /**
   *Fetch max height of locker
   * @return the max height
   */
  public int getMaxHeight() {
    return maxHeight;
  }

  /**
   *Fetch max depth of locker
   * @return the max depth
   */
  public int getMaxDepth() {
    return maxDepth;
  }

  /**
   *Fetch mail item of the locker
   * @return the mail item
   */
  public MailItem getMailItem() {
    return mailItem;
  }

  /**
   *Check if size of the mail item can fit the locker
   * @param newItem the new mail item
   * @return boolean of size fit : True - item does not fit the locker; False - item fits
   */

/*  private boolean compareSizeDetail(int itemSizeMetrics, int lockerSizeMetrics){
    return itemSizeMetrics > lockerSizeMetrics;
  }*/
  public boolean sizeFit(MailItem newItem){
    if ( (newItem.getHeight()> this.maxWidth) || (newItem.getHeight()>this.maxHeight) ||(newItem.getHeight()>this.maxDepth)){
      return true;
    } else if ((newItem.getWidth()>this.maxWidth) || (newItem.getWidth()>this.maxHeight) ||(newItem.getWidth()>this.maxDepth)) {
      return true;
    } else if ((newItem.getDepth()>this.maxWidth)||(newItem.getDepth()>this.maxHeight)||(newItem.getDepth()>this.maxDepth)) {
      return true;
    }else {
      return false;
    }
  }

  /**
   *Add new mail item to the locker when there is no mail item and the size of new mail item fits the locker
   * @param newItem the mail item to be added
   * @throws IllegalArgumentException when mailitem is full ( not null) or when the size of item does not locker
   */
  public void addMail(MailItem newItem) {
    boolean size = sizeFit(newItem);
    if ((this.mailItem != null) || size) {
      throw new IllegalArgumentException(
          "Cannot be added. There is a mail item in the locker or/and the size does not fit");
    } else {
      this.mailItem = newItem;
    }
  }

  /**
   *Fetch information of mail item that is picked up. If it is not picked up, then return nothing.
   * @param newRecipient the recipient of this locker
   * @return if information matches, return the mail item that is picked up. If information does not match, return null.
   */
  public MailItem pickupMail(Recipient newRecipient){
    if ((this.mailItem != null) && (newRecipient.equals(mailItem.getRecipient()))){
      MailItem returnItem = this.mailItem;
      this.mailItem =null;
      return returnItem;
    }else{
      return null;
    }

  }

  /**
   * Check if Locker and Object are equal/the same type
   * @param o Object
   * @return boolean result if Locker and Object are equal/the same type
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Locker locker = (Locker) o;
    return maxWidth == locker.maxWidth && maxHeight == locker.maxHeight
        && maxDepth == locker.maxDepth
        && Objects.equals(mailItem, locker.mailItem);
  }

  /**
   * Generate hash code value for the object
   * @return hash code of the object based on locker's width, height, depth and mail item
   */

  @Override
  public int hashCode() {
    return Objects.hash(maxWidth, maxHeight, maxDepth, mailItem);
  }
}

