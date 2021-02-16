package list

import "golang/common/api/model"

func JosephRingByList(startK, outM, totalN int) []int {
    var result []int

    // 0. refine startK
    if startK < 1 {
        startK = 1
    }

    // 1. create circle list
    head := &model.ListNode{} // head do not contain data
    dummyNode := head
    model.CreateCircleNode(head, dummyNode, totalN)

    // 2. re-calculate JosephRing sequence
    // 2.1 handle the startK issue
    head = head.Next
    for startK != 1 {
        head = head.Next
        startK--
    }

    // 2.2 handle the sequence issue
    count := 1
    for head.Next != head {
        // handle m out when in m-1 location: remove m node and add m.Val to result then set count to zero.
        if count == outM-1 {
            result = append(result, head.Next.Val)
            head.Next = head.Next.Next
            count = 1
        } else {
            count++
        }
        // import
        head = head.Next
    }

    // 2.2 last element
    result = append(result, head.Val)

    return result
}

// f[i]= (f[i-1] + m) % i; (1<i<=n)
func JosephRingByMath(outM, totalN int) int {
    if totalN <= 1 || outM <= 0 {
        return -1
    }

    last := 0
    for i := 2; i <= totalN; i++ {
        last = (last + outM) % i
    }

    return last + 1
}
