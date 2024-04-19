package hw2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FamilyRoomTest {

  private FamilyRoom fr;

  @BeforeEach
  void setUp() {

    this.fr = new FamilyRoom(100);
  }

  @Test
  void getMaxOccupancy() {
    Assertions.assertEquals(4,this.fr.getMaxOccupancy());

  }
}

//Q