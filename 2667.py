from collections import deque

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

def bfs(y,x,apartment):
  queue = deque()
  apartment[y][x] = 0
  queue.append((y,x))
  count = 1

  while queue:
    yIndex, xIndex = queue.popleft()
    for i in range(4):
      ny = yIndex + dy[i]
      nx = xIndex + dx[i]
      if 0<=ny<N and 0<=nx<N and apartment[ny][nx] == 1:
        apartment[ny][nx] = 0
        queue.append((ny,nx))
        count+=1
  return count

N = int(input())
apartment = []
answer = []

for _ in range(N):
  apartment.append(list(map(int, input())))

for y in range(N):
  for x in range(N):
    if apartment[y][x] == 1:
      answer.append(bfs(y,x,apartment))
answer.sort()
print(len(answer))
for detailAnswer in answer:
  print(detailAnswer)
