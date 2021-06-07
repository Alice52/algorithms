package _0220

import "golang/common/api/utils"

// function: abs(nums[i] - nums[j]) <= t and abs(i - j) <= k. <br>
// issue-link: https://github.com/Alice52/Algorithms/issues/39<br>
// leetcode-link: https://leetcode.com/problems/contains-duplicate-iii/<br>
func ContainsNearbyAlmostDuplicateV1(nums []int, k int, t int) bool {

    length := len(nums)
    for i := 0; i < length; i++ {
        count := 0
        for j := i + 1; count < k && j < length; j++ {
            if utils.Abs(nums[i]-nums[j]) <= t {
                return true
            }
            count = count + 1
        }
    }

    return false
}

func ContainsNearbyAlmostDuplicateByBucket(nums []int, k int, t int) bool {
    m := map[int]int{}

    for i, x := range nums {
        id := bucketId(x, t+1)
        if _, ok := m[id]; ok {
            return true
        }

        if v, ok := m[id-1]; ok && utils.Abs(x-v) <= t {
            return true
        }

        if v, ok := m[id+1]; ok && utils.Abs(x-v) <= t {
            return true
        }

        m[id] = x
        if i >= k {
            delete(m, bucketId(nums[i-k], t+1))
        }
    }

    return false
}

func bucketId(num int, width int) int {
    if num >= 0 {
        return num / width
    } else {
        return (num+1)/width - 1
    }
}
