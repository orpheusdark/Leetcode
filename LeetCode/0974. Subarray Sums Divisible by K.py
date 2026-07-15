def subarraysDivByK(self, nums: List[int], k: int) -> int:
        mod, result = 0, 0
        mod_dict = dict()
        mod_dict[0] = 1

        for num in nums:
            mod = (mod + num)% k
            result += mod_dict.setdefault(mod, 0)
            mod_dict[mod] += 1


        return result
class Solution:
    def subarraysDivByK(self, nums: List[int], k: int) -> int:
        counts = Counter()
        running_sum = 0
        res = 0
        for num in nums:
            running_sum += num
            ### 974. Subarray Sums Divisible by K
            if running_sum % k == 0: res += 1 # instead of *magic* counts[0] = 1
            res += counts[running_sum % k]
            counts[running_sum % k] += 1

            ### 560. Subarray Sum Equals K
            # if running_sum - k == 0: res += 1 # instead of *magic* counts[0] = 1
            # res += counts[running_sum - k]
            # counts[running_sum] += 1
        return res
class Solution:
    def subarraysDivByK(self, nums: list[int], k: int) -> int:
        prefixMod, result = 0, 0

        modGroups = [0] * k
        modGroups[0] = 1

        for num in nums:
            prefixMod = (prefixMod + num) % k
            result += modGroups[prefixMod]
            modGroups[prefixMod] += 1

        return result
class Solution:
    def subarraysDivByK(self, nums: list[int], k: int) -> int:
        result = 0

        modGroups = [0] * k
        modGroups[0] = 1

        for prefixSum in itertools.accumulate(nums):
            result += modGroups[prefixSum % k]
            modGroups[prefixSum % k] += 1

        return result