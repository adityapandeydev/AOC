import re

sum = 0
pattern = r'do\(\)|don\'t\(\)|mul\(\d{1,3},\d{1,3}\)'
file = open("2024/Input/day3.txt")
flag = True
for line in file:
    line = re.findall(pattern, line)
    line = "".join(line)
    line = re.findall(r'do\(\)|don\'t\(\)|\(\d{1,3},\d{1,3}\)', line)
    for numbers in line:
        if numbers == "do()":
            flag = True
            continue
        if numbers == "don't()":
            flag = False
            continue
        if flag:
            numbers = numbers[1:len(numbers) - 1]
            firstNumber = numbers.split(',')[0]
            secondNumber = numbers.split(',')[1]
            sum = sum + (int(firstNumber) * int(secondNumber))
print(sum)