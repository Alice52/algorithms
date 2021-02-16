package interview.list;

import lombok.extern.slf4j.Slf4j;
import model.leetcode.common.model.ListNode;

import java.util.Optional;
import java.util.Stack;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/11
 *
 * @author zack <br>
 * @create 2021-02-15 19:38 <br>
 * @project leetcode <br>
 */
@Slf4j
public class Flip {

  public static void main(String[] args) {
    ListNode<Integer> node = new ListNode<>(2, new ListNode<>(4, new ListNode<>(3)));

    flipByRecursion(node);
    flipByStack(node);

    ListNode<Integer> listNode = flipNodeV2(node);
    while (listNode != null) {
      Optional.ofNullable(listNode.value).ifPresent(System.out::println);
      listNode = listNode.nextNode;
    }
  }

  public static void flipByRecursion(ListNode<Integer> node) {
    if (node.nextNode != null) {
      flipByRecursion(node.nextNode);
    }
    log.info("{}", node.value);
  }

  public static void flipByStack(ListNode<Integer> node) {

    Stack<Integer> stack = new Stack<>();
    while (node.nextNode != null) {
      stack.push(node.value);
      node = node.nextNode;
    }
    stack.push(node.value);

    while (!stack.empty()) {
      log.info("{}", stack.pop());
    }
  }

  /**
   * flip node: A -> B -> C -> D <br>
   *
   * <pre>
   *    step:
   *      1. A -> null
   *      2. [next]B -> [pre]A -> null
   *      3. C -> B -> A -> null
   *      4. D -> C -> B -> A -> null
   * </pre>
   *
   * @param node
   */
  public static ListNode<Integer> flipNode(ListNode<Integer> node) {
    ListNode<Integer> pre, next;
    next = node.nextNode;
    pre = node;
    pre.nextNode = null;

    while (next != null) {
      ListNode temp = next.nextNode;
      next.nextNode = pre;
      pre = next;

      next = temp;
    }

    return pre;
  }

  public static ListNode<Integer> flipNodeV2(ListNode<Integer> node) {

    ListNode<Integer> cur = node;
    ListNode<Integer> pre = null;

    while (cur != null) {
      ListNode<Integer> temp = cur.nextNode;
      cur.nextNode = pre;
      pre = cur;

      cur = temp;
    }

    return pre;
  }
}
