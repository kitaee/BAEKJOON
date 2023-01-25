import sys
sys.setrecursionlimit(10**9)

def getTile(n,dp):
  if n == 1:
    return 1
  elif n == 2:
    return 2
  elif dp[n] != 0:
    return dp[n]
  else:
    dp[n] = getTile(n-1, dp) + getTile(n-2, dp)
    return dp[n]

n = int(input())
dp = [0 for i in range(n+1)]

print(getTile(n,dp) % 10007)
