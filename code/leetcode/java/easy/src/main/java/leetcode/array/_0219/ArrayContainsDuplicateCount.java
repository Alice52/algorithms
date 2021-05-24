package leetcode.array._0219;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * issue-link: https://github.com/Alice52/Algorithms/issues/65 <br>
 * leetcode-link: N/A <br>
 *
 * @author zack <br>
 * @create 2021-02-25 10:30 <br>
 * @project leetcode <br>
 */
@Slf4j
public class ArrayContainsDuplicateCount {
    public static void main(String[] args) {
        Optional.of(duplicateJudgeLessSpecifiedCount(new int[] {1, 0, 1, 1}, 1))
                .ifPresent(System.out::println);
    }

    /**
     * 判断有重复出现, 且出现次数小于 count 则返回 true
     *
     * <pre>
     *     1. 遍历数组, 将值和出现次数放入 map
     *     2. 每次放入之后判断出现次数是否大于 count
     *     3. 是, 则返回 false
     *     4. 最后判断 map.size 是否等于 nums.length: 若相等则证明没有重复元素
     * </pre>
     *
     * @param nums
     * @param count
     * @return
     */
    public static boolean duplicateJudgeLessSpecifiedCount(int[] nums, int count) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (k, v) -> v == null ? 1 : ++v);
            if (map.getOrDefault(num, 0) >= count) {
                return false;
            }
        }

        return map.size() != nums.length;
    }
}
