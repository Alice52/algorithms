package interview.list;

import model.leetcode.common.model.ListNode;

import java.util.HashSet;
import java.util.Optional;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/33<br>
 * <br>
 * I think hash and HashSet is best practice.
 *
 * @author zack <br>
 * @create 2021-02-16 15:42 <br>
 * @project leetcode <br>
 */
public class CircleIntersect {

  public static void main(String[] args) {
    ListNode<Integer> node1 = new ListNode<>(21);
    ListNode<Integer> node2 = new ListNode<>(22);
    ListNode<Integer> node3 = new ListNode<>(23);
    ListNode<Integer> node4 = new ListNode<>(24);
    ListNode<Integer> node5 = new ListNode<>(25);
    ListNode<Integer> node6 = new ListNode<>(26);
    ListNode<Integer> node7 = new ListNode<>(27);
    ListNode<Integer> node11 = new ListNode<>(121);
    ListNode<Integer> node12 = new ListNode<>(122);
    ListNode<Integer> node13 = new ListNode<>(123);

    node1.nextNode = node2;
    node2.nextNode = node3;
    node3.nextNode = node4;
    node4.nextNode = node5;
    node5.nextNode = node6;
    node6.nextNode = node7;
    node7.nextNode = node2;

    node11.nextNode = node12;
    node12.nextNode = node13;
    node13.nextNode = node3;

    Optional.of(judgeJoinByHash(node1, node11)).ifPresent(System.out::println);
  }

  /**
   * 1. hash 方法: <br>
   *
   * <pre>
   *     1. [环内相交] 两个相交节点, 求环的长度
   *     2. [环前相交] ASet 中相交节点到末尾的长度: 注意这里不能使用 HashSet 了, 需要使用LinkedList
   * </pre>
   *
   * <pre>
   *    1. [环前相交] 解开环之后求相交节点长度则为两个不相交节点求相交节点长度 {@link Intersect#getIntersectionLength(ListNode, ListNode)}
   *    2. [环内相交] 就是环的长度
   * </pre>
   *
   * @param headA
   * @param headB
   * @return
   */
  public static int getIntersectionLength(ListNode headA, ListNode headB) {

    return 0;
  }

  /**
   * 1. refer: https://blog.csdn.net/dhaibo1986/article/details/107203976/ <br>
   * 2. 有环的只有两种情况: 环前相交[1个相交点], 环内相交[2个相交点]<br>
   * 3. 方法: 把环打开
   *
   * <pre>
   *     1. [环前相交] 之后就变成了两个无环链表的交点问题
   *     2. [环内相交] 就分别打开A, B 的环可以计算出两个节点
   * </pre>
   *
   * 4. 也可以使用 hash: 交换两个参数位置获取两个节点
   *
   * @param headA
   * @param headB
   * @return
   */
  public static ListNode<Integer> getNodeOfTwoIntersection(ListNode headA, ListNode headB) {
    return null;
  }

  /**
   * 1. {@link CircleIntersect#judgeJoinByHash(ListNode, ListNode)} <br>
   * 2. 当一个链表中有环, 一个链表中没有环时, 两个链表必不相交<br>
   * 3. 如果两个链表都有环, 则打开一个链表的环之后, 若另外一个链表也无环了则证明相交<br>
   */
  public static void judge() {}

  /**
   * 1. ASet 存放A的所有元素, 每次放入之前先获取一下, 防止有环, 有环则停止<br>
   * 2. 遍历B中的元素:<br>
   *
   * <pre>
   *     1. b 存在于 ASet 则证明相交
   *     2. b 元素 放入 BSet, 每次放入之前先获取一下, 防止有环, 有环则停止
   * </pre>
   *
   * 3. return true 时的 b 就是相交的节点
   *
   * @param a
   * @param b
   * @return
   */
  public static boolean judgeJoinByHash(ListNode a, ListNode b) {

    HashSet<ListNode> aSet = new HashSet<>();
    HashSet<ListNode> bSet = new HashSet<>();
    while (a != null) {
      if (aSet.contains(a)) {
        break;
      }

      aSet.add(a);
      a = a.nextNode;
    }

    while (b != null) {

      if (bSet.contains(b)) {
        break;
      }

      if (aSet.contains(b)) {
        return true;
      }
      bSet.add(b);
      b = b.nextNode;
    }

    return false;
  }
}
