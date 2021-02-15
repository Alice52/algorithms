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
