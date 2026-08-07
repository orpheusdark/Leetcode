class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int dir = 0;
        int row = 0;
        int col = 0;
        while(true) {
            if (mat[row][col] == 1){
                mat[row][col] = 0;
                dir = (dir + 1) % 4;
            }
            
            if (dir == 0){
                col++;
            } 
            else if (dir == 1){
                row++;
            }
            else if (dir ==2) {
                col--;
            } else {
                row--;
            }
            
            if(row<0){
                return Arrays.asList(0,col);
            } else if (col<0){
                return Arrays.asList(row,0);
            }
            else if (row >= n) {
                return Arrays.asList(n-1, col);
            }
            else if (col >= m) {
                return Arrays.asList(row, m-1);
            }
