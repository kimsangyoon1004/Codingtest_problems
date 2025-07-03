import java.util.*;

class Solution {
    // dp
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int[][] dp = new int[n][4];
        // first row init
        for (int j = 0; j < 4; j++) {
            dp[0][j] = land[0][j];
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 4; j++){
                int maxPrev = -1;
                for(int k = 0; k < 4; k++){
                    if(k == j){
                        continue;
                    }
                    else{
                        maxPrev = Math.max(dp[i - 1][k], maxPrev);
                    }
                    dp[i][j] = maxPrev + land[i][j];
                }
            }
        }
        for(int i = 0; i < 4; i++){
            answer = Math.max(dp[n - 1][i], answer);
        }
        return answer;
    }
}
