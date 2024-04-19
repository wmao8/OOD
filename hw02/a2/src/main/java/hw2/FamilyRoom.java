package hw2;

/**
 * Represents a family room with details - price and number of guests
 */
// * @familyroom a family room with parameters price and number of guests
public class FamilyRoom extends Room{

  /**
   * Creates a new family room given the family room's price and initial number of guests as 0
   * @param price price of family room
   *
   */
  public FamilyRoom( double price) {

    super(price);
  }

  /**
   *Fetch max occupancy of the Family Room
   * @return max family room occupancy - 4
   */
  @Override
  public int getMaxOccupancy() {
    return ROOM_MAX_FAMILY;
  }
}
