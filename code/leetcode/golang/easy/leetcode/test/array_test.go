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

func TestRemoveDuplicateOfSortedArray(t *testing.T) {

    result := _array.RemoveDuplicateOfSortedArray([]int{1, 2, 2, 2, 4, 5, 5})
    fmt.Printf("length is: %v\n", result)
}
