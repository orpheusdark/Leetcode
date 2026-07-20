mat2[i][j] = mat[i][j];
            }
        }
        
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++)
                {
                    if (mat2[i][j]==0 && mat[i][j] == 0) {
                    
                    int sum = 0;
                    if (i>0) {
                        sum += mat2[i - 1][j];
                        
                        mat[i - 1][j] = 0;
                    }
                    if (i<n - 1) {
                        sum += mat2[i + 1][j];
                        
                        mat[i + 1][j] = 0;
                    }
                    if (j>0) {
                        sum += mat2[i][j - 1];
                        
                        mat[i][j - 1] = 0;
                    }
                    if (j<m - 1) {
                        sum += mat2[i][j + 1];