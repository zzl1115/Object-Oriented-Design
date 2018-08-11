package edu.neu.ccs.cs5004.process;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AutomationSystemControllerTest {
  private AutomationSystemController system2;
  private AutomationSystemController system;
  private String[] args;
  private String[] args2;

  @Before
  public void setUp() throws Exception {
    args = new String[7];
    args[0] = "--email";
    args[1] = "--email-template";
    args[2] = "email-template.txt";
    args[3] = "--output-dir";
    args[4] = "emails";
    args[5] = "--csv-file";
    args[6] = "theater-company-members.csv";
    args2 = new String[6];
    args2[0] = "--email";
    args2[1] = "--email-template";
    args2[2] = "email-template.txt";
    args2[3] = "--output-dir";
    args2[4] = "emails";
    args2[5] = "--csv-file";
    system = new AutomationSystemController(args);
  }

  @Test(expected = RuntimeException.class)
  public void runAutomationSystem() {
    system.runAutomationSystem();
    system2.runAutomationSystem();
  }
}