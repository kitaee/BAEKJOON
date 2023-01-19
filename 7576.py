from collections import deque

dy = [-1,1,0,0]
dx = [0,0,-1,1]

def bfs(tomatoList,graph,visited,M,N):
  countStack = []
  queue = deque()
  
  for tomato in tomatoList:
    queue.append((tomato[0],tomato[1],0))
    visited[tomato[0]][tomato[1]] = True

  while queue:
    yIndex, xIndex, count = queue.popleft()
    for i in range(4):
      ny = yIndex + dy[i]
      nx = xIndex + dx[i]
      if 0<=ny<N and 0<=nx<M and graph[ny][nx] == 0 and visited[ny][nx] == False:
        visited[ny][nx] = True
        graph[ny][nx] = 1
        countStack.append(count+1)
        queue.append((ny,nx,count+1))
  countStack.sort()
  if countStack:
    return countStack[-1]
  else:
    return 0

answer = []
tomatoList = []
M, N = map(int, input().split())
graph = []
visited = [[False for i in range(M)] for j in range(N)]

for _ in range(N):
  graph.append(list(map(int, input().split())))

for y in range(N):
  for x in range(M):
    if graph[y][x] == 1 and visited[y][x] == False:
      tomatoList.append((y,x))
answer.append(bfs(tomatoList,graph,visited,M,N))

isPossible = True
for y in range(N):
  for x in range(M):
    if graph[y][x] == 0:
      print(-1)
      isPossible = False
      break
  if isPossible == False:
    break
if isPossible:
  print(answer[0])
