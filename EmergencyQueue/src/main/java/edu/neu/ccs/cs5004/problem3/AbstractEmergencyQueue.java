package edu.neu.ccs.cs5004.problem3;

import edu.neu.ccs.cs5004.problem2.IllegalRequestException;
import edu.neu.ccs.cs5004.problem2.PriorityQueue;

import java.util.Comparator;
import java.util.Objects;

public abstract class AbstractEmergencyQueue implements EmergencyQueue {
  PriorityQueue<Patient> listOfPatient;
  int count;

  /**
   * Creates a new abstract emergency queue.
   * @param comparator the comparator used to arrange patients in the queue.
   */
  public AbstractEmergencyQueue(Comparator<Patient> comparator) {
    listOfPatient = PriorityQueue.createPriorityQueue(comparator);
  }

  @Override
  public boolean isEmpty() {
    return listOfPatient.isEmpty();
  }

  @Override
  public int size() {
    return listOfPatient.size();
  }


  /**
   * Find the next patient with the given comparator. Time Complexity: O(n).
   * @param comparator the comparator used to find the next patient
   * @return the next patient
   */
  protected Patient findNext(Comparator<Patient> comparator) {
    if (listOfPatient.isEmpty()) {
      throw new IllegalRequestException("No patient!");
    }
    Patient nextPatient = listOfPatient.front();
    for (int i = 0; i < listOfPatient.size(); i++) {
      Patient curPatient = listOfPatient.get(i);
      if (comparator.compare(curPatient, nextPatient) > 0) {
        nextPatient = curPatient;
      }
    }
    return nextPatient;
  }

  /**
   * Romove the next patient with the given comparator. Time Complexity: O(n).
   * @param comparator the comparator used to find the next patient to be removed
   */
  protected void removeOnePatient(Comparator<Patient> comparator) {
    if (listOfPatient.isEmpty()) {
      throw new IllegalRequestException("No patient!");
    }
    Patient nextPatient = listOfPatient.front();
    int nextIndex = 0;
    for (int i = 0; i < listOfPatient.size(); i++) {
      Patient curPatient = listOfPatient.get(i);
      if (comparator.compare(curPatient, nextPatient) > 0) {
        nextPatient = curPatient;
        nextIndex = i;
      }
    }
    listOfPatient.remove(nextIndex);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }

    AbstractEmergencyQueue that = (AbstractEmergencyQueue) other;
    return count == that.count
            && Objects.equals(listOfPatient, that.listOfPatient);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listOfPatient, count);
  }
}


