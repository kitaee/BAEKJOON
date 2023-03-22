import sys
input = sys.stdin.readline

N = int(input())
answer = 0
timeList = []
for _ in range(N):
  timeList.append(list(map(int,input().split())))
timeList = sorted(timeList, key = lambda x : (x[1],x[0]))
endTime = 0
for time in timeList:
  if time[0] >= endTime:
    answer+=1
    endTime = time[1]
print(answer)
