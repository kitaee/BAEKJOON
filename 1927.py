import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

import heapq

N = int(input())
minHeap = []

for _ in range(N):
  x = int(input())
  if x == 0:
    if not minHeap:
      print(0)
    else:
      print(heapq.heappop(minHeap))
  else:
    heapq.heappush(minHeap, x)
