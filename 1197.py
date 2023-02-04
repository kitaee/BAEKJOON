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

answer = 0
V,E = map(int, input().split())
parent = [i for i in range(V+1)]
vertex = []

for _ in range(E):
  vertex.append(list(map(int, input().split())))
vertex = sorted(vertex, key = lambda x : x[2])

for vertexInfo in vertex:
  node1 = findParent(parent, vertexInfo[0])
  node2 = findParent(parent, vertexInfo[1])
  if node1 == node2:
    continue
  else:
    answer += vertexInfo[2]
    unionParent(parent, node1, node2)
print(answer)
