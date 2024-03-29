package interview.list;

import lombok.extern.slf4j.Slf4j;
import model.leetcode.common.model.ListNode;

import java.util.Optional;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/10
 *
 * @author zack <br>
 * @create 2021-02-15 19:37 <br>
 * @project leetcode <br>
 */
@Slf4j
public class Circle {

    public static void main(String[] args) {

        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        ListNode<Integer> node4 = new ListNode<>(4);
        ListNode<Integer> node5 = new ListNode<>(5);
        ListNode<Integer> node6 = new ListNode<>(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node2;

        Optional.ofNullable(judgeCircle(node1)).ifPresent(System.out::println);

        Optional.ofNullable(getCircleNode(node1)).ifPresent(x -> log.info("{}", x.val));

        Optional.of(getCircleLength(node1)).ifPresent(System.out::println);
    }

    public static boolean judgeCircle(ListNode<Integer> node) {

        return Optional.ofNullable(meetPtrNode(node)).isPresent();
    }

    /**
     * 快慢指针都只想第一个元素, 快指针每次移动两个, 慢指针每次移动一个<br>
     * 快慢指针相遇则证明有相交的节点<br>
     * 快指针的下一个元素为 null 则没有环<br>
     *
     * @param node
     * @return
     */
    private static ListNode<Integer> meetPtrNode(ListNode<Integer> node) {

        // if node size is lt 2, it cannot contains circle

        ListNode<Integer> slow = node.next;
        ListNode<Integer> fast = node.next.next;

        while (slow != null && fast != null) {
            if (slow == fast) {
                return slow;
            }

            if (fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return null;
    }

    /**
     * 快慢指针相遇的时候, 让快指针指向第一个元素, 慢指针不懂, 每次快慢指针移动一个, 遭遇点为入口
     *
     * @param node
     * @return
     */
    public static ListNode getCircleNode(ListNode<Integer> node) {

        ListNode<Integer> slow = meetPtrNode(node);

        if (slow == null) {
            return null;
        }

        ListNode<Integer> fast = node;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    /**
     * 快慢指针相遇的时候, 停止快指针, 慢指针再次到这个位置时就是长度
     *
     * @param node
     * @return
     */
    public static int getCircleLength(ListNode<Integer> node) {
        ListNode meetPtrNode = meetPtrNode(node);

        if (meetPtrNode == null) {
            return 0;
        }

        ListNode<Integer> slow = meetPtrNode.next;

        int count = 1;
        while (slow != meetPtrNode) {
            count++;
            slow = slow.next;
        }

        return count;
    }
}
