package array

import "sort"

// common logic for k sum is target
func FourSumV3(nums []int, target int) [][]int {
    return kSum(nums, target, 0, 4)
}

func kSum(nums []int, target int, start int, k int) [][]int {
    sort.Ints(nums)

    var result = make([][]int, 0)
    size := len(nums)

    if start == size || nums[start]*k > target || target > nums[size-1]*k {
        return result
    }

    if k == 2 {
        return twoSumV2(nums, target, start)
    }

    for i := start; i < size; i++ {
        // de-duplicate
        if i > start && nums[i-1] == nums[i] {
            continue
        }

        for _, v := range kSum(nums, target-nums[i], i+1, k-1) {
            // TODO: cannot understand
            result = append(result, []int{nums[i]})
            result[len(result)-1] = append(result[len(result)-1], v...)
        }
    }

    return result
}

// find all two numbers from start index to end index, which sum is target.
func twoSum(nums []int, target int, start int) [][]int {
    var result [][]int
    hash := make(map[int]int, 10)

    for i := start; i < len(nums); i++ {
        // TODO: cannot understand how to de-duplicate
        if result == nil || result[len(result)-1][1] != nums[i] {
            repair := target - nums[i]
            if hash[repair] > 0 {
                result = append(result, []int{repair, nums[i]})
            }
            hash[nums[i]] = i
        }
    }

    return result
}

// find all two numbers from start index to end index, which sum is target.
func twoSumV2(nums []int, target int, start int) [][]int {
    var result [][]int

    low, high := start, len(nums)-1
    for low < high {
        sum := nums[low] + nums[high]
        // reduce one loop
        if sum > target || (high < len(nums)-1 && nums[high+1] == nums[high]) {
            high--
        } else if sum < target || (low > start+1 && nums[low+1] == nums[low]) {
            low++
        } else {
            result = append(result, []int{nums[low], nums[high]})
            low++
            high--
        }
    }

    return result
}
