from collections import deque

dy = [-1,1,0,0]
dx = [0,0,-1,1]

def bfs(y,x,graph,N,M):
  queue = deque()
  queue.append((y,x))
  graph[y][x] = 0

  while queue:
    yIndex, xIndex = queue.popleft()
    for i in range(4):
      ny = yIndex + dy[i]
      nx = xIndex + dx[i]
      if 0<=nx<M and 0<=ny<N and graph[ny][nx] == 1:
        graph[ny][nx] = 0
        queue.append((ny,nx))

testCase = int(input())

for _ in range(testCase):
  answer = 0
  M, N, K = map(int, input().split())
  graph = [[0 for i in range(M)] for j in range(N)]
  for _ in range(K):
    X, Y = map(int, input().split())
    graph[Y][X] = 1
  for y in range(N):
    for x in range(M):
      if graph[y][x] == 1:
        bfs(y,x,graph,N,M)
        answer+=1
  print(answer)
