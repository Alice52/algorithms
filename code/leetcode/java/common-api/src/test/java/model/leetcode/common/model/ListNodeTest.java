package model.leetcode.common.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zack <br>
 * @create 2021-05-24 12:13 <br>
 * @project leetcode <br>
 */
@Slf4j
public class ListNodeTest {

    @Test
    public void testGenerateList() {
        ListNode<Integer> list = ListNode.generateNode(1, 2, 2, 3, 4);
        ListNode.print(list);
    }
}
