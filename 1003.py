import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

# 0일때 -> 0 1번
# 1일때 -> 1 1번
# 2일때 -> 0,1 1번씩

zeroCount = [1,0,1]
oneCount = [0,1,1]

T = int(input())
for _ in range(T):
  N = int(input())
  length = len(zeroCount)
  if N > length-1:
    for i in range(length, N+1):
      zeroCount.append((zeroCount[i-2] + zeroCount[i-1]))
      oneCount.append((oneCount[i-2] + oneCount[i-1]))
  print(zeroCount[N], end = " ")
  print(oneCount[N], end = " ")
  print()
