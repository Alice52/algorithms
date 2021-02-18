package array

// issue-link: https://github.com/Alice52/Algorithms/issues/19
// Core thinking:
//   1. 与 {@link RemoveDuplicateOfSortedArray 一样的思路, <br>
//   2. 只是新增一个 count 变量记录 finder 下标值的次数: count <= 2 时则 finder 正常移动[即使元素相同]
func RemoveDuplicateOfSortedArrayII(nums []int, repeatedCount int) int {

    size := len(nums)
    if size <= 2 {
        return size
    }

    finder, count := 0, 1
    for i := 1; i < size; i++ {
        if nums[i] != nums[finder] {
            count = 0
        } else {
            if count >= 2 {
                continue
            }
        }
        finder++
        count++
        nums[finder] = nums[i]
    }

    return finder + 1
}
