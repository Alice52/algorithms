package model.leetcode.common.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zack <br>
 * @create 2021-02-06 22:02 <br>
 * @project leetcode <br>
 */
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class ListNode<T> {
  public T value;
  public ListNode<T> nextNode;

  public ListNode(T value) {
    this.value = value;
  }

  public static void createCircleNode(ListNode head, ListNode dummyNode, int num) {

    for (int i = 1; i <= num; i++) {
      ListNode node = new ListNode(i);
      dummyNode.nextNode = node;
      dummyNode = node;
    }
    dummyNode.nextNode = head.nextNode;
  }

  public static void print(ListNode<Integer> node) {
    while (node != null) {
      log.info("{}", node.value);
      node = node.nextNode;
    }
  }
}
