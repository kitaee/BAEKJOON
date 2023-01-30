import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

from collections import deque

N,K = map(int, input().split())
visited = [False for _ in range(100001)]
queue = deque()
queue.append((N,0))
visited[N] = True

while queue:
  current, time = queue.popleft()
  if current == K:
    print(time)
    break
  else:
    if current*2 <= 100000 and visited[current*2] == False:
      queue.append((current*2,time))
      visited[current*2] = True
    if current-1 >=0 and visited[current-1] == False:
      queue.append((current-1,time+1))
      visited[current-1] = True
    if current+1 <= 100000 and visited[current+1] == False:
      queue.append((current+1,time+1))
      visited[current+1] = True
