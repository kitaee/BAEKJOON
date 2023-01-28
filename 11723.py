import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

M = int(input())
setList = []

for _ in range(M):
  state = input().split()
  if state[0] == "add":
    if int(state[1]) not in setList:
      setList.append(int(state[1]))
  elif state[0] == "remove":
    if int(state[1]) in setList:
      setList.remove(int(state[1]))
  elif state[0] == "check":
    if int(state[1]) in setList:
      print(1)
    else:
      print(0)
  elif state[0] == "toggle":
    if int(state[1]) in setList:
      setList.remove(int(state[1]))
    else:
      setList.append(int(state[1]))
  elif state[0] == "all":
    setList = [i for i in range(1,21)]
  else:
    setList = []
