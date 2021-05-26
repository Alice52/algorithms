package test

import (
    "fmt"
    "golang/easy/leetcode/array"
    "golang/easy/leetcode/array/_0026"
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

func TestIntervalIntersection(t *testing.T) {

    result := array.IntervalIntersection([][]int{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
        [][]int{{1, 5}, {8, 12}, {15, 24}, {25, 26}})
    fmt.Printf("intersection ii is: %v\n", result)
}

func TestDuplicateJudgeLessSpecifiedCount(t *testing.T) {

    result := array.DuplicateJudgeLessSpecifiedCount([]int{1, 1, 1, 3}, 3)
    fmt.Printf("duplicate judge less specified count: %v\n", result)
}

func TestContainsNearbyDuplicate(t *testing.T) {

    result := array.ContainsNearbyDuplicate([]int{1, 2, 3, 1, 2, 3}, 2)
    fmt.Printf("contains nearby duplicate: %v\n", result)
}


func TestDeDuplicateAll(t *testing.T) {

    result := _0026.DeDuplicateAll([]int{1, 2, 3, 1, 2, 3})
    fmt.Printf("deduplicate elemnet count: %v\n", result)
}
