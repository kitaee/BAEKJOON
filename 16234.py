import sys
sys.setrecursionlimit(10**9)
from collections import deque

dy = [-1,1,0,0]
dx = [0,0,-1,1]
moveStack = []
moveSum = 0

def bfs(graph,visited,y,x,N,L,R):
  global moveStack, moveSum
  moveStack.append((y,x))
  moveSum += graph[y][x]
  queue = deque()
  queue.append((y,x))
  visited[y][x] = True

  while queue:
    yIndex, xIndex = queue.popleft()

    for i in range(4):
      ny = yIndex + dy[i]
      nx = xIndex + dx[i]

      if nx<0 or ny<0 or nx>=N or ny>=N:
        continue
      else:
        if L <= abs(graph[ny][nx]-graph[yIndex][xIndex]) <= R and visited[ny][nx] == False:
          visited[ny][nx] = True
          queue.append((ny,nx))
          moveStack.append((ny,nx))
          moveSum += graph[ny][nx]
  if len(moveStack) > 1:
    for index in moveStack:
      graph[index[0]][index[1]] = moveSum // len(moveStack)
    return 1
  else:
    return 0
    
answer = 0
N,L,R = map(int, input().split())
graph = []
for _ in range(N):
  graph.append(list(map(int, input().split())))

while True:
  count = 0
  visited = [[False for _ in range(N)] for _ in range(N)]
  for y in range(N):
    for x in range(N):
      if visited[y][x] == False:
        count += bfs(graph,visited,y,x,N,L,R)
        moveStack.clear()
        moveSum = 0
  if count == 0:
    break
  answer+=1

print(answer)
