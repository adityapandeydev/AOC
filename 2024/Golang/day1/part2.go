package day1

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
	"Golang/utils"
)

func Part2() {
    var array1 []int
	map1 := make(map[int]int)
	file, err := os.Open("../Input/day1.1.txt")
	utils.Check(err)
	defer file.Close()

	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		line := scanner.Text()
		temp, err := strconv.Atoi(strings.Split(line, " ")[0])
		utils.Check(err)
		array1 = append(array1, temp)
		temp, err = strconv.Atoi(strings.Split(line, " ")[3])
		utils.Check(err)
		map1[temp]++
	}
	if err := scanner.Err(); err != nil {
		fmt.Println("Error reading file:", err)
	}

	sum := 0
	for i := 0; i < len(array1); i++ {
		if _, exists := map1[array1[i]]; exists {
			sum += array1[i] * map1[array1[i]]
		}
	}
	fmt.Println(sum)
}