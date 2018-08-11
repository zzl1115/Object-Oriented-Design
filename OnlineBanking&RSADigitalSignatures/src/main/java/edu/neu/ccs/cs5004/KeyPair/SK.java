package edu.neu.ccs.cs5004.KeyPair;

import java.math.BigInteger;

public class SK {
  private BigInteger a;
  private BigInteger n;

  public SK(BigInteger a, BigInteger n) {
    this.a = a;
    this.n = n;
  }

  public BigInteger getA() {
    return a;
  }

  public BigInteger getN() {
    return n;
  }
}
