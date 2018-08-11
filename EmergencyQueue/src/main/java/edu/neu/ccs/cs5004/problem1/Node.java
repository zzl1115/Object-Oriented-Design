package edu.neu.ccs.cs5004.problem1;

import java.util.Objects;

/**
 * Represents a noew in the linked list.
 * @param <E> the value type of the node
 */

class Node<E> {
  private E val;
  Node<E> prev;
  Node<E> next;

  /**
   * Creates a new node with the given value.
   * @param val the given value of the node
   */
  public Node(E val) {
    this.val = val;
  }

  /**
   * Creates a new node with the given value, previous node and next node.
   * @param val the given value of the node
   * @param prev the previous node of the new node
   * @param next the next node of the new node
   */
  public Node(E val, Node<E> prev, Node<E> next) {
    this.val = val;
    this.prev = prev;
    this.next = next;
  }

  /**
   * Getter fot property 'val'.
   * @return value for property 'val'
   */
  public E getVal() {
    return val;
  }

  /**
   * Getter fot property 'prev'.
   * @return value for property 'prev'
   */
  public Node<E> getPrev() {
    return prev;
  }

  /**
   * Getter fot property 'next'.
   * @return value for property 'next'
   */
  public Node<E> getNext() {
    return next;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Node<?> node = (Node<?>) other;
    return Objects.equals(getVal(), node.getVal());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getVal());
  }
}
