class Solution {
    void booleanMatrix(int mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        boolean [] r = new boolean [n];
        boolean [] c = new boolean [m];
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m; j++){
                if (mat[i][j] == 1){
                    r[i] = true;
                    c[j] = true;
                }
            }
        }
        for(int i = 0; i<n;i++){
            for(int j = 0; j<m; j++){
                if(r[i] || c[j]){
                    mat[i][j] = 1;
                } 
            }
        }
     }
}