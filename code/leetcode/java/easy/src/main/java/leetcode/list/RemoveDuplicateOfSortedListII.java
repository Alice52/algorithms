package leetcode.list;

import lombok.extern.slf4j.Slf4j;
import model.leetcode.common.model.ListNode;

import java.util.Optional;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/20
 *
 * @author zack <br>
 * @create 2021-02-18 19:40 <br>
 * @project leetcode <br>
 */
@Slf4j
public class RemoveDuplicateOfSortedListII {
  public static void main(String[] args) {

    ListNode<Integer> node =
        new ListNode<>(
            1,
            new ListNode<>(
                2, new ListNode<>(2, new ListNode<>(3, new ListNode<>(3, new ListNode<>(3))))));

    Optional.ofNullable(deleteDuplicates(node)).ifPresent(x -> ListNode.print(x));
  }

  /**
   * Core thinking:
   *
   * <pre>
   *     1. first 指针指向第一个不重复的元素
   *     2. count 计不重复的值的下一个出现次数
   *        - 如果 count > 2 就放弃
   *        - 否则就
   * </pre>
   *
   * @param head
   * @return
   */
  public static ListNode<Integer> deleteDuplicates(ListNode<Integer> head) {
    if (head == null || head.nextNode == null) {
      return head;
    }



    return null;
  }
}
