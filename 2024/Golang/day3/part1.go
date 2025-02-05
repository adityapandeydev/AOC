package day3

import (
	"Golang/utils"
	"bufio"
	"fmt"
	"os"
	"regexp"
	"strconv"
	"strings"
)

func Part1() {
	sum := 0
	file, err := os.Open("../Input/day3.txt")
	utils.Check(err)
	defer file.Close()

	scanner := bufio.NewScanner(file)
	pattern1 := regexp.MustCompile(`(mul\(\d{1,3},\d{1,3}\))|.`)
	pattern2 := regexp.MustCompile(`(\(\d{1,3},\d{1,3}\))|.`)

	for scanner.Scan() {
		line := scanner.Text()
		line = pattern1.ReplaceAllStringFunc(line, func(match string) string {
			if pattern1.MatchString(match) {
				subMatches := pattern1.FindStringSubmatch(match)
				if subMatches[1] != "" {
					return subMatches[1]
				}
			}
			return ""
		})

		line = pattern2.ReplaceAllStringFunc(line, func(match string) string {
			if pattern2.MatchString(match) {
				subMatches := pattern2.FindStringSubmatch(match)
				if subMatches[1] != "" {
					return subMatches[1] 
				}
			}
			return "" 
		})

		i := 0;
		for j := 0; j < len(line); j++ {
			if line[j] == ')' {
				firstNumber, _:= strconv.Atoi(strings.Split(line[i+1:j], ",")[0])
				secondNumber, _:= strconv.Atoi(strings.Split(line[i+1:j], ",")[1])
				sum += firstNumber * secondNumber
				i = j + 1
			}
		}
	}
	fmt.Println(sum)
}