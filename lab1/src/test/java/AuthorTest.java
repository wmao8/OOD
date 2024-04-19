

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthorTest {

  private Author jane;

  @BeforeEach

  void setUp(){
    this.jane = new Author("Jane Austen", "jane@austen.org",
        "The Vicarage, Steventon, Hampshire, England");
  }

  @Test
  void getName() {
    Assertions.assertEquals("Jane Austen", this.jane.getName());
  }

  @Test
  void getEmail() {
    Assertions.assertEquals("jane@austen.org", this.jane.getEmail());
  }

  @Test
  void getAddress() {
    Assertions.assertEquals("The Vicarage, Steventon, Hampshire, England", this.jane.getAddress());

  }



}