class Solution {
    public int[] sortedSquares(int[] nums) {    
        int i = 0;
        int j = nums.length - 1;
        int k = j;

        int[] nums2 = new int[nums.length];

        while (i < j) {
            int iSquare = nums[i] * nums[i];
            int jSquare = nums[j] * nums[j];

            if (iSquare > jSquare) {
                nums2[k--] = iSquare;
                i++;
            } else {
                nums2[k--] = jSquare;
                j--;
            }
        }

        nums2[0] = nums[i] * nums[i];
        return nums2;
    }
}