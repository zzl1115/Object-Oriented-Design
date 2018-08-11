package edu.neu.ccs.cs5004.commandline;

import edu.neu.ccs.cs5004.model.Template;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.DirPath;
import edu.neu.ccs.cs5004.model.FileName;

public class ParseArgumentTest {

  private ParseArgument parseTest1;
  private ParseArgument parseTest2;
  private ParseArgument sameRefParseTest1;
  private ParseArgument sameStateParseTest1;
  private ParseArgument anotherParseTest1;
  @Before
  public void setUp() throws Exception {
    String[] arg1 = {"--email", "--email-template", "email-template.txt", "--output-dir", "emails",
    "--csv-file", "customer.csv"};
    String[] arg2 = {"--letter-template", "letter-template.txt", "--letter", "--output-dir",
            "letters", "--csv-file", "customer.csv"};
    parseTest1 = new ParseArgument(arg1);
    parseTest2 = new ParseArgument(arg2);
    sameRefParseTest1 = parseTest1;
    sameStateParseTest1 = new ParseArgument(arg1);
    anotherParseTest1 = new ParseArgument(arg1);
  }

  @Test
  public void checkArguments() {
    String example = "Usage:\n\n"
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
    String argNumError = "Error: Wrong arguments number. Please check arguments requirement.\n";
    String actionError = "Error: no valid action provided.\n";
    String templateError = "Error: --email provided but no --email-template was given.\n";
    String dirError = "Error: output directory was not given.\n";
    String inputError = "Error: member information file was not given.\n";
    String[] noAction = {"--email-template", "email-template.txt", "--output-dir", "emails",
            "--csv-file", "customer.csv", "customer.csv"};
    String[] noTemplate1 = {"--email", "--email-template", "--output-dir",
            "emails", "--csv-file", "customer.csv"};
    String[] noTemplate2 = {"--email", "email-template.txt", "--output-dir",
            "emails", "--csv-file", "customer.csv", "--email-template"};
    String[] noTemplate3 = {"--email", "--output-dir",
            "emails", "--csv-file", "customer.csv", "--email-template"};
    String[] wrongMatch = {"--email", "--letter-template", "email-template.txt", "--output-dir",
            "emails", "--csv-file", "customer.csv"};
    String[] noDir1 = {"--email", "--email-template", "email-template.txt", "--output-dir",
            "--csv-file", "customer.csv"};
    String[] noDir2= {"--email", "--email-template", "email-template.txt", "emails",
            "--csv-file", "customer.csv"};
    String[] noDir3 = {"--email", "--email-template", "email-template.txt", "emails",
            "--csv-file", "customer.csv",  "--output-dir"};
    String[] noInput1 = {"--email", "--email-template", "email-template.txt", "--output-dir",
            "emails", "--csv-file"};
    String[] noInput2 = {"--email", "--email-template", "email-template.txt", "--csv-file",
            "--output-dir", "emails", "customer.csv"};
    String[] noInput3 = {"--email", "--email-template", "email-template.txt", "--output-dir",
            "emails", "customer.csv"};
    String[] moreArgs = {"--email", "--email-template", "email-template.txt", "--output-dir", "emails",
            "--csv-file", "customer.csv", "customer.csv"};
    ParseArgument parseTest3 = new ParseArgument(noAction);
    ParseArgument parseTest4 = new ParseArgument(noTemplate1);
    ParseArgument parseTest5 = new ParseArgument(noTemplate2);
    ParseArgument parseTest6 = new ParseArgument(noTemplate3);
    ParseArgument parseTest7 = new ParseArgument(wrongMatch);
    ParseArgument parseTest8 = new ParseArgument(noDir1);
    ParseArgument parseTest9 = new ParseArgument(noDir2);
    ParseArgument parseTest10 = new ParseArgument(noDir3);
    ParseArgument parseTest11 = new ParseArgument(noInput1);
    ParseArgument parseTest12 = new ParseArgument(noInput2);
    ParseArgument parseTest13 = new ParseArgument(noInput3);
    ParseArgument parseTest14 = new ParseArgument(moreArgs);
    Assert.assertEquals("", parseTest1.checkArguments());
    Assert.assertEquals("", parseTest2.checkArguments());
    Assert.assertEquals(actionError + example, parseTest3.checkArguments());
    Assert.assertEquals(argNumError + example, parseTest4.checkArguments());
    Assert.assertEquals(templateError + example, parseTest5.checkArguments());
    Assert.assertEquals(argNumError + example, parseTest6.checkArguments());
    Assert.assertEquals(templateError + example, parseTest7.checkArguments());
    Assert.assertEquals(argNumError + example, parseTest8.checkArguments());
    Assert.assertEquals(argNumError + example, parseTest9.checkArguments());
    Assert.assertEquals(dirError + example, parseTest10.checkArguments());
    Assert.assertEquals(argNumError + example, parseTest11.checkArguments());
    Assert.assertEquals(inputError + example, parseTest12.checkArguments());
    Assert.assertEquals(argNumError + example, parseTest13.checkArguments());
    Assert.assertEquals(argNumError + example, parseTest14.checkArguments());
  }

  @Test
  public void getAction() {
    Assert.assertEquals("--email", parseTest1.getAction());
  }

  @Test
  public void getTemplate() {
    Assert.assertEquals(new Template(new FileName("email-template.txt")),
            parseTest1.getTemplate());
  }

  @Test
  public void getDirPath() {
    Assert.assertEquals(new DirPath("emails"), parseTest1.getDirPath());
  }

  @Test
  public void getInput() {
    Assert.assertEquals(new FileName("customer.csv"), parseTest1.getInput());
  }

  @Test
  public void equals() {
      ParseArgument nullParseTest1 = null;
      Assert.assertTrue(parseTest1.equals(sameRefParseTest1));
      Assert.assertTrue(parseTest1.equals(sameStateParseTest1));
      Assert.assertEquals(parseTest1.equals(sameStateParseTest1),
              sameStateParseTest1.equals(parseTest1));
      Assert.assertEquals(parseTest1.equals(sameStateParseTest1)
              && sameStateParseTest1.equals(anotherParseTest1), parseTest1.equals(anotherParseTest1));
      Assert.assertFalse(parseTest1.equals(nullParseTest1));
      Assert.assertFalse(parseTest1.equals(new Integer(9)));
      Assert.assertFalse(parseTest1.equals(parseTest2));
    }

    @Test
    public void testHashCode() {
      Assert.assertEquals(parseTest1.equals(sameStateParseTest1),
              parseTest1.hashCode() == sameStateParseTest1.hashCode());
      Assert.assertEquals(parseTest1.equals(sameRefParseTest1),
              parseTest1.hashCode() == sameRefParseTest1.hashCode());
      Assert.assertEquals(!parseTest1.equals(parseTest2),
              parseTest1.hashCode() != parseTest2.hashCode());
  }

  
}