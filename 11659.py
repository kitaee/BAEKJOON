import sys
input = sys.stdin.readline

N,M = map(int, input().split())
arr = list(map(int, input().split()))
dp = [0 for _ in range(N+1)]

for i in range(1,N+1):
  dp[i] = arr[i-1] + dp[i-1]

for _ in range(M):
  i,j = map(int, input().split())
  sum = dp[j] - dp[i-1]
  print(sum)
