package model.leetcode.common.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zack <br>
 * @create 2021-02-06 22:02 <br>
 * @project leetcode <br>
 */
@NoArgsConstructor
@AllArgsConstructor
public class ListNode<T> {
  public T value;
  public ListNode<T> nextNode;

  public ListNode(T value) {
    this.value = value;
  }
}
