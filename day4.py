def part1(left, right):
    result = 0
    
    for i in range(len(left)):
        result += abs(left[i] - right[i])
    
    return result

def part2(left, right):
    result = 0
    
    for i in range(len(left)):
        counter = 0
        if left[i] in right:
            j = right.index(left[i])
            while right[j] == left[i]:
                counter += 1
                j += 1
            result += left[i] * counter
            counter = 0
    
    return result



with open("inputs/day1.txt", 'r') as f:
    lines = f.readlines()
    
left = list(map(lambda line: int(line.split("   ")[0]), lines))
right = list(map(lambda line: int(line.split("   ")[1]), lines))

left.sort()
right.sort()


print(part1(left, right))
print(part2(left, right))  

