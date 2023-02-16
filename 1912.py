import sys
input = sys.stdin.readline
MIN = -sys.maxsize

n = int(input())
arr = list(map(int, input().split()))
dp = [MIN for _ in range(n)]
dp[0] = arr[0]

for i in range(1, n):
  dp[i] = max(arr[i], arr[i]+dp[i-1])

print(max(dp))
