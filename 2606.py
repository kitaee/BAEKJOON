import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

from collections import deque

N = int(input())
V = int(input())
count = 0

network = [[] for i in range(N+1)]
visited = [False for i in range(N+1)]

for _ in range(V):
  V1, V2 = map(int, input().split())
  network[V1].append(V2)
  network[V2].append(V1)

queue = deque()
queue.append(1)
visited[1] = True

while queue:
  current = queue.popleft()
  for adj in network[current]:
    if visited[adj] == False:
      queue.append(adj)
      visited[adj] = True
      count += 1

print(count)
