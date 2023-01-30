import sys
input = sys.stdin.readline

def getTile(dp,n):
  if n == 1:
    return 1
  elif n == 2:
    return 2
  else:
    dp[1] = 1
    dp[2] = 2
    for i in range(3, N+1):
      dp[i] = (dp[i-1] + dp[i-2]) % 15746
    return dp[n]

N = int(input())
dp = [0 for _ in range(N+1)]
print(getTile(dp,N)%15746)
