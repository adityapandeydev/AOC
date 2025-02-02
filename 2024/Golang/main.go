package main

import (
    "fmt"
    "os"
	"Golang/day1"
	"Golang/day2"
)

func main() {
    if len(os.Args) < 2 {
        fmt.Println("Please specify a day and part (e.g., go run main.go day1part1)")
        return
    }

    dayPart := os.Args[1]
    switch dayPart {
    case "day1part1":
        fmt.Println("Running Day 1, Part 1")
        day1.Part1()
    case "day1part2":
        fmt.Println("Running Day 1, Part 2")
        day1.Part2()
    case "day2part1":
        fmt.Println("Running Day 2, Part 1")
        day2.Part1()
    default:
        fmt.Println("Invalid day/part specified")
    }
}
