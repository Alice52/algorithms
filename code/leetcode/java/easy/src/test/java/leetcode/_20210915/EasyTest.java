package leetcode._20210915;

import lombok.extern.slf4j.Slf4j;
import model.leetcode.common.model.ListNode;
import org.junit.Test;

/**
 * @author zack <br>
 * @create 2021-08-15<br>
 * @project leetcode <br>
 */
@Slf4j
public class EasyTest {

    @Test
    public void test24() {

        ListNode<Integer> node = ListNode.generateNode(1, 2, 3, 4, 5, 6);
        swapPairs(node);
    }

    public ListNode swapPairs(ListNode head) {
        // base case 退出提交
        if (head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }

    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length - 1;

        while (c[left] == ' ') left++;
        while (c[right] == ' ') right--;

        StringBuilder str = new StringBuilder();
        while (left <= right) {
            int index = right;
            while (index >= left && c[index] != ' ') {
                index--;
            }
            for (int i = index + 1; i <= right; i++) {
                str.append(c[i]);
            }
            if (index > left) {
                str.append(' ');
            }
            while (index >= left && c[index] == ' ') {
                index--;
            }
            right = index;
        }
        return str.toString();
    }
}
