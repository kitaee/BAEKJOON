import sys
input = sys.stdin.readline

def findParent(parent, node):
  if parent[node] == node:
    return node
  else:
    return findParent(parent, parent[node])

def unionParent(parent, node1, node2):
  node1 = findParent(parent, node1)
  node2 = findParent(parent, node2)
  if node1 < node2:
    parent[node2] = node1
  else:
    parent[node1] = node2

N = int(input())
M = int(input())
parent = [i for i in range(N+1)]
graph = []
for _ in range(N):
  graph.append(list(map(int, input().split())))

for i in range(N):
  for j in range(N):
    if graph[i][j] == 1 and parent[i+1] != parent[j+1]:
      unionParent(parent, i+1, j+1)

route = list(map(int, input().split()))

def isPossibleRoute(parent, route):
  target = findParent(parent, parent[route[0]])
  for i in range(M):
    if findParent(parent, parent[route[i]]) != target:
      return "NO"
  return "YES"

print(isPossibleRoute(parent, route))
