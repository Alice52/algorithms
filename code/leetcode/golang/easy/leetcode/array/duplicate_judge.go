package array

import "sort"

// https://github.com/Alice52/Algorithms/issues/37
func JudgeDuplicateBest(nums []int) bool {

    sort.Ints(nums)
    for i := 0; i < len(nums)-1; i++ {
        if nums[i] == nums[i+1] {
            return true
        }
    }

    return false
}

// Deprecated
func JudgeDuplicate(nums []int) bool {
    m := make(map[int]bool)
    for _, num := range nums {
        if m[num] {
            return true
        }
        m[num] = true
    }
    return false
}
