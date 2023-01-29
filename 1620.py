import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

N,M = map(int, input().split())
pocketmon = []
pocketmonHash = dict()

for i in range(N):
  target = input().strip()
  pocketmon.append(target)
  pocketmonHash[target] = i+1

for _ in range(M):
  question = input().strip()
  if question.isdigit():
    print(pocketmon[int(question)-1])
  else:
    print(pocketmonHash[question])
