package edu.neu.ccs.cs5004.problem3;

public class UrgentCareQueue extends AbstractEmergencyQueue {

  public UrgentCareQueue() {
    super(new PatientOrderComparator());
  }

  @Override
  public void add(Patient patient) {
    count += 1;
    patient.setOrder(count);
    listOfPatient.insert(patient);
  }


  @Override
  public Patient nextPatient() {
    return listOfPatient.front();
  }


  @Override
  public Patient nextMostUrgent() {
    return findNext(new PatientUrgencyComparator());
  }


  @Override
  public void removeMostUrgent() {
    removeOnePatient(new PatientUrgencyComparator());
  }

  @Override
  public void removeNext() {
    listOfPatient.remove();
  }
}
