import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

N,K = map(int, input().split())
dp = [[0 for _ in range(100001)] for _ in range(101)]
weight = []
value = []

for _ in range(N):
  W, V = map(int, input().split())
  weight.append(W)
  value.append(V)

def cut(i,w):
  
  if dp[i][w] > 0:
    return dp[i][w]
  
  if i == N:
    return 0
  n1 = 0  
  if w+weight[i] <= K:
    n1 = value[i] + cut(i+1, w+weight[i])
  n2 = cut(i+1, w)
  dp[i][w] = max(n1,n2)
  return dp[i][w]

print(cut(0,0))
