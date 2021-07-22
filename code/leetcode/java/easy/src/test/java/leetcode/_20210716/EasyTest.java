package leetcode._20210716;

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
    public void test069() {

        int str = mySqrt(2147395599);
        log.info("069 mySqrt result: {}", str);
    }

    public int mySqrt(int x) {

        int left = 0;
        int right = x;
        int middle;
        while (left <= right) {
            middle = (right - left) / 2 + left;
            if ((long) middle * middle  <= x) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left - 1;
    }
}
