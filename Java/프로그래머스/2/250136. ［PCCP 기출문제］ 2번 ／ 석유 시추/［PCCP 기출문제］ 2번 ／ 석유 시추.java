import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        boolean[][] visited = new boolean[n][m];

        
        int[][] oilId = new int[n][m];
        int id = 1;
        Map<Integer, Integer> oilIdToSize = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    Set<Integer> cols = new HashSet<>();
                    int size = dfs(i, j, land, visited, cols, id, oilId);
                    oilIdToSize.put(id, size);
                    id++;
                }
            }
        }

        
        Map<Integer, Set<Integer>> colToOilIds = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (oilId[i][j] > 0) {
                    colToOilIds.computeIfAbsent(j, k -> new HashSet<>()).add(oilId[i][j]);
                }
            }
        }

        int max = 0;
        for (int col = 0; col < m; col++) {
            Set<Integer> ids = colToOilIds.getOrDefault(col, new HashSet<>());
            int sum = 0;
            for (int oid : ids) {
                sum += oilIdToSize.getOrDefault(oid, 0);
            }
            max = Math.max(max, sum);
        }

        return max;
    }

    static int dfs(int x, int y, int[][] land, boolean[][] visited, Set<Integer> cols, int id, int[][] oilId) {
        int n = land.length;
        int m = land[0].length;
        int size = 0;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;
        oilId[x][y] = id;
        cols.add(y);

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int cx = cur[0];
            int cy = cur[1];
            size++;

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m &&
                        !visited[nx][ny] && land[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    oilId[nx][ny] = id;
                    cols.add(ny);
                    stack.push(new int[]{nx, ny});
                }
            }
        }

        return size;
    }
}
