package leetcode.list;

import lombok.extern.slf4j.Slf4j;
import model.leetcode.common.model.ListNode;

import java.util.Optional;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/33
 *
 * @author zack <br>
 * @create 2021-02-16 22:36 <br>
 * @project leetcode <br>
 */
@Slf4j
public class Intersection {

  public static void main(String[] args) {

    ListNode<Integer> nodeA = new ListNode<>(1);
    ListNode<Integer> nodeA2 = new ListNode<>(2);
    ListNode<Integer> nodeA3 = new ListNode<>(3);
    ListNode<Integer> nodeA4 = new ListNode<>(4);
    ListNode<Integer> nodeA5 = new ListNode<>(5);

    ListNode<Integer> nodeB = new ListNode<>(11);
    ListNode<Integer> nodeB2 = new ListNode<>(12);

    nodeA.nextNode = nodeA2;
    nodeA2.nextNode = nodeA3;
    nodeA3.nextNode = nodeA4;
    nodeA4.nextNode = nodeA5;

    nodeB.nextNode = nodeB2;
    nodeB2.nextNode = null;

    Optional.ofNullable(getIntersectionNode(nodeA, nodeB)).ifPresent(x -> log.info("{}", x.value));
  }

  /**
   * 1. hash<br>
   * 2. two point:
   *
   * <pre>
   *    1. 最后一个节点也要参与计算
   *    2. 所以是 pa == null - 而不是 pa.next == null
   *  </pre>
   *
   * <pre>
   *    1. condition
   *      - the two list have no circle
   * </pre>
   *
   * @param headA
   * @param headB
   * @return
   */
  public static ListNode getIntersectionNode(ListNode<Integer> headA, ListNode<Integer> headB) {

    ListNode pa = headA, pb = headB;
    while (pa != pb) {
      pa = (pa == null) ? headB : pa.nextNode;
      pb = (pb == null) ? headA : pb.nextNode;
    }

    return pa;
  }
}
