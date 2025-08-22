class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m][n][2]; // 0 -> from up, 1 -> from left
        dp[0][0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                if(cityMap[i][j] == 1){
                    dp[i][j][0] = dp[i][j][1] = 0;
                }
                else{
                    if(i > 0){
                        if(cityMap[i - 1][j] == 2){
                            dp[i][j][0] = dp[i - 1][j][0] % MOD;
                        }
                        else{
                            dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                        }
                    }
                    if(j > 0){
                        if(cityMap[i][j - 1] == 2){
                            dp[i][j][1] = dp[i][j - 1][1] % MOD;
                        }
                        else{
                            dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                        }
                    }
                }
            }
        }
        return (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
    }
}