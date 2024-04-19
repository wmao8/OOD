package hw2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoubleRoomTest {

  private DoubleRoom dr;

  @BeforeEach
  void setUp() {

    this.dr = new DoubleRoom(100);
  }

  @Test
  void getMaxOccupancy() {
    Assertions.assertEquals(2,this.dr.getMaxOccupancy());

  }
}

//Q