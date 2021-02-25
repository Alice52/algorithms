package leetcode.array;

import lombok.extern.slf4j.Slf4j;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/18
 *
 * @author zack <br>
 * @create 2021-02-18 19:40 <br>
 * @project leetcode <br>
 */
@Slf4j
public class DuplicateRemoveOfSortedArray {
  public static void main(String[] args) {

    OptionalInt.of(removeDuplicate(new int[] {1, 2, 2, 2, 4, 5, 5})).ifPresent(System.out::println);
  }

  /**
   * Core: 遍历数组找到和finder不一样的值就交换, 且 finder 向前移一位, finder 表示第n个不同值<br>
   * 会改变元素的内容
   *
   * <pre>
   *   1. step:
   *     - 1 2 2 2 4 5 5
   *     - 1 2 4 2 4 5 5
   *     - 1 2 4 5 4 5 5
   * </pre>
   *
   * @param nums
   * @return
   */
  public static int removeDuplicate(int[] nums) {
    int size = nums.length;
    if (size <= 1) {
      return size;
    }

    int finder = 0;
    for (int i = 1; i < size; i++) {
      if (nums[finder] != nums[i]) {
        nums[++finder] = nums[i];
      }
    }

    IntStream.of(nums).forEach(System.out::println);
    return finder + 1;
  }

  public static int removeDuplicateWithSequence(int[] nums) {
    int size = nums.length;
    if (size <= 1) {
      return size;
    }

    int finder = 0;
    for (int i = 1; i < size; i++) {
      if (nums[finder] != nums[i]) {
        int temp = nums[i];
        ++finder;
        nums[i] = nums[finder];
        nums[finder] = temp;
      }
    }

    IntStream.of(nums).forEach(System.out::println);
    return finder + 1;
  }
}
