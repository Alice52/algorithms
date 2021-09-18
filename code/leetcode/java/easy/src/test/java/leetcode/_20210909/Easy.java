package leetcode._20210909;

import lombok.extern.slf4j.Slf4j;
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
    public void testLoopArrays2() {
        List<String> strings = generateParenthesis(2);
    }

    List<String> result = new ArrayList<>();
    char[] enums = new char[]{'(', ')'};
    public List<String> generateParenthesis(int n) {
        backtracking(n*2, new StringBuilder ());

        return result;
    }

    void backtracking(int n, StringBuilder sb) {
        if (sb.length() == n) {
            if (isValid(sb)) {
                if (!result.contains(sb.toString())) {
                    result.add(sb.toString());
                }
            }
            return;
        }

        for (int i=0; i < enums.length; i++) {
            sb.append(enums[i]);
            backtracking(n,  sb);
            sb.deleteCharAt(i);
        }
    }

    private boolean isValid(StringBuilder sb) {

        Stack<Character> characterStack = new Stack<>();
        for (int i=0; i<sb.length(); i++) {
            char next = sb.charAt(i);
            if (next == '(') {
                characterStack.add(next);
            } else {
                if (!characterStack.isEmpty() && characterStack.peek() == '(') {
                    characterStack.pop();
                } else {
                    return false;
                }
            }
        }

        return characterStack.isEmpty();
    }

    @Test
    public void testLoopArrays() {
        boolean b = canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
    }


    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum+=nums[i];
        }

        if (sum % k != 0) {
            return false;
        }
        int val = sum / k;

        List<LinkedList<Integer>> bucket = new ArrayList<>(k);

        // 组合问题
        return backtracking(0, 0, nums, bucket);
    }

    boolean backtracking(int startIndex, int k, int[] nums, List<LinkedList<Integer>> bucket) {
        if (startIndex == nums.length) {
            return isValid(bucket);
        }

        for (int i=startIndex; i<nums.length; i++) {

            LinkedList<Integer> integers = bucket.get(k);
            integers.add(nums[startIndex]);
            if (backtracking(startIndex+1, k+1, nums, bucket)){
                return true;
            }
            integers.removeLast();
        }

        return false;
    }

    private boolean isValid(List<LinkedList<Integer>> bucket) {
        int preSum=0;
        for (LinkedList<Integer> list : bucket) {
            int sum =0;
            for (Integer a : list) {
                sum+=a;
            }

            if (preSum==0) {
                preSum = sum;
            } else if (preSum != sum) {
                return false;
            }
        }

        return true;
    }

}
