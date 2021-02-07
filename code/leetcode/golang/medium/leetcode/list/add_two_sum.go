package list

import (
    "golang/common/api/model"
)

func AddTwoSum(a *model.ListNode, b *model.ListNode) *model.ListNode {
    if a == nil || b == nil {
        return nil
    }

    dummyHead := &model.ListNode{
        Val:  -1,
        Next: nil,
    }

    carry := 0
    for a != nil || b != nil || carry != 0 || carry != 0 {
        tempSum := carry
        // judge then work
        if a != nil {
            tempSum += a.Val
            a = a.Next
        }
        if b != nil {
            tempSum += b.Val
            b = b.Next
        }
        carry = tempSum / 10

        // core: dummyHead -> A => dummyHead -> B -> A
        newNode := &model.ListNode{
            Val:  tempSum % 10,
            Next: nil,
        }
        newNode.Next = dummyHead.Next
        dummyHead.Next = newNode
    }

    return dummyHead.Next
}
