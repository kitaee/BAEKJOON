import sys
input = sys.stdin.readline

from collections import deque

def operationD(num):
  num*=2
  if num > 9999:
    return num % 10000, "D"
  return num,"D"

def operationS(num):
  if num == 0:
    return 9999, "S"
  return num-1,"S"

def operationL(num):
  return (num%1000)*10+num//1000, "L"

def operationR(num):
  return (num%10)*1000+num//10, "R"

def bfs(visited, A, B):
  queue = deque()
  queue.append((A,""))
  visited[A] = True
  while queue:
    currentNum, operationResult = queue.popleft()
    if currentNum == B:
      return operationResult
    for (newNum,operation) in [operationD(currentNum), operationS(currentNum), operationL(currentNum), operationR(currentNum)]:
      if visited[newNum] == False:
        visited[newNum] = True
        queue.append((newNum, operationResult+operation))

T = int(input())
for _ in range(T):
  A,B = map(int, input().split())
  visited = [False for _ in range(10000)]
  print(bfs(visited, A, B))
