import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

from bisect import bisect_left

N = int(input())
a = list(map(int, input().split()))
b = list(set(a))
b.sort()

for num in a:
  print(bisect_left(b,num), end = " ")
