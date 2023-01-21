import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)
count = 1

def dfs(graph,visited,order,R):
  global count
  visited[R] = True
  order[R] = count
  graph[R].sort()
  count+=1

  for adj in graph[R]:
    if visited[adj] == False:
      dfs(graph,visited,order,adj)

N,M,R = map(int, input().split())
graph = [[] for i in range(N+1)]
visited = [False for i in range(N+1)]
order = [0 for i in range(N+1)]

for _ in range(M):
  u,v = map(int, input().split())
  graph[u].append(v)
  graph[v].append(u)

dfs(graph,visited,order,R)

for i in range(1, N+1):
  print(order[i])
