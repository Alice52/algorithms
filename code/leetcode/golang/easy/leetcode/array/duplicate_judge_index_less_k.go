package array

// issue-link: https://github.com/Alice52/Algorithms/issues/38
// 如果数组⾥⾯有重复数字, 并且重复数字的下标差值的最大值⼩于等于 K 就输出 true
//   1. 反向思维: 考虑找到为 false 的情况
//   2. 没有重复数字返回 false, 重复元素最大差距大于 K 返回 false
func DuplicateJudgeIndexLessK(nums []int, k int) bool {

    m := make(map[int]int)
    for i := 0; i < len(nums); i++ {
        oldIndex, ok := m[nums[i]]
        if !ok {
            m[nums[i]] = i
        } else if i-oldIndex > k {
            return false
        }
    }

    return len(m) != len(nums)
}

// 判断数组中是否存在两个不同的索引 i 和 j, 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k<br>
//   1. 最近的两个相同元素下标差值小于等于 K 则返回 true
func ContainsNearbyDuplicate(nums []int, k int) bool {

    m := make(map[int]int)
    for index, value := range nums {
        if nearIndex, ok := m[value]; ok {
            if index-nearIndex <= k {
                return true
            }
        }

        m[value] = index
    }

    return false
}
