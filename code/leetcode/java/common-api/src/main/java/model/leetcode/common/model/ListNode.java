package model.leetcode.common.model;

import cn.hutool.core.util.ObjectUtil;
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
    public T val;
    public ListNode<T> next;

    public ListNode(T value) {
        this.val = value;
    }

    public static <T> ListNode<T> generateNode(T... args) {

        ListNode<T> dummy = new ListNode();
        if(ObjectUtil.isNull(args) || args.length ==0) {
            return dummy;
        }

        ListNode<T> head = dummy;
        for (T arg : args) {
            ListNode<T> node = new ListNode(arg);
            dummy.next = node;
            dummy = node;
        }

        return head.next;
    }

    public static <T> void generateCircleNode(ListNode<T> head, ListNode<T> dummyNode, int num) {

        for (int i = 1; i <= num; i++) {
            ListNode node = new ListNode(i);
            dummyNode.next = node;
            dummyNode = node;
        }
        dummyNode.next = head.next;
    }

    public static <T> void print(ListNode<T> node) {
        while (node != null) {
            log.info("{}", node.val);
            node = node.next;
        }
    }
}
