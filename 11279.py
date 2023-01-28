import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

import heapq

N = int(input())
maxHeap = []
for _ in range(N):
  x = int(input())
  if x != 0:
    heapq.heappush(maxHeap, -x)
  else:
    if not maxHeap:
      print(0)
    else:
      print(-heapq.heappop(maxHeap))
