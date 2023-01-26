import sys
sys.setrecursionlimit(10**9)
from collections import deque

dy = [-1,1,0,0]
dx = [0,0,-1,1]

meltList = []

def bfs(graph,visited,N,M):
  global meltList
  meltCount = 0
  queue = deque()
  queue.append((0,0))
  visited[0][0] = True

  while queue:
    yIndex,xIndex = queue.popleft()
    for i in range(4):
      ny = yIndex + dy[i]
      nx = xIndex + dx[i]
      if 0<=nx<M and 0<=ny<N and visited[ny][nx] == False and graph[ny][nx] == 0:
        visited[ny][nx] = True
        queue.append((ny,nx))
      elif 0<=nx<M and 0<=ny<N and visited[ny][nx] == False and graph[ny][nx] == 1:
        visited[ny][nx] = True
        meltCount+=1
        meltList.append((ny,nx))
  return meltCount

N,M = map(int, input().split())
graph = []
cheese = 0
time = 0
for _ in range(N):
  tempList = list(map(int, input().split()))
  cheese+=tempList.count(1)
  graph.append(tempList)

while True:
  time+=1
  visited = [[False for _ in range(M)] for _ in range(N)]
  if cheese-bfs(graph,visited,N,M)==0:
    break
  else:
    for melt in meltList:
      graph[melt[0]][melt[1]] = 0
      cheese-=1
  meltList.clear()
print(time)
print(cheese)
