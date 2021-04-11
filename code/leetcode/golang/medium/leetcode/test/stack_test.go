package test

import (
    "fmt"
    "golang/medium/leetcode/stack"
    "testing"
)




func TestDailyTemperatures(t *testing.T) {
    nums := []int{73, 74, 75, 71, 69, 72, 76, 73}
    result := stack.DailyTemperatures(nums)
    fmt.Println(result)
}
