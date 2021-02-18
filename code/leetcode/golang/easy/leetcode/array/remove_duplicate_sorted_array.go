package array

// issue-link: https://github.com/Alice52/Algorithms/issues/18
func RemoveDuplicateOfSortedArray(nums []int) int {

    size := len(nums)
    if size <= 1 {
        return size
    }

    finder := 0
    for i := 1; i < size; i++ {
        if nums[i] != nums[finder] {
            finder++
            nums[finder] = nums[i]
        }
    }

    // fmt.Printf("nums is: %v\n", nums)

    return finder + 1
}
