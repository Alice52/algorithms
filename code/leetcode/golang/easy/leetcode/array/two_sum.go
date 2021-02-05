package array

func TwoSum(nums []int, target int) []int {
	// build map to store: key is num element, and value is index
	m := make(map[int]int, 10)
	for i, v := range nums {
		if repairIndex, ok := m[target-v]; ok {
			return []int{repairIndex, i}
		} else {
			m[v] = i
		}
	}

	return nil
}
