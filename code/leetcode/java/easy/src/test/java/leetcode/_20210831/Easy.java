package leetcode._20210831;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import model.leetcode.common.model.ListNode;
import org.junit.Test;

import java.text.Collator;
import java.util.*;

/**
 * @author asd <br>
 * @create 2021-07-12 1:26 PM <br>
 * @project leetcode <br>
 */
@Slf4j
public class Easy {


    @Test
    public void testLoopArrays() {
        loopArray(new int[]{1, 2, 3, 1}, 2);
    }

    /**
     * <pre>
     *     1 2 3 1  - 2
     *     1 2 3 1 1 2 3 1 1 2 3 1
     *
     * </pre>
     * @param nums
     * @param loop
     */
    public void loopArray(int[] nums, int loop) {
        for (int i=nums.length * loop-1; i>= 0; i--) {
            log.info("i: " +  nums[i%nums.length]);
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        // 1 2 1  1 2 1
        int[] ne = new int[nums.length*2];
        System.arraycopy(nums, 0, ne, 0, nums.length);
        System.arraycopy(nums, 0, ne, nums.length, nums.length);

        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i=ne.length-1; i>=0; i--) {
            while(!stack.isEmpty() && ne[i] > stack.peek()) {
                 stack.pop();
            }

            if (i < nums.length) {
                res[i] = stack.isEmpty() || ne[i] == stack.peek() ? -1 : stack.peek();
            }

            stack.push(ne[i]);
        }


        System.arraycopy(res, 0, nums, 0, nums.length);

        return nums;
    }

    @Test
    public void testSort() {

        nextGreaterElements(new int[]{1,2,1});

        List<String> list = Arrays.asList("a", "c", "A", "", "acc", "adc",
                "孙", "孟", "宋", "尹", "1", "54", ".", ";", "'", "?",  "廖", "张", "徐", "昆", "曹", "曾", "怡");

        list.sort((o1, o2) -> Collator.getInstance(Locale.CHINESE).compare(o1, o2));
        // list.sort(String::compareTo);

        list.forEach(System.out::println);
    }

}
