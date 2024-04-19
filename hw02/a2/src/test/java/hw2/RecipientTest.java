package hw2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecipientTest {
  private Recipient recipient1;

  @BeforeEach
  void setUp() {
    this.recipient1 = new Recipient("John","Doe","jd@hotmail.com" );
  }


  @Test
  void setNameExcpetion(){
    Assertions.assertThrows(IllegalArgumentException.class, () -> new Recipient(null,"Doe","jd@hotmail.com"));
    Assertions.assertThrows(IllegalArgumentException.class, () -> recipient1.setName("John",null,"jd@hotmail.com"));
    Assertions.assertThrows(IllegalArgumentException.class, () -> recipient1.setName("John","Does",""));
  }

  @Test
  void setName(){
    Assertions.assertEquals("John", recipient1.getFirstName());
    Assertions.assertEquals("Doe", recipient1.getLastName());
    Assertions.assertEquals("jd@hotmail.com", recipient1.getEmail());
  }

  @Test
  void testToString() {
    String expected = "John Doe Email:jd@hotmail.com";
    Assertions.assertEquals(expected,recipient1.toString());
  }

  @Test
  void getFirstName() {
    Assertions.assertEquals("John",recipient1.getFirstName());
  }

  @Test
  void getLastName() {
    Assertions.assertEquals("Doe",recipient1.getLastName());
  }

  @Test
  void getEmail() {
    Assertions.assertEquals("jd@hotmail.com",recipient1.getEmail());

  }

  @Test
  void testEquals() {
    Recipient recipient2 = new Recipient("John","Doe","jd@hotmail.com");
    Recipient recipient3 = new Recipient("Adil","Doe","ad@hotmail.com");
    String string1 = new String("Test1");
    Recipient recipient4 = new Recipient("Peter","Adil","pa@hotmail.com");
    Recipient recipient5 = new Recipient("Peter","Adil","pa@hotmail.com");

    Assertions.assertTrue(this.recipient1.equals(recipient2));
    Assertions.assertFalse(this.recipient1.equals(recipient3));
    Assertions.assertFalse(this.recipient1.equals(string1));
    Assertions.assertTrue(recipient4.equals(recipient5));


  }

  @Test
  void testHashCode() {
    Recipient recipient2 = new Recipient("John","Doe","jd@hotmail.com");
    Assertions.assertEquals(this.recipient1.hashCode(),recipient2.hashCode());
  }
}