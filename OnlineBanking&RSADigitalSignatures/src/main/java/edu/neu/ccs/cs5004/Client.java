package edu.neu.ccs.cs5004;

import edu.neu.ccs.cs5004.KeyPair.KeyPair;

public class Client {
  private Id id;
  private KeyPair keyPair;

  public Client(Id id, KeyPair rsaPair) {
    this.id = id;
    this.keyPair = rsaPair;
  }


  public Id getId() {
    return id;
  }

  public KeyPair getKeyPair() {
    return keyPair;
  }
}
