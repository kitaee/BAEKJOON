import sys
input = sys.stdin.readline

from collections import deque

N = int(input())
queue = deque()
visited = [False for _ in range(10**6)]
queue.append((N,0,str(N)))

while queue:
  num, count, history = queue.popleft()
  if num == 1:
    print(count)
    print(history)
    break
  if num%3==0 and visited[num//3] == False:
    queue.append((num//3, count+1,history+" "+str(num//3)))
    visited[num//3] = True
  if num%2==0 and visited[num//2] == False:
    queue.append((num//2, count+1,history+" "+str(num//2)))
    visited[num//2] = True
  if num-1 >= 1 and visited[num-1] == False:
    queue.append((num-1, count+1,history+" "+str(num-1)))
    visited[num-1] = True
