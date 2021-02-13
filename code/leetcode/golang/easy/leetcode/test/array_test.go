package test

import (
    "fmt"
    _array "golang/easy/leetcode/array"
    "testing"
)

func TestHello(t *testing.T) {
    _array.Hello()
}

func TestTwoSum(t *testing.T) {

    result := _array.TwoSum(
        []int{2, 7, 11, 15},
        26,
    )

    if result != nil {
        fmt.Printf("index is: %v", result)
    } else {
        fmt.Printf("cannot find index")
    }
}
