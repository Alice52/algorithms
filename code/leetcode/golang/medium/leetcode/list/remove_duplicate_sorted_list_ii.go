package list

import "golang/common/api/model"

// issue-link: https://github.com/Alice52/Algorithms/issues/20
func RemoveDuplicateOfSortedListII(head *model.ListNode) *model.ListNode {

    finder := &model.ListNode{
        Val:  0,
        Next: head,
    }
    first := finder

    for head != nil {
        if head.Next != nil && head.Next.Val == head.Val {
            for head.Next != nil && head.Val == head.Next.Val {
                head = head.Next
            }
            finder.Next = head.Next
        } else {
            // finder.Next is unique
            finder = finder.Next
        }

        head = head.Next
    }

    return first.Next
}
