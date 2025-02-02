package day2

import (
	"Golang/utils"
	"bufio"
	"fmt"
	"os"
	"strings"
)

func Part1() {
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
		}
	}
	fmt.Println(count)
}