package edu.neu.ccs.cs5004;

public class ParseArgument {
  private String[] args;

  public ParseArgument(String[] args) {
    this.args = args;
  }

  public Integer getClientsNum(){return Integer.valueOf(args[0]);}

  public Integer getVerificationNum(){return Integer.valueOf(args[1]);}

  public Integer getPercentage(){return Integer.valueOf(args[2]);}

  public String getOutputFile(){return args[3];}



}
