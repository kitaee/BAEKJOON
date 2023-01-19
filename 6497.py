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

while True:
  total = 0
  answer = 0
  N,M = map(int, input().split())
  if N ==0 and M ==0:
    break
  parent = [i for i in range(N+1)]
  edges = []
  
  for _ in range(M):
    a, b, cost = map(int, input().split())
    total+=cost
    edges.append((cost, a, b))
  edges.sort()
  
  for edge in edges:
    cost, a, b = edge
    if findParent(parent, a) != findParent(parent, b):
      unionParent(parent, a, b)
      answer+=cost
  print(total-answer)
