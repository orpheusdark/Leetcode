class Solution(object):
    def gcdOfOddEvenSums(self, n):
        odsm = n * n
        evnsm = n * (n + 1)
        return n