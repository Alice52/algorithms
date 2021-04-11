package leetcode.recursion;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zack <br>
 * @create 2021-04-10 15:48 <br>
 * @project leetcode <br>
 */
@Slf4j
public class KthGrammar {

  public static void main(String[] args) {}

  public static int upow(int size) {
    int order;
    size = (size - 1) >> (0);
    order = -1;
    do {
      size >>= 1;
      order++;
    } while (size > 0);

    return order;
  }

  public static int kthGrammar(int n, int k) {

    if (n == 1) {
      return 0;
    }

    int halfSize = 1 << (n - 2);
    // 前半截
    if (k <= halfSize) {
      return kthGrammar(n - 1, k);
    } else {
      // 后半截
      int grammar = kthGrammar(n - 1, k - halfSize);
      return flip(grammar);
    }
  }

  private static int flip(int i) {
    return i ^ 1;
  }

  private static boolean isPowerOfTwo(int val) {
    return (val & -val) == val;
  }
}
