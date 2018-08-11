package edu.neu.ccs.cs5004.process;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Represents writing the contents of a file into the given directory.
 */
public class Write {

  /**
   * Write the file into the directory.
   *
   * @param file    The path and name of write file.
   * @param content The content that is written into the file.
   */
  public void writeIntoDir(String file, List<String> content) {
    try (BufferedWriter outputFile = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(file), "UTF-8"))) {
      for (String line : content) {
        outputFile.write(line);
        outputFile.newLine();
      }
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
  }


}
