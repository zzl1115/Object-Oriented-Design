package edu.neu.ccs.cs5004.problem3;

public interface EmergencyQueue {

  /**
   * Check if the EmergencyQueue is empty.
   * Time complexity: O(1).
   * @return True if it is empty, otherwise return false.
   */
  boolean isEmpty();

  /**
   * Gets the size of the queue.
   * Time complexity: O(1).
   * @return the size of the queue
   */
  int size();

  /**
   * Get the next Patient of the EmergencyQueue.
   * Time complexity: EmergencyQueueC is O(n), UrgentCareQueue is O(1).
   * @return the Patient in the front in add order.
   */
  Patient nextPatient();

  /**
   * Add a patient into the EmergencyQueue.
   * Time complexity: EmergencyQueueC is O(n), UrgentCareQueue is O(n).
   * @param patient The patient that is going to add.
   */
  void add(Patient patient);

  /**
   * Get the next most urgent Patient of the EmergencyQueue.
   * Time complexity: EmergencyQueueC is O(1), UrgentCareQueue is O(n).
   * @return the Patient in the front in urgency order.
   */
  Patient nextMostUrgent();

  /**
   * Remove the next Patient of the EmergencyQueue.
   * Time complexity: EmergencyQueueC is O(n), UrgentCareQueue is O(1).
   */
  void removeNext();

  /**
   * Remove the next most urgent Patient of the EmergencyQueue.
   * Time complexity: EmergencyQueueC is O(1), UrgentCareQueue is O(n).
   */
  void removeMostUrgent();

  /**
   * Create a EmergencyQueue with urgency order.
   * Time complexity: O(1)
   * @return EmergencyQueue.
   */
  static EmergencyQueue createEmergencyQueue() {
    return new EmergencyQueueC();
  }

  /**
   * Create a EmergencyQueue with add order.
   * Time complexity: O(1)
   * @return EmergencyQueue.
   */
  static EmergencyQueue createUrgentCareQueue() {
    return new UrgentCareQueue();
  }
}
