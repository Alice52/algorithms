package test

import (
    "golang/common/api/model"
    "golang/interview/list"
    "testing"
)

func TestFlipByRecursion(t *testing.T) {
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

    list.FlipByRecursion(a)
}

func TestFlipByReserve(t *testing.T) {
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
    c := list.ReverseList(a)
    model.PrintListNode(c)
}
