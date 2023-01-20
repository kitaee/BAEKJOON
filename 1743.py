from collections import deque

dy = [-1,1,0,0]
dx = [0,0,-1,1]

def bfs(graph,visited,N,M,y,x):
  count = 1
  queue = deque()
  queue.append((y,x))
  visited[y][x] = True

  while queue:
    yIndex,xIndex = queue.popleft()
  
    for i in range(4):
      ny = yIndex + dy[i]
      nx = xIndex + dx[i]
  
      if 0<=ny<N and 0<=nx<M and visited[ny][nx] == False and graph[ny][nx] == 1:
        count+=1
        visited[ny][nx] = True
        queue.append((ny,nx))

  return count

answer = -1
N,M,K = map(int, input().split())
graph = [[0 for i in range(M)] for j in range(N)]
visited = [[False for i in range(M)] for j in range(N)]

for _ in range(K):
  r,c = map(int, input().split())
  graph[r-1][c-1] = 1

for y in range(N):
  for x in range(M):
    if visited[y][x] == False and graph[y][x] == 1:
      area = bfs(graph,visited,N,M,y,x)
      if answer < area:
        answer = area

print(answer)
