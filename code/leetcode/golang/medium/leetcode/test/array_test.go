package test

import (
    "fmt"
    "golang/medium/leetcode/array"
    "testing"
)

func Test(t *testing.T) {

    nums := []int{-2, 0, 1, 1, 2}
    result := array.ThreeSum(nums)
    fmt.Printf("result: %v", result)
}
