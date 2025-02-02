def isSafe(report):
    left = report[0]
    right = report[1]
    isIncreasing = right > left
    for i in range(len(report) - 1):
        left = report[i]
        right = report[i + 1]
        difference = abs(right - left) >= 1 and abs(right - left) <= 3
        if isIncreasing and left > right:
            return False
        elif not isIncreasing and right > left:
            return False
        elif not difference:
            return False
    return True

count = 0;
report = []
file = open("2024/Input/day2.1.txt", "r")
for line in file:
    line = line.strip()
    report = list(map(int, line.split(" ")))
    if isSafe(report):
        count = count + 1
print(count)        