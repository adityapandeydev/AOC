package day2

import (
	"Golang/utils"
	"bufio"
	"fmt"
	"os"
	"strings"
)

func Part2() {
	count := 0
	file, err := os.Open("../Input/day2.1.txt")
	utils.Check(err)
	defer file.Close()

	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		line := scanner.Text()
		numbers := strings.Split(line, " ")
		report, err := utils.StrSliceToIntSlice(numbers)
		if err != nil {
			fmt.Println("Error parsing numbers:",err)
			continue
		}

		if utils.IsSafe(report) {
			count++
		} else {
			for i := 0; i < len(report); i++ {
				unsafeReports := append([]int64{}, report[:i]...)
				unsafeReports = append(unsafeReports, report[i + 1:]...)
				if utils.IsSafe(unsafeReports) {
					count++
					break
				}
			}
		}
	}
	fmt.Println(count)
}