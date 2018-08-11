package edu.neu.ccs.cs5004.problem1;


/**
 * Represents a generic list.
 * @param <E> the type of list element
 */
public interface List<E> {
  /**
   * Creates an empty linked list.
   * Time complexity: O(1).
   * @param <T> the type of elements in the new list
   * @return an empty list of type E
   */
  static <T> List createLinkedList() {
    return new LinkedList<T>();
  }

  /**
   * Adds an element to the front of the list.
   * Time complexity: O(1).
   * @param element the element to add
   */
  void add(E element);

  /**
   * Adds a given element at the given index in the list.
   * Time complexity: O(n).
   * @param index the position to add the element
   * @param element the element to add
   * @throws IllegalArgumentException upon index larger than queue size
   */
  void add(int index, E element);

  /**
   * Gets an element located at the specified index.
   * Time complexity: O(n).
   * @param index the index where to get the element
   * @return the element at the given index
   * @throws IllegalArgumentException upon index larger than queue size-1
   */
  E get(int index);

  /**
   * Retrieves the element in the list and returns the respective index in the list.
   * Time complexity: O(n).
   * @param element the given element to get the index
   * @return the index of the given element
   */
  int indexOf(E element);

  /**
   * Checks if the list is empty.
   * Time complexity: O(1).
   * @return true if the lis tis empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Removes the element at the given index in the list.
   * Time complexity: O(n).
   * @param index the index at which to remove the element
   * @throws IllegalArgumentException upon index larger than queue size-1
   */
  void remove(int index);

  /**
   * Gets the size of the list.
   * Time complexity: O(1).
   * @return the size of the list
   */
  int size();

  /**
   * Checks whether the list contains the given element.
   * Time complexity: O(n).
   * @param element the element to check
   * @return true if the list contains the given element, false otherwise
   */
  boolean contains(E element);

}
