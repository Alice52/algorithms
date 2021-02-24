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
public class RemoveDuplicateOfSortedList {
  public static void main(String[] args) {

    ListNode<Integer> node =
        new ListNode<>(
            0,
            new ListNode<>(
                1, new ListNode<>(3, new ListNode<>(3, new ListNode<>(3, new ListNode<>(4))))));

    Optional.ofNullable(deleteIfDuplicateBestPractice(node)).ifPresent(x -> ListNode.print(x));
  }

  /**
   * Core thinking:
   *
   * <pre>
   *     1. 遍历 head: 创建一个新节点 finder [next 指向 head]
   *        - 比较 next 和 next.next 的值,
   *        - 值相同则找到最后一个相同元素后, 将 finder.next 指向最后一个相同的 next
   *        - 值不同则移动 finder 到下一位[finder.next这个值是唯一的]
   *     2. next 与 next.next 比较时, 可以考虑转换为创建一个新的节点 A: A.next 指向 next
   * </pre>
   *
   * @param head origin node
   * @return de-duplicate node
   */
  public static ListNode<Integer> deleteIfDuplicateBestPractice(ListNode<Integer> head) {

    ListNode first = new ListNode();
    ListNode finder = first;

    finder.nextNode = head;
    while (head != null) {
      if (head.nextNode != null && head.value.equals(head.nextNode.value)) {
        while (head.nextNode != null && head.value.equals(head.nextNode.value)) {
          head = head.nextNode;
        }

        finder.nextNode = head.nextNode;
      } else {
        finder = finder.nextNode;
      }

      head = head.nextNode;
    }

    return first.nextNode;
  }

  /**
   * Core thinking:
   *
   * <pre>
   *     1. head 长度小于 2 时, 直接返回
   *     2. 遍历 node
   *        - 如果 finder 和 finder.next相同, 则删除 finder.next
   *        - 否则先确定 first 位置: 如果不重复且 first 是 null, 则 first 指针指向 finder[使得 head 节点落后于 finder 节点一位];
   *        - 否则再如果有重复标识则删除 finder, 无重复标识则移动 finder, head 到下一位
   *     3. 处理尾节点问题
   *        - 如果有重复标识则最后一个元素就舍弃
   *        - 如果无重复标识且 first 为 null 则将 first 指向 finder
   * </pre>
   *
   * @param head
   * @return
   */
  public static ListNode<Integer> deleteIfDuplicate(ListNode<Integer> head) {
    // 1. head 长度小于 2 时, 直接返回
    if (head == null || head.nextNode == null) {
      return head;
    }

    boolean repeated = false;
    ListNode<Integer> first = null, finder = head;
    while (finder.nextNode != null) {
      // 2. 如果 finder 和 finder.next相同, 则删除 finder.next
      if (finder.value.equals(finder.nextNode.value)) {
        finder.nextNode = finder.nextNode.nextNode;
        repeated = true;
        continue;
      }

      // 3. 确定 first 位置: 如果不重复且 first 是 null, 则 first 指针指向 finder;
      // 使得 head 节点落后于 finder 节点一位
      if (!repeated && first == null) {
        first = finder;
        head = finder;
        finder = finder.nextNode;
        continue;
      }

      if (repeated) {
        // 4. 如果有重复则删除 finder
        head.nextNode = finder.nextNode;
        finder = head.nextNode;
      } else {
        // 5. 不重复则说明 finder 是不重复元素, 移动 finder 到下一位, 且注意同步移动 head
        // 使得 head 应用处于 finder 的上一位置: 为了删除 finder 节点本身
        finder = finder.nextNode;
        head = head.nextNode;
      }
      repeated = false;
    }

    // 6. 处理尾节点问题:
    //    - 如果重复则最后一个元素就舍弃,
    //    - 如果不重复且 first 为 null 则将 first 指向 finder
    if (repeated) {
      head.nextNode = null;
    } else if (first == null) {
      first = finder;
    }

    return first;
  }
}
