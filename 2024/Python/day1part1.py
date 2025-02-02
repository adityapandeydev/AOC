array1 = []
array2 = []
file = open("2024/Input/day1.1.txt", "r")
for line in file:
    array1.append(int(line.split(" ")[0]))
    array2.append(int(line.split(" ")[3]))
array1.sort()
array2.sort()

sum = 0
for i in range(len(array1)):
    sum += abs(array1[i] - array2[i])

print(sum)