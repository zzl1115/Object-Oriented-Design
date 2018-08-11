package edu.neu.ccs.cs5004.problem3;



public class EmergencyQueueC extends AbstractEmergencyQueue{

  public EmergencyQueueC() {
    super(new PatientUrgencyComparator());

  }

  @Override
  public void add(Patient patient) {
    listOfPatient.insert(patient);
    count += 1;
    patient.setOrder(count);
  }


  @Override
  public Patient nextPatient() {
    return findNext(new PatientOrderComparator());
  }


  @Override
  public Patient nextMostUrgent() {
    return listOfPatient.front();
  }


  @Override
  public void removeMostUrgent() {
    long startTime = System.nanoTime();
    listOfPatient.remove();
    System.out.println("The time of removeMostUrgent: " + (System.nanoTime() - startTime));
  }

  @Override
  public void removeNext() {
    long startTime = System.nanoTime();
    removeOnePatient(new PatientOrderComparator());
    System.out.println("The time of removeNext: " + (System.nanoTime() - startTime));

  }


}
