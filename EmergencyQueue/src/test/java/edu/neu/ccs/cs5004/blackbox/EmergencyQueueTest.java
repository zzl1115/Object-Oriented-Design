package edu.neu.ccs.cs5004.blackbox;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.problem2.IllegalRequestException;
import edu.neu.ccs.cs5004.problem3.EmergencyQueue;
import edu.neu.ccs.cs5004.problem3.Name;
import edu.neu.ccs.cs5004.problem3.Patient;
import edu.neu.ccs.cs5004.problem3.Urgency;

public class EmergencyQueueTest {
  EmergencyQueue queue1;
  EmergencyQueue queue2;
  EmergencyQueue queue3;
  Patient p1 = new Patient(new Urgency(1), new Name("A", "a"));
  Patient p2 = new Patient(new Urgency(6), new Name("B", "b"));
  Patient p3 = new Patient(new Urgency(300), new Name("C", "c"));
  Patient p4 = new Patient(new Urgency(250), new Name("D", "d"));

  @Before
  public void setUp() throws Exception {
    queue1 = EmergencyQueue.createEmergencyQueue();
    queue2 = EmergencyQueue.createUrgentCareQueue();
    queue3 = EmergencyQueue.createEmergencyQueue();
    queue1.add(p1);
    queue1.add(p2);
    queue1.add(p3);
    queue1.add(p4);
    queue2.add(p1);
    queue2.add(p2);
    queue2.add(p3);
    queue2.add(p4);
  }

  @Test
  public void isEmpty() {
    Assert.assertTrue(queue3.isEmpty());
    Assert.assertFalse(queue1.isEmpty());
  }

  @Test
  public void size() {
    Assert.assertEquals(0, queue3.size());
    Assert.assertEquals(4, queue1.size());
  }

  @Test(expected = IllegalRequestException.class)
  public void nextPatient() {
    Assert.assertEquals(p1, queue1.nextPatient());
    Assert.assertEquals(p1, queue2.nextPatient());
    queue3.nextPatient();
  }

  @Test
  public void add() {
    queue3.add(p1);
    queue3.add(p2);
    queue3.add(p3);
    queue3.add(p4);
    Assert.assertEquals(queue1, queue3);
  }

  @Test(expected = IllegalRequestException.class)
  public void nextMostUrgent() {
    Assert.assertEquals(p3, queue1.nextMostUrgent());
    Assert.assertEquals(p3, queue3.nextMostUrgent());
    queue3.nextMostUrgent();
  }

  @Test(expected = IllegalRequestException.class)
  public void removeNext() {
    Patient p = new Patient(new Urgency(250), new Name("Temp", "t"));
    for(int i = 0; i < 100; i++) {
      queue1.add(p);
    }
    queue1.removeNext();
    Assert.assertEquals(p2, queue1.nextPatient());
    queue2.removeNext();
    Assert.assertEquals(p2, queue2.nextPatient());
    queue3.removeNext();
  }

  @Test(expected = IllegalRequestException.class)
  public void removeMostUrgent() {
    Patient p = new Patient(new Urgency(250), new Name("Temp", "t"));
    for(int i = 0; i < 100; i++) {
      queue1.add(p);
    }
    queue1.removeMostUrgent();
    Assert.assertEquals(p4, queue1.nextMostUrgent());
    queue2.removeMostUrgent();
    Assert.assertEquals(p4, queue2.nextMostUrgent());
    queue3.removeMostUrgent();
  }

  @Test
  public void createEmergencyQueue() {
    Assert.assertTrue(EmergencyQueue.createEmergencyQueue().isEmpty());
  }

  @Test
  public void createUrgentCareQueue() {
    Assert.assertTrue(EmergencyQueue.createUrgentCareQueue().isEmpty());
  }
}