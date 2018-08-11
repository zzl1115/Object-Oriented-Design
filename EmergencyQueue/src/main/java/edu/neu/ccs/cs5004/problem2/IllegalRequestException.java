package edu.neu.ccs.cs5004.problem2;

/**
 * Represents an illegal request exception.
 */
public class IllegalRequestException extends RuntimeException{

  /**
   * Creates a new illegal request exception with the given message.
   * @param msg the message about the new exception
   */
  public IllegalRequestException(String msg) {
    super(msg);
  }
}
