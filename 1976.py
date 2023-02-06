import sys
input = sys.stdin.readline

import heapq

INF = sys.maxsize

N = int(input())
M = int(input())
distance = [INF for _ in range(N+1)]
graph = [[] for _ in range(N+1)]

for _ in range(M):
  v1,v2,cost = map(int, input().split())
  graph[v1].append((v2,cost))

start, end = map(int, input().split())

def dijkstra(distance, graph, start):
  queue = []
  heapq.heappush(queue, (0,start))
  distance[start] = 0

  while queue:
    dist, current = heapq.heappop(queue)
    if distance[current] < dist:
      continue
    else:
      for adj in graph[current]:
        if distance[adj[0]] > adj[1] + dist:
          distance[adj[0]] = adj[1] + dist
          heapq.heappush(queue, (distance[adj[0]], adj[0]))
  return distance

distance = dijkstra(distance, graph, start)
print(distance[end])
