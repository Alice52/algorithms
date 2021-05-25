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
            Optional.ofNullable(listNode.val).ifPresent(System.out::println);
            listNode = listNode.next;
        }
    }

    public static void flipByRecursion(ListNode<Integer> node) {
        if (node.next != null) {
            flipByRecursion(node.next);
        }
        log.info("{}", node.val);
    }

    public static void flipByStack(ListNode<Integer> node) {

        Stack<Integer> stack = new Stack<>();
        while (node.next != null) {
            stack.push(node.val);
            node = node.next;
        }
        stack.push(node.val);

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
        next = node.next;
        pre = node;
        pre.next = null;

        while (next != null) {
            ListNode temp = next.next;
            next.next = pre;
            pre = next;

            next = temp;
        }

        return pre;
    }

    public static ListNode<Integer> flipNodeV2(ListNode<Integer> node) {

        ListNode<Integer> cur = node;
        ListNode<Integer> pre = null;

        while (cur != null) {
            ListNode<Integer> temp = cur.next;
            cur.next = pre;
            pre = cur;

            cur = temp;
        }

        return pre;
    }
}
