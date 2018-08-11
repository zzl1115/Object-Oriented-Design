package edu.neu.ccs.cs5004.problem3;

import java.util.Objects;

public class Patient implements Comparable<Patient> {
  private Urgency urgency;
  private Name name;
  private int order;

  /**
   * Create a new patient.
   *
   * @param urgency given urgency value of the patient
   * @param name    of the patient
   */
  public Patient(Urgency urgency, Name name) {
    this.urgency = urgency;
    this.name = name;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public int getOrder() {
    return order;
  }

  /**
   * Getter for property ’urgency’.
   *
   * @return Value for property ’urgency’.
   */
  public Urgency getUrgency() {
    return this.urgency;
  }


  @Override
  public int compareTo(Patient patient) {
    if (this.urgency.value > patient.urgency.value) {
      return 1;
    } else if (this.urgency.value < patient.urgency.value) {
      return -1;
    } else {
      return 0;
    }
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Patient patient = (Patient) object;
    return Objects.equals(urgency, patient.urgency)
            && Objects.equals(name, patient.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(urgency, name);
  }

  @Override
  public String toString() {
    return "Patient{"
            + "urgency=" + urgency
            + ", name=" + name
            + '}';
  }

}
