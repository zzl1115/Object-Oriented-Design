package edu.neu.ccs.cs5004;

public class Record {
  private String transactionNumAndDate;
  private String time;
  private Id clientId;
  private Message message;
  private DS signature;
  private VerifiedStatus verified;
  private String transactionStatus;


  public Record(String transactionNumAndDate, String time, Id clientId, Message message,
                DS signature, VerifiedStatus verified, String transactionStatus) {
    this.transactionNumAndDate = transactionNumAndDate;
    this.time = time;
    this.clientId = clientId;
    this.message = message;
    this.signature = signature;
    this.verified = verified;
    this.transactionStatus = transactionStatus;
  }



}
