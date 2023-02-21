import sys
input = sys.stdin.readline

def binarySearch(arr, target, N):
  start = 0
  end = N-1

  while start <= end:
    mid = (start + end) // 2
    if arr[mid] == target:
      return 1
    elif arr[mid] < target:
      start = mid + 1
    else:
      end = mid -1
  return 0

N = int(input())
arr = list(map(int, input().split()))
arr.sort()
M = int(input())
targetList = list(map(int, input().split()))
for target in targetList:
  print(binarySearch(arr,target,N))
