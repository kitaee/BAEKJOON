import sys
input = sys.stdin.readline

n, c = map(int, input().split())
arr = []
for _ in range(n):
    arr.append(int(input()))

arr.sort()

end = arr[-1] - arr[0]
start = 1
ans = 0

while start <= end:
    mid = (start + end) // 2
    count = 1
    current_router = arr[0]
    tmp = float("INF")

    for i in range(1, n):
        if current_router + mid <= arr[i]:
            tmp = min(arr[i] - current_router, tmp)
            count += 1
            current_router = arr[i]

    if count < c: # 공유기 설치를 더 해야함 -> 간격을 짧게 해야 함
        end = mid - 1

    elif count >= c: # 공유기 설치가 완료 or 더 많이 됨 -> 간격 늘려야 함
        start = mid + 1
        ans = max(ans, tmp)
    

print(ans)
