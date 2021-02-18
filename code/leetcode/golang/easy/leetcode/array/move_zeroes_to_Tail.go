package array

// issue-link: https://github.com/Alice52/Algorithms/issues/26
//   1. 0, finder表示最后结果的所有非 0 元素
//   2. 遍历数组, nums[i] != 0 则交换 finder 和 i 的值, finder 移动一位
func MoveZeroes2Tail(nums []int) []int {
    finder := 0
    for i := 0; i < len(nums); i++ {
        if nums[i] != 0 {
            nums[i], nums[finder] = nums[finder], nums[i]
            finder++
        }
    }

    return nums
}
