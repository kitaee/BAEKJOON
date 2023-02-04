import sys
input = sys.stdin.readline

import heapq

queue = []
N = int(input())
for _ in range(N):
  num = int(input())
  if num == 0:
    if queue:
      minValue, isPlus = heapq.heappop(queue)
      if isPlus:
        print(minValue)
      else:
        print(-minValue)
    else:
      print(0)
  elif num > 0:
    heapq.heappush(queue, (num, True))
  else:
    heapq.heappush(queue, (-num, False))
