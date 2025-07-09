import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};  
    static int[] dy = {0, 0, 1, -1};

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        boolean[][] visited = new boolean[n][m];

        int startX = 0, startY = 0;
        int goalX = 0, goalY = 0;

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = board[i].charAt(j);
                if (c == 'R') {
                    startX = i;
                    startY = j;
                } else if (c == 'G') {
                    goalX = i;
                    goalY = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            if (x == goalX && y == goalY) {
                return count;
            }
            for (int d = 0; d < 4; d++) {
                int nx = x;
                int ny = y;

                while (true) {
                    int tx = nx + dx[d];
                    int ty = ny + dy[d];

                    if (tx < 0 || tx >= n || ty < 0 || ty >= m || board[tx].charAt(ty) == 'D') {
                        break;
                    }
                    nx = tx;
                    ny = ty;
                } 
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, count + 1});
                }
            }
        }
        return -1;
    }
}
