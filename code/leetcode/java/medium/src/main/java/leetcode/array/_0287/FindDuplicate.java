package leetcode.array._0287;

import java.util.HashSet;
import java.util.OptionalInt;
import java.util.Set;

/**
 * function: 不修改数据的情况下, 找出重复元素. <br>
 * issue-link: https://github.com/Alice52/Algorithms/issues/40<br>
 * leetcode-link: https://leetcode-cn.com/problems/find-the-duplicate-number/<br>
 *
 * @author zack <br>
 * @create 2021-06-08 09:18 <br>
 * @project leetcode <br>
 */
public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 3, 2};
        OptionalInt.of(findDuplicateV4(nums)).ifPresent(System.out::println);
    }

    /**
     * 有6个数小于等同于5, 则重复的数一定在[1, 5]之间
     *
     * <pre>
     *   1. cnt 小于 middle 的数的个数
     *      - cnt > middle, 则重复的数字在 [left, middle] 之间
     *      - cnt <= middle, 则重复的数字在[middle+1, right] 之间
     * </pre>
     *
     * @param nums
     * @return
     */
    public static int findDuplicateV4(int[] nums) {
        int length = nums.length;
        // left = 1 是因为题目要求值不为 0
        int left = 1, right = length - 1;

        while (left < right) {
            int middle = (left + right) >> 1;
            // 小于 middle 的数的个数
            // cnt > middle, 则重复的数字在 [left, middle] 之间
            // cnt <= middle, 则重复的数字在 [middle+1, right] 之间
            int cnt = 0;
            for (int num : nums) {
                if (num <= middle) {
                    cnt += 1;
                }
            }

            if (cnt > middle) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    /**
     * 快慢指针:
     *
     * <pre>
     *     1. 题目中的值不为 0 很重要: 保证了首元素不在环内
     *         value 1   2   0  *  2
     *         index 0   1   2  3  4
     *         ---------------------- 此时 2 重复元素
     *     2. 快慢指针:
     *         - 快指针执行 2 步
     *         - 慢指针执行 1 步
     *     3. 移动的不是下标, 而是下标的值作为下标
     *         value 1   2   3  2
     *         index 0   1   2  3
     *         ---------------------- 此时 2 重复元素, 但是快指针只会出现在 1, 3
     *         ---------------------- 如果元素个数为偶数, 则快指针只能指到一般的元素
     *     4. 下标的值作为下标可以使得一定走进环
     *         - 直接使用下标做指针会跳出环
     *         - 使用值作为下标就可以不跳出环
     * </pre>
     *
     * @param nums
     * @return
     */
    public static int findDuplicateV3(int[] nums) {

        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    /**
     * 桶: 每个元素都是桶Id, 判断桶里有元素则重复
     *
     * @param nums
     * @return
     */
    public static int findDuplicateV2(int[] nums) {

        int[] bucket = new int[nums.length];
        for (int element : nums) {
            bucket[element]++;
            if (bucket[element] > 1) {
                return element;
            }
        }

        return -1;
    }

    /**
     * 使用 Hash 存储判断
     *
     * @param nums
     * @return
     */
    public static int findDuplicateV1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer element : nums) {
            if (set.contains(element)) {
                return element;
            }

            set.add(element);
        }

        return -1;
    }
}
