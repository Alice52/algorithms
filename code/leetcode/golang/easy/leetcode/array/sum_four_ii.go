package array

// issue-link: https://github.com/Alice52/Algorithms/issues/17
func FourSumII(a []int, b []int, c []int, d []int) int {

    count := 0
    m := make(map[int]int, len(a)+len(b))
    for _, i := range a {
        for _, j := range b {
            m[i+j]++
        }
    }

    for _, k := range c {
        for _, l := range d {
            count += m[-k-l]
        }
    }

    return count
}
