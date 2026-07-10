class Solution {
    public int maxPoint(int k, int[] arr1, int[] arr2) {
                  int maxPoint = 0;

        for(int i = 0; i< arr2.length; i++){
        int time = (k/arr1[i]);
        int total = time * arr2[i];
        maxPoint = Math.max(total, maxPoint);
        }
        return maxPoint;
    }
}