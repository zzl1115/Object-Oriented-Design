package edu.neu.ccs.cs5004.process;

import edu.neu.ccs.cs5004.model.MemberInfo;
import edu.neu.ccs.cs5004.model.Members;

import java.util.List;

/**
 * Represents the process of generating a communicating file to a member.
 */
public interface GeneratorI {
  static GeneratorI createGenerator(List<String> templateContents, Members members) {
    return new Generator(templateContents, members);
  }

  List<String> replacePlaceHolder(MemberInfo member);
}
