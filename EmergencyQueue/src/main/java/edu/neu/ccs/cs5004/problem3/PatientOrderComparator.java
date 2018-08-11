package edu.neu.ccs.cs5004.problem3;

import java.io.Serializable;
import java.util.Comparator;

public class PatientOrderComparator implements Comparator<Patient>, Serializable {
  @Override
  public int compare(Patient patient1, Patient patient2) {
    if (patient1.getOrder() > patient2.getOrder()) {
      return -1;
    } else if (patient1.getOrder() < patient2.getOrder()) {
      return 1;
    } else {
      return 0;
    }
  }
}
