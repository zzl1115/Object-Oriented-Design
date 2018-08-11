package edu.neu.ccs.cs5004.commandline;

import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.commandline.Run;


public class RunTest {
  String[] args;

  @Before
  public void setUp() throws Exception {
    args = new String[7];
    args[0] = "--email";
    args[1] = "--email-template";
    args[2] = "email-template.txt";
    args[3] = "--output-dir";
    args[4] = "email";
    args[5] = "--csv-file";
    args[6] = "theater-company-members.csv";
  }

  @Test
  public void testMain() {
    Run.main(args);
  }
}