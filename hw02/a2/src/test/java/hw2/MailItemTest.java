package hw2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MailItemTest {

  private MailItem mailItem1;
  private Recipient recipient1;

  @BeforeEach
  void setUp() {
    this.recipient1 = new Recipient("John", "Doe","jd@hotmail.com");
    this.mailItem1 = new MailItem(2,2,2,recipient1);
  }

  @Test
  void setMailItemSizeException(){
    Assertions.assertThrows(IllegalArgumentException.class, ()-> new MailItem(-1,-1,-1,recipient1));
    Assertions.assertThrows(IllegalArgumentException.class, ()-> new MailItem(3,-1,3,recipient1));
    Assertions.assertThrows(IllegalArgumentException.class, ()-> new MailItem(3,3,0,recipient1));
  }

  @Test
  void setMailItemSize(){
    this.mailItem1.setMailItemSize(2,2,2);
  }

  @Test
  void mailItemExcpetion(){
    Assertions.assertThrows(IllegalArgumentException.class, ()-> new MailItem(1,1,1,null));
  }

  @Test
  void getRecipient() {
    Assertions.assertEquals(recipient1, this.mailItem1.getRecipient());
  }

  @Test
  void getWidth() {
    Assertions.assertEquals(2,this.mailItem1.getWidth());
  }

  @Test
  void getHeight() {
    Assertions.assertEquals(2,this.mailItem1.getHeight());
  }

  @Test
  void getDepth() {
    Assertions.assertEquals(2,this.mailItem1.getDepth());
  }

  @Test
  void testEquals() {
    MailItem mailItem2 = new MailItem(2,2,2,recipient1);
    MailItem mailItem3 = new MailItem(2,2,3,recipient1);
    String string1 = new String("String");
    MailItem mailItem4 = new MailItem(2,4,2,recipient1);
    MailItem mailItem5 = new MailItem(2,4,2,recipient1);
    Assertions.assertTrue(this.mailItem1.equals(mailItem2));
    Assertions.assertFalse(this.mailItem1.equals(mailItem3));
    Assertions.assertFalse(this.mailItem1.equals(string1));
    Assertions.assertTrue(mailItem4.equals(mailItem5));

  }

  @Test
  void testHashCode() {
    MailItem mailItem2 = new MailItem(2,2,2,recipient1);
    Assertions.assertEquals(this.mailItem1.hashCode(),mailItem2.hashCode());
  }
}