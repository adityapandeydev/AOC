import re

sum = 0
pattern = r'mul\(\d{1,3},\d{1,3}\)'
file = open("2024/Input/day3.txt")
for line in file:
    line = re.findall(pattern, line)
    line = "".join(line)
    line = re.findall(r'\(\d{1,3},\d{1,3}\)', line)
    for numbers in line:
        numbers = numbers[1:len(numbers) - 1]
        firstNumber = numbers.split(',')[0]
        secondNumber = numbers.split(',')[1]
        sum = sum + (int(firstNumber) * int(secondNumber))
print(sum)