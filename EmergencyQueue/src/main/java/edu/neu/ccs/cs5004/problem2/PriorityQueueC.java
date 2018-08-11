package edu.neu.ccs.cs5004.problem2;

import edu.neu.ccs.cs5004.problem1.List;

import java.util.Comparator;
import java.util.Objects;



/**
 * Represents a priority queue.
 * @param <E> the type of element in the queue
 */
public class PriorityQueueC<E extends Comparable<E>> implements PriorityQueue<E> {

  List<E> queue;
  Comparator<E> comparator;

  /**
   * Creates a new priority queue.
   * @param comparator the comparator used to build the priority queue
   */
  public PriorityQueueC(Comparator<E> comparator) {
    queue = List.createLinkedList();
    this.comparator = comparator;
  }

  @Override
  public void insert(E element) {
    int index = 0;
    while (index < queue.size()) {
      if (comparator.compare(element, queue.get(index)) > 0) {
        queue.add(index, element);
        return;
      } else {
        index++;
      }
    }
    queue.add(queue.size(), element);
  }



  @Override
  public void remove() {
    if (queue.size() == 0) {
      throw new IllegalRequestException("Empty queue cannot remove!");
    }
    queue.remove(0);
  }

  @Override
  public void remove(int index) {
    if (index >= queue.size()) {
      throw new IllegalRequestException("Index out of bounds!");
    }
    queue.remove(index);
  }


  @Override
  public E front() {
    if (queue.size() == 0) {
      throw new IllegalRequestException("Queue is empty!");
    }
    return queue.get(0);
  }

  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  @Override
  public int size() {
    return queue.size();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    PriorityQueueC<?> that = (PriorityQueueC<?>) other;
    return Objects.equals(queue, that.queue);
  }

  @Override
  public int hashCode() {

    return Objects.hash(queue);
  }


  @Override
  public E get(int index) {
    if (index >= queue.size()) {
      throw new IllegalRequestException("Index out of bounds!");
    }
    return queue.get(index);
  }
}

