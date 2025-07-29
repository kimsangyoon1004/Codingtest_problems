import java.util.*;
class Point {
    int x, y, direction, cost;
    Point(int x, int y, int direction, int cost){
        this.x = x;
        this.y = y;
        this.direction = direction; 
        this.cost = cost;
    }
}

class Solution {
    static int[] xDir = {1, 0, -1, 0};
    static int[] yDir = {0, -1, 0, 1};
    public int solution(int[][] board) {
        int n = board.length;
        int[][][] dp = new int[n][n][4];
        for(int[][] layer : dp){
            for(int[] row : layer){
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }
        
        Queue<Point> queue = new LinkedList<>();
        for(int dir = 0; dir < 4; dir++){
            dp[0][0][dir] = 0;
            queue.offer(new Point(0, 0, dir, 0));
        }
        while(!queue.isEmpty()){
            Point current = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nextX = current.x + xDir[i];
                int nextY = current.y + yDir[i];
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || board[nextX][nextY] == 1){
                    continue;
                }
                int newCost = current.cost + (current.direction == i ? 100 : 600);
                if(dp[nextX][nextY][i] > newCost) {
                    dp[nextX][nextY][i] = newCost;
                    queue.offer(new Point(nextX, nextY, i, newCost));
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int dir = 0; dir < 4; dir++) {
            answer = Math.min(answer, dp[n-1][n-1][dir]);
        }
        return answer;
    }
}