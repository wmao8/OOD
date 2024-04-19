package hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileTest {
  private File file1;
  private File file2;

  @BeforeEach
  void setUp() {
    this.file1 = new File("file1",1);
    this.file2 = new File("file2",2);
  }

  @Test
  void fileSize_helperExcpetion() {

    Assertions.assertThrows(IllegalArgumentException.class,() -> new File("file3",0),"File size cannot be less or equal to zero");
  }

  @Test
  void getFileSize() {
    Assertions.assertEquals(1,file1.getFileSize());
    Assertions.assertEquals(2,file2.getFileSize());
  }

  @Test
  void totalFileSize() {
    Assertions.assertEquals(1, file1.totalFileSize());
    Assertions.assertEquals(2, file2.totalFileSize());
  }

  @Test
  void containsFile() {
    Assertions.assertTrue(file1.containsFile("file1"));
    Assertions.assertTrue(file2.containsFile("file2"));
    Assertions.assertFalse(file2.containsFile("file3"));
  }
}