package leetcode._20210815;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zack <br>
 * @create 2021-08-15<br>
 * @project leetcode <br>
 */
@Slf4j
public class EasyTest {
    @Test
    public void test637() {
        search(new int[] {-1, 0, 3, 5, 9, 12}, 9);
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {

                System.out.println(l + "");
                return mid;
            }

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(l + "");
        return -1;
    }

    public int findShortestSubArray(int[] nums) {
        // int[] 三个元素分别代表这个数出现的次数、这个数在原数组中第一次出现的位置和这个数在原数组中最后一次出现的位置
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[] {1, i, i});
            }
        }

        int degree = 0, minLen = Integer.MAX_VALUE;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (degree < arr[0]) {
                degree = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (degree == arr[0]) {
                minLen = Math.min(minLen, arr[2] - arr[1] + 1);
            }
        }
        return minLen;
    }

    public int findLengthOfLCIS(int[] nums) {
        // 单调栈
        Stack<Integer> stack = new Stack<>();
        int maxSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                stack.add(nums[i]);
                continue;
            }

            int last = stack.peek();
            if (nums[i] > last) {
                stack.push(nums[i]);
            } else {
                maxSize = Math.max(maxSize, stack.size());
                stack.clear();
                stack.add(nums[i]);
            }
        }

        return Math.max(maxSize, stack.size());
    }
}
