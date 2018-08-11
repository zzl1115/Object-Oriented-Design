package edu.neu.ccs.cs5004.KeyPair;

public class KeyPair {
  private SK privateKey;
  private PK publicKey;

  public KeyPair(SK privateKey, PK publicKey) {
    this.privateKey = privateKey;
    this.publicKey = publicKey;
  }

  public SK getPrivateKey() {
    return privateKey;
  }

  public PK getPublicKey() {
    return publicKey;
  }
}
