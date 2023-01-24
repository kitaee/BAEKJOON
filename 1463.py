import sys
sys.setrecursionlimit(10**9)
from collections import deque

# X가 3으로 나누어 떨어지면, 3으로 나눈다.
# X가 2로 나누어 떨어지면, 2로 나눈다.
# 1을 뺀다.

def convertToOne(num):
  queue = deque()
  queue.append((num,0))
  visited[num] = True

  while queue:
    current, count = queue.popleft()

    if current == 1:
      return count

    if current % 3 == 0 and visited[current//3] == False:
      visited[current//3] = True
      queue.append((current//3, count+1))

    if current % 2 == 0 and visited[current//2] == False:
      visited[current//2] = True
      queue.append((current//2, count+1))

    if visited[current-1] == False:
      queue.append((current-1, count+1))

N = int(input())
visited = [False for _ in range(N+1)]
print(convertToOne(N))
