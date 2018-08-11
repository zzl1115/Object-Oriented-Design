package edu.neu.ccs.cs5004.commandline;

import edu.neu.ccs.cs5004.model.DirPath;
import edu.neu.ccs.cs5004.model.FileName;
import edu.neu.ccs.cs5004.model.Template;
import edu.neu.ccs.cs5004.model.TemplateI;

import java.util.Arrays;



/**
 * Represents parsing the command line arguments to get information for the automation system.
 */
public class ParseArgument {
  private String[] args;


  /**
   * Creates a new argument parser with given command line arguments.
   * @param args given command line arguments
   */
  public ParseArgument(String[] args) {
    this.args = new String[args.length];
    int index = 0;
    for (String str: args) {
      this.args[index] = str;
      index++;
    }
  }

  /**
   * Check if an argument is a switch.
   * @param arg the argument to check
   * @return true if the argument is a switch, false otherwise
   */
  protected boolean notSwitch(String arg) {
    return CommandlineArgs.NONSWITCH.matcher(arg).matches();
  }

  /**
   * Check if the command line arguments are valid.
   * @return empty string if the arguments are valid, error message if the arguments are
   *        invalid.
   */
  public String checkArguments() {
    String res = "";
    if (args.length != 7) {
      res += CommandlineArgs.ARGNUMERR;
    } else {
      String action = getAction();
      int templateIndex = getTemplateIndex();

      if (action == null) {
        res += CommandlineArgs.ACTIONERR;
      } else if (templateIndex == -1 || misMatch(action, args[templateIndex - 1])) {
        res += CommandlineArgs.generateTemplateErr(action);
      }

      if (getDirPath() == null) {
        res += CommandlineArgs.OUTPUTDIRERR;
      }
      if (getInput() == null) {
        res += CommandlineArgs.INPUTERR;
      }
    }
    if (!res.equals("")) {
      res += CommandlineArgs.ARGSEXP;
    }
    return res;

  }

  /**
   * Check if the given action and the given template is a mismatch.
   * @param action the given action
   * @param templateFlagIndex the index of the template flag in the commandline argument array
   * @return true if the given action and the given template is a mismatch, false otherwise
   */

  protected boolean misMatch(String action, String templateFlagIndex) {
    if (templateFlagIndex.replaceFirst(CommandlineArgs.TEMPLATE, "").equals(action)) {
      return false;
    }
    return true;
  }



  /**
   * Gets the action requested.
   * @return the action requested
   */
  protected String getAction() {
    String action  = null;
    for (int i = 0; i < args.length - 1; i++) {
      if (Arrays.stream(CommandlineArgs.ACTIONS).parallel().anyMatch(args[i]::matches)) {
        action = args[i];
      }
    }

    return action;
  }

  /**
   * Gets the index of the template in the given commandline argument.
   * @return the index of the template in the given commandline argument
   */
  protected int getTemplateIndex() {
    String action = getAction();
    if (action != null) {
      for (int i = 0; i < args.length - 1; i++) {
        if (CommandlineArgs.TEMPLATEPATTERN.matcher(args[i]).matches() && notSwitch(args[i + 1])) {
          return i + 1;
        }
      }
    }
    return -1;
  }

  /**
   * Gets the template provided.
   * @return the template provided
   */
  public TemplateI getTemplate() {
    int templateIndex = getTemplateIndex();
    if (templateIndex != -1) {
      return new Template(new FileName(args[templateIndex]));
    }
    return null;
  }

  /**
   * Gets the directory path where to write the output in.
   * @return the directory path where to write the output in
   */
  public DirPath getDirPath() {
    for (int i = 0; i < args.length - 1; i++) {
      if (CommandlineArgs.DIRPATTERN.matcher(args[i]).matches() && notSwitch(args[i + 1])) {
        return new DirPath(args[i + 1]);
      }
    }
    return null;
  }

  /**
   * Gets the input file name.
   * @return the input file name
   */
  public FileName getInput() {
    for (int i = 0; i < args.length - 1; i++) {
      if (CommandlineArgs.INPUTPATTERN.matcher(args[i]).matches() && notSwitch(args[i + 1])) {
        return new FileName(args[i + 1]);
      }
    }
    return null;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    ParseArgument that = (ParseArgument) other;
    return Arrays.equals(args, that.args);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(args);
  }
}
