package hw2;

/**
 * Represents a double room with details - price and number of guests
 */
// * @doubleroom a double room with parameters price and number of guests


public class DoubleRoom extends Room{


  /**
   * Creates a new double room given the double room's price and initial number of guests as 0
   * @param price price of double room
   *
   */ //Q
  public DoubleRoom(double price) {

    super(price);
  }

  /**
   * Fetch max occupancy of Double Room
   * @return max double room occupancy - 2
   */
  @Override
  public int getMaxOccupancy() {
    return ROOM_MAX_DOUBLE;
  }


}
