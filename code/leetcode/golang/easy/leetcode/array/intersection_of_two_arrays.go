package array

func Intersection(nums1 []int, nums2 []int) []int {

    var result []int
    m := map[int]bool{}
    for i := 0; i < len(nums1); i++ {
        m[nums1[i]] = true
    }

    for _, num := range nums2 {
        if m[num] {
            result = append(result, num)
            delete(m, num)
        }
    }

    return result
}
