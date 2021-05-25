package leetcode.array;

import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * issue-linked: https://github.com/Alice52/Algorithms/issues/9
 *
 * @author zack <br>
 * @create 2021-02-09 18:32 <br>
 * @project leetcode <br>
 */
@Slf4j
public class SumThree {

    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};

        final List<List<Integer>> results = threeSumBestPractice(nums);
        results.forEach(x -> System.out.println(x));
    }

    /**
     * Core: the difficulty is de-duplicated.<br>
     * Timing: O(n^3)
     *
     * <pre>
     *    thinking:
     *        1. sort + two-point closest
     *        2. 找到满足的之后把f,s值相同的都去掉
     *        2. nums[firPr] + nums[secPr] < -baseVal
     * </pre>
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);

        final int size = nums.length;
        if (nums == null || nums.length <= 2 || nums[0] > 0 || nums[size - 1] < 0) {
            return results;
        }

        for (int i = 0; i < size - 2; i++) {
            // 1. 找到满足的之后把f,s值相同的都去掉
            if (i >= 1 && nums[i - 1] == nums[i]) {
                continue;
            }

            int baseVal = nums[i];
            // first-point: i++'s value; second-point: last-index's value
            int secPr = size - 1;
            int firPr = i + 1;

            while (secPr > firPr) {
                // 2. 找到满足的之后把f,s值相同的都去掉: [-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6]
                if (nums[firPr] + baseVal + nums[secPr] == 0) {
                    results.add(Arrays.asList(baseVal, nums[firPr], nums[secPr]));
                    while (firPr < secPr && nums[firPr] == nums[++firPr]) {}
                    while (firPr < secPr && nums[secPr] == nums[--secPr]) {}
                }
                // 3. move point according to baseVal
                else if (nums[firPr] + nums[secPr] < -baseVal) {
                    firPr++;
                } else {
                    secPr--;
                }
            }
        }

        return results;
    }

    /**
     * counter: 放每个元素出现的此时 <br>
     * unique: unique 元素 <br>
     * core: 元素被使用的次数
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSumBestPractice(int[] nums) {
        Assert.notNull(nums);

        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        HashMap<Integer, Integer> counter = new HashMap<>(size);

        Arrays.stream(nums)
                .forEach(
                        num -> {
                            counter.compute(
                                    num,
                                    (k, v) -> {
                                        Integer val = Optional.ofNullable(v).orElse(0);
                                        return ++val;
                                    });
                        });

        final List<Integer> unique = counter.keySet().stream().collect(Collectors.toList());

        unique.sort(Integer::compareTo);

        // calculate
        for (int i = 0; i < unique.size(); i++) {
            // third
            if (unique.get(i) == 0 && counter.get(0) >= 3) {
                result.add(Arrays.asList(0, 0, 0));
            }

            for (int j = i + 1; j < unique.size(); j++) {
                // twice
                if (2 * unique.get(i) + unique.get(j) == 0 && counter.get(unique.get(i)) >= 2) {
                    result.add(Arrays.asList(unique.get(i), unique.get(i), unique.get(j)));
                }

                if (2 * unique.get(j) + unique.get(i) == 0 && counter.get(unique.get(j)) >= 2) {
                    result.add(Arrays.asList(unique.get(i), unique.get(j), unique.get(j)));
                }

                // once
                int repair = 0 - unique.get(i) - unique.get(j);
                if (repair > unique.get(j) && counter.getOrDefault(repair, 0) > 0) {
                    result.add(Arrays.asList(unique.get(i), unique.get(j), repair));
                }
            }
        }

        return result;
    }
}
