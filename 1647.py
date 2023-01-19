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
costStack = []
N, M = map(int, input().split())
parent = [i for i in range(N+1)]
edges = []

for _ in range(M):
  A,B,C = map(int, input().split())
  edges.append((C,A,B))
edges.sort()

for edge in edges:
  cost,a,b = edge
  if findParent(parent,a) != findParent(parent,b):
    unionParent(parent,a,b)
    costStack.append(cost)
    answer+=cost
print(answer-costStack[-1])
