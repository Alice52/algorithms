package leetcode.array;

import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 1. Given an array of integers, return indices of the two numbers such that they add up to a
 * specific target. <br>
 * 2. You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 *
 * <pre>
 *     Given nums = [2, 7, 11, 15], target = 9,
 *     Because nums[0] + nums[1] = 2 + 7 = 9,
 *
 *     return [0, 1]
 * </pre>
 *
 * @author zack <br>
 * @create 2021-02-04 12:20 <br>
 * @project leetcode <br>
 */
@Slf4j
public class SumTwo {
  public static void main(String[] args) {
    log.info("hello algorithms *** ");

    int[] nums = new int[] {2, 7, 11, 15};
    int target = 26;
    int[] results = twoSum(nums, target);

    Optional.ofNullable(results)
        .ifPresent(x -> Arrays.stream(results).forEach(System.out::println));
  }

  /**
   * containsKey is O(1)
   *
   * <pre>
   *    core thinking:
   *      1. build one map to store nums element, which key is num value, and value is index
   * </pre>
   *
   * @param nums origin arrays
   * @param target target value
   * @return index or null
   */
  public static int[] twoSum(int[] nums, int target) {
    Assert.notNull(nums);
    Assert.notNull(target);

    // key num value, and value is index
    Map<Integer, Integer> map = new HashMap<>(10);

    int size = nums.length;
    for (int i = 0; i < size; i++) {
      int repair = target - nums[i];
      if (map.containsKey(repair)) {
        return new int[] {map.get(repair), i};
      } else {
        map.put(nums[i], i);
      }
    }

    return null;
  }
}
