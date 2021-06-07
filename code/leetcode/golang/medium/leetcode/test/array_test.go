package test

import (
    "fmt"
    "golang/medium/leetcode/array"
    "golang/medium/leetcode/array/_0220"
    "testing"
)

func Test(t *testing.T) {

    nums := []int{0, 0, 0, 0}
    result := array.ThreeSum(nums)
    fmt.Printf("result: %v", result)
}

func TestFourSum(t *testing.T) {

    result := array.FourSumV3([]int{0, 1, 5, 0, 1, 5, 5, -4}, 11)

    fmt.Printf("%v", result)
}

func TestFourSumII(t *testing.T) {

    println(array.FourSumII([]int{1, 2},
        []int{-2, -1},
        []int{-1, 2},
        []int{0, 2}))
}

func Test220ContainElement(t *testing.T) {

    println(_0220.ContainsNearbyAlmostDuplicateByBucket([]int{1, 2, 3, 1}, 3, 0))
}
