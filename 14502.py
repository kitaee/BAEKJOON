import sys
input = sys.stdin.readline

from collections import deque
from itertools import combinations
import copy

dy = [-1,1,0,0]
dx = [0,0,-1,1]

def bfs(testGraph,visited,y,x,N,M):
  destroy = 0
  queue = deque()
  queue.append((y,x))
  visited[y][x] = True

  while queue:
    yIndex, xIndex = queue.popleft()
    for i in range(4):
      ny = yIndex + dy[i]
      nx = xIndex + dx[i]
      if 0<=nx<M and 0<=ny<N and visited[ny][nx] == False and testGraph[ny][nx] == 0:
        queue.append((ny,nx))
        visited[ny][nx] = True
        testGraph[ny][nx] = 2

N,M = map(int, input().split())
answer = 0
blankList = []
graph = []

for i in range(N):
  tempList = list(map(int, input().split()))
  for j in range(M):
    if tempList[j] == 0:
      blankList.append((i,j))
  graph.append(tempList)

wallOrder = list(combinations(blankList, 3))
for wallList in wallOrder:
  safeZone = 0
  visited = [[False for _ in range(M)] for _ in range(N)]
  testGraph = copy.deepcopy(graph)
  for wall in wallList:
    testGraph[wall[0]][wall[1]] = 1
  for y in range(N):
    for x in range(M):
      if testGraph[y][x] == 2 and visited[y][x] == False:
        bfs(testGraph,visited,y,x,N,M)
  for i in range(N):
    for j in range(M):
      if testGraph[i][j] == 0:
        safeZone += 1
  if safeZone > answer:
    answer = safeZone
print(answer)
