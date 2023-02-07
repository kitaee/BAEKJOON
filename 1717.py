import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def findParent(parent, node):
  if parent[node] == node:
    return node
  else:
    temp = findParent(parent, parent[node])
    parent[node] = temp
    return temp

def unionParent(parent, node1, node2):
  node1 = findParent(parent, node1)
  node2 = findParent(parent, node2)
  if node1 < node2:
    parent[node2] = node1
  else:
    parent[node1] = node2

N,M = map(int, input().split())
parent = [i for i in range(N+1)]
for _ in range(M):
  command, node1, node2 = map(int, input().split())
  if command == 0:
    unionParent(parent, node1, node2)
  else:
    if findParent(parent, node1) == findParent(parent, node2):
      print("YES")
    else:
      print("NO")
