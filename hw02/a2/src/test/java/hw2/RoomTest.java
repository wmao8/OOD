package hw2;

import hw2.Room;
import hw2.SingleRoom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class RoomTest {

  private SingleRoom R;

  @BeforeEach
  void setUp() {
    this.R = new SingleRoom(100);
  }

  @Test
  void roomException(){
    Assertions.assertThrows(IllegalArgumentException.class, () -> new SingleRoom(-1));
  }

  @Test
  void getMaxOccupancy() {
    Assertions.assertEquals(1,this.R.getMaxOccupancy());
  }

  @Test
  void isAvailable() {
    Assertions.assertTrue(this.R.isAvailable());
    this.R.bookRoom(1);
    Assertions.assertFalse(this.R.isAvailable());
  }

  @Test
  void bookRoomException() {
      IllegalStateException a = Assertions.assertThrows(IllegalStateException.class,()->R.bookRoom(3), "Assigned number of guests must be between 0 and max room capacity for the corresponding type of room");
      Assertions.assertTrue(a.getMessage().contains("Assigned number of guests must be between 0 and max room capacity for the corresponding type of room"));
  }

  @Test
  void bookRoom(){
    this.R.bookRoom(1);
  }

  @Test
  void getNumberOfGuest() {
    Assertions.assertEquals(0,this.R.getNumberOfGuest());

  }



  @Test
  void testEquals() {
//    Object o = new Object();
    SingleRoom r = new SingleRoom(100);
    SingleRoom r2 = new SingleRoom(126);
    String s1 = new String("M");
    Room r3 = new SingleRoom(100);
    Room r4 = new SingleRoom(100);
    Assertions.assertTrue(this.R.equals(r));
    Assertions.assertFalse(this.R.equals(r2));
    Assertions.assertFalse(this.R.equals(s1));
    Assertions.assertTrue(r3.equals(r4));
//    Assertions.assertEquals(true,this.R.equals(r2)); //Q
  }

  @Test
  void testHashCode() {
    SingleRoom r = new SingleRoom(100);
    Assertions.assertEquals(this.R.hashCode(),r.hashCode());

  }

}



//@Test
//void testIsAvailable() {
//}
//
//@Test
//void testBookRoom() {
//}
//
//@Test
//void testGetNumberOfGuest() {
