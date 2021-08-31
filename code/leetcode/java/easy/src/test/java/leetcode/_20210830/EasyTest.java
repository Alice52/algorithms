package leetcode._20210830;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * @author zack <br>
 * @create 2021-08-15<br>
 * @project leetcode <br>
 */
@Slf4j
public class EasyTest {

    @Test
    public void test1011() {

        shipWithinDays(new int[] {3, 2, 2, 4, 1, 4}, 3);
    }

    public int shipWithinDays(int[] weights, int days) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < weights.length; i++) {
            if (max < weights[i]) {
                max = weights[i];
            }
        }

        int left = max, right = 50000;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (days(weights, mid) <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int days(int[] weights, int speed) {

        int day = 0;
        int tmp = 0;
        for (int i = 0; i < weights.length; i++) {
            tmp = tmp + weights[i];
            if (tmp > speed) {
                i = i - 1;
                day++;
                tmp = 0;
            }
        }

        if (tmp != 0) {
            day++;
        }

        System.out.println("speed: " + speed + " day: " + day);
        return day;
    }

    // dp[i][j]
    // \  0   1   2   3   4   5   6   7     j
    // 0  2
    // 1  5   6
    // 2  11 10  13
    // 3  15 11  18 16
    // 4
    // 5
    // 6
    // 7

    // f(i)(j) = Math.min{f(i-1)(j), f(i-1)(j-1)} + num[i]

    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[][] dp = new int[length][length];

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < length; i++) {
            List<Integer> rows = triangle.get(i);
            dp[i][0] = dp[i - 1][0] + rows.get(0);
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    dp[i][j] = dp[i - 1][j - 1] + rows.get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + rows.get(j);
                }
            }
        }

        int[] resArr = dp[length - 1];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < resArr.length; i++) {
            if (res > resArr[i]) {
                res = resArr[i];
            }
        }

        return res;
    }

    @Test
    public void test1094() {

        int[] diff = {-2, 2, 3, 2, -2};
        int[] res = new int[diff.length];
        // 根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int length = trips.length;
        int[] diff = new int[1000];
        int[] tmp;
        for (int i = 0; i < length; i++) {
            tmp = trips[i];
            diff[tmp[1]] += tmp[0];
            if (tmp[2] + 1 < length) {
                diff[tmp[2] + 1] -= tmp[0];
            }
        }

        int[] res = new int[diff.length];
        int val = diff[0];
        if (val > capacity) {
            return false;
        }

        for (int i = 1; i < diff.length; i++) {
            val += diff[i];
            if (val > capacity) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test370() {

        int[] diff = {-2, 2, 3, 2, -2};
        int[] res = new int[diff.length];
        // 根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
    }

    class Difference {
        // 差分数组
        private int[] diff;

        public Difference(int[] nums) {
            assert nums.length > 0;
            diff = new int[nums.length];
            // 构造差分数组
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        /* 给闭区间 [i,j] 增加 val 或减少 val（val 是负数） */
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            // 根据差分数组构造结果数组
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}
