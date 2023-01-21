import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

from collections import deque

def bfs(graph,visited,order,R):
  count = 1
  queue = deque()
  queue.append(R)
  visited[R] = True
  order[R] = count
  count+=1

  while queue:
    current = queue.popleft()
    graph[current].sort(reverse=True)
    for adj in graph[current]:
      if visited[adj] == False:
        visited[adj] = True
        order[adj] = count
        count+=1
        queue.append(adj)

N,M,R = map(int, input().split())
graph = [[] for i in range(N+1)]
visited = [False for i in range(N+1)]
order = [0 for i in range(N+1)]

for _ in range(M):
  u,v = map(int, input().split())
  graph[u].append(v)
  graph[v].append(u)

bfs(graph,visited,order,R)

for i in range(1, len(order)):
  print(order[i])
