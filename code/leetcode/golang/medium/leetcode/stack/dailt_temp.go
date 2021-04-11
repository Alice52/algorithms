package stack

func DailyTemperatures(T []int) []int {
    res := make([]int, len(T))
    var toCheck []int
    for i, t := range T {
        for len(toCheck) > 0 && T[toCheck[len(toCheck)-1]] < t {
            idx := toCheck[len(toCheck)-1]
            res[idx] = i - idx
            toCheck = toCheck[:len(toCheck)-1]
        }
        toCheck = append(toCheck, i)
    }
    return res
}
