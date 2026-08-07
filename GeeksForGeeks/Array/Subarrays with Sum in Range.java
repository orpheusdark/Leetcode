class Solution {
    public int countSubarray(int[] arr, int l, int r) {
     int rcount = countSub(arr, r);
      int lcount = countSub(arr, l - 1);
      return rcount - lcount;
    }
    
static int countSub( int[] arr,int x){

        int i = 0;
        int j = 0;int sum = 0;
        int count = 0;
        while (j < arr.length) {
            sum += arr[j];
            
        while (i <= j && sum > x) {
            sum -= arr[i];
            i++;
        }
            count += (j - i + 1);
                 j++;
        }

        return count;
    }
}
