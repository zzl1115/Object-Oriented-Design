package edu.neu.ccs.cs5004;

public class Message {
  private Integer m;

  public Message(Integer message) {
    this.m= message;
  }

  public Integer getM() {
    return m;
  }

  public int frontDigit(){
    String messageStr = m.toString();
    String str = messageStr.substring(0, messageStr.length() - 1);

    if (messageStr.length() == 0) {
      return 0;
    }

    return Integer.parseInt(messageStr.substring(0, messageStr.length() - 1));
  }

  public int lastDigit(){
    String messageStr = m.toString();
    return Character.getNumericValue(messageStr.charAt(messageStr.length() - 1));
  }


}
