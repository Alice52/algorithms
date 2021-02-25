package leetcode.array;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/38
 *
 * @author zack <br>
 * @create 2021-02-25 10:30 <br>
 * @project leetcode <br>
 */
@Slf4j
public class DuplicateJudgeIndexLessK {
  public static void main(String[] args) {
    Optional.of(duplicateJudgeIndexLessK(new int[] {1, 2, 3, 1}, 3)).ifPresent(System.out::println);
  }

  /**
   * 如果数组⾥⾯有重复数字, 并且重复数字的下标差值的最大值⼩于等于 K 就输出 true
   *
   * <pre>
   *     1. 反向思维: 考虑找到为 false 的情况
   *     2. 没有重复数字返回 false, 重复元素最大差距大于 K 返回 false
   * </pre>
   *
   * @param nums
   * @param k
   * @return
   */
  public static boolean duplicateJudgeIndexLessK(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int oldIndex;
    for (int i = 0; i < nums.length; i++) {
      oldIndex = map.getOrDefault(nums[i], -1);
      if (oldIndex == -1) {
        // 第一次出现和最后一次出现的相同的元素才是下标差距最大的
        map.put(nums[i], i);
      } else if (i - oldIndex > k) {
        return false;
      }
    }

    return map.size() != nums.length;
  }

  /**
   * 判断数组中是否存在两个不同的索引 i 和 j, 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k<br>
   * <br>
   * Core thinking:
   *
   * <pre>
   *    1. 最近的两个相同元素下标差值小于等于 K 则返回 true
   * </pre>
   *
   * @param nums
   * @param k
   * @return
   */
  public static boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int nearIndex;
    for (int i = 0; i < nums.length; i++) {
      nearIndex = map.getOrDefault(nums[i], -1);
      if (nearIndex != -1 && i - nearIndex <= k) {
        return true;
      }

      map.put(nums[i], i);
    }

    return false;
  }
}
