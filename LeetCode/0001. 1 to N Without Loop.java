public class Solution {
     public static void fillArray(int current, int size, int[] result) {
        if (current > size) {
            return; 
        }
        result[current - 1] = current;
        fillArray(current + 1, size, result);
    }
    public static int[] printNos(int x) {
        // Write Your Code Here
        int[] result = new int[x];
        fillArray(1, x, result);
        return result; 
    }
}