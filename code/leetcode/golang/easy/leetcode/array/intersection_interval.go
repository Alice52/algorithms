package array

import (
    "golang/common/api/model"
    "golang/common/api/utils"
)

// issue-link: https://github.com/Alice52/Algorithms/issues/34
// each list of intervals is pairwise disjoint and in sorted order
//  1. 左边界为: start := max(A[i].Start, B[j].Start)
//  2. 右边界为: end := min(A[i].End, B[j].End) ，
//  3. 如果 start <= end, 那么这个就是⼀个满⾜条件的交集, 放⼊最终数组中
//  4. 如果 A[i].End <= B[j].End, 代表 B 数组范围⽐ A 数组⼤, A 的游标右移
//  5. 如果 A[i].End > B[j].End, 代表 A 数组范围⽐ B 数组⼤, B 的游标右移
func IntervalIntersection(a, b [][]int) [][]int {
    var result [][]int
    for i, j := 0, 0; i < len(a) && j < len(b); {
        start := utils.Max(a[i][0], b[j][0])
        end := utils.Min(a[i][1], b[j][1])

        if start <= end {
            result = append(result, []int{start, end})
        }

        if a[i][1] <= b[j][1] {
            i++
        } else {
            j++
        }
    }

    return result
}

func IntervalIntersectionII(a []model.Interval, b []model.Interval) []model.Interval {

    var result []model.Interval
    for i, j := 0, 0; i < len(a) && j < len(b); {
        start := utils.Max(a[i].Start, b[j].Start)
        end := utils.Min(a[i].End, b[j].End)

        if start <= end {
            result = append(result, model.Interval{Start: start, End: end})
        }

        if a[i].End <= b[j].End {
            i++
        } else {
            j++
        }
    }

    return result
}
