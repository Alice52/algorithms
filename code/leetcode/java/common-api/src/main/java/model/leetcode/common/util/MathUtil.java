package model.leetcode.common.util;

import java.util.Arrays;

/**
 * @author zack <br>
 * @create 2021-07-14<br>
 * @project leetcode <br>
 */
public final class MathUtil {
    public static int max(int[] nums) {
        // sort then take
        Arrays.sort(nums);

        return nums[nums.length - 1];
    }
}
