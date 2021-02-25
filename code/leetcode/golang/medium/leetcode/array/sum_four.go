package array

import "sort"

// issue-link: https://github.com/Alice52/Algorithms/issues/16

// Core thinking:
//    1. sort origin nums
//    2. two-point to closest from start[j+1] and end
//    3. deduplicate when outer loop of i & j and inner loop of increase or decrease ptr
func FourSumV2(nums []int, target int) [][]int {

    var result [][]int
    size := len(nums)

    if size < 4 {
        return nil
    }
    sort.Ints(nums)

    for i := 0; i < size-3; i++ {
        // 1. de-duplicate
        if i > 0 && nums[i-1] == nums[i] {
            continue
        }

        for j := i + 1; j < size-2; j++ {
            low, high := j+1, size-1
            // 2. de-duplicate
            if j > i+1 && nums[j-1] == nums[j] {
                continue
            }

            for ; low < high; {
                sum := nums[i] + nums[j] + nums[low] + nums[high]
                if target == sum {
                    result = append(result, []int{nums[i], nums[j], nums[low], nums[high]})
                    low++
                    high--
                    // 3. de-duplicate
                    for low < high && nums[low-1] == nums[low] {
                        low++
                    }

                    for low < high && nums[high+1] == nums[high] {
                        high--
                    }

                } else if target > sum {
                    low++
                } else {
                    high--
                }
            }
        }
    }

    return result
}

// issue: poor performance
func FourSum(nums []int, target int) [][]int {
    var res [][]int
    counter := map[int]int{}
    for _, value := range nums {
        counter[value]++
    }
    var uniqNums []int
    for key := range counter {
        uniqNums = append(uniqNums, key)
    }
    sort.Ints(uniqNums)
    for i := 0; i < len(uniqNums); i++ {
        if (uniqNums[i]*4 == target) && counter[uniqNums[i]] >= 4 {
            res = append(res, []int{uniqNums[i], uniqNums[i], uniqNums[i],
                uniqNums[i]})
        }
        for j := i + 1; j < len(uniqNums); j++ {
            if (uniqNums[i]*3+uniqNums[j] == target) && counter[uniqNums[i]] > 2 {
                res = append(res, []int{uniqNums[i], uniqNums[i], uniqNums[i],
                    uniqNums[j]})
            }
            if (uniqNums[j]*3+uniqNums[i] == target) && counter[uniqNums[j]] > 2 {
                res = append(res, []int{uniqNums[i], uniqNums[j], uniqNums[j],
                    uniqNums[j]})
            }
            if (uniqNums[j]*2+uniqNums[i]*2 == target) && counter[uniqNums[j]] > 1 && counter[uniqNums[i]] > 1 {
                res = append(res, []int{uniqNums[i], uniqNums[i], uniqNums[j],
                    uniqNums[j]})
            }
            for k := j + 1; k < len(uniqNums); k++ {
                if (uniqNums[i]*2+uniqNums[j]+uniqNums[k] == target) &&
                    counter[uniqNums[i]] > 1 {
                    res = append(res, []int{uniqNums[i], uniqNums[i], uniqNums[j],
                        uniqNums[k]})
                }
                if (uniqNums[j]*2+uniqNums[i]+uniqNums[k] == target) &&
                    counter[uniqNums[j]] > 1 {
                    res = append(res, []int{uniqNums[i], uniqNums[j], uniqNums[j],
                        uniqNums[k]})
                }
                if (uniqNums[k]*2+uniqNums[i]+uniqNums[j] == target) &&
                    counter[uniqNums[k]] > 1 {
                    res = append(res, []int{uniqNums[i], uniqNums[j], uniqNums[k],
                        uniqNums[k]})
                }
                c := target - uniqNums[i] - uniqNums[j] - uniqNums[k]
                if c > uniqNums[k] && counter[c] > 0 {
                    res = append(res, []int{uniqNums[i], uniqNums[j], uniqNums[k], c})
                }
            }
        }
    }
    return res

}
