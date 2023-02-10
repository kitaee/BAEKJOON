import sys
input = sys.stdin.readline

N,M = map(int, input().split())
answer = 1
div = M
for _ in range(M):
  answer *= N
  N-=1
for _ in range(M):
  answer = answer // div
  div-=1

print(answer)
