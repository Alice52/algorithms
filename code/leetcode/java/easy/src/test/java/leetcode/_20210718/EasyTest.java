package leetcode._20210718;

import lombok.extern.slf4j.Slf4j;
import model.leetcode.common.model.ListNode;
import model.leetcode.common.model.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author zack <br>
 * @create 2021-07-14<br>
 * @project leetcode <br>
 */
@Slf4j
public class EasyTest {

    @Test
    public void test() {
        int maxValue = Integer.MAX_VALUE;
        long maxValue1 = Long.MAX_VALUE;

        log.info(maxValue + "");
        log.info(maxValue1 + "");
        long t = 2147483645L * 2147483645L;
        log.info(t + "");
    }

    @Test
    public void test367() {
        // 819
        isPerfectSquare(2147483645);
    }

    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        long left = 2, right = num / 2, mid;
        long guessSquared;
        while (left <= right) {
            mid = left + (right - left) / 2;
            guessSquared = mid * mid;

            if (guessSquared == num) {
                return true;
            }
            if (guessSquared > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    @Test
    public void test1089() {
        duplicateZeros(new int[] {1, 0, 2, 3, 0, 4, 5, 0});
    }

    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int i = 0, j = 0;
        for (; j < len; i++, j++) {
            if (arr[i] == 0) {
                j++;
            }
        }

        i--;
        j--;

        if (j > len - 1) { // 同解法二，特判
            arr[--j] = arr[i--];
            j--;
        }

        while (j > i) {
            if (arr[i] == 0) arr[j--] = arr[i];
            arr[j--] = arr[i--];
        }
    }

    @Test
    public void test338() {
        countBits(2);
    }

    public int[] countBits(int n) {

        // n&(n-1)
        // n&1
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = count(i);
        }

        return arr;
    }

    private int count(int n) {
        int counter = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                counter++;
            }

            n >>= 1;
        }

        return counter;
    }

    @Test
    public void test290() {
        wordPattern("abba", "dog cat cat dog");
    }

    public boolean wordPattern(String pattern, String s) {

        String[] s1 = s.split(" ");
        if (s1.length != pattern.length()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        char key;
        String realVal;
        for (int i = 0; i < pattern.length(); i++) {
            key = pattern.charAt(i);
            realVal = s1[i];
            String val = map.get(key);
            if (val == null) {
                if (map.containsValue(realVal)) {
                    return false;
                }
                map.put(key, realVal);
            } else if (!realVal.equals(val)) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test387() {
        firstUniqChar("abz");
    }

    @Test
    public void test08() {
        ListNode listNode = reverseList(ListNode.generateNode(1, 2, 3)); // 2 3 5 7
    }

    public ListNode reverseList(ListNode head) {

        // iter:
        //          1 -> 2 -> 3 -> null
        //  null <- 1 <- 2 <- 3

        // stack: N/A

        // 递归: 1 2 3
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public int firstUniqChar(String s) {
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (table[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            map.compute(s.charAt(i), (k, v) -> v == null ? 1 : v++);
        }

        for (int i = 0; i < t.length(); i++) {
            map.compute(s.charAt(i), (k, v) -> --v);
            if (map.getOrDefault(t.charAt(i), -1) < 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isHappy(int n) {

        // s-q point
        int slow = (n);
        int quick = (n);
        do {
            slow = getNext(slow);
            quick = getNext(getNext(quick));
        } while (slow != quick);

        return quick == 1;
    }

    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

    public int getNext(int n) {

        if (n >= Integer.MAX_VALUE) {
            return 0;
        }

        int res = 0;
        while (n > 0) {
            res += (n % 10) * (n % 10);
            n = n / 10;
        }

        return res;
    }

    public int reverseBits(int n) {
        if (n == 0) {
            return 0;
        }

        int rev = 0;
        for (int i = 0; i < 32; i++) {
            rev = (rev << 1) | n;
            n >>= 1;
        }

        return rev;
    }

    public int[] twoSum(int[] numbers, int target) {

        int pair;
        int first = 0;
        int second = numbers.length - 1;
        while (first < second) {
            pair = numbers[first] + numbers[second];
            if (pair == target) {
                return new int[] {first + 1, second + 1};
            }

            if (pair > target) {
                second--;
            } else {
                first++;
            }
        }

        return null;
    }

    public int titleToNumber(String columnTitle) {

        int mul = 1;
        int length = columnTitle.length();
        int result = 0;
        for (int i = length - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            result += k * mul;
            mul *= 26;
        }

        return result;
    }

    public int maxProfit(int[] prices) {

        // f(n) = f(n-1) + a(n) - a(n-1)

        int length = prices.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                dp[i] = 0;
            } else if (i == 1) {
                dp[i] = prices[1] > prices[0] ? prices[1] - prices[0] : 0;
            } else {
                dp[i] = Math.max(dp[i - 1] + prices[i] - prices[i - 1], 0);
            }
        }

        Arrays.sort(dp);

        System.out.println(dp);
        // [2,1,2,1,0,1,2]
        //  0 0 1 0 0 1 2

        return dp[length - 1];
    }

    public List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList(rowIndex + 1);
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0);
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode pop = stack.pop();
            list.add(pop.val);
            root = pop.right;
        }

        return list;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    @Test
    public void test088() {
        // merge(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3);
        merge(new int[] {4, 0, 0, 0, 0, 0}, 1, new int[] {1, 2, 3, 5, 6}, 5);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1;
        int t = m + n - 1;
        int val;

        while (i >= 0 || j >= 0) {

            if (i == -1) {
                val = nums2[j--];
            } else if (j == -1) {
                val = nums1[i--];
            } else if (nums1[i] > nums2[j]) {
                val = nums1[i--];
            } else {
                val = nums2[j--];
            }

            nums1[t--] = val;
        }
    }

    @Deprecated
    public void mergeV0(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }

        int i = 0, j = 0, len = m + n;
        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                System.arraycopy(nums1, i, nums1, i + 1, len - i - 1);
                nums1[i] = nums2[j++];
                m++;
                i++;
            } else {
                i++;
            }
        }

        if (i == m && j < n) {
            System.arraycopy(nums2, j, nums1, len - n + j, n - j);
        }

        log.info("{}", nums1);
    }
}
