package leetcode.array;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/32
 *
 * @author zack <br>
 * @create 2021-02-24 19:08 <br>
 * @project leetcode <br>
 */
@Slf4j
public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {

        Optional.of(
                        intersection(
                                new int[] {
                                    54, 93, 21, 73, 84, 60, 18, 62, 59, 89, 83, 89, 25, 39, 41, 55,
                                    78, 27, 65, 82, 94, 61, 12, 38, 76, 5, 35, 6, 51, 48, 61, 0, 47,
                                    60, 84, 9, 13, 28, 38, 21, 55, 37, 4, 67, 64, 86, 45, 33, 41
                                },
                                new int[] {
                                    17, 17, 87, 98, 18, 53, 2, 69, 74, 73, 20, 85, 59, 89, 84, 91,
                                    84, 34, 44, 48, 20, 42, 68, 84, 8, 54, 66, 62, 69, 52, 67, 27,
                                    87, 49, 92, 14, 92, 53, 22, 90, 60, 14, 8, 71, 0, 61, 94, 1, 22,
                                    84, 10, 55, 55, 60, 98, 76, 27, 35, 84, 28, 4, 2, 9, 44, 86, 12,
                                    17, 89, 35, 68, 17, 41, 21, 65, 59, 86, 42, 53, 0, 33, 80, 20
                                }))
                .ifPresent(x -> IntStream.of(x).forEach(System.out::println));
    }

    /**
     * Core thinking:
     *
     * <pre>
     *     1. 遍历 nums1: 将值和出现次数存入 map
     *     2. 遍历 nums2:
     *        - 如果元素在 map 中, 则将该元素放入 result, 并对出现次数减一
     * </pre>
     *
     * @param nums1 original nums
     * @param nums2 original nums
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] result = new int[0];
        HashMap<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int num : nums1) {
            map.compute(num, (k, v) -> v == null ? 1 : ++v);
        }

        for (int num : nums2) {
            Integer count = map.getOrDefault(num, 0);
            if (count != 0) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = num;
                map.put(num, --count);
            }
        }

        return result;
    }
}
