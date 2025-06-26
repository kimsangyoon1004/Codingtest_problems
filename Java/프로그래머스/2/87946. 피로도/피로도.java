class Solution {
    static boolean[] visited;
    static int maxCount;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        maxCount = 0;

        dfs(k, dungeons, 0);

        return maxCount;
    }

    public void dfs(int fatigue, int[][] dungeons, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                visited[i] = true;
                dfs(fatigue - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }

        
        maxCount = Math.max(maxCount, count);
    }
}
