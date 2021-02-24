package utils

func Abs(v int) int {
    if v < 0 {
        return -v
    }

    return v
}

func Max(a, b int) int {
    if a < b {
        return b
    }

    return a
}

func Min(a, b int) int {
    if a < b {
        return a
    }

    return b
}
