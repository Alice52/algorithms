package _0026

import "sort"

// https://github.com/Alice52/Algorithms/issues/73

// 1. 和前一个不同, 且和后一个不同就是唯一的元素
// 2. 考虑首尾元素的问题
func DeDuplicateAll(nums []int) int {
    sort.Ints(nums)
    length := len(nums)
    if len(nums) < 2 {
        return length
    }

    finder := -1
    if nums[0] != nums[1] {
        finder = finder + 1
    }

    for i := 1; i < length-1; i++ {
        if nums[i-1] != nums[i] && nums[i] != nums[i+1] {
            finder = finder + 1
            nums[finder] = nums[i]
        }
    }

    if nums[length-1] != nums[length-2] {
        finder = finder + 1
        nums[finder] = nums[length-1]
    }

    return finder + 1
}
