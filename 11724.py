import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

from collections import deque

def bfs(visited, graph, i):
  queue = deque()
  queue.append(i)
  visited[i] = True

  while queue:
    current = queue.popleft()
    for adj in graph[current]:
      if visited[adj] == False:
        visited[adj] = True
        queue.append(adj)

answer = 0
N, M = map(int, input().split())
visited = [False for i in range(N+1)]
graph = [[] for i in range(N+1)]

for _ in range(M):
  U, V = map(int, input().split())
  graph[U].append(V)
  graph[V].append(U)

for i in range(1, N+1):
  if visited[i] == False:
    bfs(visited, graph, i)
    answer+=1
print(answer)
