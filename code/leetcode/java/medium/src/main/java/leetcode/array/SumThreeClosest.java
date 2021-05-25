package leetcode.array;

import java.util.Arrays;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/13
 *
 * @author zack <br>
 * @create 2021-02-14 18:05 <br>
 * @project leetcode <br>
 */
public class SumThreeClosest {

    /**
     * Timing: O(n^2)
     *
     * <pre>
     *   Core thinking:
     *      1. sort the nums
     *      2. two point to closest target
     *          - diff 计算存储当前指针的和与 target 差值的绝对值: 处理 lt&gt 问题
     *          - 移动双指针
     * </pre>
     *
     * @param target
     * @param nums
     * @return
     */
    public static int threeSumClosest(int target, int[] nums) {
        int size = nums.length;
        if (size < 2) {
            return 0;
        }

        int result = 0;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < size - 2; i++) {
            int j = i + 1, k = size - 1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                // this is handle gt and lt issue
                if (Math.abs(temp - target) < diff) {
                    result = temp;
                    diff = Math.abs(temp - target);
                }

                if (target == temp) {
                    return result;
                } else if (target > temp) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }
}
