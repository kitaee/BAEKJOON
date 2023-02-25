import sys
input = sys.stdin.readline

from collections import deque

def bfs(jump,visited,N):
  if N == 1:
    return 0
  queue = deque()
  queue.append((0,0))
  visited[0] = True

  while queue:
    current, count = queue.popleft()
    if jump[current] == 0:
      continue
    for i in range(1, jump[current]+1):
      newPosition = current + i
      if newPosition >= N-1:
        return count+1
      elif visited[newPosition] == False:
        queue.append((newPosition, count+1))
        visited[newPosition] = True
  return -1

N = int(input())
jump = list(map(int, input().split()))
visited = [False for _ in range(N)]
print(bfs(jump, visited, N))
