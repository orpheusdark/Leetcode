class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        
        int lTotal = 0;
        for (int i = 0; i < nums.length; i++) {
            int rTotal = total - lTotal - nums[i];
            if (rTotal == lTotal) {
                return i;
            }
            lTotal += nums[i];
        }

        return -1;        
    }
}