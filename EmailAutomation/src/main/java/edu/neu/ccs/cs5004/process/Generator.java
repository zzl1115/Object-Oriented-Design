package edu.neu.ccs.cs5004.process;

import edu.neu.ccs.cs5004.model.Header;
import edu.neu.ccs.cs5004.model.MemberInfo;
import edu.neu.ccs.cs5004.model.Members;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Represents the process of generating a communicating file to a member.
 */
public class Generator implements GeneratorI {
  private List<String> templateContents;
  private Map<Header, Integer> headerMap;

  public Generator(List<String> templateContents, Members members) {
    this.templateContents = templateContents;
    this.headerMap = members.getHeaderMap();
  }

  /**
   * Replace the key words in template with member information.
   *
   * @param member The memberInfo.
   * @return The list of message with right information.
   */
  public List<String> replacePlaceHolder(MemberInfo member) {
    List<String> result = new ArrayList<>();
    for (String line : templateContents) {
      int index = line.indexOf("[[");
      while (index > 0) {
        int end = line.indexOf("]]", index);
        String template = line.substring(index + 2, end);
        int header = -1;
        try {
          header = headerMap.get(new Header(template));
        } catch (NullPointerException nullPointerEx) {
          System.out.println("Don't contains this header:" + template);
          nullPointerEx.printStackTrace();
        }
        line = line.replaceAll("\\[\\[" + template + "\\]\\]", member.getInfo()[header]);
        index = line.indexOf("[[");
      }
      result.add(line);
    }
    return result;
  }


}
