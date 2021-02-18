package leetcode.array;

import lombok.extern.slf4j.Slf4j;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/19
 * @author zack <br>
 * @create 2021-02-18 20:10 <br>
 * @project leetcode <br>
 */
@Slf4j
public class RemoveDuplicateOfSortedArrayII {

  public static void main(String[] args) {
    OptionalInt.of(removeDuplicate(new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3}, 2))
        .ifPresent(System.out::println);
  }

  /**
   * Core: 与 {@link RemoveDuplicateOfSortedArray#removeDuplicate(int[])} 一样的思路, <br>
   * 只是新增一个 count 变量记录 finder 下标值的次数: count <= 2 时则 finder 正常移动[即使元素相同]
   *
   * @param nums
   * @param repeatedCount
   * @return
   */
  public static int removeDuplicate(int[] nums, int repeatedCount) {

    int size = nums.length;
    if (size <= 2) {
      return size;
    }

    int finder = 0, count = 1;
    for (int i = 1; i < size; i++) {
      if (nums[finder] != nums[i]) {
        // due to below count++
        count = 0;
      } else {
        if (count >= repeatedCount) {
          continue;
        }
      }

      count++;
      nums[++finder] = nums[i];
    }

    IntStream.of(nums).forEach(System.out::println);

    return finder + 1;
  }
}
