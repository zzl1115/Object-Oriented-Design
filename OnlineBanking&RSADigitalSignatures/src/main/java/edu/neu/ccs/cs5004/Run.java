package edu.neu.ccs.cs5004;

public class Run {

  public static void main(String[] args) {
    if (args.length != 4) {
      System.out.println("Lacks of inputs!");
      System.exit(1);
    }

    ParseArgument pa = new ParseArgument(args);

    SecureBankVerificationSimulator simulator = new SecureBankVerificationSimulator();
    simulator.simulation(pa.getClientsNum(),pa.getVerificationNum(),pa.getPercentage(),pa.getOutputFile());

  }
}
