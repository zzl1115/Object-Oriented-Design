package edu.neu.ccs.cs5004;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

import edu.neu.ccs.cs5004.KeyPair.PK;

public class Bank {

  private Map<Id,PK> publicKeyMap;
  private Map<Id,DepositLimit> depositLimitMap;
  private Map<Id,WithdrawalLimit> withdrawalLimitMap;
  private Map<Id,Message> messageMap;
  private Map<Id,Pair> signatureMap;
  private static final DateTimeFormatter FORMATTER
      = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.US);
  private int transcationNum = 1;


  public Map<Id, PK> getPublicKeyMap() {
    return publicKeyMap;
  }

  public Map<Id, DepositLimit> getDepositLimitMap() {
    return depositLimitMap;
  }

  public Map<Id, WithdrawalLimit> getWithdrawalLimitMap() {
    return withdrawalLimitMap;
  }

  public Map<Id, Message> getMessageMap() {
    return messageMap;
  }

  public Map<Id, Pair> getSignatureMap() {
    return signatureMap;
  }

  public boolean isClient(Id id,Pair pair){
    return RSA.SignatureVerify(pair.getMessage(),pair.getDs(),this.getPublicKeyMap().get(id));
  }

  public Record generateRecord(Id clientId){
    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();
    String transactionNumAndDate = transcationNum + "-" + date.toString();
    String transactionTime = FORMATTER.format(time);

    transcationNum++;

    Boolean isClient = isClient(clientId,signatureMap.get(clientId));
    VerifiedStatus verified = isClient? VerifiedStatus.yes : VerifiedStatus.no;

    return new Record(transactionNumAndDate, transactionTime, clientId,
        signatureMap.get(clientId).getMessage(), signatureMap.get(clientId).getDs(),
        verified, process(clientId, signatureMap.get(clientId).getMessage(), isClient));
  }

  private String process(Id clientId, Message msg, Boolean verified) {
    int lastDigit = msg.lastDigit();

    if (verified) {
      int amount = msg.frontDigit();
      if(lastDigit >= 0 && lastDigit <= 4){
        return depositStatus(clientId,amount);
      }
      return withdrawStatus(clientId,amount);
    }

    if (lastDigit >= 0 && lastDigit <= 4) {
      return "deposit rejected";
    }

    return "withdraw rejected";
  }

  public String depositStatus(Id id,int amount){
    if(this.depositLimitMap.get(id).getDl() >= amount){
      return "deposit accepted";
    }
    return "deposit rejected";
  }

  public String withdrawStatus(Id id,int amount){
    if(this.withdrawalLimitMap.get(id).getWl() >= amount){
      return "withdraw accepted";
    }
    return "withdraw rejected";
  }
}
