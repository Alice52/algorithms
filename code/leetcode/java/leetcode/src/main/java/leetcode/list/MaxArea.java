package leetcode.list;

import cn.hutool.core.lang.Assert;

import java.util.Optional;

/**
 * <link>https://leetcode.com/problems/container-with-most-water/</link>
 *
 * @author zack <br>
 * @create 2021-02-07 10:44 <br>
 * @project java <br>
 */
public class MaxArea {

  public static void main(String[] args) {
    Optional.ofNullable(maxArea(new int[] {2, 3, 4, 5, 18, 17, 6})).ifPresent(System.out::println);
  }

  /**
   * core: min(ai, aj) ↑ * width ↓ <br>
   * time complexity: O(n^2) <br>
   * * space complexity: O(1) <br>
   *
   * @param nums
   * @return int
   */
  public static int maxArea(int[] nums) {
    Assert.notNull(nums);

    int size = nums.length;
    int tempMaxArea = 0, firstIndex = 0, lastIndex = size - 1;

    int width, high;
    for (int i = 0; i < size && lastIndex > firstIndex; i++) {
      width = lastIndex - firstIndex;

      // judgement
      if (nums[firstIndex] < nums[lastIndex]) {
        high = nums[firstIndex++];
      } else {
        high = nums[lastIndex--];
      }

      // calculate
      if (tempMaxArea < high * width) {
        tempMaxArea = high * width;
      }
    }

    return tempMaxArea;
  }

  /**
   * time complexity: O(n^2) <br>
   * space complexity: O(1) <br>
   *
   * @param nums
   * @return
   */
  public static int maxAreaSilly(int[] nums) {
    Assert.notNull(nums);
    int size = nums.length;
    int tempMaxArea = 0;
    for (int i = 0; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        tempMaxArea = Math.max(tempMaxArea, Math.min(nums[i], nums[j]) * (j - i));
      }
    }

    return tempMaxArea;
  }
}
