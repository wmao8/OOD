package hw05;

/**
 *  * Represents a generic content item within a folder structure, serving as a base class
 *  * for more specific types of content such as files and folders.
 */

public abstract class FolderContent {
  private String name;

  /**
   * Constructs a new content item with the specified name.
   * @param name The name of the content item.
   */

  public FolderContent(String name) {
    this.name = name;
  }

  /**
   * Retrieves the name of this content item.
   * @return The name of the content item.
   */

  public String getName() {
    return name;
  }

  /**
   * Calculates the total file size of this content item. In the case of a file,
   * this would be the size of the file itself. For a folder, it would be the sum
   * of the sizes of all contained files including files in its subfolders.
   * @return The total file size in bytes.
   */

  public abstract int totalFileSize();

  /**
   * Determines whether a file with the specified name exists within this content item.
   * For a file, this would mean checking if the file's name matches the specified name.
   * For a folder, it involves searching for the file recursively within all contained
   * files and folders.
   * @param name The name of the file to search for.
   * @return true if the file exists within this content item, false otherwise.
   */
  public abstract boolean containsFile(String name);
}
