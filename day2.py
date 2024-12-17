import copy


with open("inputs/day2.txt", 'r') as f:
    lines = f.readlines()
    
reports = [[int(item) for item in report] for report in list(map(lambda line: line.split(), lines))]

def check_safety(report):
    trend = report[0] - report[1]
    if trend < 0:
        for j in range(1, len(report)):
            if report[j-1] - report[j] in range(-3, 0):
                continue
            else:
                return False
        return True
    elif trend > 0:
        for j in range(1, len(report)):
            if report[j-1] - report[j] in range(1, 4):
                continue
            else:
                return False
        return True

def part1():
    result = 0
    
    for report in reports:
        if check_safety(report): result += 1
    
    return result



def part2():
    result = 0
    for report in reports:
        if check_safety(report): result += 1
        else:
            for j in range(len(report)):
                report_wihout_item = copy.deepcopy(report)
                report_wihout_item.pop(j)
                if check_safety(report_wihout_item): 
                    result += 1
                    break
    
    return result
    
print(part1())
print(part2())  

