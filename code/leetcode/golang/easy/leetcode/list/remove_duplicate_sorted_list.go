package list

import "golang/common/api/model"

// issue-link: https://github.com/Alice52/Algorithms/issues/21
func RemoveDuplicateOfSortedList(head *model.ListNode) *model.ListNode {
    if head == nil || head.Next == nil {
        return head
    }

    finder, first := head, head
    for head = head.Next; head != nil; {
        if finder.Val != head.Val {
            finder.Next = head
            finder = finder.Next
        } else {
            finder.Next = head.Next
        }

        head = head.Next
    }

    return first
}
