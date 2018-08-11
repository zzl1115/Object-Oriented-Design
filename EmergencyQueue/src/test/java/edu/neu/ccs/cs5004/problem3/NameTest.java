package edu.neu.ccs.cs5004.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {
  Name name1;
  Name name2;

  @Before
  public void setUp() throws Exception {
    name1 = new Name("A", "a");
    name2 = new Name("A", "a");
  }

  @Test
  public void equals() {
    Assert.assertTrue(name1.equals(name1));
    Assert.assertEquals(name1, name2);
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(name1.equals(name2), name2.hashCode() == name1.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Name{first='A', last='a'}", name1.toString());
  }
}