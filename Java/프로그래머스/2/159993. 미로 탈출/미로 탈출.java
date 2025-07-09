import java.util.*;

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }

        int startX = 0, startY = 0;
        int leverX = 0, leverY = 0;

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (map[i][j] == 'L') {
                    leverX = i;
                    leverY = j;
                }
            }
        }

        int distToLever = bfs(map, startX, startY, 'L');
        if (distToLever == -1) return -1;
        int distToExit = bfs(map, leverX, leverY, 'E');
        if (distToExit == -1) return -1;

        
        return distToLever + distToExit;
    }

    static int bfs(char[][] map, int startX, int startY, char target) {
        int n = map.length;
        int m = map[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});
        visited[startX][startY] = true;

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                if (map[x][y] == target){ 
                    return distance;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        continue;
                        }
                    if (visited[nx][ny]){ 
                        continue;
                    }
                    if (map[nx][ny] == 'X'){ 
                        continue;
                    }

                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
            distance++;
        }
        return -1;  
    }
}
