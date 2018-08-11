package edu.neu.ccs.cs5004.commandline;

import java.util.regex.Pattern;

/**
 * Represents the patterns and error messages used when processing commandline arguments.
 */
public class CommandlineArgs {
  public static final String EMAIL = "--email";
  public static final String LETTER = "--letter";
  public static final String TEMPLATE = "-template";
  public static final Pattern DIRPATTERN = Pattern.compile("--output-dir");
  public static final Pattern INPUTPATTERN = Pattern.compile("--csv-file");
  public static final Pattern TEMPLATEPATTERN = Pattern.compile("--[a-zA-Z]+-template");
  public static final Pattern NONSWITCH = Pattern.compile("^[^-].*");
  static final String[] ACTIONS = {EMAIL, LETTER};

  public static final String ARGNUMERR = "Error: Wrong arguments number. "
          + "Please check arguments requirement.\n";
  public static final String ACTIONERR = "Error: no valid action provided.\n";
  public static final String OUTPUTDIRERR = "Error: output directory was not given.\n";
  public static final String INPUTERR = "Error: member information file was not given.\n";
  public static final String ARGSEXP = "Usage:\n\n"
          + "        --email                        only generate email messages\n"
          + "        --email-template <file>  accepts a filename that holds the email "
          + "template.\n"
          + "          Required if --email is used\n\n"
          + "        --letter                        only generate letters\n"
          + "        --letter-template <file> accepts a filename that holds the email "
          + "template.\n"
          + "          Required if --letter is used\n\n"
          + "        --output-dir <path> accepts the name of a folder, all output is placed "
          + "in this folder\n"
          + "\n"
          + "        --csv-file <path> accepts the name of the csv file to process\n";

  /**
   * Generates an error message on the template with the given action.
   *
   * @param action the action required in the commandline argument
   * @return an error message on lack of template argument
   */
  public static String generateTemplateErr(String action) {
    return "Error: " + action + " provided but no " + action
            + CommandlineArgs.TEMPLATE + " was given.\n";
  }

}
