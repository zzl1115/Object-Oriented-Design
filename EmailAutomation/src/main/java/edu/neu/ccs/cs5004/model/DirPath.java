package edu.neu.ccs.cs5004.model;


import java.util.Objects;

/**
 * Represents a directory.
 */
public class DirPath {
  private String directPath;

  /**
   * Creates a new directory path with the given directory path.
   *
   * @param directPath the given directory path
   */

  public DirPath(String directPath) {
    this.directPath = directPath;
  }

  /**
   * Getter for property 'dirpath'.
   *
   * @return Value for property 'dirpath'
   */

  public String getDirPath() {
    return directPath;
  }


  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    DirPath dirPath1 = (DirPath) other;
    return Objects.equals(directPath, dirPath1.directPath);
  }

  @Override
  public int hashCode() {

    return Objects.hash(directPath);
  }
}

