package test

import (
    "fmt"
    "golang/medium/leetcode/array"
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
