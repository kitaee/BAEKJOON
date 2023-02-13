import sys
input = sys.stdin.readline

from collections import deque

T = int(input())
for _ in range(T):
  N,M = map(int, input().split())
  count = 1
  queue = deque(map(int, input().split()))
  while True:
    document = queue.popleft()
    if not queue:
      print(count)
      break
    else:
      if M == 0:
        if document >= max(queue):
          print(count)
          break
        else:
          queue.append(document)
          M = len(queue)-1
      else:
        if document >= max(queue):
          count+=1
        else:
          queue.append(document)
        M-=1
