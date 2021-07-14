package leetcode._20210714;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zack <br>
 * @create 2021-07-14<br>
 * @project leetcode <br>
 */
@Slf4j
public class EasyTest {

    @Test
    public void test053() {

        int str = maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4});
        log.info("053 maxSubArray result: {}", str);
    }

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    @Test
    public void test035() {

        int str = searchInsert(new int[] {1, 3, 5, 7}, 6);
        log.info("035 searchInsert result: {}", str);
    }

    @Deprecated
    public int searchInsertV0(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }

        return nums.length;
    }

    public int searchInsert(int[] nums, int target) {

        int right = nums.length - 1;
        int left = 0;

        int middle;
        while (left <= right) {
            middle = (right - left) / 2 + left;
            if (nums[middle] == target) {
                return middle;
            }

            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

    @Test
    public void test028() {

        int str = strStr("hello", "o");
        log.info("028 strStr result: {}", str);
    }

    @Deprecated
    public int strStrV0(String haystack, String needle) {

        if (haystack.equals(needle) || needle.equals("")) {
            return 0;
        }
        if (haystack.equals("")) {
            return -1;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            int t = i;
            while (haystack.charAt(t++) == needle.charAt(j++)) {
                if (j == needle.length()) {
                    return t - j;
                }
            }
        }

        return -1;
    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i < n - m + 1; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }

        return -1;
    }

    @Test
    public void test027() {

        int count = removeElement(new int[] {3, 2, 2, 3}, 3);
        log.info("027 remove element result: {}", count);
    }

    /**
     * Double pointer
     *
     * @param nums
     * @param val
     * @return
     */
    @Deprecated
    public int removeElement_V0(int[] nums, int val) {

        // due to first is removed element
        int ptr = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[++ptr] = nums[i];
            }
        }

        return ptr + 1;
    }

    public int removeElement(int[] nums, int val) {

        int left = 0;
        int right = nums.length;

        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[--right];
            } else {
                left++;
            }
        }

        return left;
    }

    @Test
    public void test026() {

        int count = removeDuplicates(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        log.info("026 remove duplicates result: {}", count);
    }

    /**
     * Double pointer
     *
     * @param nums
     * @return
     */
    @Deprecated
    public int removeDuplicates_V0(int[] nums) {

        int length = nums.length;
        if (length < 2) {
            return length;
        }

        int ptr = 0;
        int tmp;
        for (int i = 1; i < length; i++) {
            if (nums[ptr] != nums[i]) {
                tmp = nums[ptr + 1];
                nums[ptr + 1] = nums[i];
                nums[i] = tmp;
                ptr++;
            }
        }

        return ptr + 1;
    }

    public int removeDuplicates(int[] nums) {

        int finder = 0;
        for (int second = 1; second < nums.length; second++) {
            if (nums[finder] != nums[second]) {
                nums[++finder] = nums[second];
            }
        }

        return finder + 1;
    }
}
