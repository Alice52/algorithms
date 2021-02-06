package model.leetcode.common.model;

import lombok.AllArgsConstructor;

/**
 * @author zack <br>
 * @create 2021-02-06 22:02 <br>
 * @project leetcode <br>
 */
@AllArgsConstructor
public class ListNode {
  public int value;
  public ListNode nextNode;

  public ListNode(int value) {
    this.value = value;
  }
}
