package leetcode.array;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/26
 *
 * @author zack <br>
 * @create 2021-02-18 20:59 <br>
 * @project leetcode <br>
 */
@Slf4j
public class MoveZeroes2Tail {

  public static void main(String[] args) {

    Optional.of(moveZeroes2Tail(new int[] {1, 2, 0}))
        .ifPresent(x -> IntStream.of(x).forEach(System.out::println));
  }

  /**
   * Core thinking: 0, finder表示最后结果的所有非 0 元素
   *
   * <pre>
   *     1. 遍历数组
   *          - nums[i] != 0 则交换 finder 和 i 的值, finder 移动一位
   *     2. step of [2 0 1 0 1]
   *          - 2 0 1 0 1
   *          - 2 1 0 0 1
   *          - 2 1 0 0 1
   *          - 2 1 1 0 0
   * </pre>
   *
   * @param nums
   * @return
   */
  public static int[] moveZeroes2Tail(int[] nums) {

    int finder = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[i];
        nums[i] = nums[finder];
        nums[finder] = temp;

        finder++;
      }
    }
    return nums;
  }
}
