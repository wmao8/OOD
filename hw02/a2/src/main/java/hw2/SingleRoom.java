package hw2;

/**
 * Represent a single room with their details -- price and number of guests
 */
// * @SingleRoom a single room with parameters -- price and number of guests


public class SingleRoom extends Room{



  /**
   * Creates a new single room given the single room's price and initial number of guests as 0
   * @param price price of single room
   *
   */
  public SingleRoom(double price) {

    super(price);

  }


  /**
   *Fetch max occupancy of single room
   * @return max single room occupancy - 1
   */

  @Override
  public int getMaxOccupancy() {
    return ROOM_MAX_SINGLE;
  }


}
