import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

import heapq

INF = int(1e9)

def dijkstra(distance, graph, K):
  queue = []
  heapq.heappush(queue, (0,K))
  distance[K] = 0

  while queue:
    dist, current = heapq.heappop(queue)
    if distance[current] < dist:
      continue
    for adj in graph[current]:
      if distance[adj[0]] > adj[1] + distance[current]:
        distance[adj[0]] = adj[1] + distance[current]
        heapq.heappush(queue, (distance[adj[0]], adj[0]))
  return distance

V, E = map(int, input().split())
K = int(input())

distance = [INF for i in range(V+1)]
graph = [[] for i in range(V+1)]

for _ in range(E):
    start, end, dist = map(int, input().split())
    graph[start].append((end,dist))

distance = dijkstra(distance, graph, K)
for i in range(1, V+1):
  if distance[i] == INF:
    print("INF")
  else:
    print(distance[i])
