(Iahub enters)
                     ↓
               +------------+
               |  (i-1, j)  |
               +------------+
                     ↓
(Ina enters)   +------------+   (Ina exits)
      →        |  MEET (X)  |       →
  (i, j-1)     +------------+    (i, j+1)
                     ↓
               +------------+
               |  (i+1, j)  |
               +------------+
                     ↓
               (Iahub exits)



(Ina exits)
                     ↑
               +------------+
               |  (i-1, j)  |
               +------------+
                     ↑
(Iahub enters) +------------+   (Iahub exits)
      →        |  MEET (X)  |       →
  (i, j-1)     +------------+    (i, j+1)
                     ↑
               +------------+
               |  (i+1, j)  |
               +------------+
                     ↑
               (Ina enters)





+------------+
                               |  MEET (X)  |
                               +------------+
                                     ↑
(Both are here)  +------------+      | (Iahub goes up? ILLEGAL!) 
       →         |  (i, j-1)  | ──→ 
                 +------------+      | (Ina goes right)
                                     ↓
                               +------------+
                               |            |
                               +------------+






```
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Using BufferedReader for fast I/O as the grid can be up to 1000x1000
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // Creating the grid 
        // We use arrays slightly larger than N and M (up to 1005) 
        // to handle 1-based indexing and avoid out-of-bounds errors easily.
        long[][] a = new long[n + 2][m + 2];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                a[i][j] = Long.parseLong(st.nextToken());
            }
        }
        
        // 4 DP tables for all 4 corners
        long[][] dp1 = new long[n + 2][m + 2]; // (1,1) to (i,j)
        long[][] dp2 = new long[n + 2][m + 2]; // (i,j) to (N,M)
        long[][] dp3 = new long[n + 2][m + 2]; // (N,1) to (i,j)
        long[][] dp4 = new long[n + 2][m + 2]; // (i,j) to (1,M)
        
        // 1. Iahub: (1,1) -> (i,j)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp1[i][j] = a[i][j] + Math.max(dp1[i - 1][j], dp1[i][j - 1]);
            }
        }
        
        // 2. Iahub: (i,j) -> (n,m)
        // Note: we loop backwards
        for (int i = n; i >= 1; i--) {
            for (int j = m; j >= 1; j--) {
                dp2[i][j] = a[i][j] + Math.max(dp2[i + 1][j], dp2[i][j + 1]);
            }
        }
        
        // 3. Iahubina: (n,1) -> (i,j)
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= m; j++) {
                dp3[i][j] = a[i][j] + Math.max(dp3[i + 1][j], dp3[i][j - 1]);
            }
        }
        
        // 4. Iahubina: (i,j) -> (1,m)
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                dp4[i][j] = a[i][j] + Math.max(dp4[i - 1][j], dp4[i][j + 1]);
            }
        }
        
        long maxGain = 0;
        
        // Iterate through all possible meeting cells
        // Meeting cell cannot be on the border, so iterate 2 to N-1 and 2 to M-1
        for (int i = 2; i < n; i++) {
            for (int j = 2; j < m; j++) {
                
                // Case 1: 
                // Iahub comes from Top, goes Bottom. 
                // Iahubina comes from Left, goes Right.
                long case1 = dp1[i - 1][j] + dp2[i + 1][j] + dp3[i][j - 1] + dp4[i][j + 1];
                
                // Case 2: 
                // Iahub comes from Left, goes Right.
                // Iahubina comes from Bottom, goes Top.
                long case2 = dp1[i][j - 1] + dp2[i][j + 1] + dp3[i + 1][j] + dp4[i - 1][j];
                
                // Find the maximum over all cases and meeting points
                maxGain = Math.max(maxGain, Math.max(case1, case2));
            }
        }
        
        System.out.println(maxGain);
    }
}
