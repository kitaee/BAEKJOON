# import sys
# input = sys.stdin.readline
# sys.setrecursionlimit(10**9)

dp = [0 for _ in range(41)]
recursionCount = 0
dpCount = 0

def originalFibo(n):
  global recursionCount
  if n == 1 or n == 2:
    recursionCount+=1
    return 1
  else:
    return originalFibo(n-2) + originalFibo(n-1)

def dpFibo(n):
  global dpCount
  dp[1] = 1
  dp[2] = 1
  for i in range(3,n+1):
    dp[i] = dp[i-2] + dp[i-1]
    dpCount+=1
  return dp[n]

N = int(input())
originalFibo(N)
dpFibo(N)
print(recursionCount, end = " ")
print(dpCount)
