package leetcode.array._0026;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * function: 删除无序数组内所有的重复元素<br>
 * issue-link: https://github.com/Alice52/Algorithms/issues/73 <br>
 *
 * @author zack <br>
 * @create 2021-05-26 09:01 <br>
 * @project leetcode <br>
 */
public class DeDuplicateAllSortedArray {

    public static void main(String[] args) {
        OptionalInt.of(deDuplicate(new int[] {1, 2, 3, 2, 4, 5, 7})).ifPresent(System.out::println);
    }

    /**
     * Core Thinking:
     *
     * <pre>
     *     1. 排序
     *     2. 由于首个元素可能重复, 所以 finder 指针初始化为首元素的前一个
     *     3. 比较 i 和 i-1 是否相同
     *         - 不同这证明 i 没有重复
     *         - 否则找到重复元素的下一个元素[本质是下下个元素]
     *     4. 处理尾元素相同的问题.
     *
     *     1. 和前一个不同, 且和后一个不同就是唯一的元素
     *     2. 考虑首尾元素的问题
     * </pre>
     *
     * @param nums
     * @return
     */
    public static int deDuplicateAll(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length;
        if (length < 2) {
            return length;
        }

        int finder = -1;
        for (int i = 1; i < length; i++) {
            if (nums[i - 1] == nums[i]) {
                while (i < length && nums[i - 1] == nums[i]) {
                    i++;
                }
            } else {
                // i-1 位置不重复
                nums[++finder] = nums[i - 1];
            }
        }

        if (nums[length - 1] != nums[length - 2]) {
            nums[++finder] = nums[length - 1];
        }

        IntStream.of(nums).forEach(System.out::println);
        return finder + 1;
    }

    public static int deDuplicate(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length;
        if (length < 2) {
            return length;
        }

        // head
        int finder = -1;
        if (nums[0] != nums[1]) {
            finder++;
        }

        for (int i = 1; i < length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                nums[++finder] = nums[i];
            }
        }

        // tail
        if (nums[length - 1] != nums[length - 2]) {
            nums[++finder] = nums[length - 1];
        }

        IntStream.of(nums).forEach(System.out::println);

        return finder + 1;
    }
}
