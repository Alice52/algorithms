package interview.list;

import lombok.extern.slf4j.Slf4j;
import model.leetcode.common.model.ListNode;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/15
 *
 * @see CircleIntersect 有环链表相交问题
 * @author zack <br>
 * @create 2021-02-15 19:39 <br>
 * @project leetcode <br>
 */
@Slf4j
public class Intersect {
  public static void main(String[] args) {
    ListNode<Integer> node1 = new ListNode<>(1);
    ListNode<Integer> node2 = new ListNode<>(2);
    ListNode<Integer> node3 = new ListNode<>(3);
    ListNode<Integer> node4 = new ListNode<>(4);
    ListNode<Integer> node5 = new ListNode<>(5);
    ListNode<Integer> node6 = new ListNode<>(6);
    ListNode<Integer> node7 = new ListNode<>(7);
    ListNode<Integer> node11 = new ListNode<>(11);
    ListNode<Integer> node12 = new ListNode<>(12);
    ListNode<Integer> node13 = new ListNode<>(13);

    node1.nextNode = node2;
    node2.nextNode = node3;
    node3.nextNode = node4;
    node4.nextNode = node5;
    node5.nextNode = node6;
    node6.nextNode = node7;

    node11.nextNode = node12;
    node12.nextNode = node13;
    node13.nextNode = node3;

    Optional.of(judgeListIntersection(node1, node11)).ifPresent(System.out::println);
    Optional.ofNullable(getNodeOfTwoIntersection(node1, node11))
        .ifPresent(x -> log.info("{}", x.value));

    OptionalInt.of(getIntersectionLength(node1, node11)).ifPresent(System.out::println);
  }

  /**
   * 判断连个任意的无环链表相交长度
   *
   * @param headA
   * @param headB
   * @return
   */
  public static int getIntersectionLength(ListNode headA, ListNode headB) {

    if (!judgeListIntersection(headA, headB)) {
      return 0;
    }

    ListNode<Integer> node = getNodeOfTwoIntersection(headA, headB);

    int count = 0;
    while (node != null) {
      count++;
      node = node.nextNode;
    }

    return count;
  }

  /**
   * 获取两个无环相交链表的相交节点
   *
   * @param headA
   * @param headB
   * @return
   */
  public static ListNode<Integer> getNodeOfTwoIntersection(ListNode headA, ListNode headB) {
    ListNode pa = headA, pb = headB;

    while (pa != pb) {
      pa = (pa != null) ? pa.nextNode : headB;
      pb = (pb != null) ? pb.nextNode : headA;
    }

    return pa;
  }

  /**
   * 判断两个无环链表是否相交: 4
   *
   * <pre>
   *     1. 暴力解法
   *     2. hash
   *     3. 短的那个尾结点指向长的那个的首节点, 判断链表是否有环: 快慢指针
   *     4. 如果两个链表相交, 则最后一个元素一定相同
   *        - 让较长的那个链表先移动 |len1- len2| 长度之后再共同移动两个节点直到相交
   * </pre>
   *
   * @param a
   * @param b
   * @return
   */
  public static boolean judgeListIntersection(ListNode a, ListNode b) {

    if (a == null || b == null) {
      return false;
    }

    while (a.nextNode != null) {
      a = a.nextNode;
    }

    while (b.nextNode != null) {
      b = b.nextNode;
    }

    return a == b;
  }
}
