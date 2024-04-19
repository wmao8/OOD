package hw05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FolderTest {
  private Folder root;
  private Folder subfolder;

  @BeforeEach
  void setUp() {
    this.root = new Folder("root");
    this.subfolder = new Folder("subfolder");

    root.contents.add(subfolder);

    root.newFile("rootfile1", 1);
    root.newFile("rootfile2",2);
    root.newFile("rootfile3",3);
    subfolder.newFile("subfolderfile1",1);
    subfolder.newFile("subfolderfile2",2);
    subfolder.newFile("subfolderfile3",3);

    root.newFolder("rootfolder2");
    root.newFolder("rootfolder3");
    subfolder.newFolder("subfolderfolder1");
    subfolder.newFolder("subfolderfolder2");


  }

  @Test
  void newFile() {
    int rootItemSize = root.contents.size();

    root.newFile("rootfile4",1);
    Assertions.assertEquals(13,root.totalFileSize());
    Assertions.assertTrue(root.containsFile("rootfile4"));
    Assertions.assertEquals(rootItemSize+1, root.contents.size());
  }

  @Test
  void newFolder() {
    int rootItemSize = root.contents.size();
    root.newFolder("rootfolder4");
    Assertions.assertEquals(rootItemSize+1,root.contents.size());
  }

  @Test
  void totalFileSize() {
    Assertions.assertEquals(12,root.totalFileSize());
  }

  @Test
  void containsFile() {
    Assertions.assertFalse(root.containsFile("rootfile4"));
    Assertions.assertTrue(root.containsFile("rootfile1"));
    Assertions.assertTrue(root.containsFile("subfolderfile1"));
  }

  @Test
  void getContents() {
    Assertions.assertEquals("subfolder, rootfile1, rootfile2, rootfile3, rootfolder2, rootfolder3", root.getContents());
  }
}