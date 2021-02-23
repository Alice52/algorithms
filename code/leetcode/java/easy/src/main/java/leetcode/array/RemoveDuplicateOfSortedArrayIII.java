package leetcode.array;

import lombok.extern.slf4j.Slf4j;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/19
 *
 * @author zack <br>
 * @create 2021-02-18 20:10 <br>
 * @project leetcode <br>
 */
@Slf4j
public class RemoveDuplicateOfSortedArrayIII {

  public static void main(String[] args) {
    OptionalInt.of(removeDuplicate(new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3}, 0))
        .ifPresent(System.out::println);
  }


  public static int removeDuplicate(int[] nums, int repeatedCount) {

     return  0;
  }
}
