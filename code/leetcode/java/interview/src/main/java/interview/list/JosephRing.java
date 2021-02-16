package interview.list;

import model.leetcode.common.model.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author zack <br>
 * @create 2021-02-15 19:39 <br>
 * @project leetcode <br>
 */
public class JosephRing {

  public static void main(String[] args) {

    Optional.of(josephRingByList(1, 2, 4)).ifPresent(x -> x.forEach(System.out::println));

    Optional.ofNullable(josephRingByMath(2, 4)).ifPresent(System.out::println);
  }

  /**
   * f[i]= (f[i-1] + m) % i; (1<i<=n) <br>
   * 只能算出最后一个, 且不能加入参数 startK
   *
   * @param outM 从 1 开始报数, 第 outM 个出环
   * @param totalN 总人数
   * @return
   */
  public static int josephRingByMath(int outM, int totalN) {
    if (totalN == 0 || outM <= 0) {
      return -1;
    }

    int last = 0;
    for (int i = 2; i <= totalN; i++) {
      last = (last + outM) % i;
    }

    return last + 1;
  }

  /**
   * Core thinking:
   *
   * <pre>
   *     1. startK 可以通过先移动 head startK - 1 次来消除
   *     2. 循环退出的条件是最后只剩一个节点, 也就是这个结点的下一个节点是它本身
   *     3. outM -1 时才能出 queue outM 的机会, 且 count = 1
   * </pre>
   *
   * @param startK 从第 startK 开始报数
   * @param outM 从 1 开始报数, 第 outM 个出环
   * @param totalN 总人数, 只参与 startK 的问题
   * @return
   */
  public static List<Integer> josephRingByList(int startK, int outM, int totalN) {

    // 1. 创建约瑟夫环
    /** 不存元素 */
    ListNode<Integer> head = new ListNode();

    ListNode<Integer> dummyNode = head;
    ListNode.createCircleNode(head, dummyNode, totalN);

    // 2. 求约瑟夫环出 queue 顺序
    List<Integer> result = new ArrayList<>();
    head = head.nextNode;
    // startK > 1 的话, 就移动 head 指针使得 count 依旧是从 1 开始计数
    while (startK % totalN != 1) {
      head = head.nextNode;
      startK--;
    }

    int count = 1;
    // 循环退出的条件是最后只剩一个节点, 也就是这个结点的下一个节点是它本身
    while (head.nextNode != head) {
      // 计算 outM
      if (count == outM - 1) {
        result.add(head.nextNode.value);
        head.nextNode = head.nextNode.nextNode;
        count = 1;
      } else {
        count++;
      }
      head = head.nextNode;
    }

    result.add(head.value);
    return result;
  }
}
