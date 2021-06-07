package leetcode.array._0220;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;

/**
 * function: abs(nums[i] - nums[j]) <= t and abs(i - j) <= k. <br>
 * issue-link: https://github.com/Alice52/Algorithms/issues/39<br>
 * leetcode-link: https://leetcode.com/problems/contains-duplicate-iii/<br>
 *
 * @author zack <br>
 * @create 2021-05-27 17:38 <br>
 * @project leetcode <br>
 */
@Slf4j
public class DuplicateContainsNearby {

    public static void main(String[] args) {
        Optional.of(containsNearbyAlmostDuplicateV2(new int[] {-2147483648, 2147483647}, 1, 1))
                .ifPresent(System.out::println);
    }

    /**
     * Core Thinking: 桶
     *
     * <pre>
     *      1. 明确桶的编号划分: t + 1 做桶宽
     *  </pre>
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicateV2(int[] nums, int k, int t) {
        int length = nums.length;
        Map<Integer, Long> bucket = new HashMap<>(length / (t + 1));
        for (int i = 0; i < length; i++) {

            int bucketId = getBucketId(nums[i], t + 1);
            if (bucket.get(bucketId) != null) {
                return true;
            }

            if (bucket.get(bucketId - 1) != null
                    && Math.abs(nums[i] - bucket.get(bucketId - 1)) <= t) {
                return true;
            }

            if (bucket.get(bucketId + 1) != null
                    && Math.abs(nums[i] - bucket.get(bucketId + 1)) <= t) {
                return true;
            }

            bucket.put(bucketId, (long) nums[i]);
            if (i >= k) {
                bucket.remove(getBucketId(nums[i - k], t + 1));
            }
        }

        return false;
    }

    /**
     * 计算桶的编号
     *
     * <pre>
     *     1. x >= 0, x/width: width = 10
     *          - [0,  10)           bucket-id: 0
     *          - [10, 20)           bucket-id: 1
     *     2. x < 0:
     *          -5/10   = -0 -- -5   bucket-id: -1
     *          -10/10  = -1 --  0   bucket-id: -1
     *          -15/10  = -1 -- -5   bucket-id: -2
     *
     * </pre>
     *
     * @param x 值
     * @param width 桶宽
     * @return
     */
    private static int getBucketId(int x, int width) {
        if (x >= 0) {
            return x / width;
        }
        return (x + 1) / width - 1;
    }

    /**
     * Core Thinking:
     *
     * <pre>
     *   1. ceiling 是相当于 j 的值: vi - t <= ceiling <= vi + t
     *   2. ceiling 是符合滑动窗口条件时, 且 >= vi -t 的最小的一个
     *   3. 注意维护窗口
     * </pre>
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicateV1(int[] nums, int k, int t) {
        int length = nums.length;
        if (k < 0 || length < 2 || t < 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet();
        for (int i = 0; i < length; i++) {
            // ceiling 是相当于 j 的值: vi - t <= ceiling <= vi + t
            // ceiling 是符合滑动窗口条件时 >= vi -t 的最小的一个:
            //     此值如果不满足那么比其大的值就更加不满足右边界了
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= ((long) nums[i] + t)) {
                return true;
            }

            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }

        return false;
    }

    /**
     * 暴力解法: 超时了
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    @Deprecated
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int length = nums.length;
        if (k < 0 || length < 2 || t < 0) {
            return false;
        }
        int count;
        for (int i = 0; i < length; i++) {
            count = 0;
            for (int j = i + 1; j < length; j++) {
                if (Math.abs((long) nums[i] - (long) nums[j]) <= t) {
                    return true;
                }
                count++;
            }
        }
        return false;
    }
}
