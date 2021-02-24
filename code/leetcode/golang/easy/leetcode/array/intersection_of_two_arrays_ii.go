package array

// issue-link: https://github.com/Alice52/Algorithms/issues/32
//  1. 遍历 nums1, 将值和出现次数记录到 map
//  2. 遍历 nums2, 如果该值存在于 map 中[count>0], 则将其放入结果并对出现次数减一
func IntersectionII(nums1 []int, nums2 []int) []int {

    var result []int
    m := map[int]int{}
    for _, num := range nums1 {
        m[num]++
    }

    for _, num := range nums2 {
        if m[num] != 0 {
            result = append(result, num)
            m[num]--
        }
    }

    return result
}
