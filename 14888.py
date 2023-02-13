import sys
input = sys.stdin.readline

from itertools import permutations

N = int(input())
operator = []
answer = []
num = list(map(int, input().split()))
plus, minus, mult, div = map(int, input().split())
for _ in range(plus):
  operator.append("+")
for _ in range(minus):
  operator.append("-")
for _ in range(mult):
  operator.append("*")
for _ in range(div):
  operator.append("/")

operationList = list(permutations(operator, N-1))
for operation in operationList:
  temp = num[0]
  for i in range(1,N):
    if operation[i-1] == "+":
      temp = temp + num[i]
    elif operation[i-1] == "-":
      temp = temp - num[i]
    elif operation[i-1] == "*":
      temp = temp * num[i]
    else:
      if temp >= 0:
        temp = temp // num[i]
      else:
        temp = -(-temp // num[i])
  answer.append(temp)
answer.sort()
print(answer[-1])
print(answer[0])
