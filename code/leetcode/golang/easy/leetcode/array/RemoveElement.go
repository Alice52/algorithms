package array

// issue-link: https://github.com/Alice52/Algorithms/issues/25
func RemoveElement(nums []int, target int) int {
    finder := 0
    for i := 0; i < len(nums); i++ {
        if nums[i] != target {
            nums[target] = nums[i]
            finder++
        }
    }

    return finder + 1
}
