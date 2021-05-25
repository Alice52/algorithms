package leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/16
 *
 * @author zack <br>
 * @create 2021-02-15 11:13 <br>
 * @project leetcode <br>
 */
public class SumFour {

    public static void main(String[] args) {
        final int[] nums = {-2, -1, -1, 1, 1, 2, 2};

        final List<List<Integer>> lists = fourSumV2(nums, 0);
        lists.forEach(x -> System.out.println(x));
    }

    /**
     * Core: the difficulty is de-duplicated.<br>
     * Timing: O(n^3)
     *
     * <pre>
     *    thinking:
     *        1. sort + two-point closest
     *        2. deduplicate when outer loop of i & j and inner loop of increase or decrease ptr
     *        3. two-point to closest from start[j+1] and end
     *        4. <code>1 2 2 2 4: 这里取得是 4 前面的 2, 之后再通过 while 进行去重</code>
     * </pre>
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSumV2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < size - 3; i++) {
            // de-duplicate
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < size - 2; j++) {
                // de-duplicate
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int low = j + 1;
                int high = size - 1;

                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    // de-duplicate
                    if (sum > target || (high < size - 1 && nums[high + 1] == nums[high])) {
                        // 2. 1 2 2 2 4: 会指向 1
                        high--;
                    } else if (sum < target || (low > j + 1 && nums[low - 1] == nums[low])) {
                        low++;
                    } else {
                        // 1. 1 2 2 2 4: 这里取得是 4 前面的 2
                        result.add(Arrays.asList(nums[i], nums[j], nums[low++], nums[high--]));
                    }
                }
            }
        }

        return result;
    }

    /**
     * core: de-duplicate<br>
     * issue: poor performance<br>
     * Timing: O(N^3)
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        Map<Integer, Integer> counter = new HashMap<>(size);

        for (int num : nums) {
            counter.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }

        List<Integer> unique = counter.keySet().stream().collect(Collectors.toList());
        unique.sort(Integer::compareTo);

        for (int i = 0; i < unique.size(); i++) {
            Integer iV = unique.get(i);
            if (iV * 4 == target && counter.get(iV) >= 4) {
                result.add(Arrays.asList(iV, iV, iV, iV));
            }

            for (int j = i + 1; j < unique.size(); j++) {
                Integer jV = unique.get(j);
                if (iV * 3 + jV == target && counter.get(iV) >= 3) {
                    result.add(Arrays.asList(iV, iV, iV, jV));
                }

                if (jV * 3 + iV == target && counter.get(jV) >= 3) {
                    result.add(Arrays.asList(iV, jV, jV, jV));
                }

                if (iV * 2 + jV * 2 == target && counter.get(jV) >= 2 && counter.get(iV) >= 2) {
                    result.add(Arrays.asList(iV, iV, jV, jV));
                }

                for (int k = j + 1; k < unique.size(); k++) {
                    int kV = unique.get(k);

                    if (iV * 2 + jV + kV == target && counter.get(iV) >= 2) {
                        result.add(Arrays.asList(iV, iV, jV, kV));
                    }

                    if (jV * 2 + iV + kV == target && counter.get(jV) >= 2) {
                        result.add(Arrays.asList(iV, jV, jV, kV));
                    }

                    if (kV * 2 + iV + jV == target && counter.get(kV) >= 2) {
                        result.add(Arrays.asList(iV, jV, kV, kV));
                    }

                    // 4 sum
                    int repair = target - iV - jV - kV;
                    if (repair > kV && counter.getOrDefault(repair, 0) > 0) {
                        result.add(Arrays.asList(iV, jV, kV, repair));
                    }
                }
            }
        }
        return result;
    }
}
