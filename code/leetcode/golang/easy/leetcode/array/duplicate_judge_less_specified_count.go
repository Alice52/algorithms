package array

// issue-link: https://github.com/Alice52/Algorithms/issues/65
// 判断有重复出现, 且出现次数小于 count 则返回 true
func DuplicateJudgeLessSpecifiedCount(nums []int, count int) bool {
    m := make(map[int]int)
    for _, num := range nums {
        m[num]++
        if m[num] >= count {
            return false
        }
    }

    return len(m) != len(nums)
}
