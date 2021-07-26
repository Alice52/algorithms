package leetcode._20210718;

import lombok.extern.slf4j.Slf4j;
import model.leetcode.common.model.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author zack <br>
 * @create 2021-07-14<br>
 * @project leetcode <br>
 */
@Slf4j
public class EasyTest {

    @Test
    public void test08() {
        // merge(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3);
        // maxProfit(new int[]{4,5,3,16,4});

        titleToNumber("A");

    }

    public int titleToNumber(String columnTitle) {

        int mul = 1;
        int length = columnTitle.length();
        int result=0;
        for(int i=length-1; i>=0; i--) {
            int k = columnTitle.charAt(i) - 'A' +1;
            result += k*mul;
            mul*=26;
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
                dp[i] = Math.max( dp[i - 1] + prices[i] - prices[i - 1], 0);
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
