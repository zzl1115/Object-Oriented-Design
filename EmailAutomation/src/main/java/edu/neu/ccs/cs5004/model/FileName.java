package edu.neu.ccs.cs5004.model;

import java.util.Objects;

/**
 * Represents a file name.
 */
public class FileName {
  private String theFileName;

  /**
   * Creates a new file name with the given file name.
   *
   * @param theFileName the given file name
   */
  public FileName(String theFileName) {
    this.theFileName = theFileName;
  }

  /**
   * Return the file name.
   *
   * @return String
   */
  public String getFileName() {
    return theFileName;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    FileName fileName1 = (FileName) other;
    return Objects.equals(theFileName, fileName1.theFileName);
  }

  @Override
  public int hashCode() {

    return Objects.hash(theFileName);
  }
}
