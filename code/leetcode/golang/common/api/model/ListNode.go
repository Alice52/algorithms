package model

import "fmt"

// singly-linked
type ListNode struct {
    Val  int
    Next *ListNode
}

func PrintListNode(node *ListNode) {
    for node.Next != nil {
        fmt.Println(node.Val)
        node = node.Next
    }
    fmt.Println(node.Val)
}

func CreateCircleNode(head *ListNode, dummyNode *ListNode, totalN int) {
    for i := 1; i <= totalN; i++ {
        node := &ListNode{
            Val:  i,
            Next: nil,
        }
        dummyNode.Next = node
        dummyNode = node
    }

    dummyNode.Next = head.Next
}
