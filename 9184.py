import sys
input = sys.stdin.readline

dp = [[[0 for _ in range(51)] for _ in range(51)] for _ in range(51)]

def w(a,b,c):
  global dp
  if a <= 0 or b <= 0 or c <= 0:
    return 1
  elif dp[a][b][c] != 0:
    return dp[a][b][c]
  elif a > 20 or b > 20 or c > 20:
    dp[a][b][c] = w(20,20,20)
    return dp[a][b][c]
  elif a < b and b < c:
    dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c)
    return dp[a][b][c]
  else:
    dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
    return dp[a][b][c]

while True:
  a,b,c = map(int, input().split())
  if a == -1 and b == -1 and c == -1:
    break
  else:
    print("w(" + str(a) + ", " + str(b) + ", " + str(c) + ") = " + str(w(a,b,c)))
