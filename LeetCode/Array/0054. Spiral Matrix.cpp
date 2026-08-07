class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int top = 0, bottom = matrix.size()-1, left = 0 , right = matrix[0].size()-1;
        vector <int> spiral;
        while (top <= bottom && left <= right){
            for (int i = left ; i <= right ; i ++){
                spiral.push_back(matrix[top][i]);
            }
            top += 1;

            for (int j = top; j <= bottom ; j++){
                spiral.push_back(matrix[j][right]);
            }
            right -= 1;


            if (top <= bottom){
            for (int k = right; k >= left; k--){
                spiral.push_back(matrix[bottom][k]);
            }
            bottom -= 1;

            }
            if (left <= right){
            for (int l = bottom; l >= top; l--){
                spiral.push_back(matrix[l][left]);
            }
            left += 1;
            }
        }
        return spiral;
    }
};
1class Solution {
2 public:
3  vector<int> spiralOrder(vector<vector<int>>& matrix) {
4    if (matrix.empty())
5      return {};
6
7    const int m = matrix.size();
8    const int n = matrix[0].size();
9    vector<int> ans;
10    int r1 = 0;
11    int c1 = 0;
12    int r2 = m - 1;
13    int c2 = n - 1;
14
15    // Repeatedly add matrix[r1..r2][c1..c2] to `ans`.
16    while (ans.size() < m * n) {
17      for (int j = c1; j <= c2 && ans.size() < m * n; ++j)
18        ans.push_back(matrix[r1][j]);
19      for (int i = r1 + 1; i <= r2 - 1 && ans.size() < m * n; ++i)
20        ans.push_back(matrix[i][c2]);
21      for (int j = c2; j >= c1 && ans.size() < m * n; --j)
22        ans.push_back(matrix[r2][j]);
23      for (int i = r2 - 1; i >= r1 + 1 && ans.size() < m * n; --i)
24        ans.push_back(matrix[i][c1]);
25      ++r1, ++c1, --r2, --c2;
26    }
27
28    return ans;
29  }
30};
