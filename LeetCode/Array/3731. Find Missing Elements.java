class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> b = new ArrayList<>();   
        for (int i = 0; i<nums.length-1; i++){
            for(int a = nums[i]+1; a < nums[i + 1]; a++){
                b.add(a);
            }
        }   
        return b;
    }
}