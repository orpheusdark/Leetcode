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
n: int,
nums: list[int],
maxDiff: int,
queries: list[list[int]]
) -> list[bool]:
uf = UnionFind(n)
for i in range(1, n):
if abs(nums[i] - nums[i - 1]) <= maxDiff:
uf.unionByRank(i, i - 1)
return [uf.find(u) == uf.find(v)
for u, v in queries]