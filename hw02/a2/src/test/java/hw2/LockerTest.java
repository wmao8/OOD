package hw2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LockerTest {

  private Locker locker1;
  private MailItem mailItem1;
  private MailItem mailItem2;
  private MailItem mailItem3;
  private MailItem mailItem4;
  private MailItem mailItem5;
  private MailItem mailItem6;
  private MailItem mailItem7;
  private Recipient recipient1;
  private Recipient recipient2;

  @BeforeEach
  void setUp() {
    this.recipient1 = new Recipient("John","Doe","jd@hormail.com");
    this.recipient2 = new Recipient("David","Doe","dd@hormail.com");
    this.mailItem1 = new MailItem(6,2,3,recipient1);
    this.mailItem2 = new MailItem(2,7,3,recipient1);
    this.mailItem3 = new MailItem(2,2,8,recipient1);
    this.mailItem4 = new MailItem(2,2,2,recipient1);

    this.mailItem5 = new MailItem(7,7,7,recipient1);
    try{
      this.mailItem6 = new MailItem(0,2,2,recipient1);
    }
    catch(IllegalArgumentException ex1){};

    try{
      this.mailItem7 = new MailItem(2,2,0,recipient1);
    }
    catch(IllegalArgumentException ex1){};

    this.locker1 = new Locker(5,5,5);
  }

  @Test
  void setLockerSizeException(){
    Assertions.assertThrows(IllegalArgumentException.class,() -> new Locker(5,0,5));
    Assertions.assertThrows(IllegalArgumentException.class,() -> new Locker(5,5,-2));
  }

  @Test
  void setLockerSize(){
    this.locker1.setLockerSize(5,5,5);
  }

  @Test
  void getMaxWidth() {
    Assertions.assertEquals(5,this.locker1.getMaxWidth());
  }

  @Test
  void getMaxHeight() {
    Assertions.assertEquals(5,this.locker1.getMaxHeight());
  }

  @Test
  void getMaxDepth() {

    Assertions.assertEquals(5,this.locker1.getMaxDepth());
  }

  @Test
  void getMailItem() {
    Assertions.assertNull(this.locker1.getMailItem());
  }

  @Test
  void sizeFit() {
    Assertions.assertTrue(this.locker1.sizeFit(mailItem1));
    Assertions.assertTrue(this.locker1.sizeFit(mailItem2));
    Assertions.assertTrue(this.locker1.sizeFit(mailItem3));
    Assertions.assertFalse(this.locker1.sizeFit(mailItem4));
  }

  @Test
  void addMailExcpetion() {
//    Recipient recipient1 = new Recipient("John", "Doe","jd@hotmail.com");
//    Recipient recipient2 = new Recipient("Dave", "Doe","dd@hotmail.com");
//    MailItem mailItem1 = new MailItem(4,4,4, recipient1);

    //Adding a mailitem that exceeds size of locker and this item is for recipient1
    Assertions.assertThrows(
        IllegalArgumentException.class, ()-> this.locker1.addMail(new MailItem(5,5,6,recipient1))
    );
    //Adding mailitem4 to locker1
    locker1.addMail(mailItem4);

    //Illegalexception when the locker is not empty (occupied by mailitem4 that fits the size)
    Assertions.assertThrows(
        IllegalArgumentException.class, ()-> this.locker1.addMail(new MailItem(4,4,4,recipient2))
    );

  }
  @Test
  void addMail() {
    this.locker1.addMail(mailItem4);
  }

  @Test
  void pickupMail() {

//    Recipient recipient1 = new Recipient("John","Doe", "dd@hotmail.com");
//    Recipient recipient2 = new Recipient("David","Doe", "dd@hotmail.com");

    //Empty locker
    Assertions.assertNull(this.locker1.pickupMail(recipient1));
    //Add mailitem4 for receipent1
    locker1.addMail((mailItem4));
    //Try picking up by receipent2
    Assertions.assertNull(this.locker1.pickupMail(recipient2));
    //Receipent1 picking up
    Assertions.assertEquals(mailItem4,this.locker1.pickupMail(recipient1));
    // Check locker is empty
    Assertions.assertNull(locker1.getMailItem());
  }

  @Test
  void testEquals() {
    Locker locker2 = new Locker(5,5,5);
    Locker locker3 = new Locker(6,6,8);
    String string1 = new String("test");
    Locker locker4 = new Locker(6,7,8);
    Locker locker5 = new Locker(6,7,8);
    Assertions.assertTrue(this.locker1.equals(locker2));
    Assertions.assertFalse(this.locker1.equals(locker3));
    Assertions.assertFalse(this.locker1.equals(string1));
    Assertions.assertTrue(locker4.equals(locker5));


  }

  @Test
  void testHashCode() {
    Locker locker2 = new Locker(5,5,5);
    Assertions.assertEquals(this.locker1.hashCode(),locker2.hashCode());
  }
}