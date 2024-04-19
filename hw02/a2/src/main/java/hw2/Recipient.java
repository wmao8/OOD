package hw2;

import java.util.Objects;

/**
 * Represent a recipient with details - first name, last name, and email
 */

// * @recipient a recipient with parameters - firs name, last name and email


public class Recipient {
  private String firstName;
  private String lastName;
  private String email;

  /**
   * Helper method to validate details of recipient class
   * @param firstName first name of recipient
   * @param lastName last name of recipient
   * @param email email of recipient
   * @throws IllegalArgumentException when first name is null or empty, last name is null or empty, email is null or empty
   */

  public void setName(String firstName, String lastName, String email){
    if ((firstName == null) || (firstName.isEmpty())){
      throw new IllegalArgumentException("First name cannot be null or empty");
    }
    this.firstName = firstName;
    if ((lastName == null) || (lastName.isEmpty())){
      throw new IllegalArgumentException("Last name cannot be null or empty");
    }
    this.lastName = lastName;
    if ((email == null) || (email.isEmpty())){
      throw new IllegalArgumentException("Email cannot be null or empty");
    }
    this.email = email;
  }

  /**
   * Creates a new recipient given first name, last name and email
   * @param firstName fist name of the recipient
   * @param lastName last name of the recipient
   * @param email email of the recipient
   */

  public Recipient(String firstName, String lastName, String email) {
    setName(firstName,lastName,email);
  }


  /**
   * Create and return string that is in this format ("FirstName LastName Email:xxx@yyyy.com") to represent the recipient
   * @return string that includes information of recipient "FirstName LastName Email:xxx@yyyy.com"
   */

  public String toString(){
    return firstName + " "+ lastName + " Email:" + email;
  }

  /**
   * Return first name of recipient
   * @return first name of recipient
   */

  public String getFirstName() {
    return firstName;
  }

  /**
   * Return last name of the recipient
   * @return last name of the recipient
   */

  public String getLastName() {
    return lastName;
  }

  /**
   * Return email of the recipient
   * @return email of the recipient
   */
  public String getEmail() {
    return email;
  }

  /**
   * Check if Recipient and Object are equal/the same type
   * @param o Object
   * @return boolean result if Recipient and Object are equal/the same type
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipient recipient = (Recipient) o;
    return Objects.equals(firstName, recipient.firstName) && Objects.equals(
        lastName, recipient.lastName) && Objects.equals(email, recipient.email);
  }

  /**
   * Generate hash code value for the object
   * @return hash code of the object based on first name, last name and email
   */

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, email);
  }
}
