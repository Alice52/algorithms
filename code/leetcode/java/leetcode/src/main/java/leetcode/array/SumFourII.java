package leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/17
 *
 * @author zack <br>
 * @create 2021-02-15 18:39 <br>
 * @project leetcode <br>
 */
public class SumFourII {

  public static void main(String[] args) {

    OptionalInt.of(
            fourSumII(new int[] {1, 2}, new int[] {-2, -1}, new int[] {-1, 2}, new int[] {0, 2}))
        .ifPresent(System.out::println);
  }

  /**
   * A[i] + B[j] + C[k] + D[l] = 0
   *
   * <pre>
   *   Core thinking:
   *      1. trade time for space
   *      2. get A and B array sum and store to map
   *      3. loop C and D to re-calculate
   * </pre>
   *
   * @param a
   * @param b
   * @param c
   * @param d
   * @return
   */
  public static int fourSumII(int[] a, int[] b, int[] c, int[] d) {

    int count = 0;
    Map<Integer, Integer> map = new HashMap<>(a.length + b.length);
    for (int i : a) {
      for (int j : b) {
        map.put(i + j, map.getOrDefault(i + j, 0) + 1);
      }
    }

    for (int k : c) {
      for (int l : d) {
        count += map.getOrDefault(-k - l, 0);
      }
    }

    return count;
  }
}
