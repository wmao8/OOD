package hw2;

import java.util.Objects;

/**
 * Represent a room with their details -- price and number of guests
 */
//@room a room with parameters price and number of guests

public abstract class Room {

  private int maxOccupancy;
  private double price;

  private int numberOfGuests;

  static final int ROOM_MAX_SINGLE = 1;
  static final int ROOM_MAX_DOUBLE = 2;
  static final int ROOM_MAX_FAMILY = 4;

  static final int ASSIGNED_NUMBER_GUESTS_MIN =0;


  /**
   * Creates a new room given the room's price and initial number of guests as 0
   * @param price the room's price
   * @throws IllegalArgumentException when price is less than 0
   */


  public Room(double price) {
    if (price<0){
      throw new IllegalArgumentException("Price cannot be negative");
    }
    this.price = price;
    this.numberOfGuests = 0;
  }

  /**
   *Get the max occupancy of the room
   * @return the max room occupancy
   */
  public abstract int getMaxOccupancy();

  /**
   * Get price of the room
   * @return price of the room
   */
  public double getPrice() {
    return price;
  }

  /**
   *Check if the room the available
   * @return boolean availability of the room
   * @throws IllegalArgumentException when number of guests is less than 0
   */

  public boolean isAvailable(){
    if (numberOfGuests==0){
      return true;
    }else if(numberOfGuests>0){
      return false;
    }else {
      throw new IllegalArgumentException("Number of guests cannot be negative");
    }
  }

  /**
   * Book room - input the assigned number of guests to room's detail -number of guests, when room is available and suitable for booking
   * @param assignedNumberOfGuests assigned number of guests
   *
   */

  public void bookRoom(int assignedNumberOfGuests){
    if (isAvailable() && assignedNumberOfGuests>ASSIGNED_NUMBER_GUESTS_MIN && assignedNumberOfGuests<=getMaxOccupancy()){
      this.numberOfGuests = assignedNumberOfGuests;
    }else{
      throw new IllegalStateException(
          "Assigned number of guests must be between 0 and max room capacity for the corresponding type of room"
      );
    }
  }


  /**
   * Fetch number of guests of the room
   * @return the number of guests of the room
   */
  public int getNumberOfGuest(){

    return numberOfGuests;

  }



  @Override
  /**
   * Checking if two objects are equal/ the same type - room and object
   * @param o Object o
   * @return boolean result from checking if room and Object are equal
   */

  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Room room = (Room) o;
    return Double.compare(price, room.price) == 0 && numberOfGuests == room.numberOfGuests;
  }


  @Override
  public int hashCode() {
    return Objects.hash(price, numberOfGuests);
  }
}




