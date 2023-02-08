import sys
input = sys.stdin.readline

from collections import deque

dy = [-2,-2,-1,-1,1,1,2,2]
dx = [1,-1,2,-2,2,-2,1,-1]

def bfs(visited,y,x,targetY,targetX):
  queue = deque()
  queue.append((y,x,0))
  visited[y][x] = True

  while queue:
    yIndex, xIndex, count = queue.popleft()
    if yIndex == targetY and xIndex == targetX:
      return count
    for i in range(8):
      ny = yIndex + dy[i]
      nx = xIndex + dx[i]
      if 0<=ny<N and 0<=nx<N and visited[ny][nx] == False:
        visited[ny][nx] = True
        queue.append((ny,nx,count+1))

T = int(input())
for _ in range(T):
  N = int(input())
  visited = [[False for _ in range(N)] for _ in range(N)]
  x, y = map(int, input().split())
  targetX, targetY = map(int, input().split())
  print(bfs(visited,y,x,targetY,targetX))
