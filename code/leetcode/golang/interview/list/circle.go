package list

import "golang/common/api/model"

func meetPtrNode(node *model.ListNode) *model.ListNode {
    // 长度为 2 则一定没有环
    slow, fast := node.Next, node.Next.Next
    for slow != nil && fast != nil {
        if slow == fast {
            return slow
        }

        if fast.Next == nil {
            return nil
        }
        slow = slow.Next
        fast = fast.Next.Next
    }

    return nil
}

func JudgeCircle(node *model.ListNode) bool {
    meetPtrNode := meetPtrNode(node)
    if meetPtrNode == nil {
        return false
    }

    return true
}

func GetCircleNode(node *model.ListNode) *model.ListNode {
    slow := meetPtrNode(node)
    if slow == nil {
        return nil
    }

    fast := node
    for fast != slow {
        fast = fast.Next
        slow = slow.Next
    }

    return slow
}

func GetCircleLength(node *model.ListNode) int {
    fast := meetPtrNode(node)
    if fast == nil {
        return 0
    }

    slow, count := fast.Next, 1
    for slow != fast {
        count++
        slow = slow.Next
    }

    return count
}
