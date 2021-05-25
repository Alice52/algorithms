package leetcode.array._0080;

import leetcode.array._0026.DeDuplicateSortedArray;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * function: 有序数组去重，保留 2 个 <br>
 * issue-link: https://github.com/Alice52/Algorithms/issues/19 <br>
 * leetcode-link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/ <br>
 *
 * @author zack <br>
 * @create 2021-02-18 20:10 <br>
 * @project leetcode <br>
 */
@Slf4j
public class DeDuplicateSortedArrayCount {

    public static void main(String[] args) {
        OptionalInt.of(removeDuplicate(new int[] {0, 0, 1, 1, 1, 2, 3, 3}, 2))
                .ifPresent(System.out::println);
    }

    /**
     * Core Thinking: <br>
     *
     * <pre>
     *        1. 与 {@link DeDuplicateSortedArray#removeDuplicate(int[])} 一样的思路, <br>
     *        2. 只是新增一个 count 变量记录 finder 下标值的次数: count <= 2 时则 finder 正常移动[即使元素相同]
     *
     *        1. 双指针[一个指向不同的元素 + 一个遍历] + 出现次数
     *        2. 双指针值不同则覆盖且 count 置位 1, 否则 count++ 且 count 小于等于指定次数也覆盖
     *     </pre>
     *
     * @param nums
     * @param repeatedCount
     * @return
     */
    public static int removeDuplicate(int[] nums, int repeatedCount) {

        if (nums.length <= repeatedCount) {
            return nums.length;
        }

        int counter = 1;
        int finder = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[finder] != nums[i]) {
                nums[++finder] = nums[i];
                counter = 1;
                continue;
            }

            counter++;
            if (counter <= repeatedCount) {
                nums[++finder] = nums[i];
            }
        }

        Arrays.stream(nums).forEach(System.out::println);

        return finder + 1;
    }

    @Deprecated
    public static int removeDuplicateV1(int[] nums, int repeatedCount) {

        if (nums.length <= repeatedCount) {
            return nums.length;
        }

        int counter = 1;
        int finder = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[finder] && counter >= repeatedCount) {
                continue;
            }

            if (nums[i] != nums[finder]) {
                counter = 0;
            }

            counter++;
            nums[++finder] = nums[i];
        }

        Arrays.stream(nums).forEach(System.out::println);

        return finder + 1;
    }
}
