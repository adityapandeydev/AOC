import utils

count = 0;
report = []
file = open("2024/Input/day2.1.txt", "r")
for line in file:
    line = line.strip()
    report = list(map(int, line.split(" ")))
    if utils.isSafe(report):
        count = count + 1
print(count)        