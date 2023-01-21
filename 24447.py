import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

from collections import deque

def bfs(graph,visited,order,R,relation):
  count = 1
  queue = deque()
  queue.append((R,0))
  visited[R] = True
  order[R] = 0
  relation[R] = count
  count+=1

  while queue:
    current,depth = queue.popleft()
    for adj in graph[current]:
      if visited[adj] == False:
        queue.append((adj,depth+1))
        visited[adj] = True
        order[adj] = depth+1
        relation[adj] = count
        count+=1
  
answer = 0
N,M,R = map(int, input().split())
graph = [[] for i in range(N+1)]
visited = [False for i in range(N+1)]
order = [-1 for i in range(N+1)]
relation = [0 for i in range(N+1)]

for _ in range(M):
  u,v = map(int, input().split())
  graph[u].append(v)
  graph[v].append(u)

bfs(graph,visited,order,R,relation)

for i in range(1, N+1):
  answer+=(relation[i]*order[i])

print(answer)
