package array

import (
    "golang/common/api/utils"
    "math"
    "sort"
)

// issue-link: https://github.com/Alice52/Algorithms/issues/13
// core thinking:
//    1. diff is abs of target and current value to handle the gt&lt issue.
//    2. move ptr and re-calculate diff are two different things.
func ThreeSumClosest(nums []int, target int) int {
    result, size, diff := 0, len(nums), math.MaxInt32

    if size < 2 {
        return result
    }

    sort.Ints(nums)

    for i := 0; i < size-2; i++ {
        for j, k := i+1, size-1; j < k; {
            sum := nums[i] + nums[j] + nums[k]
            if utils.Abs(sum-target) < diff {
                result = sum
                diff = utils.Abs(sum - target)
            }

            if target == sum {
                return result
            } else if target > sum {
                j++
            } else {
                k--
            }
        }
    }

    return result
}
