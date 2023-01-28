import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

from collections import deque

visited = [False for _ in range(100001)]

N,K = map(int, input().split())
maxLength = max(N,K)
queue = deque()
queue.append((N,0))
visited[N] = True

while queue:
  current, count = queue.popleft()
  if current == K:
    print(count)
    break
  else:
    if current+1 <= 100000 and visited[current+1] == False:
      queue.append((current+1, count+1))
      visited[current+1] = True
    if 0 <= current-1 and visited[current-1] == False:
      visited[current-1] = True
      queue.append((current-1, count+1))
    if current*2 <= 100000 and visited[current*2] == False:
      visited[current*2] = True
      queue.append((current*2, count+1))
