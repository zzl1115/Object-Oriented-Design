package edu.neu.ccs.cs5004.blackbox;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.problem1.List;

import static org.junit.Assert.*;

public class ListTest {
  List<Integer> intList;
  List<String> strList;
  List<Integer> oneIntList;

  @Before
  public void setUp() throws Exception {
    intList = List.createLinkedList();
    strList = List.createLinkedList();
    oneIntList = List.createLinkedList();
    oneIntList.add(new Integer(4));
    oneIntList.add(new Integer(3));
    oneIntList.add(new Integer(2));
    oneIntList.add(new Integer(1));
  }

  @Test
  public void createLinkedList() {
    Assert.assertTrue(intList.isEmpty());
  }

  @Test
  public void add() {
    intList.add(new Integer(2));
    strList.add("haha");
    Assert.assertEquals(new Integer(2), intList.get(0));
    Assert.assertEquals("haha", strList.get(0));
    intList.add(new Integer(4));
    Assert.assertEquals(new Integer(4), intList.get(0));
    strList.add("hehe");
    Assert.assertEquals("hehe", strList.get(0));
  }

  @Test
  public void add1() {
    intList.add(new Integer(4));
    intList.add(new Integer(2));
    intList.add(new Integer(1));
    intList.add(2, 3);
    Assert.assertEquals(oneIntList, intList);
  }

  @Test(expected=IllegalArgumentException.class)
  public void get() {
    oneIntList.get(80);
    Assert.assertEquals(new Integer(2),oneIntList.get(1));
    Assert.assertEquals(new Integer(3), oneIntList.get(2));
  }

  @Test
  public void indexOf() {
    Assert.assertEquals(-1, oneIntList.indexOf(80));
    Assert.assertEquals(2, oneIntList.indexOf(3));
    Assert.assertEquals(1, oneIntList.indexOf(2));
  }

  @Test
  public void isEmpty() {
    Assert.assertTrue(intList.isEmpty());
    Assert.assertFalse(oneIntList.isEmpty());
  }

  @Test(expected=IllegalArgumentException.class)
  public void remove() {
    oneIntList.remove(80);
    oneIntList.remove(1);
    intList.add(4);
    intList.add(3);
    intList.add(1);
    Assert.assertEquals(oneIntList, intList);
  }

  @Test
  public void size() {
    Assert.assertEquals(0, intList.size());
    Assert.assertEquals(4, oneIntList.size());
  }

  @Test
  public void contains() {
    Assert.assertTrue(oneIntList.contains(3));
    Assert.assertFalse(oneIntList.contains(9));
    Assert.assertFalse(intList.contains(4));
  }
}