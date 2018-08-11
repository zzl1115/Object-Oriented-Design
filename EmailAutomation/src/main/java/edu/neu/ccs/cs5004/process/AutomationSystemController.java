package edu.neu.ccs.cs5004.process;

import edu.neu.ccs.cs5004.commandline.ParseArgument;
import edu.neu.ccs.cs5004.model.MemberInfo;
import edu.neu.ccs.cs5004.model.Members;

import java.io.File;


/**
 * Represents the automation system to generate communicating files.
 */
public class AutomationSystemController {
  private Reader reader;
  private Write write;
  private ParseArgument parser;

  /**
   * The constructor of the controller.
   *
   * @param args The command line arguments.
   */
  public AutomationSystemController(String[] args) {
    reader = new Reader();
    write = new Write();
    parser = new ParseArgument(args);
  }

  /**
   * Check if the command request is valid and run automation system.
   * @throws IllegalArgumentException upon wrong command line arguments
   * @throws RuntimeException upon failing to create output directory
   */
  public void runAutomationSystem() {
    String error = parser.checkArguments();
    if (!error.equals("")) {
      throw new IllegalArgumentException(error);
    } else {
      generateMessages();
    }
  }

  /**
   * Read the file, process the template then write the file into a directory.
   * @throws RuntimeException upon failing to create output directory
   */
  protected void generateMessages() {
    Members members = new Members();
    reader.readMembersInfo(parser.getInput(), members);
    GeneratorI generator = GeneratorI.createGenerator(
            reader.readTemplates(parser.getTemplate().getTemplateName()), members);
    String path = "./src/main/java/edu/neu/ccs/cs5004/" + parser.getDirPath().getDirPath();
    File dir = new File(path);
    boolean successful = dir.mkdir();
    if (!successful) {
      throw new RuntimeException("Counld not create directory!");
    }
    int index = 0;
    for (MemberInfo member : members.getMembersInfo()) {
      write.writeIntoDir(path + "/" + index++ + ".txt",
              generator.replacePlaceHolder(member));
    }
  }
}
