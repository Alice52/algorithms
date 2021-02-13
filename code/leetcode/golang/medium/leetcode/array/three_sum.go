package array

import "sort"

// issue-linked: https://github.com/Alice52/Algorithms/issues/9

// Timing: O(n^3)
// Core thinking:
//    1. sort origin nums
//    2. two-point to closest from start[i+1] and end
//    3. deduplicate when outer loop of i and inner loop of increase or decrease ptr
func ThreeSum(nums []int) [][]int {
    var result [][]int
    size := len(nums)

    if size <= 2 {
        return nil
    }
    sort.Ints(nums)
    for i := 0; i < size; i++ {

        firPtr, lastPtr, repair := i+1, size-1, -nums[i]
        // 1. deduplicate
        if i > 0 && nums[i-1] == nums[i] {
            continue
        }

        for ; firPtr < lastPtr; {
            if nums[firPtr]+nums[lastPtr] == repair {
                result = append(result, []int{nums[i], nums[firPtr], nums[lastPtr]})
                // 2. deduplicate
                firPtr++
                lastPtr--
                for ; firPtr < lastPtr && nums[firPtr-1] == nums[firPtr]; {
                    firPtr++
                }
                for ; firPtr < lastPtr && nums[lastPtr] == nums[lastPtr+1]; {
                    lastPtr--
                }
            } else if nums[firPtr]+nums[lastPtr] > repair {
                lastPtr--
            } else {
                firPtr++
            }
        }
    }

    return result
}

// poor performance than ThreeSum by testing
func ThreeSumPractice(nums []int) [][]int {
    var result [][]int
    counter := map[int]int{}
    var unique []int

    for _, value := range nums {
        counter[value]++
    }
    for key := range counter {
        unique = append(unique, key)
    }
    sort.Ints(unique)

    for i := 0; i < len(unique); i++ {
        // third
        if unique[i] == 0 && counter[unique[i]] >= 3 {
            result = append(result, []int{0, 0, 0})
        }

        for j := i + 1; j < len(unique); j++ {
            if 2*unique[i]+unique[j] == 0 && counter[unique[i]] >= 2 {
                result = append(result, []int{unique[i], unique[i], unique[j]})
            }

            if 2*unique[j]+unique[i] == 0 && counter[unique[j]] >= 2 {
                result = append(result, []int{unique[i], unique[j], unique[j]})
            }

            c := 0 - unique[i] - unique[j]
            // this need sort
            if c > unique[j] && counter[c] > 0 {
                result = append(result, []int{unique[i], unique[j], c})
            }
        }
    }

    return result
}
