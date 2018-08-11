package edu.neu.ccs.cs5004.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatientTest {
  Patient patient1;
  Patient patient2;
  Urgency urgency;
  Name name;

  @Before
  public void setUp() throws Exception {
    urgency = new Urgency(1);
    name = new Name("A", "a");
    patient1 = new Patient(urgency, name);
    patient2 = new Patient(urgency, name);
  }

  @Test
  public void setOrder() {
    patient1.setOrder(3);
    Assert.assertEquals(3, patient1.getOrder());
  }

  @Test
  public void getOrder() {
    patient1.setOrder(5);
    Assert.assertEquals(5, patient1.getOrder());
  }

  @Test
  public void getUrgency() {
    Assert.assertEquals(urgency, patient1.getUrgency());
  }

  @Test
  public void compareTo() {
    Patient patient = new Patient(new Urgency(3), new Name("B","b"));
    Assert.assertEquals(-1, patient1.compareTo(patient));
    Assert.assertEquals(1, patient.compareTo(patient1));
    Assert.assertEquals(0,patient.compareTo(patient));
  }

  @Test
  public void equals() {
    Assert.assertEquals(patient1, patient2);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(patient1.equals(patient2), patient2.hashCode() == patient1.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Patient{urgency=Urgency{value=1}, name=Name{first='A', last='a'}}",
            patient1.toString());
  }
}