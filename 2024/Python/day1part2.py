array1 = []
map = {}
file = open("2024/Input/day1.1.txt", "r")
for line in file:
    array1.append(int(line.split(" ")[0]))
    key = int(line.split(" ")[3])
    if key in map.keys():
        map[key] = map.get(key, 0) + 1
    else:
        map[key] = 1

sum = 0
for i in range(len(array1)):
    if array1[i] in map.keys():
        sum += array1[i] * map.get(array1[i])

print(sum)