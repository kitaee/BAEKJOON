import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

from collections import deque

dy = [1,0]
dx = [0,1]

def bfs(graph, N, visited):
  queue = deque()
  queue.append((0,0))
  visited[0][0] = True
  isAble = False

  while queue:
    y,x = queue.popleft()
    if graph[y][x] == -1:
      isAble = True
      print("HaruHaru")
      break
    for i in range(2):
      ny = y + dy[i]*graph[y][x]
      nx = x + dx[i]*graph[y][x]

      if 0<=ny<N and 0<=nx<N and visited[ny][nx] == False:
        visited[ny][nx] = True
        queue.append((ny,nx))

  if isAble == False:
    print("Hing")

N = int(input())
graph = []
visited = [[False for i in range(N)] for i in range(N)]

for _ in range(N):
  graph.append(list(map(int, input().split())))

bfs(graph, N, visited)
