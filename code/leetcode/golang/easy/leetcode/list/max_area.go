package list

// link: https://leetcode.com/problems/container-with-most-water/
func MaxArea(nums []int) int {
    size := len(nums)
    firstIndex, lastIndex := 0, size-1
    width, high, tempMaxArea := 0, 0, 0

    for i := 0; i < size && (lastIndex > firstIndex); i++ {
        width = lastIndex - firstIndex

        // 01. judgement
        if nums[firstIndex] < nums[lastIndex] {
            high = nums[firstIndex]
            firstIndex++
        } else {
            high = nums[lastIndex]
            lastIndex--
        }

        // 02. calculate
        if width*high > tempMaxArea {
            tempMaxArea = width * high
        }
    }

    return tempMaxArea
}
