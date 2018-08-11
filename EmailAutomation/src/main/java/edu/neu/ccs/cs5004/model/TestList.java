package edu.neu.ccs.cs5004.model;

public class TestList {
  private static class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) { val = x; }
  }
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode node1 = new ListNode(2);
    ListNode node2 = new ListNode(3);
    ListNode node3 = new ListNode(4);
    ListNode node4 = new ListNode(5);
    head.next = node1;
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    ListNode temp = head;
    for(int i = 0; i < 4; i++) {
      temp = temp.next;
    }
    temp = null;
    node4 = null;
    System.out.println(node3.next.val);
  }
}
