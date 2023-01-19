import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def findParent(parent, node):
  if parent[node] != node:
    parent[node] = findParent(parent, parent[node])
  return parent[node]

def unionParent(parent, node1, node2):
  node1 = findParent(parent, node1)
  node2 = findParent(parent, node2)

  if node1 < node2:
    parent[node2] = node1
  else:
    parent[node1] = node2
  
answer = 0
N = int(input())
M = int(input())
parent = [i for i in range(N+1)]
edges = []

for _ in range(M):
  a,b,c = map(int, input().split())
  edges.append((c, a, b))

edges.sort()
for edge in edges:
  if findParent(parent, edge[1]) != findParent(parent, edge[2]):
    unionParent(parent, edge[1], edge[2])
    answer += edge[0]

print(answer)
