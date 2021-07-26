package model.leetcode.common.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zack <br>
 * @create 2021-07-18<br>
 * @project leetcode <br>
 */
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
