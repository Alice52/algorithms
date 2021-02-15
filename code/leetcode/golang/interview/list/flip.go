package list

import (
    "fmt"
    "golang/common/api/model"
)

func FlipByRecursion(node *model.ListNode) {
    if node.Next != nil {
        FlipByRecursion(node.Next)
    }
    fmt.Println(node.Val)
}


func ReverseList(head *model.ListNode) *model.ListNode {
    cur := head
    var pre *model.ListNode = nil
    for cur != nil {
        pre, cur, cur.Next = cur, cur.Next, pre
    }
    return pre
}
