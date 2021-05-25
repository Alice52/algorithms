package leetcode.array._0217;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

/**
 * function: 数组内是否有重复元素<br>
 * issue-link: https://github.com/Alice52/Algorithms/issues/37<br>
 * leetcode-link: https://leetcode.com/problems/contains-duplicate/<br>
 *
 * @author zack <br>
 * @create 2021-02-25 09:29 <br>
 * @project java <br>
 */
@Slf4j
public class ArrayContainsDuplicate {

    public static void main(String[] args) {
        Optional.of(judgeDuplicateBest(new int[] {1, 2, 3, 1})).ifPresent(System.out::println);
    }

    /**
     * Core thinking:
     *
     * <pre>
     *     1. 不引进其他的数据结构: 需要 sorted array
     *     2. 遍历数组, num[i] == num[i+1] 则返回 true
     * </pre>
     *
     * @param nums
     * @return
     */
    public static boolean judgeDuplicateBest(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Core thinking:
     *
     * <pre>
     *      1. 遍历数组, 将值放入 hash, 放入之前判断是否存在
     *      2. 已存在就返回 true, 否则就继续遍历
     *  </pre>
     *
     * @param nums
     * @return
     */
    @Deprecated
    public static boolean judgeDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
