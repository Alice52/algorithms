package list

import "golang/common/api/model"

// issue-link: https://github.com/Alice52/Algorithms/issues/33
// assume the two list must intersect and all of them have no circle.
func GetIntersectionNode(headA, headB *model.ListNode) *model.ListNode {
    // boundary check
    if headA == nil || headB == nil {
        return nil
    }

    aPtr, bPtr := headA, headB
    for aPtr != bPtr {
        if aPtr == nil { // import, to be sure last element participate calculate
            aPtr = headB
        } else {
            aPtr = aPtr.Next
        }

        if bPtr == nil {
            bPtr = headA
        } else {
            bPtr = bPtr.Next
        }
    }

    return bPtr
}
