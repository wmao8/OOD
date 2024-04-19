package hw05;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a Folder which can contain files and subfolders.
 */

public class Folder extends FolderContent {

  List<FolderContent> contents = new ArrayList<>();

  /**
   * Creates a new Folder with name that will be given.
   * @param name The name of the folder.
   */
  public Folder(String name) {
    super(name);
  }

  /**
   *Adds a new file with the given name and size to the folder.
   * @param name The name of the file to be added.
   * @param fileSize The size of the file to be added.
   */

  public void newFile(String name, int fileSize) {
    File newFile = new File(name, fileSize);
    contents.add(newFile);
  }

  /**
   * Create and add a new subfolder with given name to the folder
   * @param name Name of the subfolder that will be added
   */

  public void newFolder(String name) {
    Folder newFolder = new Folder(name);
    contents.add(newFolder);
  }

  /**
   * Return the total size of all files in this folder
   * @return The total file size
   */

  @Override
  public int totalFileSize() {
    int totalFileSize = 0;
    for (FolderContent i : contents) {
      totalFileSize += i.totalFileSize();
    }
    return totalFileSize;
  }

  /**
   * Check if a file with a given name exists in the folder or subfolders
   * @param name The name of the file to search for.
   * @return True if the file exists, false otherwise
   */

  @Override
  public boolean containsFile(String name) {
    for (FolderContent i : contents) {
      if (i.containsFile(name)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Retrieves the list of FolderContent items (files and subfolders) contained in this folder.
   * @return A list of files and subfolders within this folder.
   */

  public String getContents() {
    StringBuilder sb = new StringBuilder();
    for(FolderContent i : contents){
      sb.append(i.getName()).append(", ");
    }
    if (sb.length()>0){
      sb.setLength(sb.length()-2);
    }
    return sb.toString();
  }

}
