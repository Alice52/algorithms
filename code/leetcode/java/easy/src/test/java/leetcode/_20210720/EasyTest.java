package leetcode._20210720;

import lombok.extern.slf4j.Slf4j;
import model.leetcode.common.model.ListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zack <br>
 * @create 2021-07-14<br>
 * @project leetcode <br>
 */
@Slf4j
public class EasyTest {
    @Test
    public void test459() {
        repeatedSubstringPattern("abcabcabd");
    }

    public boolean repeatedSubstringPattern(String s) {

        // BF:
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = 1; j <= i; j++) {
                    int count = 1;
                    char temp = s.charAt(j - 1);
                    while (i * count + j - 1 < n) {
                        if (temp != s.charAt(i * count + j - 1)) {
                            match = false;
                            break;
                        }
                        count++;
                    }
                }

                if (match) {
                    return true;
                }
            }
        }

        return false;
    }

    @Test
    public void test234() {
        ListNode head = ListNode.generateNode(1, 2, 3, 1);
        ListNode palindrome = reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        // 1. dummy -> 1: 遍历插入 dummy.next
        // 2. satck
        // 3. 翻转指针: cur.next.next=cur || next[pre]
        // 4. 递归: 全局变量 || 翻转指针
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    @Test
    public void test746() {
        isIsomorphic("paper", "title");
    }

    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i);
            char ti = t.charAt(i);

            if (map.containsKey(si)) {
                if (map.get(si) == ti) {
                    return false;
                }
            } else {
                if (map.values().contains(ti)) {
                    return false;
                }
                map.put(si, ti);
            }
        }

        return false;
    }

    public int minCostClimbingStairs(int[] cost) {
        // [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] 2

        int length = cost.length;
        int[] dp = new int[length + 1];
        for (int i = 0; i <= length; i++) {
            if (i <= 1) {
                dp[i] = 0;
            } else {
                dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
            }
        }

        return dp[length];
    }
    /*
    // 0 1 2 3 4
    // 2,7,9,3,1
     选4
        f(2) + a(4)
     不选4
        f(3)

     f(n) = max(f(n-2) + a(n), f(n-1))

     */

    public int rob(int[] nums, int start, int end) {

        int[] dp = new int[end];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[end - 1];
    }
}
