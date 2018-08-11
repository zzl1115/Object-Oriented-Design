package edu.neu.ccs.cs5004.model;

/**
 * Represents the member information for a member in the input file.
 */

public class MemberInfo {
  private String[] info;

  /**
   * The instructor of the MemberInfo.
   *
   * @param info The information of the member.
   */
  public MemberInfo(String[] info) {
    this.info = new String[info.length];
    for (int i = 0; i < info.length; i++) {
      this.info[i] = info[i];
    }
  }

  /**
   * Get the information of the member.
   *
   * @return The string array represents the information.
   */
  public String[] getInfo() {
    String[] res = new String[info.length];
    for (int i = 0; i < info.length; i++) {
      res[i] = info[i];
    }
    return res;
  }
}
