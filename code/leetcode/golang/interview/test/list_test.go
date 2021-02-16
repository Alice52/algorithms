package test

import (
    "fmt"
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

func Test(t *testing.T) {
    node1 := &model.ListNode{
        Val:  1,
        Next: nil,
    }

    node2 := &model.ListNode{
        Val:  2,
        Next: nil,
    }

    node3 := &model.ListNode{
        Val:  3,
        Next: nil,
    }
    node4 := &model.ListNode{
        Val:  4,
        Next: nil,
    }
    node5 := &model.ListNode{
        Val:  5,
        Next: nil,
    }
    node6 := &model.ListNode{
        Val:  6,
        Next: nil,
    }

    node1.Next = node2
    node2.Next = node3
    node3.Next = node4
    node4.Next = node5
    node5.Next = node6
    node6.Next = node2

    fmt.Printf("node contains circle: %v", list.JudgeCircle(node1))
    fmt.Println()
    fmt.Printf("node circle node value: %v", list.GetCircleNode(node1).Val)
    fmt.Println()
    fmt.Printf("node circle length: %v", list.GetCircleLength(node1))
    fmt.Println()
}
