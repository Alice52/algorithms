package leetcode.list._0082;

import lombok.extern.slf4j.Slf4j;
import model.leetcode.common.model.ListNode;

import java.util.Optional;

/**
 * Function: 有序列表元素去重<br>
 * issue-link: https://github.com/Alice52/Algorithms/issues/20<br>
 * leetcode-link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/ <br>
 *
 * @author zack <br>
 * @create 2021-02-18 19:40 <br>
 * @project leetcode <br>
 */
@Slf4j
public class DeDuplicateSortedList {
    public static void main(String[] args) {

        ListNode node = ListNode.generateNode(0, 0, 0);
        Optional.ofNullable(deleteIfDuplicateBestPractice(node)).ifPresent(x -> ListNode.print(x));
    }

    /**
     * Core Thinking:
     *
     * <pre>
     *     1. finder 表示不重复的元素, 搞一个结果指针指向 finder
     *     2. 由于第一个元素就可能重复, 所以 finder 指针在 head 的前一位
     *     3. 遍历列表, 比较 head 和 head.next 值
     *          - 不同则说明 head 不重复[finder指针跟进一个]
     *          - 否则找到最后一个重复的元素
     *     4. 考虑最后一个元素重复问题
     * </pre>
     *
     * @param head
     * @return
     */
    public static ListNode deDuplicate(ListNode head) {
        if (head == null) {
            return null;
        }

        // 存放的时不同的元素
        ListNode finder = new ListNode();
        ListNode result = finder;
        finder.next = head;
        while (head != null) {
            if (head.next != null && head.next.val.equals(head.val)) {
                while (head.next != null && head.next.val.equals(head.val)) {
                    // 得到最后一个相同的元素
                    head = head.next;
                }
            } else {
                finder.next = head;
                finder = finder.next;
            }

            if (head.next == null) {
                finder.next = null;
            }

            head = head.next;
        }

        return result.next;
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

        finder.next = head;
        while (head != null) {
            if (head.next != null && head.val.equals(head.next.val)) {
                while (head.next != null && head.val.equals(head.next.val)) {
                    head = head.next;
                }

                finder.next = head.next;
            } else {
                finder = finder.next;
            }

            head = head.next;
        }

        return first.next;
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
    @Deprecated
    public static ListNode<Integer> deleteIfDuplicate(ListNode<Integer> head) {
        // 1. head 长度小于 2 时, 直接返回
        if (head == null || head.next == null) {
            return head;
        }

        boolean repeated = false;
        ListNode<Integer> first = null, finder = head;
        while (finder.next != null) {
            // 2. 如果 finder 和 finder.next相同, 则删除 finder.next
            if (finder.val.equals(finder.next.val)) {
                finder.next = finder.next.next;
                repeated = true;
                continue;
            }

            // 3. 确定 first 位置: 如果不重复且 first 是 null, 则 first 指针指向 finder;
            // 使得 head 节点落后于 finder 节点一位
            if (!repeated && first == null) {
                first = finder;
                head = finder;
                finder = finder.next;
                continue;
            }

            if (repeated) {
                // 4. 如果有重复则删除 finder
                head.next = finder.next;
                finder = head.next;
            } else {
                // 5. 不重复则说明 finder 是不重复元素, 移动 finder 到下一位, 且注意同步移动 head
                // 使得 head 应用处于 finder 的上一位置: 为了删除 finder 节点本身
                finder = finder.next;
                head = head.next;
            }
            repeated = false;
        }

        // 6. 处理尾节点问题:
        //    - 如果重复则最后一个元素就舍弃,
        //    - 如果不重复且 first 为 null 则将 first 指向 finder
        if (repeated) {
            head.next = null;
        } else if (first == null) {
            first = finder;
        }

        return first;
    }
}
