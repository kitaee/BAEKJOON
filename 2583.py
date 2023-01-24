import sys
sys.setrecursionlimit(10**9)

from collections import deque

dy = [-1,1,0,0]
dx = [0,0,-1,1]

def bfs(visited,graph,N,M,y,x):
  count = 1
  queue = deque()
  queue.append((y,x))
  visited[y][x] = True

  while queue:
    yIndex, xIndex = queue.popleft()
    for i in range(4):
      ny = yIndex + dy[i]
      nx = xIndex + dx[i]

      if 0<=ny<N and 0<=nx<M and visited[ny][nx] == False and paper[ny][nx] == 0:
        count+=1
        visited[ny][nx] = True
        queue.append((ny,nx))
  return count

N,M,K = map(int, input().split())
paper = [[0 for _ in range(M)] for _ in range(N)]
visited = [[False for _ in range(M)] for _ in range(N)]
area = []

for _ in range(K):
  x1,y1,x2,y2 = map(int, input().split())
  for y in range(y1, y2):
    for x in range(x1, x2):
      paper[y][x] = 1

for y in range(N):
  for x in range(M):
    if paper[y][x] == 0 and visited[y][x] == False:
      area.append(bfs(visited,paper,N,M,y,x))

area.sort()
print(len(area))
for detailArea in area:
  print(detailArea, end = " ")
