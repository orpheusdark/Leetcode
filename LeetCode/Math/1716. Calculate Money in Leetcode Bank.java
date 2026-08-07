class Solution {
    public int totalMoney(int n) {
        int w = n/7;
        int rd = n%7;
        int sum = 0;
        for(int i = 0; i < w; i++){
            for(int j = i+1; j <= i+7; j++){
                sum += j;
            }
        }       
        for(int i = w+1; i<=rd+w; i++){
            sum += i;
        }
        return sum;
    }
}
