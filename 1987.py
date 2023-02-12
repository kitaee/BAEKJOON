import sys
input = sys.stdin.readline

def bfs(graph,R,C,answer):
  queue = set([(0,0,graph[0][0],1)])
  
  while queue:
    yIndex,xIndex,route,count = queue.pop()
    for i in range(4):
      ny = dy[i] + yIndex
      nx = dx[i] + xIndex
      if 0<=ny<R and 0<=nx<C:
        if graph[ny][nx] in route:
          answer.append(count)
        else:
          queue.add((ny,nx,route+graph[ny][nx],count+1))

dy = [-1,1,0,0]
dx = [0,0,-1,1]

answer = []
R,C = map(int, input().split())
graph = []
for _ in range(R):
  tempList = list(input())
  graph.append(tempList[0:C])
bfs(graph,R,C,answer)
print(max(answer))
