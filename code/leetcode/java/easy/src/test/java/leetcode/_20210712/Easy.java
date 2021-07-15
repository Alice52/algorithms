package leetcode._20210712;

import lombok.SneakyThrows;
import model.leetcode.common.model.ListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @author asd <br>
 * @create 2021-07-12 1:26 PM <br>
 * @project leetcode <br>
 */
public class Easy {

    @Test
    public void testCombineSortedList() {

        ListNode l1 = ListNode.generateNode(1, 2, 4);
        ListNode l2 = ListNode.generateNode(1, 3, 4);

        ListNode listNode = mergeTwoLists(l1, l2);

        ListNode.print(listNode);
    }

    public ListNode<Integer> mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode<Integer> dummy = new ListNode<>(-1);
        ListNode<Integer> result = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }

            dummy = dummy.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        dummy.next = l1 == null ? l2 : l1;

        return result.next;
    }

    static final Map<Character, Character> pairs =
            new HashMap<Character, Character>() {
                {
                    put(')', '(');
                    put('}', '{');
                    put(']', '[');
                }
            };

    public static boolean isValid(String s) {
        int length = s.length();
        if (s.isEmpty() || length <= 1 || length % 2 == 1) {
            return false;
        }

        LinkedList<Character> list = new LinkedList<>();
        char c;
        for (int i = 0; i < length; i++) {
            c = s.charAt(i);
            if (pairs.containsKey(c)) {
                if (list.isEmpty() || !list.peekLast().equals(pairs.get(c))) {
                    return false;
                }
                list.removeLast();
            } else {
                list.addLast(c);
            }
        }

        return list.size() == 0;
    }

    static final Map<Character, Character> map_2 =
            new HashMap<Character, Character>() {
                {
                    put('(', ')');
                    put('{', '}');
                    put('[', ']');
                }
            };

    public static boolean isValidV1(String s) {
        int length = s.length();
        if (s.isEmpty() || length <= 1 || length % 2 == 1) {
            return false;
        }

        //  stack
        Stack<Character> stack = new Stack<Character>();
        char c = s.charAt(0);
        stack.push(c);
        for (int i = 1; i < length; i++) {
            c = s.charAt(i);
            if (stack.size() != 0 && c == map_2.getOrDefault(stack.peek(), '0')) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size() == 0;
    }

    public String longestCommonPrefix(String[] strs) {

        int min = Integer.MAX_VALUE;
        int tmp = 0;
        for (String str : strs) {
            tmp = str.length();
            if (min > tmp) {
                min = tmp;
            }
        }

        String first = strs[0];
        int count = strs.length;
        for (int i = 0; i < min; i++) {
            char c = first.charAt(i);
            for (int j = 1; j < count; j++) {
                if (strs[j].charAt(i) != c) {
                    return first.substring(0, i);
                }
            }
        }

        return first;
    }

    static final Map<Character, Integer> map =
            new HashMap<Character, Integer>() {
                {
                    put('I', 1);
                    put('V', 5);
                    put('X', 10);
                    put('L', 50);
                    put('C', 100);
                    put('D', 500);
                    put('M', 1000);
                }
            };

    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            Integer integer = map.get(s.charAt(i));
            if (integer < map.get(s.charAt(i + 1))) {
                res -= integer;
            } else {
                res += integer;
            }
        }

        res += map.get(s.charAt(s.length() - 1));

        return res;
    }

    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        return x == reverse(x);
    }

    private static int reverse4Palindrome(int x) {

        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        return x;
    }

    public static int reverse(int x) {

        int res = 0;
        while (x != 0) {
            if (x < Integer.MIN_VALUE / 10 || x > Integer.MAX_VALUE / 10) {
                return 0;
            }

            res = res * 10 + x % 10;
            x = x / 10;
        }

        return x;
    }

    @SneakyThrows
    public static void main(String[] args) {
        boolean valid = isValid("([])");
        System.out.println(valid);
    }
}
