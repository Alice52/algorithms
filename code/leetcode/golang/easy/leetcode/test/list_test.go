package test

import (
    "fmt"
    "golang/common/api/model"
    _list "golang/easy/leetcode/list"
    "testing"
)

func TestAddTwoSum(t *testing.T) {
    
    a := &model.ListNode{
        Val: 2,
        Next: &model.ListNode{
            Val: 4,
            Next: &model.ListNode{
                Val:  3,
                Next: nil,
            },
        },
    }
    
    b := &model.ListNode{
        Val: 5,
        Next: &model.ListNode{
            Val: 6,
            Next: &model.ListNode{
                Val:  4,
                Next: nil,
            },
        },
    }
    
    result := _list.AddTwoSum(a, b)
    for result != nil {
        fmt.Print(result.Val)
        result = result.Next
    }
    
    fmt.Println()
    
    a2 := &model.ListNode{
        Val: 9,
        Next: &model.ListNode{
            Val: 9,
            Next: &model.ListNode{
                Val:  9,
                Next: nil,
            },
        },
    }
    
    b2 := &model.ListNode{
        Val:  1,
        Next: nil,
    }
    
    result2 := _list.AddTwoSum(a2, b2)
    for result2 != nil {
        fmt.Print(result2.Val)
        result2 = result2.Next
    }
}
