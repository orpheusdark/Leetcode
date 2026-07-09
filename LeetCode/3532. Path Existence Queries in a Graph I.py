else:
self.id[i] = j
self.rank[j] += 1
def find(self, u: int) -> int:
if self.id[u] != u:
self.id[u] = self.find(self.id[u])
return self.id[u]
class Solution:
def pathExistenceQueries(
self,
self.id[j] = i
elif self.rank[i] > self.rank[j]:
self.id[i] = j
if self.rank[i] < self.rank[j]:
return
if i == j:
j = self.find(v)
i = self.find(u)
def unionByRank(self, u: int, v: int) -> None:
self.rank = [0] * n
def __init__(self, n: int):
self.id = list(range(n))
class UnionFind: