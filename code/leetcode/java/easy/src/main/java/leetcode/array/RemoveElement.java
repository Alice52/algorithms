package leetcode.array;

import lombok.extern.slf4j.Slf4j;

import java.util.OptionalInt;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/25
 *
 * @author zack <br>
 * @create 2021-02-18 20:37 <br>
 * @project leetcode <br>
 */
@Slf4j
public class RemoveElement {

  public static void main(String[] args) {

    OptionalInt.of(removeElement(new int[] {0, 1, 2, 2, 3, 0, 4, 2}, 2))
        .ifPresent(System.out::println);
  }

  /**
   * Core thing: remove all target elements<br>
   *
   * <pre>
   *      1. 0, finder 表示最终的结果数组下标
   *      2. 遍历 nums:
   *          - 如果值与 target 不同, 则将改值放入 finder 位置&& finder 移动一位
   *          - 否则 finder 不动[什么都不做]
   *  </pre>
   *
   * @param nums
   * @param target
   * @return
   */
  public static int removeElement(int[] nums, int target) {

    int finder = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != target) {
        nums[finder++] = nums[i];
      }
    }

    return finder;
  }
}
