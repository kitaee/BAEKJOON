# import sys
# input = sys.stdin.readline

N = int(input())
words = []
for _ in range(N):
  words.append(input())

words = list(set(words))
words.sort()
words = sorted(words, key = lambda x : len(x))
for word in words:
  print(word)
