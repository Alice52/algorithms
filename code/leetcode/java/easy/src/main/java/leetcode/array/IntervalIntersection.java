package leetcode.array;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

//

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/34
 *
 * @author zack <br>
 * @create 2021-02-24 22:24 <br>
 * @project leetcode <br>
 */
@Slf4j
public class IntervalIntersection {

  public static void main(String[] args) {

    Optional.of(
            intervalIntersection(
                new int[][] {{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][] {{1, 5}, {8, 12}, {15, 24}, {25, 26}}))
        .ifPresent(x -> Stream.of(x).forEach(e -> log.info("{}", e)));
  }

  /**
   * Each list of intervals is pairwise disjoint and in sorted order<br>
   * Core thinking
   *
   * <pre>
   *     1. 左边界为: start := max(A[i].Start, B[j].Start)
   *     2. 右边界为: end := min(A[i].End, B[j].End)
   *     3. 如果 start <= end, 那么这个就是⼀个满⾜条件的交集, 放⼊最终数组中
   *     4. 如果 A[i].End <= B[j].End, 代表 B 数组范围⽐ A 数组⼤, A 的游标右移
   *     5. 如果 A[i].End > B[j].End, 代表 A 数组范围⽐ B 数组⼤, B 的游标右移
   * </pre>
   *
   * @param a
   * @param b
   * @return
   */
  public static int[][] intervalIntersection(int[][] a, int[][] b) {
    List<int[]> lists = new ArrayList<>();
    int i = 0, j = 0;
    while (i < a.length && j < b.length) {

      int start = Math.max(a[i][0], b[j][0]);
      int end = Math.min(a[i][1], b[j][1]);

      if (start <= end) {
        lists.add(new int[] {start, end});
      }

      if (a[i][1] <= b[j][1]) {
        i++;
      } else {
        j++;
      }
    }

    return lists.toArray(new int[][] {});
  }
}
