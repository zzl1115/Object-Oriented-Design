package edu.neu.ccs.cs5004.problem1;

import java.util.Objects;

/**
 * Represents a linked list.
 * @param <E> the element type in the linked list
 */
class LinkedList<E> implements List<E> {

  private Node<E> sentinel;
  private int listSize;

  /**
   * Creates a new linked list.
   */
  public LinkedList() {
    sentinel = new Node<>(null, null, null);
    sentinel.prev = sentinel;
    sentinel.next = sentinel;
    listSize = 0;
  }

  /**
   * Creates a new linked list with the given element as the first element.
   * @param element the first element in the new linked list
   */
  public LinkedList(E element) {
    sentinel = new Node<>(null, null, null);
    Node<E> node = new Node<>(element);
    sentinel.next = node;
    sentinel.prev = node;
    listSize = 0;
  }


  @Override
  public void add(E element) {
    sentinel.next = new  Node<E>(element, sentinel, sentinel.next);
    sentinel.next.next.prev = sentinel.next;
    listSize++;
  }

  @Override
  public void add(int index, E element) {
    if (index > listSize) {
      throw new IllegalArgumentException("Index out of bounds!");
    }
    Node<E> temp = this.sentinel;
    while (index > 0) {
      temp = temp.next;
      index--;
    }
    Node<E> node = new Node<>(element, temp, temp.next);
    temp.next.prev = node;
    temp.next = node;
    listSize++;
  }

  @Override
  public E get(int index) {
    if (index >= listSize) {
      throw new IllegalArgumentException("Index out of bounds!");
    }
    Node<E> temp = this.sentinel;
    while (index > 0) {
      temp = temp.next;
      index--;
    }
    return temp.next.getVal();
  }

  @Override
  public int indexOf(E element) {
    Node<E> temp = this.sentinel.next;
    int index = 0;
    while (temp != sentinel) {
      if (temp.getVal().equals(element)) {
        return index;
      }
      temp = temp.next;
      index++;
    }
    return -1;
  }

  @Override
  public boolean isEmpty() {
    return listSize == 0;
  }

  @Override
  public void remove(int index) {
    if (index >= listSize) {
      throw new IllegalArgumentException("Index out of bounds!");
    }
    Node<E> temp = this.sentinel;
    while (index > 0) {
      temp = temp.next;
      index--;
    }
    temp.next.next.prev = temp;
    temp.next = temp.next.next;
    listSize--;
  }

  @Override
  public int size() {
    return listSize;
  }

  @Override
  public boolean contains(E element) {
    return indexOf(element) != -1;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }

    LinkedList<?> that = (LinkedList<?>) other;
    if (this.listSize != that.listSize) {
      return false;
    }
    Node<?> temp = that.sentinel.next;
    Node<?> node = this.sentinel.next;
    while (!temp.equals(that.sentinel)) {
      if (!temp.equals(node)) {
        return false;
      }
      temp = temp.next;
      node = node.next;
    }
    return true;
  }

  @Override
  public int hashCode() {

    return Objects.hash(sentinel, listSize);
  }
}
