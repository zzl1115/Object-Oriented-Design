package edu.neu.ccs.cs5004.commandline;

import edu.neu.ccs.cs5004.process.AutomationSystemController;

/**
 * Represents running a automation system.
 */
public class Run {
  /**
   * The run main method of all application.
   *
   * @param args The command line.
   */
  public static void main(String[] args) {
    AutomationSystemController controller = new AutomationSystemController(args);
    controller.runAutomationSystem();
  }
}
