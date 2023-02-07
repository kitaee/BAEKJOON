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

def getAnswer(parent, M):
  answer = 1
  for _ in range(M):
    node1, node2 = map(int, input().split())
    if findParent(parent, node1) == findParent(parent, node2):
      return answer
    else:
      answer += 1
      unionParent(parent, node1, node2)
  return 0

N,M = map(int, input().split())
parent = [i for i in range(N)]
print(getAnswer(parent, M))
