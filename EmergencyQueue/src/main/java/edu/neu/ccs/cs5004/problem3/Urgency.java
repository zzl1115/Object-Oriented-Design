package edu.neu.ccs.cs5004.problem3;

import java.util.Objects;

public class Urgency {
  Integer value;

  public Urgency(Integer value) {
    this.value = value;
  }


  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Urgency urgency = (Urgency) object;
    return Objects.equals(value, urgency.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Urgency{"
            + "value=" + value
            + '}';
  }
}
