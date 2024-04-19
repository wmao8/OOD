package hw05;

/**
 * Represents a File with a name and size.
 */
public class File extends FolderContent {

  private int fileSize;

  /**
   * Creates a new file with name that will be given and size.
   * @param name The name of the file.
   * @param fileSize The size of the file in bytes. Must be positive.
   */
  public File(String name, int fileSize) {
    super(name);
    fileSize_helper(fileSize);
  }

  /**
   * Helper method to set the file size after validating it is greater than zero.
   * @param fileSize Size of the file to be set.
   * @throws IllegalArgumentException if fileSize is less than or equal to zero.
   */
  public void fileSize_helper(int fileSize) {
    if (fileSize <= 0) {
      throw new IllegalArgumentException("File size cannot be less or equal to zero");
    } else {
      this.fileSize = fileSize;
    }
  }

  /**
   * Return the size of the file.
   * @return The size of the file.
   */

  public int getFileSize() {
    return fileSize;
  }

  /**
   * Returns the total file size - size of the file itself.
   * @return The size of the file.
   */
  @Override
  public int totalFileSize() {
    return fileSize;
  }

  /**
   * Check if this file with the specified name exists in the folder or any of its subfolder
   * @param name the name of the file to search for
   * @return true if the file exists,false otherwise
   */

  @Override
  public boolean containsFile(String name) {
    if (this.getName().equals(name)){
      return true;
    }
    return false;
  }
}
