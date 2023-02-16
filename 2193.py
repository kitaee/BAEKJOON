import sys
input = sys.stdin.readline

# 이친수는 0으로 시작하지 않는다.
# 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.

# N == 1 -> 1
# N == 2 -> 10
# N == 3 -> 101, 100
# N == 4 -> 1010, 1001, 1000
# N == 5 -> 10101, 10101, 10010, 10000, 10001
# 피보나치인거 같은데?

N = int(input())
dp = [0 for _ in range(91)]
dp[1], dp[2] = 1, 1
if N > 2:
  for i in range(3, N+1):
    dp[i] = dp[i-1] + dp[i-2]

print(dp[N])
