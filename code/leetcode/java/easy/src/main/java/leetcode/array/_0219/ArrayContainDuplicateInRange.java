package leetcode.array._0219;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * function: i和j的差的绝对值至多为 k, 且 nums[i]=nums[j] <br>
 * issue-link: https://github.com/Alice52/Algorithms/issues/38 <br>
 * leetcode-link: https://leetcode.com/problems/contains-duplicate-ii/ <br>
 *
 * @author zack <br>
 * @create 2021-02-25 10:30 <br>
 * @project leetcode <br>
 */
@Slf4j
public class ArrayContainDuplicateInRange {
    public static void main(String[] args) {
        Optional.of(duplicateJudgeIndexLessK(new int[] {1, 2, 3, 1}, 3))
                .ifPresent(System.out::println);
    }

    /**
     * 判断数组中是否存在两个不同的索引 i 和 j, 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k<br>
     * <br>
     * Core thinking:
     *
     * <pre>
     *    1. 两个相同元素下标差值小于等于 K 则返回 true
     * </pre>
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean duplicateJudgeIndexLessK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        Integer nearIndex;
        for (int i = 0; i < nums.length; i++) {
            nearIndex = map.get(nums[i]);
            if (nearIndex != null && i - nearIndex <= k) {
                return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }
}
