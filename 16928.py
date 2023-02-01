import sys
input = sys.stdin.readline

from collections import deque

N,M = map(int, input().split())
snakeDict = dict()
ladderDict= dict()
visited = [False for _ in range(101)]

for _ in range(N):
  x,y = map(int, input().split())
  ladderDict[x] = y
for _ in range(M):
  u,v = map(int, input().split())
  snakeDict[u] = v

queue = deque()
queue.append((1,0))
visited[1] = True

while queue:
  current, count = queue.popleft()
  if current == 100:
    print(count)
    break
  for i in range(1,7):
    move = current + i
    if move in ladderDict and ladderDict[move] <= 100:
      queue.append((ladderDict[move], count+1))
      visited[ladderDict[move]] = True
    elif move in snakeDict and snakeDict[move] >= 1:
      queue.append((snakeDict[move], count+1))
      visited[snakeDict[move]] = True
    elif move <= 100 and visited[move] == False:
      queue.append((move, count+1))
      visited[move] = True
    else:
      continue
