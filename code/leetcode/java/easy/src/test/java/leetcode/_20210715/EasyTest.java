package leetcode._20210715;

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
    public void test1137() {

        int str = tribonacci(4);
        log.info("1137 tribonacci result: {}", str);
    }

    public int tribonacci(int n) {

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == 2) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }

        return dp[n];
    }

    @Test
    public void test509() {

        int str = dpFibV0(3);
        log.info("509 fib result: {}", str);
    }

    @Deprecated
    public int dpFibV0(int n) {

        int[] dp = new int[n+1];
        for (int i = 1; i < n; i++) {
            // i=0: fib(0)=0
            if (i == 1 || i == 2) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];
    }

    public int dpFib(int n) {

        if (n < 2) {
            return n;
        }

        int first, second = 0, third = 1;
        for (int i = 2; i <= n; i++) {
            first = second;
            second = third;
            third = first + second;
        }

        return third;
    }
}
