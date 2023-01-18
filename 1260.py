from collections import deque

def bfs(visited, graph, v):
    queue = deque()
    queue.append(v)
    while queue:
        current = queue.popleft()
        if visited[current]:
            continue
        else:
            print(current, end = " ")
            visited[current] = True
            for adj in graph[current]:
                queue.append(adj)

def dfs(visited, graph, v):
  print(v, end = " ")
  visited[v] = True
  for i in graph[v]:
    if not visited[i]:
      dfs(visited, graph, i)
    

n, m, v = map(int, input().split())
visited1 = [False for i in range(n+1)]
visited2 = [False for i in range(n+1)]
graph = [[] for i in range(n+1)]

for i in range(m):
    v1, v2 = map(int, input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)
    graph[v1].sort()
    graph[v2].sort()

dfs(visited1, graph, v)
print()
bfs(visited2, graph, v)
