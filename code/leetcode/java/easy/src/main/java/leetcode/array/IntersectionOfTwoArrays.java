package leetcode.array;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/31
 *
 * @author zack <br>
 * @create 2021-02-24 19:08 <br>
 * @project leetcode <br>
 */
@Slf4j
public class IntersectionOfTwoArrays {
  public static void main(String[] args) {
    Optional.of(intersection(new int[] {1, 2, 2, 1}, new int[] {2, 2}))
        .ifPresent(x -> IntStream.of(x).forEach(System.out::println));
  }

  /**
   * Core thinking:
   *
   * <pre>
   *     1. nums1 放入 map: 可以做到去重 nums1
   *     2. 遍历 nums2:
   *        - 如果元素在 map 中, 则将该元素放入 result
   *        - 并且从 map 中移除: 防止结果重复
   *     3. core: int[] result
   *        - Arrays.copyOf: {@link System#arraycopy(Object, int, Object, int, int)}
   * </pre>
   *
   * @param nums1 original nums
   * @param nums2 original nums
   * @return
   */
  public static int[] intersection(int[] nums1, int[] nums2) {
    int[] result = new int[0];
    HashMap<Integer, Boolean> map = new HashMap<>(nums1.length);

    for (int num : nums1) {
      map.put(num, true);
    }

    for (int num : nums2) {
      if (map.containsKey(num)) {
        result = Arrays.copyOf(result, result.length + 1);
        result[result.length - 1] = num;
        map.remove(num);
      }
    }

    return result;
  }
}
