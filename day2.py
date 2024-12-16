def part1(reports):
    result = 0
    
    for i in range(len(reports)):
        trend = reports[i][0] - reports[i][1]
        if trend < 0:
        
    
    
    return result

def part2(reports):
    result = 0
    
    
    return result



with open("inputs/day2.txt", 'r') as f:
    lines = f.readlines()
    

reports = [[int(item) for item in report] for report in list(map(lambda line: line.split(), lines))]

for report in reports:
    print(report)
    
print(part1(reports))
print(part2(reports))  

