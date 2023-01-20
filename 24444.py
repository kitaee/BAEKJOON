import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

from collections import deque

def bfs(graph,visited,R,order):
  count = 1
  queue = deque()
  visited[R] = True
  queue.append(R)
  order[R] = count
  count+=1

  while queue:
    current = queue.popleft()
    graph[current].sort()
    for adj in graph[current]:
      if visited[adj] == False:
        visited[adj] = True
        order[adj] = count
        count+=1
        queue.append(adj)
  
count = 2
N,M,R = map(int,input().split())
graph = [[] for i in range(N+1)]
visited = [False for i in range(N+1)]
order = [-1 for i in range(N+1)]

for _ in range(M):
  u,v = map(int, input().split())
  graph[u].append(v)
  graph[v].append(u)

bfs(graph,visited,R,order)
for i in range(1, N+1):
  if order[i] == -1:
    print(0)
  else:
    print(order[i])
