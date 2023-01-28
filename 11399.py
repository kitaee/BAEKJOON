import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

answer = 0
N = int(input())
people = list(map(int, input().split()))
people.sort()

for i in range(1, N+1):
  answer += sum(people[0:i])

print(answer)
