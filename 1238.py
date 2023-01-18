import heapq

INF = 9999999999999999

def getFromDistance(fromDistance, graph, X):
  queue = []
  heapq.heappush(queue, (0,X))
  fromDistance[X] = 0
  while queue:
    dist, current = heapq.heappop(queue)
    if fromDistance[current] < dist:
      continue
    else:
      for adj in graph[current]:
        if fromDistance[adj[0]] > adj[1] + dist:
          fromDistance[adj[0]] = adj[1] + dist
          heapq.heappush(queue, (fromDistance[adj[0]], adj[0]))
  return fromDistance

maxDistance = -1
N, M, X = map(int, input().split())
fromDistance = [INF for i in range(N+1)]
graph = [[] for i in range(N+1)]
for i in range(M):
    start, end, dist = map(int, input().split())
    graph[start].append((end, dist))

fromDistance = getFromDistance(fromDistance, graph, X)

for i in range(1, N+1):
  if i == X:
    continue
  toDistance = [INF for i in range(N+1)]
  toDistance = getFromDistance(toDistance, graph, i)
  if (toDistance[X] + fromDistance[i]) > maxDistance:
    maxDistance = toDistance[X] + fromDistance[i]
print(maxDistance)
