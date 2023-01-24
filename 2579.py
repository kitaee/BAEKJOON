import sys
sys.setrecursionlimit(10**9)

def getMaxStair(dp, stair, N):
  if N == 1:
    return stair[0]
  elif N == 2:
    return stair[0] + stair[1]
  else:
    dp.append(stair[0])
    dp.append(max(stair[0]+stair[1], stair[1]))
    dp.append(max(stair[0]+stair[2], stair[1]+stair[2]))
    
    for i in range(3,N):
      dp.append(max(dp[i-3]+stair[i-1]+stair[i], dp[i-2]+stair[i]))
  
    return dp[-1]

N = int(input())
dp = []
stair = []

for _ in range(N):
  stair.append(int(input()))

print(getMaxStair(dp, stair, N))
