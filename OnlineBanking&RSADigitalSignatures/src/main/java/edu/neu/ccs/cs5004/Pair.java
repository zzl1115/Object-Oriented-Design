package edu.neu.ccs.cs5004;

import java.util.Random;


public class Pair {
  private Message message;
  private DS ds;

  public Pair(Message message,DS ds) {
    this.message = message;
    this.ds = ds;
  }

  public Message getMessage() {
    return message;
  }

  public DS getDs() {
    return ds;
  }

  public Message generateMessage(){
    Random rand = new Random(30000);
    return new Message(rand.nextInt());
  }

}
