package leetcode.list._0083;

import lombok.extern.slf4j.Slf4j;
import model.leetcode.common.model.ListNode;

import java.util.Optional;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/21<br>
 * leetcode-link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/ <br>
 *
 * @author zack <br>
 * @create 2021-02-18 19:40 <br>
 * @project leetcode <br>
 */
@Slf4j
public class DeDuplicateSortedListCount {
    public static void main(String[] args) {

        ListNode node = ListNode.generateNode(1, 2, 2, 3);
        Optional.ofNullable(deleteDuplicates(node)).ifPresent(ListNode::print);
    }

    /**
     * function: 保留一个相同元素的列表去重<br>
     * Core thinking:
     *
     * <pre>
     *     1. two point method, finder 是不同的元素
     *     2. 遍历 node, head = head.next
     *        - 如果 finder 值不等于 head 的值, 则 finder 移动一位
     *        - 否则要处理链表最后一个元素相同的问题, finder.next = head.next
     * </pre>
     *
     * @param head
     * @return
     */
    public static ListNode<Integer> deleteDuplicates(ListNode<Integer> head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode finder = head;
        ListNode first = finder;
        head = head.next;
        while (head != null) {
            if (!finder.val.equals(head.val)) {
                finder.next = head;
                finder = finder.next;
            }
            head = head.next;

            // 链表最后一个元素相同的问题
            if (head == null) {
                finder.next = null;
            }
        }

        return first;
    }
}
