package test

import (
    "fmt"
    "golang/easy/leetcode/array"
    "testing"
)

func TestHello(t *testing.T) {
    array.Hello()
}

func TestTwoSum(t *testing.T) {

    result := array.TwoSum(
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

    result := array.RemoveDuplicateOfSortedArray([]int{1, 2, 2, 2, 4, 5, 5})
    fmt.Printf("length is: %v\n", result)
}

func TestRemoveDuplicateOfSortedArrayII(t *testing.T) {

    result := array.RemoveDuplicateOfSortedArrayII([]int{1, 2, 2, 2, 4, 5, 5}, 2)
    fmt.Printf("length is: %v\n", result)
}

func TestMoveZeroes2Tail(t *testing.T) {

    result := array.MoveZeroes2Tail([]int{1, 2, 0})
    fmt.Printf("nums is: %v\n", result)
}

func TestIntersection(t *testing.T) {

    result := array.Intersection([]int{1, 2, 2, 3}, []int{2, 2})
    fmt.Printf("intersection is: %v\n", result)
}

func TestIntersectionII(t *testing.T) {

    result := array.IntersectionII([]int{4, 9, 5}, []int{9, 4, 9, 8, 4})
    fmt.Printf("intersection ii is: %v\n", result)
}
