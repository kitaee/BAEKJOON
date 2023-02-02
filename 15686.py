import sys
input = sys.stdin.readline

from itertools import combinations
import heapq

N,M = map(int, input().split())
homeList = []
chickenList = []
chickenDistanceList = []
for i in range(N):
  tempList = list(map(int, input().split()))
  for j in range(N):
    if tempList[j] == 1:
      homeList.append((i,j))
    elif tempList[j] == 2:
      chickenList.append((i,j))

chickenList = list(combinations(chickenList, M))
for chicken in chickenList:
  chickenDistance = 0
  for home in homeList:
    homeDistance = []
    for chickenHouse in chicken:
      heapq.heappush(homeDistance, abs(home[0]-chickenHouse[0]) + abs(home[1]-chickenHouse[1]))
    chickenDistance += homeDistance[0]
  heapq.heappush(chickenDistanceList, chickenDistance)

print(chickenDistanceList[0])
