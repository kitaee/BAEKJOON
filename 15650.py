import sys
input = sys.stdin.readline

from itertools import combinations

N,M = map(int, input().split())
arr = [i for i in range(1, N+1)]
combinationList = list(combinations(arr,M))
for combinationCase in combinationList:
  for case in combinationCase:
    print(case, end = " ")
  print()
