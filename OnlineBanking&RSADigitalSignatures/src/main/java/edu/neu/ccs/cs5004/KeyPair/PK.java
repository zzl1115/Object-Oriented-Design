package edu.neu.ccs.cs5004.KeyPair;

import java.math.BigInteger;

public class PK {
  private BigInteger b;
  private BigInteger n;

  public PK(BigInteger b, BigInteger n) {
    this.b = b;
    this.n = n;
  }

  public BigInteger getB() {
    return b;
  }

  public BigInteger getN() {
    return n;
  }
}
