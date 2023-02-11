import sys
input = sys.stdin.readline

from itertools import combinations_with_replacement

N,M = map(int, input().split())
arr = [i for i in range(1,N+1)]

allCase = list(combinations_with_replacement(arr,M))
for case in allCase:
  for num in case:
    print(num, end = " ")
  print()
