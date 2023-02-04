import sys
input = sys.stdin.readline

from itertools import permutations

N,M = map(int, input().split())
arr = [i+1 for i in range(N)]
permutationList = list(permutations(arr,M))
for permutation in permutationList:
  for num in permutation:
    print(num, end = " ")
  print()
