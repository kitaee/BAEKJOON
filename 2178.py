from collections import deque

N, M = map(int, input().split())
maze = [list(map(int, input().strip())) for _ in range(N)]
visited = [[False for i in range(M)] for i in range(N)]

visited[0][0] = True
queue = deque()
queue.append((0,0,1))

while queue:
  yIndex, xIndex, count = queue.popleft()
  if yIndex == N-1 and xIndex == M-1:
    print(count)
    break
  dx = [-1, 1, 0, 0]
  dy = [0, 0, -1, 1]
  for i in range(4):
    nx = dx[i] + xIndex
    ny = dy[i] + yIndex
    if 0<=nx<=M-1 and 0<=ny<=N-1 and visited[ny][nx] == False and maze[ny][nx] == 1:
      visited[ny][nx] = True
      queue.append((ny,nx,count+1))
