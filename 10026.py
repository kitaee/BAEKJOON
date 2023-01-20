from collections import deque

dy = [-1,1,0,0]
dx = [0,0,-1,1]

def bfs(graph, visited, N, y, x):
  queue = deque()
  queue.append((y,x))

  while queue:
    yIndex, xIndex = queue.popleft()
    for i in range(4):
      ny = yIndex + dy[i]
      nx = xIndex + dx[i]
      if 0<=ny<N and 0<=nx<N and visited[ny][nx] == False and graph[ny][nx] == graph[yIndex][xIndex]:
        visited[ny][nx] = True
        queue.append((ny,nx))
        
firstAnswer = 0
secondAnswer = 0
N = int(input())
graph = []
area = []

for _ in range(N):
  graph.append(list(input()))

visited = [[False for i in range(N)] for j in range(N)]

for y in range(N):
  for x in range(N):
    if visited[y][x] == False:
      bfs(graph, visited, N, y, x)
      firstAnswer+=1
      
visited = [[False for i in range(N)] for j in range(N)]

for y in range(N):
  for x in range(N):
    if graph[y][x] == "G":
      graph[y][x] = "R"

for y in range(N):
  for x in range(N):
    if visited[y][x] == False:
      bfs(graph, visited, N, y, x)
      secondAnswer+=1

print(firstAnswer, secondAnswer)
