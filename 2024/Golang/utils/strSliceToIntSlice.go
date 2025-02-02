package utils

import (
	"strconv"
)

func StrSliceToIntSlice(strs []string) ([]int64, error) {
	nums := make([]int64, len(strs))
	for i, s := range strs {
		n, err := strconv.ParseInt(s, 10, 64)
		if err != nil {
			return nil, err
		}
		nums[i] = n
	}
	return nums, nil
}
