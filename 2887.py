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

def getDistance(node1, node2):
  return min(getAbsolute(node1[0]-node2[0]),getAbsolute(node1[1]-node2[1]),getAbsolute(node1[2]-node2[2]))

def getAbsolute(num):
  if num < 0:
    return -num
  else:
    return num

answer = 0
N = int(input())
parent = [i for i in range(N+1)]
point = []
edges = []

for i in range(N):
  x,y,z = map(int, input().split())
  point.append((x,y,z,i+1))

for i in range(3):
  point = sorted(point, key = lambda x : x[i])
  for j in range(N-1):
    edges.append(((getDistance(point[j], point[j+1])), point[j][3], point[j+1][3]))

edges.sort()

for edge in edges:
  cost, a, b = edge
  if findParent(parent, a) != findParent(parent, b):
    unionParent(parent, a, b)
    answer+=cost

print(answer)
