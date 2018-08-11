package edu.neu.ccs.cs5004;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

public class Write {
  private static final String TITLE = "Transaction number - Date, Time, Client Id, Message, "
      + "Digital signature, Verified, Transactions status";

  public static void write(String fileName,List<Record> records){
    PrintWriter output = null;
    try {
      File file = new File(fileName + ".csv");
      Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
      output = new PrintWriter(writer);
      output.println(TITLE);

      for (Record record : records) {
        output.println(record.toString());
      }
    }catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
  }

}
