package hw2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SingleRoomTest {

  private SingleRoom sr;

  @BeforeEach
  void setUp() {

    this.sr = new SingleRoom(100);
  }

  @Test
  void getMaxOccupancy() {
      Assertions.assertEquals(1,this.sr.getMaxOccupancy());
    }

}

//Q