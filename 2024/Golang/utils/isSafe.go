package utils

import (

)

func IsSafe(report []int64) bool {
	if len(report) < 2 {
		return true
	}
	isIncreasing := report[0] < report[1]

	for i := 0; i < len(report) - 1; i++ {
		difference := abs(report[i] - report[i + 1])
		if difference > 3 || difference < 1 {
			return false
		}
		if (isIncreasing && report[i] >= report[i + 1]) || (!isIncreasing && report[i] <= report[i + 1]) {
			return false
		}
	}
	return true
}

func abs(n int64) int64 {
    if n < 0 {
        return -n
    }
    return n
}