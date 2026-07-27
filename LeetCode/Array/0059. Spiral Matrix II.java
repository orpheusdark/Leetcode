class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, down = n - 1;
        int left = 0, right = n - 1;
        int element = 1;

        while (element <= n * n) {
            for (int c = left; c <= right; c++)
                matrix[top][c] = element++;
            top++;

            for (int r = top; r <= down; r++)
                matrix[r][right] = element++;
            right--;

            for (int c = right; c >= left && element <= n * n; c--)
                matrix[down][c] = element++;
            down--;

            for (int r = down; r >= top && element <= n * n; r--)
                matrix[r][left] = element++;
            left++;
        }

        return matrix;
    }
}