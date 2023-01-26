import sys
sys.setrecursionlimit(10**9)

from bisect import bisect_left, bisect_right

N = int(input())
card = list(map(int, input().split()))
card.sort()
M = int(input())
target = list(map(int, input().split()))

for targetCard in target:
  leftIndex = bisect_left(card,targetCard)
  rightIndex = bisect_right(card,targetCard)
  print(rightIndex-leftIndex, end = " ")
