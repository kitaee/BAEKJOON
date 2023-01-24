import sys
sys.setrecursionlimit(10**9)

#1,2,3을 이용해서만 더하기
# 1 => 1가지
# 2 => (1+1) / (2) : 2가지
# 3 => (1+1+1) / (1+2) / (2+1) / 3  : 4가지

memoization = [-1 for _ in range(12)]

def dp(num):
  global memoization
  if num == 1:
    memoization[1] = 1
    return 1
  elif num == 2:
    memoization[2] = 2
    return 2
  elif num == 3:
    memoization[3] = 4
    return 4
  elif memoization[num] != -1:
    return memoization[num]
  else:
    memoization[num] = dp(num-1) + dp(num-2) + dp(num-3)
    return memoization[num]

T = int(input())
for _ in range(T):
  n = int(input())
  print(dp(n))
