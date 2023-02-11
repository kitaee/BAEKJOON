import sys
input = sys.stdin.readline

from itertools import permutations

N,M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

allCase = list(permutations(arr,M))
for case in allCase:
  for num in case:
    print(num, end = " ")
  print()
