import sys
# input = sys.stdin.readline
sys.setrecursionlimit(10**9)

from collections import deque

dy = [-1,1,0,0]
dx = [0,0,-1,1]

answer = []

def bfs(visited,maze,N,M):
  global answer
  queue = deque()
  queue.append((0,0,0))
  visited[0][0] = True

  while queue:
    yIndex, xIndex, count = queue.popleft()
    if yIndex == M-1 and xIndex == N-1:
      answer.append(count)
    for i in range(4):
      ny = yIndex + dy[i]
      nx = xIndex + dx[i]

      if 0<=nx<N and 0<=ny<M and visited[ny][nx] == False:
        if maze[ny][nx] == '0':
          queue.appendleft((ny,nx,count))
        else:
          queue.append((ny,nx,count+1))
        visited[ny][nx] = True

N,M = map(int, input().split())
maze = []
for _ in range(M):
  maze.append(list(input()))
visited = [[False for _ in range(N)] for _ in range(M)]
bfs(visited,maze,N,M)
answer.sort()
print(answer[0])
