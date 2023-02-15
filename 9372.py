import sys
input = sys.stdin.readline

def findParent(parent, node):
  if parent[node] == node:
    return node
  else:
    tempNode = parent[node]
    return findParent(parent, tempNode)

def unionParent(parent, node1, node2):
  node1 = findParent(parent, node1)
  node2 = findParent(parent, node2)
  if node1 < node2:
    parent[node2] = node1
  else:
    parent[node1] = node2

T = int(input())
for _ in range(T):
  answer = 0
  N,M = map(int, input().split())
  parent = [i for i in range(N+1)]
  graph = []
  for _ in range(M):
    graph.append(list(map(int, input().split())))
  for vertex in graph:
    if findParent(parent, vertex[0]) != findParent(parent, vertex[1]):
      unionParent(parent, vertex[0], vertex[1])
      answer+=1
  print(answer)
