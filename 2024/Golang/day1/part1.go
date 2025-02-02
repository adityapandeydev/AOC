package day1

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
	"math"
	"Golang/utils"
)

func Part1() {
    var array1 []int
	var array2 []int
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
		array2 = append(array2, temp)
	}
	if err := scanner.Err(); err != nil {
		fmt.Println("Error reading file:", err)
	}

	sort.Ints(array1)
	sort.Ints(array2)

	sum := 0
	for i := 0; i < len(array1); i++ {
		sum += int(math.Abs(float64(array1[i] - array2[i])))
	}
	fmt.Println(sum)
}