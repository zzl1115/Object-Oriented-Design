package edu.neu.ccs.cs5004.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UrgencyTest {
  Urgency urgency;
  Urgency urgency1;

  @Before
  public void setUp() throws Exception {
    urgency = new Urgency(2);
    urgency1 = new Urgency(2);
  }

  @Test
  public void equals() {
    Assert.assertEquals(urgency,urgency1);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(urgency.equals(urgency1), urgency1.hashCode() == urgency.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Urgency{value=2}", urgency.toString());
  }
}