import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

from bisect import bisect_left, bisect_right

N = int(input())
card = list(map(int, input().split()))
M = int(input())
target = list(map(int, input().split()))

card.sort()

for targetCard in target:
  leftIndex = bisect_left(card, targetCard)
  rightIndex = bisect_right(card, targetCard)
  print(rightIndex - leftIndex, end = " ")
