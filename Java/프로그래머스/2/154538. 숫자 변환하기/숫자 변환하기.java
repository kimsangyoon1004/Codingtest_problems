import java.util.Arrays;

class Solution {
    public int solution(int x, int y, int n) {
        int INF = Integer.MAX_VALUE / 2;
        int[] dp = new int[y + 1];
        Arrays.fill(dp, INF);
        if (x <= y) dp[x] = 0;

        for (int v = x; v <= y; v++) {
            if (dp[v] == INF) continue;
            
            if (v + n <= y) {
                dp[v + n] = Math.min(dp[v + n], dp[v] + 1);
            }
            
            if (v * 2 <= y) {
                dp[v * 2] = Math.min(dp[v * 2], dp[v] + 1);
            }
            
            if (v * 3 <= y) {
                dp[v * 3] = Math.min(dp[v * 3], dp[v] + 1);
            }
        }

        return dp[y] == INF ? -1 : dp[y];
    }
}
