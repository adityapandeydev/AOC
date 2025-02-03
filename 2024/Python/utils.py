def isSafe(report):
    if len(report) < 2:
        return True

    left = report[0]
    right = report[1]
    isIncreasing = right > left

    for i in range(len(report) - 1):
        left = report[i]
        right = report[i + 1]
        difference = 1 <= abs(right - left) <= 3

        if (isIncreasing and left > right) or (not isIncreasing and right > left) or not difference:
            return False

    return True
