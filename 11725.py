from collections import deque
import sys
input = sys.stdin.readline
 
n = int(input())
 
graph = [[] for _ in range(n+1)]
parent = [0 for _ in range(n+1)]
 
 
def bfs(start):
    queue = deque()
    queue.append(start)
 
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if parent[i] == 0:
                parent[i] = v
                queue.append(i)
 
 
for i in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
 
bfs(1)
 
for i in parent[2:]:
    print(i)
