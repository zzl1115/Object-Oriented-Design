package edu.neu.ccs.cs5004.problem2;

import java.util.Comparator;

/**
 * Represents a priority queue with comparable element.
 * @param <E> the type of the element in the priority queue
 */
public interface PriorityQueue<E extends Comparable<E>> {

  /**
   * Creates a new priority queue.
   * Time complexity: O(1).
   * @param <T> the type of element in the priority queue
   * @return a new priority queue of the given element type
   */
  static <T extends Comparable<T>> PriorityQueue createPriorityQueue(Comparator<T> comparator) {
    return new PriorityQueueC<>(comparator);
  }

  /**
   * Inserts a given element into the priority queue according to the priority of the element.
   * Time complexity: O(n).
   * @param element the element to add into the queue
   */
  void insert(E element);



  /**
   * Removes the element from the front.
   * Time complexity: O(1).
   * @throws IllegalRequestException upon an empty queue
   */
  void remove();


  /**
   * Removes the element located at the specified index from the queue.
   * Time complexity: O(n).
   * @param index the index at which to remove the element
   * @throws IllegalRequestException upon index larger than queue size-1
   */
  void remove(int index);


  /**
   * Returns the element at the front of the queue.
   * Time complexity: O(1).
   * @return the element at the front of the queue.
   * @throws IllegalRequestException upon an empty queue
   */
  E front();

  /**
   * Checks if the queue is empty.
   * Time complexity: O(1).
   * @return true if the queue is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Gets the size of the queue.
   * Time complexity: O(1).
   * @return the size of the queue
   */
  int size();

  /**
   * Gets an element located at the specified index.
   * Time complexity: O(n).
   * @param index the index where to get the element.
   * @return the element at the given index
   * @throws IllegalRequestException upon index larger than queue size-1
   */
  E get(int index);

}

