package leetcode.list;

import lombok.extern.slf4j.Slf4j;
import model.leetcode.common.model.ListNode;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;

/**
 * @author zack <br>
 * @create 2021-02-06 21:12 <br>
 * @project leetcode <br>
 */
@Slf4j
public class AddTwoNumber {

  public static void main(String[] args) {

    // test-01
    ListNode a = new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode b = new ListNode(5, new ListNode(6, new ListNode(4)));

    ListNode nodeT1 = addTwoNumber(a, b);
    while (nodeT1 != null) {
      System.out.print(nodeT1.value);
      nodeT1 = nodeT1.nextNode;
    }

    Optional.of(1).ifPresent(System.out::println);

    // test-02
    ListNode a2 = new ListNode(9, new ListNode(9, new ListNode(9)));
    ListNode b2 = new ListNode(1);
    ListNode nodeT2 = addTwoNumber(a2, b2);
    while (nodeT2 != null) {
      System.out.print(nodeT2.value);
      nodeT2 = nodeT2.nextNode;
    }
  }

  /**
   * Core thinking:
   *
   * <pre>
   *     1. non-negative list, so flow should be below:
   *          dummyHead -> A => dummyHead -> B -> A
   *     2. make dummyHead
   * </pre>
   *
   * @param a
   * @param b
   * @return
   */
  public static ListNode addTwoNumber(ListNode a, ListNode b) {
    if (a == null || b == null) {
      return null;
    }

    ListNode dummyHead = new ListNode(-1);
    int tempSum, carry = 0;

    // judgement and worker
    while (a != null || b != null) {
      tempSum = carry;
      if (a != null) {
        tempSum += a.value;
        a = a.nextNode;
      }

      if (b != null) {
        tempSum += b.value;
        b = b.nextNode;
      }

      carry = tempSum / 10;

      // core: dummyHead -> A => dummyHead -> B -> A
      ListNode newNode = new ListNode(tempSum % 10);
      newNode.nextNode = dummyHead.nextNode;
      dummyHead.nextNode = newNode;
    }

    if (carry > 0) {
      ListNode newNode = new ListNode(carry);
      newNode.nextNode = dummyHead.nextNode;
      dummyHead.nextNode = newNode;
    }

    return dummyHead.nextNode;
  }

  /**
   * Ignore this implementation due to we have define link node.<br>
   * Which use jdk api.
   *
   * @param a
   * @param b
   * @return linked list value.
   */
  @Deprecated
  public static LinkedList<Integer> addTwoNumberError(
      Collection<Integer> a, Collection<Integer> b) {

    LinkedList<Integer> list = new LinkedList<>();

    int carry = 0, bitSum;
    final Iterator<Integer> aIterator = a.iterator();
    final Iterator<Integer> bIterator = b.iterator();
    // loop a list for calculate
    while (aIterator.hasNext()) {
      // b have next element.
      int aValue = aIterator.next();
      if (bIterator.hasNext()) {
        int bValue = bIterator.next();
        bitSum = aValue + bValue + carry;
      } else {
        bitSum = carry + aValue;
      }

      list.offerFirst(bitSum % 10);
      carry = bitSum / 10;
    }

    // a has no element, but  b has next element.
    while (bIterator.hasNext()) {
      bitSum = carry + bIterator.next();
      list.offerFirst(bitSum % 10);
      carry = bitSum / 10;
    }

    Optional.of(carry).filter(x -> x != 0).ifPresent(y -> list.offerFirst(y));

    return list;
  }

  public void testError() {
    LinkedList<Integer> aList =
        new LinkedList<Integer>() {
          {
            add(9);
            add(9);
            add(9);
            add(9);
            add(9);
          }
        };

    LinkedList<Integer> bList =
        new LinkedList<Integer>() {
          {
            add(1);
          }
        };

    LinkedList<Integer> results = addTwoNumberError(aList, bList);

    results.forEach(System.out::print);
  }
}
