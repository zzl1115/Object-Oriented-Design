package edu.neu.ccs.cs5004.blackbox;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import edu.neu.ccs.cs5004.problem2.IllegalRequestException;
import edu.neu.ccs.cs5004.problem2.PriorityQueue;


public class priorityQueueCITest {
  private PriorityQueue<Integer> queue1;
  private PriorityQueue<Integer> queue2;



  @Before
  public void setUp() throws Exception {
    queue1 = PriorityQueue.createPriorityQueue(Comparator.<Integer> naturalOrder());
    queue2 = PriorityQueue.createPriorityQueue(Comparator.<Integer> naturalOrder());
    queue1.insert(4);
    queue1.insert(2);
    queue1.insert(5);
    queue1.insert(3);
  }

  @Test
  public void insert() {
    Assert.assertEquals(new Integer(5), queue1.front());
    queue1.insert(9);
    Assert.assertEquals(new Integer(9), queue1.front());
    queue2.insert(5);
    queue2.insert(3);
    queue2.insert(4);
    queue2.insert(2);
    queue2.insert(9);
    Assert.assertEquals(queue1,queue2);

  }

  @Test(expected = IllegalRequestException.class)
  public void remove() {
    Assert.assertEquals(new Integer(5), queue1.front());
    queue1.remove();
    Assert.assertEquals(new Integer(4), queue1.front());
    queue2.remove();
  }

  @Test(expected = IllegalRequestException.class)
  public void front() {
    Assert.assertEquals(new Integer(5), queue1.front());
    queue2.front();
  }

  @Test
  public void isEmpty() {
    Assert.assertTrue(queue2.isEmpty());
    Assert.assertFalse(queue1.isEmpty());
  }

  @Test
  public void size() {
    Assert.assertEquals(0, queue2.size());
    Assert.assertEquals(4, queue1.size());
  }

  @Test(expected = IllegalRequestException.class)
  public void get() {
    Assert.assertEquals(new Integer(2), queue2.get(3));
    queue1.get(100);
  }

  @Test(expected = IllegalRequestException.class)
  public void remove1() {
    Assert.assertEquals(new Integer(5), queue1.front());
    queue1.remove(0);
    Assert.assertEquals(new Integer(4), queue1.front());
    queue2.remove(0);
  }
}