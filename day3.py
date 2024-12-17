import re

with open("inputs/day3.txt", 'r') as f:
    lines = f.readlines()
    



def part1():
    result = 0
    
    for line in lines:
        operations = re.findall(r"mul\(\d{1,3},\d{1,3}\)", line)
        
        for mul in operations:
            result += int(mul[4:-1].split(",")[0])*int(mul[4:-1].split(",")[1])
    
    
    return result



def part2():
    result = 0
    able = True
    
    for line in lines:
        operations = re.findall(r"mul\(\d{1,3},\d{1,3}\)|do(?:n't)?\(\)", line)
        
        for operation in operations:
            if "don't()" in operation: able = False
            elif "do()" in operation: able = True 
            elif "mul" in operation and able: result += int(operation[4:-1].split(",")[0])*int(operation[4:-1].split(",")[1])
    
    return result
    
print(part1())
print(part2())  

