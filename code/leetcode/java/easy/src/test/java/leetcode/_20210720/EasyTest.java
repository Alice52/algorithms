package leetcode._20210720;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zack <br>
 * @create 2021-07-14<br>
 * @project leetcode <br>
 */
@Slf4j
public class EasyTest {

    @Test
    public void test746() {
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
        dp[start+1] = Math.max(nums[start], nums[start+1]);
        for(int i=start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[end-1];
    }
}
