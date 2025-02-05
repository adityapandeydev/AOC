package day3

import (
	"bufio"
	"fmt"
	"os"
	"regexp"
	"strconv"
)

func Part2() {
	file, err := os.Open("../Input/day3.txt")
	if err != nil {
		fmt.Println("Error opening file:", err)
		return
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)
	sum := 0
	flag := true
	pattern := regexp.MustCompile(`(do\(\))|(don't\(\))|(mul\((\d+),(\d+)\))`)

	for scanner.Scan() {
		line := scanner.Text()
		matches := pattern.FindAllStringSubmatch(line, -1)

		for _, match := range matches {
			if match[1] != "" { 
				flag = true
			}
			if match[2] != "" { 
				flag = false
			}
			if match[3] != "" && flag { 
				firstNumber, _ := strconv.Atoi(match[4]) 
				secondNumber, _ := strconv.Atoi(match[5]) 
				sum += firstNumber * secondNumber
			}
		}
	}

	fmt.Println(sum)
}