import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

import heapq

# I 이면 큐에 저장
# D1 이면 최댓값 삭제
# D-1 이면 최솟값 삭제

T = int(input())
for _ in range(T):
  minHeap = []
  maxHeap = []
  isDeleted = []
  count = 0
  Q = int(input())
  for _ in range(Q):
    command,num = input().split()
    if command == "I":
      heapq.heappush(minHeap, (int(num),count))
      heapq.heappush(maxHeap, (-int(num),count))
      isDeleted.append(1)
      count+=1
    else:
      if num[0] == "-":
        while minHeap:
          if isDeleted[minHeap[0][1]] == 1:
            isDeleted[minHeap[0][1]] = 0
            heapq.heappop(minHeap)
            break
          heapq.heappop(minHeap)
      else:
        while maxHeap:
          if isDeleted[maxHeap[0][1]] == 1:
            isDeleted[maxHeap[0][1]] = 0
            heapq.heappop(maxHeap)
            break
          heapq.heappop(maxHeap)
  if sum(isDeleted) == 0:
    print("EMPTY")
  else:
    while isDeleted[maxHeap[0][1]] != 1:
      heapq.heappop(maxHeap)
    print(-maxHeap[0][0], end = " ")
    while isDeleted[minHeap[0][1]] != 1:
      heapq.heappop(minHeap)
    print(minHeap[0][0])
