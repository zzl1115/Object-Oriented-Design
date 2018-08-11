package edu.neu.ccs.cs5004.problem3;

import java.util.Objects;

public class Name {
  String first;
  String last;

  public Name(String first, String last) {
    this.first = first;
    this.last = last;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Name name = (Name) object;
    return Objects.equals(first, name.first)
            && Objects.equals(last, name.last);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first, last);
  }

  @Override
  public String toString() {
    return "Name{"
            + "first='" + first + '\''
            + ", last='" + last + '\''
            + '}';
  }
}