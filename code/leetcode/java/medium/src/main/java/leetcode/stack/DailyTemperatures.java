package leetcode.stack;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/739
 *
 * @author zack <br>
 * @create 2021-04-10 12:49 <br>
 * @project leetcode <br>
 */
@Slf4j
public class DailyTemperatures {

  public static void main(String[] args) {

    final int[] ints = dailyTemperaturesStack(new int[] {73, 74, 75, 71, 69, 72, 76, 73});
    log.info("results :{}", ints);
  }

  /**
   * 维护一个单调递减的栈, 存储下标
   *
   * @param T
   * @return
   */
  public static int[] dailyTemperaturesStack(int[] T) {

    int[] ans = new int[T.length];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < ans.length; i++) {

      for (; stack.size() > 0 && T[i] > T[stack.peek()]; ) {
        Integer previousLessThanIndex = stack.pop();
        ans[previousLessThanIndex] = i - previousLessThanIndex;
      }

      stack.push(i);
    }

    return ans;
  }

  @Deprecated
  public static int[] dailyTemperaturesForce(int[] arr) {

    int[] results = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      int v = arr[i];
      int result = 0;
      for (int j = i + 1; j < 101; j++) {
        if (v < arr[j]) {
          result = j - i;
          break;
        }
      }

      results[i] = result;
    }

    return results;
  }
}
